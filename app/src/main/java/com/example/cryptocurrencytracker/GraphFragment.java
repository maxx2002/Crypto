package com.example.cryptocurrencytracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class GraphFragment extends Fragment {

    private View view;
    LineChart lineChart;
    Graph graph;
    Button graph_Button_checkgraph;
    MaterialSpinner graph_spinner;

    String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_graph, container, false);

        graph_Button_checkgraph = view.findViewById(R.id.graph_Button_checkgraph);
        graph_spinner = view.findViewById(R.id.graph_spinner);
        lineChart = view.findViewById(R.id.LineChart);

        graph = new Graph(lineChart);
        graph_spinner.setItems(coin);

        graph_Button_checkgraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("BTC")){
                    graph._lineGraph(getContext(), "BTC");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("ETH")){
                    graph._lineGraph(getContext(), "ETH");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("ETC")){
                    graph._lineGraph(getContext(), "ETC");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("XRP")){
                    graph._lineGraph(getContext(), "XRP");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("LTC")){
                    graph._lineGraph(getContext(), "LTC");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("XMR")){
                    graph._lineGraph(getContext(), "XMR");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("DASH")){
                    graph._lineGraph(getContext(), "DASH");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("MAID")){
                    graph._lineGraph(getContext(), "MAID");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("AUR")){
                    graph._lineGraph(getContext(), "AUR");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("XEM")){
                    graph._lineGraph(getContext(), "XEM");
                }
            }
        });

        return view;
    }
}