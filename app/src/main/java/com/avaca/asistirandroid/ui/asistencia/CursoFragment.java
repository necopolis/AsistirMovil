package com.avaca.asistirandroid.ui.asistencia;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
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

import com.avaca.asistirandroid.modelo.Curso;
import com.avaca.asistirandroid.modelo.Turno;
import com.avaca.asistirandroid.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class CursoFragment extends Fragment {

    private RecyclerView ReciclerViewInquilino;
    private CursoAdapter cursoAdapter;
    private CursoViewModel mViewModel;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Uri photoUri;

    public static CursoFragment newInstance() {
        return new CursoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.curso_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(CursoViewModel.class);
        ReciclerViewInquilino = view.findViewById(R.id.rvCurso);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        mViewModel.getCursoMT().observe(getViewLifecycleOwner(), new Observer<ArrayList<Curso>>() {
            @Override
            public void onChanged(ArrayList<Curso> cursos) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                );
                ReciclerViewInquilino.setLayoutManager(linearLayoutManager);
                cursoAdapter = new CursoAdapter(cursos, view , getLayoutInflater());
                ReciclerViewInquilino.setAdapter(cursoAdapter);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            // La foto se ha tomado con éxito, puedes manejarla según tus necesidades
            // En este ejemplo, puedes enviarla a tu API con Retrofit
            if (photoUri != null) {
                // Aquí deberías implementar la lógica para enviar la imagen con Retrofit
                // photoUri contiene la URI de la imagen capturada
            }
        }
    }
}