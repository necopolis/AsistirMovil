package com.avaca.asistirandroid.ui.partediario;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.databinding.FragmentPerfilBinding;
import com.avaca.asistirandroid.modelo.AlumnoCurso;
import com.avaca.asistirandroid.modelo.Autoridad;
import com.avaca.asistirandroid.modelo.Diario;
import com.avaca.asistirandroid.ui.asistencia.AlumnoAdapter;
import com.avaca.asistirandroid.ui.asistencia.AlumnoFragment;
import com.avaca.asistirandroid.ui.asistencia.AlumnoViewModel;

import java.io.File;
import java.util.ArrayList;

public class DiarioFragment extends Fragment {

    private RecyclerView ReciclerViewDiario;
    private DiarioAdapter diarioAdapter;
    private DiarioViewModel mViewModel;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri photoUri;
    ImageView imgView;
    File storageDir;
    //String imageFileName;


    public static AlumnoFragment newInstance() {
        return new AlumnoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diario_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(DiarioViewModel.class);
        ReciclerViewDiario = view.findViewById(R.id.rvDiario);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        mViewModel.getDiarioMT().observe(getViewLifecycleOwner(), new Observer<ArrayList<Diario>>() {
            @Override
            public void onChanged(ArrayList<Diario> diarios) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                );
                ReciclerViewDiario.setLayoutManager(linearLayoutManager);
                diarioAdapter = new DiarioAdapter(diarios, view , getLayoutInflater());
                ReciclerViewDiario.setAdapter(diarioAdapter);
            }
        });

        mViewModel.setCursoMT(getArguments());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}