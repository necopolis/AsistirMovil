package com.avaca.asistirandroid.ui.asistencia;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.AlumnoCurso;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnoViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel

    private Alumno alumnoAux;
    private Curso cursoAux;
    private final Alumno alumno;
    private MutableLiveData<ArrayList<AlumnoCurso>> alumnoMT;
    //private final String token;
    private final Context context;


    public AlumnoViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
        //token = ApiClient.token().getString("token", "");
        alumno=new Alumno();
    }


    public MutableLiveData<ArrayList<AlumnoCurso>> getAlumnoMT(){
        if (alumnoMT==null){
            alumnoMT= new MutableLiveData<>();
        }
        return alumnoMT;
    }
    //Actualizo el estado de disponible, el inmuble viaja desde el adapter

    //Se lo asigno a mi mutable
    public void setCursoMT(Bundle bundle){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String yearString = String.valueOf(year);

        // Crear una nueva fecha con el 01 de enero del año actual
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Obtener la nueva fecha
        Date newDate = calendar.getTime();
        String fecha = "1-1-"+yearString;
        cursoAux=(Curso) bundle.getSerializable("curso");
//        Call<ArrayList<Alumno>> callAlumno = ApiClient.getMyApiClient().listaDeAlumnoDeCurso(6,13,fecha);
        Call<ArrayList<AlumnoCurso>> callAlumno = ApiClient.getMyApiClient().listaDeAlumnoDeCursoAux2("6", Integer.toString(cursoAux.getId()));
        callAlumno.enqueue(new Callback<ArrayList<AlumnoCurso>>() {
            @Override
            public void onResponse(Call<ArrayList<AlumnoCurso>> call, Response<ArrayList<AlumnoCurso>> response) {
                if (response.isSuccessful())
                {
                    alumnoMT.setValue(response.body());
                    Log.d("Salida","Exito Alumnos" + response.body().toString());
                }
                else
                {
                    Log.d("Salida","No trajo Alumnos"+ response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AlumnoCurso>>  call, Throwable throwable) {
                //turnoMT.setValue("Error");
                Log.d("Salida", "Error "+throwable.getMessage());
            }
        });
    }
}