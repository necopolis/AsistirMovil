package com.avaca.asistirandroid.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.avaca.asistirandroid.modelo.Alumno;
import com.avaca.asistirandroid.modelo.AlumnoCurso;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Asistencia;
import com.avaca.asistirandroid.modelo.Autoridad;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.modelo.Diario;
import com.avaca.asistirandroid.modelo.Division;
import com.avaca.asistirandroid.modelo.MyDataModel;
import com.avaca.asistirandroid.modelo.Post;
import com.avaca.asistirandroid.modelo.Turno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiClient {
    //"http://192.168.1.10:45462/api/"
    private static final String UrlBase = "http://192.168.1.8:45455/api/";
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
        Call<ArrayList<Alumno>> listaDeAlumnos();

        //Lista de alumno seleccionados, idTurno= turno, idAno= ano, idDivision= division, idAutoridad= autoridad, fechaAno= 01-01-año
        @GET("alumnocurso/autoridad/{id}")
        Call<ArrayList<Alumno>> listaDeAlumnoPorCurso( @Path("id") int id);

        @GET("alumno/test")
        Call<MyDataModel> test();

        @GET("pokemon/{id}")
        Call<MyDataModel> testa(@Path("id") String id);

        @GET("alumnocurso/autoridad/{autoridadId}/curso/{cursoId}/anoFecha/{dateAnoFecha}")
        Call<ArrayList<Alumno>> listaDeAlumnoDeCurso(
                @Path("autoridad") int autoridadId,
                @Path("curso") int cursoId,
                @Path("anoFecha") String dateAnoFecha);

        @GET("alumnocurso/autoridad/{autoridadId}/curso/{cursoId}")
        Call<ArrayList<Alumno>> listaDeAlumnoDeCursoAux(
                @Path("autoridadId") String autoridadId,
                @Path("cursoId") String cursoId);

        @GET("alumnocurso/autoridad/{autoridadId}/curso/{cursoId}")
        Call<ArrayList<AlumnoCurso>> listaDeAlumnoDeCursoAux2(
                @Path("autoridadId") String autoridadId,
                @Path("cursoId") String cursoId);


//#################  CURSOS   #######################################

        //Traer Lista de cursos por turno
        @GET("curso/autoridad/{id}/fecha/{fecha}")
        Call<ArrayList<Curso>> listaDeCursoPorAutoridad(@Path("id") int id, @Path("fecha") String fecha);
//
        //Traer curso por id (seleccion de año)
        @GET("curso")
        Call<ArrayList<Curso>> listaDeCursos( );

//#################  TURNOS   #######################################
        //Lista de Turno
        @GET("turno")
        Call<ArrayList<Turno>> listaDeTurnos();

        //Turno Por Id
        @GET("turno/{id}")
        Call<Turno> TurnoPorId(@Path("id") int id );

//#################  AÑOS  #######################################
        //Lista de Ano
        @GET("ano")
        Call<ArrayList<Ano>> listaDeAnos();

        //Ano Por Id
        @GET("ano/{id}")
        Call<Ano> AnoPorId(@Path("id") int id );

//#################  DIVISION   #######################################
        //Lista de Division
        @GET("division")
        Call<ArrayList<Division>> listaDeDivision();

        //Division Por Id
        @GET("division/{id}")
        Call<Division> DivisionPorId(@Path("id") int id );

//#################  ASISTENCIA   #######################################

        //Asistencia x ID-AlumnoCurso
        @POST("asistencia")
        Call<Asistencia> CrearAsistencia(@Body Asistencia asistencia);

//#################  IMAGEN   #######################################
        @Multipart
        @POST("UploadFile/upload")
        Call<String> uploadImage(
                @Part MultipartBody.Part image,
                @Part("name") RequestBody name
        );


//#################  DIARIO   #######################################

        @POST("diario")
        Call<Diario> CrearDiario(@Body Diario diario);

        @PUT("diario")
        Call<Diario> ActualizaDiario(@Body Diario diario);

        @GET("diario")
        Call <ArrayList<Diario>> todosLosDiarios();

        @GET("diario/{id}")
        Call <ArrayList<Diario>> DiarioId(@Path("id") int id );

    }
}
