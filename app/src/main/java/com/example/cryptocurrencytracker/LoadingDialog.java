package com.example.cryptocurrencytracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

class LoadingDialog {
    private Activity activity;
    private AlertDialog dialog;

    LoadingDialog(Activity myactivity) {
        activity = myactivity;
    }

    public void startLoadingAnimation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    void dismissDialog() {
        dialog.dismiss();
    }
}
