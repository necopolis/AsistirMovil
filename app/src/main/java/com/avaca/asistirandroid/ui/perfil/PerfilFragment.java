package com.avaca.asistirandroid.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.avaca.asistirandroid.databinding.FragmentPerfilBinding;
import com.avaca.asistirandroid.modelo.Autoridad;

public class PerfilFragment extends Fragment {

    private PerfilViewModel mViewModel;
    private FragmentPerfilBinding binding;
    private Toast toast;

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel=new ViewModelProvider(this).get(PerfilViewModel.class);
        binding= FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //Cargo los datos del usuario Actual
        //Viene del ViewModel MutableLiveData <-> Observe llama al metodo getPropietario().observe()
        // el observer correlacionado con el mutable del lado view model autoridadMT.setValue() ahi le seteo la autoridad
        //del lado del view model traigo desde la api y se la doy al mutable para lo traiga
        // por el observe en el metodo onChange() con el binding
        mViewModel.getPropietario().observe(getViewLifecycleOwner(), new Observer<Autoridad>() {
            @Override
            public void onChanged(Autoridad propietario) {
                binding.edtDNI.setText(propietario.getDNI().toString());
                binding.edtNombre.setText(propietario.getNombre());
                binding.edtApellido.setText(propietario.getApellido());
                binding.edtPassword.setText(propietario.getContraseña());
            }
        });
        mViewModel.getCamposMT().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.edtDNI.setEnabled(aBoolean);
                binding.edtNombre.setEnabled(aBoolean);
                binding.edtApellido.setEnabled(aBoolean);
                binding.edtEmail.setEnabled(aBoolean);
                binding.edtPassword.setEnabled(aBoolean);
                binding.edtTelefono.setEnabled(aBoolean);
            }
        });

        binding.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.editarDatos();
            }
        });

        mViewModel.getBTNEditarMT().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.btnEditar.setEnabled(aBoolean);
            }
        });
        mViewModel.getBTNGuardarMT().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.btnGuardar.setEnabled(aBoolean);
            }
        });
        mViewModel.gettoastMT().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();

            }
        });
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Autoridad EditadoP = new Autoridad();
                EditadoP.setDNI(binding.edtDNI.getText().toString());
                EditadoP.setNombre(binding.edtNombre.getText().toString());
                EditadoP.setApellido(binding.edtApellido.getText().toString());
                EditadoP.setContraseña(binding.edtPassword.getText().toString());
                //Se modifico la api para que se vean los cambios realizados
                mViewModel.GuardarDatos(EditadoP);
                mViewModel.bloquearCampor();
            }
        });
        //mViewModel.ActualizarPantalla();
        mViewModel.bloquearCampor();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PerfilViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    /*private PerfilViewModel perfilViewModel;
    private FragmentHomeBinding binding;
    private Toast toast;

    public static PerfilFragment newInstance() {
        return new PerfilFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView7;
        perfilViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
}