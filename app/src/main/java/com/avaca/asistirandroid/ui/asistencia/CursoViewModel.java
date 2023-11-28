package com.avaca.asistirandroid.ui.asistencia;

import android.app.Application;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursoViewModel extends AndroidViewModel {
    private Ano anoAux;
    private final Curso curso;
    private MutableLiveData<ArrayList<Curso>> cursoMT;
    //private final String token;
    private final Context context;

    public CursoViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
        //token = ApiClient.token().getString("token", "");
        curso=new Curso();
    }


    public MutableLiveData<ArrayList<Curso>> getCursoMT(){
        if (cursoMT==null){
            cursoMT= new MutableLiveData<>();
        }
        return cursoMT;
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
        Call<ArrayList<Curso>> callAlumno = ApiClient.getMyApiClient().listaDeCursoPorAutoridad(6, fecha);
        callAlumno.enqueue(new Callback<ArrayList<Curso>>() {
            @Override
            public void onResponse(Call<ArrayList<Curso>> call, Response<ArrayList<Curso>> response) {
                if (response.isSuccessful())
                {
                    cursoMT.setValue(response.body());
                    Log.d("Salida","Exito CURSOS" + response.body().toString());
                }
                else
                {
                    Log.d("Salida","No trajo CURSOS"+ response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Curso>>  call, Throwable throwable) {
                //turnoMT.setValue("Error");
                Log.d("Salida", "Error "+throwable.getMessage());
            }
        });
    }
}