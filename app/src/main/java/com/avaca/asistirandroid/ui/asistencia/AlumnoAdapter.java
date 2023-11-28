package com.avaca.asistirandroid.ui.asistencia;

import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.AlumnoCurso;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Asistencia;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.MiViewHolder>{

    private final ArrayList<AlumnoCurso> alumnoList;
    private final View context;
    private final LayoutInflater inflaterVista;
    private final Fragment fragment;
    ImageView imgView;
    private boolean asistioState;
    private boolean justificadaState;



    public AlumnoAdapter(ArrayList<AlumnoCurso> alumnoList, View view, LayoutInflater inflater, Fragment fragment ) {
        this.alumnoList=alumnoList;
        this.context=view;
        this.inflaterVista=inflater;
        this.fragment = fragment;
    }

    //
    @NonNull
    @Override
    public AlumnoAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //######## Designo la vista, item inquilino y la paso a mi holder para llenar los campos #########
        View view =inflaterVista.inflate(R.layout.alumno_detalle_fragment, parent, false);
        return new AlumnoAdapter.MiViewHolder(view);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.MiViewHolder holder, int position) {
        AlumnoCurso alumnoCurso= alumnoList.get(position);
//        Glide.with(context.getContext())
//                .load(ApiClient.getConecion() +inmueble.getImagen())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.img);
//        Log.d("exc", "exc:"+ inmueble.getDireccion());
        //holder.btnImagen.setEnabled(false);
        //holder.datosAlumno.setText(alumno.getNombre() +" "+alumno.Apellido );

        holder.datosAlumno.setText(alumnoCurso.getAlumno().getNombre() +" "+alumnoCurso.getAlumno().getNombre() );
        holder.asistio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("Salida", "Funciona el check Box");
                if (isChecked) {
                    Log.d("Salida", "Activo el check Box Justificada");
                    holder.btnImagen.setEnabled(true);
                } else {
                    Log.d("Salida", "Desactivo el check box Justificada");
                    holder.btnImagen.setEnabled(false);
                }
                asistioState=isChecked;
            }
        });
        holder.justificada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.d("Salida", "Activo el check Box Justificada");
                    holder.btnImagen.setEnabled(true);
                } else {
                    Log.d("Salida", "Desactivo el check box Justificada");
                    holder.btnImagen.setEnabled(false);
                }
                justificadaState=isChecked;
            }
        });
        holder.btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle= new Bundle();
//                bundle.putSerializable("inmueble", inmueble);
//                Navigation.findNavController(view).navigate(R.id.AnoFragment, bundle);

                ((AlumnoFragment) fragment).startCamera();
                Log.d("Salida", "Funciona el boton");
            }
        });
        holder.btnAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Asistencia asistencia= new Asistencia();
                asistencia.setAsitencia(asistioState);
                asistencia.setJustificada(justificadaState);
                //asistencia.setDescripcion("ProbandoDescripcion");
                //asistencia.setImagen("ProbandoImagen");
                asistencia.setAlumnoCursoId(alumnoCurso.getId());
                Call<Asistencia> callAsistencia = ApiClient.getMyApiClient().CrearAsistencia(asistencia);
                callAsistencia.enqueue(new Callback<Asistencia>() {
                    @Override
                    public void onResponse(Call<Asistencia> call, Response<Asistencia> response) {
                        if (response.isSuccessful())
                        {
                            Log.d("Salida", "onResponse: "+response.message());
                            Toast.makeText(v.getContext(), "Asistencia Creada", Toast.LENGTH_SHORT).show();

                        }
                        if(response.code() == 406)
                        {
                            Log.d("Salida", "onResponse: "+response.code() + "  "+response.errorBody());
                            Toast.makeText(v.getContext(), "La asistencia ya existe", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Asistencia> call, Throwable t) {
                        Log.d("Salida", "ERROR: "+t.getMessage());
                    }
                });
            }
        });
    }
    //
    @Override
    public int getItemCount() {
        return alumnoList.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{
        //Elementos de la vista
//        private final ImageView img;
        private final TextView datosAlumno;
        private final Button btnImagen;
        private final Button btnAsistencia;
        private final Switch asistio;
        private final Switch justificada;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            datosAlumno=itemView.findViewById(R.id.datosAlumno);
            asistio=itemView.findViewById(R.id.chbAsistencia);
            justificada=itemView.findViewById(R.id.chbJustificada);
            btnImagen=itemView.findViewById(R.id.btnCargarImagen);
            btnAsistencia=itemView.findViewById(R.id.btnGuardarAistencia);
            btnImagen.setEnabled(false);
        }
    }
}
