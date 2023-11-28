package com.avaca.asistirandroid.ui.informes;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.avaca.asistirandroid.R;
import com.avaca.asistirandroid.ui.partediario.ParteDiarioFragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;


public class InformesFragment extends Fragment {

    GraphView grafica1;
    GraphView grafica;
    private LineChart lineChart;
    private LineDataSet lineDataSet;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
        public static InformesFragment newInstance() {
    return new InformesFragment();
}
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment InformesFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static InformesFragment newInstance(String param1, String param2) {
//        InformesFragment fragment = new InformesFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        
        View view = inflater.inflate(R.layout.fragment_informes, container, false);

        lineChart = view.findViewById(R.id.lineChart);

// Creamos un set de datos
        ArrayList<Entry> lineEntries = new ArrayList<Entry>();
        for (int i = 0; i<11; i++){
            float y = (int) (Math.random() * 8) + 1;
            lineEntries.add(new Entry((float) i,(float)y));
        }

// Unimos los datos al data set
        lineDataSet = new LineDataSet(lineEntries, "Platzi");

// Asociamos al gráfico
        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);
        lineChart.setData(lineData);
        
        grafica = view.findViewById(R.id.grafica);

        // DATOS DE LAS BARRAS
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
        });

        grafica.addSeries(series);

        // ESTILO
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(20);

        // DIBUJANDO LOS VALORES
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);


        return view;
    }
}