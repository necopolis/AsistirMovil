package com.avaca.asistirandroid.ui.asistencia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Division;

import java.util.ArrayList;

public class DivisionAdapter extends RecyclerView.Adapter<DivisionAdapter.MiViewHolder>{
    private final ArrayList<Division> divisionList;
    private final View context;
    private final LayoutInflater inflaterVista;


    public DivisionAdapter(ArrayList<Division> divisionList, View view, LayoutInflater inflater) {
        this.divisionList=divisionList;
        this.context=view;
        this.inflaterVista=inflater;
    }
    //
    @NonNull
    @Override
    public DivisionAdapter.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //######## Designo la vista, item inquilino y la paso a mi holder para llenar los campos #########
        View view =inflaterVista.inflate(R.layout.division_detalle_fragment, parent, false);
        return new DivisionAdapter.MiViewHolder(view);
    }
    //
    @Override
    public void onBindViewHolder(@NonNull DivisionAdapter.MiViewHolder holder, int position) {
        Division division= divisionList.get(position);
//        Glide.with(context.getContext())
//                .load(ApiClient.getConecion() +inmueble.getImagen())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.img);
//        Log.d("exc", "exc:"+ inmueble.getDireccion());
        holder.tituloDivision.setText(division.getNombre());
        holder.btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle bundle= new Bundle();
//                bundle.putSerializable("inmueble", inmueble);
//                Navigation.findNavController(view).navigate(R.id.AnoFragment, bundle);
            }
        });
    }
    //
    @Override
    public int getItemCount() {
        return divisionList.size();
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{
        //Elementos de la vista
//        private final ImageView img;
        private final TextView tituloDivision;
        private final Button btnVer;

        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloDivision=itemView.findViewById(R.id.tvTitleDivision);
            btnVer=itemView.findViewById(R.id.btnVerDivision);
        }
//
//
    }
}
