package com.avaca.asistirandroid.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.Autoridad;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.modelo.MyDataModel;
import com.avaca.asistirandroid.modelo.Post;
import com.avaca.asistirandroid.modelo.Turno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiClient {
    //"http://192.168.1.10:45462/api/"
    private static final String UrlBase = "http://192.168.1.10:45455/api/";
    private static PostInterface postInterface;
    //private static SharedPreferences token;
    //private static final String conecion= "http://192.168.0.10:45462/";

//    public static SharedPreferences conectar(Context context) {
//        if (token==null){
//            token=context.getSharedPreferences("token.dat", 0);
//        }
//        return token;
//    }
//    public static SharedPreferences token() {
//        return token;
//    }
//    public static void eliminarToken(Context context) {
//        context.getSharedPreferences("token.dat", 0).edit().clear().commit();
//    }
//    public static String getConecion(){
//        return conecion;
//    }

    public static PostInterface getMyApiClient() {

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlBase)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        postInterface = retrofit.create(PostInterface.class);

        return postInterface;
    }


    public interface PostInterface {

///####################  AUTORIDAD  ################################################
        @GET("autoridad/{id}")
        Call<Autoridad>  obtenerAutoridad(@Path("id") int id);

        @PUT("autoridad/")
        Call<Autoridad>  actualizarAutoridad(@Body Autoridad autoridad);


//################################################################



///####################  ALUMNO  ##################################################
        //Inmuebles
        //Lista de Alumnos
        @GET("alumno/{id}")
        Call<Alumno> Alumno(@Path("id") int id);

        //Sin token ni nada, para probar
        @GET("alumno")
        Call<List<Alumno>> listaDeAlumnos( );

        @GET("alumno/test")
        Call<MyDataModel> test();

        @GET("pokemon/{id}")
        Call<MyDataModel> testa(@Path("id") String id);


//#################  CURSOS   #######################################

//        //Traer Lista de cursos por turno
//        @GET("Curso/{turnoId}")
//        Call<ArrayList<Curso>> listaDeCursoPorTurno( );
//
//        //Traer curso por id (seleccion de año)
//        @GET("Curso/{id}")
//        Call<ArrayList<Curso>> CursoAno( );

//#################  TURNOS   #######################################
        //Lista de Turno
        @GET("turno")
        Call<ArrayList<Turno>> listaDeTurnos();

//#################  AÑOS  #######################################


//#################  DIVISIO   #######################################


//#################  ASISTENCIA   #######################################



    }
}
