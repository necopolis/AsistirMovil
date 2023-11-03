package com.avaca.asistirandroid.ui.asistencia;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class TurnoAdapter extends RecyclerView.Adapter<TurnoAdapter.MiViewHolder> {

    private final ArrayList<Turno> turnoList;
    private final View context;
//    private final Context context;
//    private final View root;
    private final LayoutInflater inflaterVista;

        public TurnoAdapter(ArrayList<Turno> turnoList, View view, LayoutInflater inflater){
//    public TurnoAdapter(View root, ArrayList<Turno> turnoList) {
        this.turnoList=turnoList;
        this.context=view;
//        this.root = root;
//        this.context = root.getContext();
        this.inflaterVista=inflater;
//        this.inflaterVista=LayoutInflater.from(root.getContext());

    }

    @NonNull
    @Override
    public TurnoAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //######## Designo la vista, item inquilino y la paso a mi holder para llenar los campos #########
        View view =inflaterVista.inflate(R.layout.turno_detalle_fragment, parent, false);
        return new TurnoAdapter.MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TurnoAdapter.MiViewHolder holder, int position) {
        Turno turno= turnoList.get(position);
//        Glide.with(context.getContext())
//                .load(ApiClient.getConecion() +inmueble.getImagen())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.img);
        //Log.d("exc", "exc:"+ inmueble.getDireccion());
        holder.tituloTurno.setText(turno.getNombre());
        holder.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle= new Bundle();
//////                bundle.putSerializable("turno", turno);
////                Navigation.findNavController(context).navigate(R.id.rvAno, bundle);
//                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//                transaction.replace(R.id.rvTurno, new SeleccionarDivisionFragment());
//                transaction.addToBackStack(null);
//                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return turnoList.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{
        //Elementos de la vista
//        private final ImageView img;
        private final TextView tituloTurno;
        private final Button btnVer;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTurno=itemView.findViewById(R.id.tvTitleTurno);
            btnVer=itemView.findViewById(R.id.btnVerTurno);
        }
    }

    //#####################################################


}
