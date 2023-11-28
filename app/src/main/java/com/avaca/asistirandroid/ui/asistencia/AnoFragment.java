package com.avaca.asistirandroid.ui.asistencia;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.modelo.Ano;
import com.avaca.asistirandroid.modelo.Turno;

import java.util.ArrayList;

public class AnoFragment extends Fragment {
    private RecyclerView ReciclerViewInquilino;
    private AnoAdapter anoAdapter;
    private AnoViewModel mViewModel;


    public static TurnoFragment newInstance() {
        return new TurnoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ano_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(AnoViewModel.class);
        ReciclerViewInquilino = view.findViewById(R.id.rvAno);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        mViewModel.getAnoMT().observe(getViewLifecycleOwner(), new Observer<ArrayList<Ano>>() {
            @Override
            public void onChanged(ArrayList<Ano> anos) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                );
                ReciclerViewInquilino.setLayoutManager(linearLayoutManager);
                anoAdapter = new AnoAdapter(anos, view , getLayoutInflater());
                ReciclerViewInquilino.setAdapter(anoAdapter);
            }
        });

        mViewModel.setAnoMT(getArguments());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}