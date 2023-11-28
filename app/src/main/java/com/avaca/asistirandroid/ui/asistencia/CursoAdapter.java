package com.avaca.asistirandroid.ui.asistencia;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.MainActivity;
import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.request.ApiClient;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.net.URI;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class CursoAdapter extends RecyclerView.Adapter<CursoAdapter.MiViewHolder>{
    private final ArrayList<Curso> cursoList;
    private final View context;
    private final LayoutInflater inflaterVista;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri photoUri;


    public CursoAdapter(ArrayList<Curso> cursoList, View view, LayoutInflater inflater) {
        this.cursoList=cursoList;
        this.context=view;
        this.inflaterVista=inflater;
    }


    //
    @NonNull
    @Override
    public CursoAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //######## Designo la vista, item inquilino y la paso a mi holder para llenar los campos #########
        View view =inflaterVista.inflate(R.layout.curso_detalle_fragment, parent, false);
        return new CursoAdapter.MiViewHolder(view);
    }

    //
    @Override
    public void onBindViewHolder(@NonNull CursoAdapter.MiViewHolder holder, int position) {
        Curso curso= cursoList.get(position);
//        Glide.with(context.getContext())
//                .load(ApiClient.getConecion() +inmueble.getImagen())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.img);
//        Log.d("exc", "exc:"+ inmueble.getDireccion());
//        holder.tituloCursoAno.setText((CharSequence) ApiClient.getMyApiClient().AnoPorId(curso.getAnoId()));
//        holder.tituloCursoDivision.setText((CharSequence) ApiClient.getMyApiClient().DivisionPorId(curso.getDivisionId()));
//        holder.tituloCursoTurno.setText((CharSequence) ApiClient.getMyApiClient().TurnoPorId(curso.getTurnoId()));

        holder.tituloCursoTurno.setText("Turno: "+curso.getTurnoNombre());
        holder.tituloCursoAno.setText(curso.getAnoNombre());
        holder.tituloCursoDivision.setText(curso.getDivisionNombre());


        holder.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle= new Bundle();
                bundle.putSerializable("curso", curso);
                Navigation.findNavController(view).navigate(R.id.action_nav_asistencia_to_alumnoFragment, bundle);
                //dispatchTakePictureIntent(view.getContext());
            }
        });

    }
    //
    @Override
    public int getItemCount() {
        return cursoList.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{
        //Elementos de la vista
//        private final ImageView img;
        private final TextView tituloCursoAno;
        private final TextView tituloCursoDivision;
        private final TextView tituloCursoTurno;
        private final Button btnVer;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloCursoAno=itemView.findViewById(R.id.tvTitleCursoAno);
            tituloCursoDivision=itemView.findViewById(R.id.tvTitleCursoDivision);
            tituloCursoTurno=itemView.findViewById(R.id.tvTitleCursoTurno);
            btnVer=itemView.findViewById(R.id.btnVerCurso);
        }
    }
////////////////////////////////////////


}
