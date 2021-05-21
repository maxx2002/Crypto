package com.example.cryptocurrencytracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class GraphActivity extends AppCompatActivity {

    LineChart lineChart;
    Graph graph;
    Button graph_Button_checkgraph;
    MaterialSpinner graph_spinner;

    String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        graph_Button_checkgraph = findViewById(R.id.graph_Button_checkgraph);
        graph_spinner = findViewById(R.id.graph_spinner);
        lineChart = findViewById(R.id.LineChart);

        graph = new Graph(lineChart);
        graph_spinner.setItems(coin);


        graph_Button_checkgraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("BTC")){
                    graph._lineGraph(GraphActivity.this, "BTC");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("ETH")){
                    graph._lineGraph(GraphActivity.this, "ETH");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("ETC")){
                    graph._lineGraph(GraphActivity.this, "ETC");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("XRP")){
                    graph._lineGraph(GraphActivity.this, "XRP");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("LTC")){
                    graph._lineGraph(GraphActivity.this, "LTC");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("XMR")){
                    graph._lineGraph(GraphActivity.this, "XMR");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("DASH")){
                    graph._lineGraph(GraphActivity.this, "DASH");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("MAID")){
                    graph._lineGraph(GraphActivity.this, "MAID");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("AUR")){
                    graph._lineGraph(GraphActivity.this, "AUR");
                }else if(graph_spinner.getItems().get(graph_spinner.getSelectedIndex()).toString().equals("XEM")){
                    graph._lineGraph(GraphActivity.this, "XEM");
                }
            }
        });
    }


}







