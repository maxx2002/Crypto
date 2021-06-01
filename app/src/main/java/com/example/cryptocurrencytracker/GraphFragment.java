package com.example.cryptocurrencytracker;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class GraphFragment extends Fragment {

    private View view;
    LineChart lineChart;
    Graph graph;
    Button graph_Button_checkgraph;
    MaterialSpinner graph_spinner;
    TextView graph_textView_price, graph_textView_selisih;
    ImageView graph_imageview;

    String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_graph, container, false);

        graph_Button_checkgraph = view.findViewById(R.id.graph_Button_checkgraph);
        graph_spinner = view.findViewById(R.id.graph_spinner);
        lineChart = view.findViewById(R.id.LineChart);
        graph_textView_price = view.findViewById(R.id.graph_textView_price);
        graph_textView_selisih = view.findViewById(R.id.graph_textView_selisih);
        graph_imageview = view.findViewById(R.id.graph_imageview);

        graph = new Graph(lineChart);
        graph_spinner.setItems(coin);
        final Handler handler = new Handler();

        graph._lineGraph(getContext(), "BTC");
        graph_imageview.setVisibility(View.INVISIBLE);

        graph_spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                graph_imageview.setVisibility(View.INVISIBLE);
                graph_textView_price.setVisibility(View.INVISIBLE);
                graph_textView_selisih.setVisibility(View.INVISIBLE);
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
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        graph_imageview.setVisibility(View.VISIBLE);
                        graph_textView_price.setVisibility(View.VISIBLE);
                        graph_textView_selisih.setVisibility(View.VISIBLE);
                        tampildata();
                    }
                }, 2000);

            }
        });

        return view;
    }
    public void tampildata(){
        int check1 = 0;
        int check2 = 0;
        int resultdata2 = 0;
        int resultdata1 = 0;
        resultdata2 = graph.balikdata2();
        resultdata1 = graph.balikdata1();
        graph_textView_price.setText(String.valueOf(resultdata1)+", "+resultdata2);
        double selisih;
        String persen = "";
        if(resultdata2 >= resultdata1){
            selisih = (double)((double)((double)(resultdata2-resultdata1))/(resultdata1))*100;
            persen = (selisih)+"%";
            graph_textView_selisih.setTextColor(Color.parseColor("#008000"));
            graph_imageview.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_naik));
        }else{
            selisih = (double)((double)((double)(resultdata1-resultdata2))/(resultdata1))*100;
            persen = "-"+(selisih)+"%";
            graph_textView_selisih.setTextColor(Color.parseColor("#FF0000"));
            graph_imageview.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_turun));
        }

        graph_textView_selisih.setText(persen);

    }
}