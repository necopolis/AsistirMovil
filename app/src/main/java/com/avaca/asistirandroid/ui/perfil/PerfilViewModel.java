package com.avaca.asistirandroid.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.Autoridad;
import com.avaca.asistirandroid.modelo.MyDataModel;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    // TODO: Implement the ViewModel
    private ApiClient api;
    private Autoridad paux;
    private MutableLiveData<Boolean> CamposMT;
    private MutableLiveData<Autoridad> autoridadMT;
    private MutableLiveData<Boolean> BTNEditarMT;
    private MutableLiveData<Boolean> BTNGuardarMT;
    private MutableLiveData<String> toastMT;
    private Context context;
    private String token;

    public PerfilViewModel(@NonNull Application application){
        super(application);
        context=application.getApplicationContext();
        //token = ApiClient.token().getString("token", "");
        AutoridadActual();
        //autoridadMT.setValue(api.obtenerAutoridadActual());

    }
    public MutableLiveData<Boolean> getCamposMT(){
        if (CamposMT==null){
            CamposMT=new MutableLiveData<>();
        }
        return CamposMT;
    }

    public LiveData<Autoridad> getPropietario(){
        if (autoridadMT==null){
            autoridadMT= new MutableLiveData<>();
        }
        return autoridadMT;
    }

    public MutableLiveData<Boolean> getBTNEditarMT(){
        if (BTNEditarMT==null){
            BTNEditarMT= new MutableLiveData<>();
        }
        return BTNEditarMT;
    }
    public MutableLiveData<String> gettoastMT(){
        if (toastMT==null){
            toastMT= new MutableLiveData<>();
        }
        return toastMT;
    }
    public MutableLiveData<Boolean> getBTNGuardarMT(){
        if (BTNGuardarMT==null){
            BTNGuardarMT= new MutableLiveData<>();
        }
        return BTNGuardarMT;
    }

    public void editarDatos(){
        this.CamposMT.setValue(true);
        this.BTNGuardarMT.setValue(true);
        this.BTNEditarMT.setValue(false);
    }

    public void GuardarDatos(Autoridad p){
        //this.api.actualizarPerfil(p);
        Log.d("exc", "Autoridad");
        Log.d("exc", p.getNombre()+"  "+p.getApellido()+" "+p.getDNI()+" "+p.getContraseña());
        Call<Autoridad> Perfil= ApiClient.getMyApiClient().actualizarAutoridad(p);
        Perfil.enqueue(new Callback<Autoridad>() {
            @Override
            public void onResponse(Call<Autoridad> call, Response<Autoridad> response) {
                if (response.isSuccessful()){
                    autoridadMT.setValue(response.body());
                    BTNGuardarMT.setValue(false);
                    BTNEditarMT.setValue(true);
                    CamposMT.setValue(false);
                    toastMT.setValue("Datos guardados correctamente");
                }else{
                    toastMT.setValue("No se Guardo");
                }

            }

            @Override
            public void onFailure(Call<Autoridad> call, Throwable t) {
                Log.d("exc", t.getMessage());
                toastMT.setValue("Error");
            }
        });


    }
    public void bloquearCampor(){
        this.CamposMT.setValue(false);
    }
    //
    public void ActualizarPantalla(){
        AutoridadActual();
        this.CamposMT.setValue(false);
    }
    public void AutoridadActual(){
        int aux=3;
        Call<Autoridad> autoridadsCall= ApiClient.getMyApiClient().obtenerAutoridad(aux);
        autoridadsCall.enqueue(new Callback<Autoridad>() {
            @Override
            public void onResponse(Call<Autoridad> call, Response<Autoridad> response) {
                if (response.isSuccessful()){
                    toastMT.setValue("Trajo la Autoridad");
                    autoridadMT.setValue(response.body());
                }else {
                    toastMT.setValue("No Trajo la autoridad");
                }
            }

            @Override
            public void onFailure(Call<Autoridad> call, Throwable t) {
                toastMT.setValue("Error");
                Log.d("exc",t.getMessage());

            }
        });
//        autoridadCall.enqueue(new Callback<Autoridad>() {
//            @Override
//            public void onResponse(Call<Autoridad> call, Response<Autoridad> response) {
//                if (response.isSuccessful()){
//                    toastMT.setValue("Trajo la Autoridad");
//                    autoridadMT.setValue(response.body());
//                }else {
//                    toastMT.setValue("No Trajo la autoridad");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Autoridad> call, Throwable t) {
//                toastMT.setValue("Error");
//                Log.d("exc",t.getMessage());
//            }
//        });
//
//        autoridadCall.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                if (response.isSuccessful()){
//                    toastMT.setValue("Trajo Algo");
//                }else {
//                    toastMT.setValue("No Trajo al proietario");
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable throwable) {
//                toastMT.setValue("Error");
//                Log.d("exc",throwable.getMessage());
//            }
//        });


    }
    /*private MutableLiveData<String> mText;

    public PerfilViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is perfil fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }*/

}