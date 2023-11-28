package com.avaca.asistirandroid.ui.partediario;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.avaca.asistirandroid.MainActivity;
import com.avaca.asistirandroid.R;


import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.databinding.FragmentPerfilBinding;
import com.avaca.asistirandroid.modelo.Autoridad;
import com.avaca.asistirandroid.ui.perfil.PerfilViewModel;

public class ParteDiarioFragment extends Fragment {


    public static ParteDiarioFragment newInstance() {
        return new ParteDiarioFragment();
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parte_diario_fragment, container, false);

        Button btnCrearDiario = view.findViewById(R.id.btnCrearDiario);
        Button btnVerModificarDiario = view.findViewById(R.id.btnVerModificarDiario);

        btnCrearDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navegar al fragmento DiarioCrearFragment
                Navigation.findNavController(view).navigate(R.id.action_nav_partediario_to_diarioCrearFragment);


            }
        });

        btnVerModificarDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar al fragmento DiarioFragment
                Navigation.findNavController(v).navigate(R.id.action_nav_partediario_to_diarioFragment);
            }
        });

        return view;
    }


}