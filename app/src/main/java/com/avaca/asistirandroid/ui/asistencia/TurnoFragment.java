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
//import com.avaca.asistirandroid.databinding.TurnoFragmentBinding;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class TurnoFragment extends Fragment {
    private RecyclerView ReciclerViewInquilino;
    private TurnoAdapter turnoAdapter;
    private TurnoViewModel mViewModel;
//    private TurnoFragmentBinding binding;

    public static TurnoFragment newInstance() {
        return new TurnoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.turno_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(TurnoViewModel.class);
//        binding = TurnoFragmentBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        ReciclerViewInquilino = view.findViewById(R.id.rvTurno);
//        ReciclerViewInquilino= binding.rvTurno;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        mViewModel.getInquilinoMT().observe(getViewLifecycleOwner(), new Observer<ArrayList<Turno>>() {
            @Override
            public void onChanged(ArrayList<Turno> turnos) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                );
                ReciclerViewInquilino.setLayoutManager(linearLayoutManager);
                turnoAdapter = new TurnoAdapter(turnos, view , getLayoutInflater());
                ReciclerViewInquilino.setAdapter(turnoAdapter);
            }
        });

        mViewModel.setTurnoMT(getArguments());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

//##################################################################################

//############################################################################

}