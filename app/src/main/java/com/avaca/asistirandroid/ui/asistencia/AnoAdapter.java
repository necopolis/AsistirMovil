package com.avaca.asistirandroid.ui.asistencia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;

public class AnoAdapter{

//    private final ArrayList<Ano> anoList;
//    private final View context;
//    private final LayoutInflater inflaterVista;
//
//
//    public AnoAdapter(ArrayList<Ano> anoList, View view, LayoutInflater inflater) {
//        this.anoList=anoList;
//        this.context=view;
//        this.inflaterVista=inflater;
//
//    }
//
//    @NonNull
//    @Override
//    public AnoAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //######## Designo la vista, item inquilino y la paso a mi holder para llenar los campos #########
//        View view =inflaterVista.inflate(R.layout.item_inquilino, parent, false);
//        return new AnoAdapter.MiViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AnoAdapter.MiViewHolder holder, int position) {
//        Ano ano= anoList.get(position);
//        Glide.with(context.getContext())
//                .load(ApiClient.getConecion() +inmueble.getImagen())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.img);
//        Log.d("exc", "exc:"+ inmueble.getDireccion());
//        holder.dir.setText(inmueble.getDireccion());
//        holder.btnVer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle bundle= new Bundle();
//                bundle.putSerializable("inmueble", inmueble);
//                Navigation.findNavController(context).navigate(R.id.AnoFragment, bundle);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return anoList.size();
//    }
//
//    public class MiViewHolder extends RecyclerView.ViewHolder{
//        //Elementos de la vista
//        private final ImageView img;
//        private final TextView dir;
//        private final Button btnVer;
//
//        public MiViewHolder(@NonNull View itemView) {
//            super(itemView);
//            img=itemView.findViewById(R.id.ivContratoItem);
//            dir=itemView.findViewById(R.id.tvDireContratoItem);
//            btnVer=itemView.findViewById(R.id.btnVerInmuebleInquilino);
//        }
//
//
//    }
}
