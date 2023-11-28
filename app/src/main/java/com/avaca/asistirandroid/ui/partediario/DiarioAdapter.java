package com.avaca.asistirandroid.ui.partediario;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Asistencia;
import com.avaca.asistirandroid.modelo.Diario;
import com.avaca.asistirandroid.modelo.Division;
import com.avaca.asistirandroid.request.ApiClient;
import com.avaca.asistirandroid.ui.asistencia.DivisionAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiarioAdapter extends RecyclerView.Adapter<DiarioAdapter.MiViewHolder>{

    private final ArrayList<Diario> diarioList;
    private final View context;
    private final LayoutInflater inflaterVista;


    public DiarioAdapter(ArrayList<Diario> diarioList, View view, LayoutInflater inflater) {
        this.diarioList=diarioList;
        this.context=view;
        this.inflaterVista=inflater;
    }
    //
    @NonNull
    @Override
    public DiarioAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //######## Designo la vista, item inquilino y la paso a mi holder para llenar los campos #########
        View view =inflaterVista.inflate(R.layout.diario_detalle_fragment, parent, false);
        return new DiarioAdapter.MiViewHolder(view);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull DiarioAdapter.MiViewHolder holder, int position) {
        Diario diario= diarioList.get(position);
//        Glide.with(context.getContext())
//                .load(ApiClient.getConecion() +inmueble.getImagen())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.img);
//        Log.d("exc", "exc:"+ inmueble.getDireccion());
        holder.fecha.setText(diario.getFecha().toString());
        holder.observacion.setText(diario.getResumen());
        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevaObservacion = holder.observacion.getText().toString();

                Diario diarioAux= new Diario();
                diarioAux.setResumen(nuevaObservacion);
                diarioAux.setId(diario.getId());
                //asistencia.setDescripcion("ProbandoDescripcion");
                //asistencia.setImagen("ProbandoImagen");
                Call<Diario> callDiario = ApiClient.getMyApiClient().ActualizaDiario(diarioAux);
                callDiario.enqueue(new Callback<Diario>() {
                    @Override
                    public void onResponse(Call<Diario> call, Response<Diario> response) {
                        if (response.isSuccessful())
                        {
                            Log.d("Salida", "onResponse: "+response.message());
                            Toast.makeText(v.getContext(), "Parte diario Actualizado", Toast.LENGTH_SHORT).show();

                        }
                        if(response.code() == 406)
                        {
                            Log.d("Salida", "onResponse: "+response.code() + "  "+response.errorBody());
                            Toast.makeText(v.getContext(), "No se pudo actualizar", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Diario> call, Throwable t) {
                        Log.d("Salida", "ERROR: "+t.getMessage());
                    }
                });
            }
        });
    }
    //
    @Override
    public int getItemCount() {
        return diarioList.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{
        //Elementos de la vista
//        private final ImageView img;
        private final TextView fecha;
        private final TextView observacion;
        private final Button btnEditar;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha=itemView.findViewById(R.id.tvFechaEditarDiario);
            observacion = itemView.findViewById(R.id.multiLineObservacioDiario);
            btnEditar=itemView.findViewById(R.id.btnEditarDiario);
        }
//
//
    }
}
