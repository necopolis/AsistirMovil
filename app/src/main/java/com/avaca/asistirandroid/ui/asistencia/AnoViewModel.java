package com.avaca.asistirandroid.ui.asistencia;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnoViewModel extends AndroidViewModel {
    //ApiClient api;
    private Ano anoAux;
    private final Ano ano;
    private MutableLiveData<ArrayList<Ano>> anoMT;
    //private final String token;
    private final Context context;

    public AnoViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
        //token = ApiClient.token().getString("token", "");
        ano=new Ano();
    }


    public MutableLiveData<ArrayList<Ano>> getAnoMT(){
        if (anoMT==null){
            anoMT= new MutableLiveData<>();
        }
        return anoMT;
    }
    //Actualizo el estado de disponible, el inmuble viaja desde el adapter

    //Se lo asigno a mi mutable
    public void setAnoMT(Bundle bundle){
        Call<ArrayList<Ano>> callAlumno = ApiClient.getMyApiClient().listaDeAnos();
        callAlumno.enqueue(new Callback<ArrayList<Ano>>() {
            @Override
            public void onResponse(Call<ArrayList<Ano>> call, Response<ArrayList<Ano>> response) {
                if (response.isSuccessful())
                {
                    anoMT.setValue(response.body());
                    Log.d("Salida","Exito TURNOS" + response.body().toString());
                }
                else
                {
                    Log.d("Salida", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Ano>>  call, Throwable throwable) {
                //turnoMT.setValue("Error");
                Log.d("Salida", throwable.getMessage());
            }
        });
    }
}