package com.avaca.asistirandroid.ui.partediario;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.AlumnoCurso;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.modelo.Diario;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiarioViewModel extends AndroidViewModel {


    private Alumno alumnoAux;
    private Curso cursoAux;
    private final Diario diario;
    private MutableLiveData<ArrayList<Diario>> diarioMT;
    //private final String token;
    private final Context context;


    public DiarioViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
        //token = ApiClient.token().getString("token", "");
        diario=new Diario();
    }


    public MutableLiveData<ArrayList<Diario>> getDiarioMT(){
        if (diarioMT==null){
            diarioMT= new MutableLiveData<>();
        }
        return diarioMT;
    }
    //Actualizo el estado de disponible, el inmuble viaja desde el adapter

    //Se lo asigno a mi mutable
    public void setCursoMT(Bundle bundle){

        Call<ArrayList<Diario>> callDiario= ApiClient.getMyApiClient().todosLosDiarios();
        //Call<ArrayList<Diario>> callDiario= ApiClient.getMyApiClient().DiarioId(1);
        callDiario.enqueue(new Callback<ArrayList<Diario>>() {
            @Override
            public void onResponse(Call<ArrayList<Diario>> call, Response<ArrayList<Diario>> response) {
                if (response.isSuccessful())
                {
                    diarioMT.setValue(response.body());
                    Log.d("Salida","Exito DIARIOA" + response.body().toString());
                }
                else
                {
                    Log.d("Salida","No trajo DIARIOS"+ response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Diario>>  call, Throwable throwable) {
                //turnoMT.setValue("Error");
                Log.d("Salida", "Error "+throwable.getMessage());
            }
        });
    }
}