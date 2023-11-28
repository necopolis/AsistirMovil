package com.avaca.asistirandroid.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.asistirandroid.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.avaca.asistirandroid.request.ApiClient;


public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        Call<ArrayList<Alumno>> call= ApiClient.getMyApiClient().listaDeAlumnos();
        call.enqueue(new Callback<ArrayList<Alumno>>() {
            @Override
            public void onResponse(Call<ArrayList<Alumno>> call, Response<ArrayList<Alumno>> response) {

                if(!response.isSuccessful()){
                    mText.setValue("Codigo: "+ response.code() );
                    return;

                }
                ArrayList<Alumno> postList= response.body();

                for (Alumno post: postList){
                    String content = "";
                    content+="Id: " + post.getId() + "\n";
                    content+="Nombre: " + post.getNombre() + "\n";
                    content+="Apellido: " + post.getApellido() + "\n";
                    mText.setValue(content);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Alumno>> call, Throwable throwable) {
                mText.setValue(throwable.getMessage());
            }
        });
        //mText.setValue("This is gallery fragment");

    }


    public LiveData<String> getText() {
        return mText;
    }


}