package com.avaca.asistirandroid.ui.partediario;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.Diario;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiarioCrearViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> mFecha;
    private MutableLiveData<String> mTextObservacion;
    private MutableLiveData<Button> mbutton;

    public DiarioCrearViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public MutableLiveData<Button> getMbutton() {
        if(mbutton==null)
        {
            mbutton= new MutableLiveData<>();
        }
        return mbutton;
    }

    public MutableLiveData<String> getmFecha() {
        if(mFecha==null)
        {
            mFecha= new MutableLiveData<>();
        }
        return mFecha;
    }

    public MutableLiveData<String> getmTextObservacion() {
        if(mTextObservacion==null)
        {
            mTextObservacion= new MutableLiveData<>();
        }
        return mTextObservacion;
    }

    public void setmFecha(String fecha) {
        mFecha.setValue(fecha);
    }

    public void setmTextObservacion(String observacion)
    {
        mTextObservacion.setValue(observacion);
    }

    public void setMbutton(String fecha, String obser)
    {

        Diario diario= new Diario();
        diario.setAutoridadId(6);
        diario.setFecha(fecha);
        diario.setResumen(obser);
        Call<Diario> callDiario = ApiClient.getMyApiClient().CrearDiario(diario);
        callDiario.enqueue(new Callback<Diario>() {
            @Override
            public void onResponse(Call<Diario> call, Response<Diario> response) {
                if (response.isSuccessful())
                {
                    Toast.makeText(context, "Diario Creado con Exito", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Log.d("Salida", "No se pudo crear el Parte Diario");
                }
            }

            @Override
            public void onFailure(Call<Diario> call, Throwable t) {

            }
        });
    }
}