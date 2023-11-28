package com.avaca.asistirandroid.ui.slideshow;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.Autoridad;
import com.avaca.asistirandroid.modelo.MyDataModel;
import com.avaca.asistirandroid.modelo.Post;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        //Call<Autoridad> callAlumno = ApiClient.getMyApiClient().obtenerAutoridad(3);
        //Call<ArrayList<Turno>> callAlumno = ApiClient.getMyApiClient().listaDeTurnos();
        Call<ArrayList<Alumno>> callAlumno = ApiClient.getMyApiClient().listaDeAlumnos();
        callAlumno.enqueue(new Callback<ArrayList<Alumno>> () {
            @Override
            public void onResponse(Call<ArrayList<Alumno>>  call, Response<ArrayList<Alumno>>  response) {
                if (response.isSuccessful())
                {
                    mText.setValue(response.body().toString());
                    Log.d("Salida","Exito Alumnos" + response.body());
                }
                else
                {
                    Log.d("Salida", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Alumno>>  call, Throwable throwable) {
                mText.setValue("Error");
                Log.d("Salida", throwable.getMessage());
            }
        });

//        callAlumno.enqueue(new Callback<Autoridad> () {
//            @Override
//            public void onResponse(Call<Autoridad>  call, Response<Autoridad>  response) {
//                if (response.isSuccessful())
//                {
//                    mText.setValue(response.body().toString());
//                    Log.d("Salida","Exito" + response.body());
//                }
//                else
//                {
//                    Log.d("Salida", response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Autoridad>  call, Throwable throwable) {
//                mText.setValue("Error");
//                Log.d("Salida", throwable.getMessage());
//            }
//        });

//        callAlumno.enqueue(new Callback<ArrayList<Turno>> () {
//            @Override
//            public void onResponse(Call<ArrayList<Turno>>  call, Response<ArrayList<Turno>>  response) {
//                if (response.isSuccessful())
//                {
//                    mText.setValue(response.body().toString());
//                    Log.d("Salida","Exito" + response.body());
//                }
//                else
//                {
//                    Log.d("Salida", response.errorBody().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Turno>>  call, Throwable throwable) {
//                mText.setValue("Error");
//                Log.d("Salida", throwable.getMessage());
//            }
//        });


    }

    public LiveData<String> getText() {
        return mText;
    }
}