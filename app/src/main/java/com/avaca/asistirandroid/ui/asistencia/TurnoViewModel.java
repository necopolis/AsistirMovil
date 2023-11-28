package com.avaca.asistirandroid.ui.asistencia;


import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  TurnoViewModel extends AndroidViewModel {
    //ApiClient api;
    private Turno turnoAux;
    private final Turno turno;
    private MutableLiveData<ArrayList<Turno>> turnoMT;
    //private final String token;
    private final Context context;

    public TurnoViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
        //token = ApiClient.token().getString("token", "");
        turno=new Turno();
    }


    public MutableLiveData<ArrayList<Turno>> getInquilinoMT(){
        if (turnoMT==null){
            turnoMT= new MutableLiveData<>();
        }
        return turnoMT;
    }
    //Actualizo el estado de disponible, el inmuble viaja desde el adapter

    //Se lo asigno a mi mutable
    public void setTurnoMT(Bundle bundle){
        Call<ArrayList<Turno>> callAlumno = ApiClient.getMyApiClient().listaDeTurnos();
//        turnoCall.enqueue(new Callback<ArrayList<Turno>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Turno>> call, Response<ArrayList<Turno>> response) {
//                if (response.isSuccessful()|| response.body() != null){
//                    if (response.body().size()>0) {
//                        //turno.setNombre(response.body().getNombre());
//
//                        turnoMT.setValue(response.body());
//                        Log.d("Salida","Llego a enviar lista de turnos");
//                    }
//                    //toasMT.setValue("Propiedades Alquiladas Encontradas");
//                    Log.d("exc","Llego a inquilino");
//                }else{
//                    //toasMT.setValue("Sin propiedades Alquiladas");
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Turno>> call, Throwable t) {
//                //toasMT.setValue("Error");
//                Log.d("exc", t.getMessage());
//            }
//        });
        callAlumno.enqueue(new Callback<ArrayList<Turno>>() {
            @Override
            public void onResponse(Call<ArrayList<Turno>> call, Response<ArrayList<Turno>> response) {
                if (response.isSuccessful())
                {
                    turnoMT.setValue(response.body());
                    Log.d("Salida","Exito TURNOS" + response.body().toString());
                }
                else
                {
                    Log.d("Salida", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Turno>>  call, Throwable throwable) {
                //turnoMT.setValue("Error");
                Log.d("Salida", throwable.getMessage());
            }
        });
    }


    ///###########################################################################



//###########################################################


}