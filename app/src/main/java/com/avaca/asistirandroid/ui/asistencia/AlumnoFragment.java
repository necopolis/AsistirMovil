package com.avaca.asistirandroid.ui.asistencia;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.AlumnoCurso;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.request.ApiClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnoFragment extends Fragment {


    private RecyclerView ReciclerViewAlumno;
    private AlumnoAdapter alumnoAdapter;
    private AlumnoViewModel mViewModel;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri photoUri;
    ImageView imgView;
    File storageDir;
    //String imageFileName;


    public static AlumnoFragment newInstance() {
        return new AlumnoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alumno_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(AlumnoViewModel.class);
        ReciclerViewAlumno = view.findViewById(R.id.rvAlumno);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        mViewModel.getAlumnoMT().observe(getViewLifecycleOwner(), new Observer<ArrayList<AlumnoCurso>>() {
            @Override
            public void onChanged(ArrayList<AlumnoCurso> alumnoCursos) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                );
                ReciclerViewAlumno.setLayoutManager(linearLayoutManager);
                alumnoAdapter = new AlumnoAdapter(alumnoCursos, view , getLayoutInflater(), AlumnoFragment.this);
                ReciclerViewAlumno.setAdapter(alumnoAdapter);
            }
        });

        mViewModel.setCursoMT(getArguments());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    public void startCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //this.startActivityForResult(takePictureIntent,1);
        if (takePictureIntent.resolveActivity(mViewModel.getApplication().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Handle the error
                Log.d("Salida", "Error en camara: "+ex.getMessage());
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                //photoUri-> content://com.avaca.asistirandroid.fileprovider/my_images/Pictures/JPEG_20231126_182354_3671911893014751142.jpg
                //photoUri.getPath() -> /my_images/Pictures/JPEG_20231126_182354_3671911893014751142.jpg
                photoUri = FileProvider.getUriForFile(getContext(), "com.avaca.asistirandroid.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takePictureIntent, 1);
                Log.d("Salida", "FOTO URI GETPATH: "+photoUri.getPath());
                Log.d("Salida", "FOTO URI: "+photoUri);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        //Stampa/UID/ID para que no se repita
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        //Armo el nombre completo
        String imageFileName = "JPEG_" + timeStamp + "_";

        //storageDir.getAbsolutePath() -> /storage/emulated/0/Android/data/com.avaca.asistirandroid/files/Pictures
        storageDir = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        Log.d("Salida", "CREO EL ARCHIVO DE FOTO ");
        //Crea el archivo 1parametro el nombre completo, 2parametro tipo JPG(Imagen), 3parametro en que lugar
        return File.createTempFile(imageFileName, ".jpg", storageDir);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {

//        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
//                // Photo was taken successfully, handle the result
//                // You can use the 'photoUri' to get the image file path
//                // and pass it to your Retrofit call or handle it as needed
//                // For example
//            //Decodifica la imagen que esta storageDir.getAbsolutePath() y se la envia al visor de imagenes
//            Bitmap imgBitmap = BitmapFactory.decodeFile(storageDir.getAbsolutePath());
//            //Muestra la imagen que saque en el visor por defecto
//            imgView.setImageBitmap(imgBitmap);
//            Log.d("Salida", "onActivityResult: PASO POR ACA ");
//                if (photoUri != null) {
//                    String imagePath = photoUri.getPath();
//                    // Now you can use 'imagePath' to send the image to your API
//                    // Update the corresponding Alumno object with the image path
//                }
//            }

        Log.d("Salida", "onActivityResult: PASO POR ACA ");
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (storageDir != null) {
//                File photoFile = new File(storageDir.getAbsolutePath());
//                RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), photoFile);
//                MultipartBody.Part body = MultipartBody.Part.createFormData("image", photoFile.getName(), requestFile);
//                RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "Image description");
                Log.d("Salida", "Nombre/Direccion de la foto: "+storageDir.getAbsolutePath());
                Log.d("Salida", "Nombre/Direccion de la foto: "+storageDir.getName());
//                Bitmap photoFile = BitmapFactory.decodeFile(storageDir.getAbsolutePath());
//                //File photoFile = new File(storageDir.getAbsolutePath());
//
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                photoFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
//                byte[] imageBytes = byteArrayOutputStream.toByteArray();
//
//                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imageBytes);
//                //RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), photoFile);
//                MultipartBody.Part body = MultipartBody.Part.createFormData("files", storageDir.getAbsolutePath(), requestFile);
//
//                RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "Image description");

                Bitmap bitmap = BitmapFactory.decodeFile(photoUri.getPath());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] imageBytes = byteArrayOutputStream.toByteArray();

                RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imageBytes);
                MultipartBody.Part body = MultipartBody.Part.createFormData("files", storageDir.getName(), requestFile);
                RequestBody name = RequestBody.create(MediaType.parse("text/plain"), "Image description");


                Log.d("Salida", "Se esta por enviar ");
                //ApiClient.PostInterface apiService = ApiClient.getMyApiClient();
                Call<String> call = ApiClient.getMyApiClient().uploadImage(body, name);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response)
                    {
                        if (response.isSuccessful()) {
                            String result = response.body();
                            Log.e("Salida", " " +result+ response.message());
                        } else {
                            Log.e("Salida", "Error: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("Salida", "Error: " + t.getMessage());
                    }
                });
            }
        }
    }

}