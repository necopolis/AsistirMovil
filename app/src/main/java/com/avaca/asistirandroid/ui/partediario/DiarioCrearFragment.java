package com.avaca.asistirandroid.ui.partediario;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.databinding.DiarioCrearFragmentBinding;
import com.avaca.asistirandroid.databinding.FragmentGalleryBinding;
import com.avaca.asistirandroid.modelo.Asistencia;
import com.avaca.asistirandroid.modelo.Diario;
import com.avaca.asistirandroid.request.ApiClient;
import com.avaca.asistirandroid.ui.asistencia.CursoViewModel;
import com.avaca.asistirandroid.ui.asistencia.DivisionViewModel;
import com.avaca.asistirandroid.ui.gallery.GalleryViewModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DiarioCrearFragment extends Fragment {

    private DiarioCrearViewModel mViewModel;

    private TextView tvFecha;
    private EditText editTextObservaciones;
    private Button button;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.diario_crear_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(DiarioCrearViewModel.class);

        tvFecha = view.findViewById(R.id.tvFecha);
        editTextObservaciones = view.findViewById(R.id.editTextObservaciones);
        button = view.findViewById(R.id.button);

        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        // Obtener la fecha formateada
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Configurar observadores para actualizar la interfaz de usuario cuando cambien los LiveData
        mViewModel.getmTextObservacion().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                editTextObservaciones.setText(s);
            }
        });

        mViewModel.getmFecha().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvFecha.setText(s);
            }
        });

        mViewModel.getMbutton().observe(getViewLifecycleOwner(), new Observer<Button>() {
            @Override
            public void onChanged(Button button) {
                // Puedes hacer algo con el botón si es necesario
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actualizar el ViewModel cuando se hace clic en el botón
                mViewModel.setMbutton(fechaFormateada, editTextObservaciones.getText().toString());
            }
        });

        // Inicializar los LiveData con valores predeterminados o cargar valores iniciales
        mViewModel.setmFecha(fechaFormateada);
        //mViewModel.setmTextObservacion("Observación Inicial");

        return view;
    }

}