package com.avaca.asistirandroid.ui.asistencia;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.databinding.TurnoFragmentBinding;
import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.modelo.Division;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class DivisionFragment extends Fragment {

    private RecyclerView ReciclerViewInquilino;
    private DivisionAdapter divisionAdapter;
    private DivisionViewModel mViewModel;


    public static DivisionFragment newInstance() {
        return new DivisionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.division_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(DivisionViewModel.class);
        ReciclerViewInquilino = view.findViewById(R.id.rvAno);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        mViewModel.getDivisionMT().observe(getViewLifecycleOwner(), new Observer<ArrayList<Division>>() {
            @Override
            public void onChanged(ArrayList<Division> divisiones) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                );
                ReciclerViewInquilino.setLayoutManager(linearLayoutManager);
                divisionAdapter = new DivisionAdapter(divisiones, view , getLayoutInflater());
                ReciclerViewInquilino.setAdapter(divisionAdapter);
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