package com.example.cryptocurrencytracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import Model.Coin;
import Remote.CoinService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PriceFragment extends Fragment {

    private View view;

    CoinService mService;

    RadioButton coin2coin, money2coin, coin2money;
    MaterialSpinner fromSpinner,toSpinner;
    RadioGroup radioGroup;
    Button btnConvert;
    ImageView coinImage;
    TextView toTextView;

    String[] money = {"USD", "EUR", "IDR"};
    String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_price, container, false);
        mService = Common.getCoinService();

        fromSpinner = view.findViewById((R.id.fromSpinner));
        toSpinner = view.findViewById((R.id.toSpinner));
        btnConvert = view.findViewById(R.id.btnConvert);
        radioGroup = view.findViewById(R.id.radioGroup);
        coin2coin = view.findViewById(R.id.coin2coin);
        money2coin = view.findViewById(R.id.money2coin);
        coin2money = view.findViewById(R.id.coin2money);
        coinImage = view.findViewById(R.id.coinImage);
        toTextView = view.findViewById(R.id.toTextView);

        loadCoinList();

        btnConvert.setOnClickListener((view) -> { calculateValue();});

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.coin2coin) {
                    setCoin2CoinSource();
                } else if (checkedId == R.id.money2coin) {
                    setMoney2CoinSource();
                } else if (checkedId == R.id.coin2money) {
                    setCoin2MoneySource();
                }
            }
        });

        return view;
    }

    private void loadCoinList() {
        if (coin2money.isSelected()) {
            setCoin2MoneySource();
        } else if (coin2coin.isSelected()) {
            setCoin2CoinSource();
        } else if (money2coin.isSelected()) {
            setMoney2CoinSource();
        }
    }

    private void setCoin2CoinSource() {
        fromSpinner.setItems(coin);
        toSpinner.setItems(coin);
    }

    private void setCoin2MoneySource() {
        fromSpinner.setItems(coin);
        toSpinner.setItems(money);
    }

    private void setMoney2CoinSource() {
        fromSpinner.setItems(money);
        toSpinner.setItems(coin);
    }

    private void calculateValue() {
        ProgressDialog mDialog = new ProgressDialog(getContext());
        mDialog.setMessage("Please waiting...");
        mDialog.show();

        final String toCoin = toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString();
        final String fromCoin = fromSpinner.getItems().get(fromSpinner.getSelectedIndex()).toString();

        mService.calculatevalue(fromCoin,toCoin).enqueue(new Callback<Coin>() {
            @Override
            public void onResponse(Call<Coin> call, Response<Coin> response) {
                mDialog.dismiss();

                if (toCoin.equals("BTC")) {
                    showData(response.body().getBTC());
                } else if (toCoin.equals("ETH")) {
                    showData(response.body().getETH());
                } else if (toCoin.equals("ETC")) {
                    showData(response.body().getETC());
                } else if (toCoin.equals("XRP")) {
                    showData(response.body().getXRP());
                } else if (toCoin.equals("LTC")) {
                    showData(response.body().getLTC());
                } else if (toCoin.equals("XMR")) {
                    showData(response.body().getXMR());
                } else if (toCoin.equals("DASH")) {
                    showData(response.body().getDASH());
                } else if (toCoin.equals("MAID")) {
                    showData(response.body().getMAID());
                } else if (toCoin.equals("AUR")) {
                    showData(response.body().getAUR());
                } else if (toCoin.equals("XEM")) {
                    showData(response.body().getXEM());
                } else if (toCoin.equals("USD")) {
                    showData(response.body().getUSD());
                } else if (toCoin.equals("EUR")) {
                    showData(response.body().getEUR());
                } else if (toCoin.equals("IDR")) {
                    showData(response.body().getIDR());
                }
            }

            @Override
            public void onFailure(Call<Coin> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                mDialog.dismiss();
            }
        });
    }

    private void showData(String value) {
        if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("BTC")) {
            coinImage.setImageResource(R.drawable.btc);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("ETH")) {
            coinImage.setImageResource(R.drawable.eth);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("ETC")) {
            coinImage.setImageResource(R.drawable.etc);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("XRP")) {
            coinImage.setImageResource(R.drawable.xrp);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("LTC")) {
            coinImage.setImageResource(R.drawable.ltc);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("XMR")) {
            coinImage.setImageResource(R.drawable.xmr);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("DASH")) {
            coinImage.setImageResource(R.drawable.dash);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("MAID")) {
            coinImage.setImageResource(R.drawable.maid);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("AUR")) {
            coinImage.setImageResource(R.drawable.aur);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("XEM")) {
            coinImage.setImageResource(R.drawable.xem);
            toTextView.setText(value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("USD")) {
            coinImage.setImageResource(R.drawable.dollar);
            toTextView.setText("$ " + value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("EUR")) {
            coinImage.setImageResource(R.drawable.euro);
            toTextView.setText("??? " + value);
        } else if (toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString().equals("IDR")) {
            coinImage.setImageResource(R.drawable.indonesia);
            toTextView.setText("Rp " + value);
        }
    }
}