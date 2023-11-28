package com.avaca.asistirandroid.ui.asistencia;

import android.app.Application;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Division;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DivisionViewModel extends AndroidViewModel {
    private Ano anoAux;
    private final Division division;
    private MutableLiveData<ArrayList<Division>> divisionMT;
    //private final String token;
    private final Context context;

    public DivisionViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
        //token = ApiClient.token().getString("token", "");
        division=new Division();
    }


    public MutableLiveData<ArrayList<Division>> getDivisionMT(){
        if (divisionMT==null){
            divisionMT= new MutableLiveData<>();
        }
        return divisionMT;
    }
    //Actualizo el estado de disponible, el inmuble viaja desde el adapter

    //Se lo asigno a mi mutable
    public void setAnoMT(Bundle bundle){
        Call<ArrayList<Division>> callAlumno = ApiClient.getMyApiClient().listaDeDivision();
        callAlumno.enqueue(new Callback<ArrayList<Division>>() {
            @Override
            public void onResponse(Call<ArrayList<Division>> call, Response<ArrayList<Division>> response) {
                if (response.isSuccessful())
                {
                    divisionMT.setValue(response.body());
                    Log.d("Salida","Exito TURNOS" + response.body().toString());
                }
                else
                {
                    Log.d("Salida", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Division>>  call, Throwable throwable) {
                //turnoMT.setValue("Error");
                Log.d("Salida", throwable.getMessage());
            }
        });
    }
}