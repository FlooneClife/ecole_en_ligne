package com.example.ecole_en_ligne.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.ecole_en_ligne.R;

public class ActionUtil {

    public static void showPurplePopup(Context context, String headerTitle, String contentText, String buttonText, ViewGroup root) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyAlertDialog);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_blue_custom, root);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.titrepopup)).setText(headerTitle);
        ((TextView) view.findViewById(R.id.description)).setText(contentText);
        ((Button) view.findViewById(R.id.boutonOk)).setText(buttonText);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.boutonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    public static void showOrangePopup(Context context, String headerTitle, String contentText, String buttonText, ViewGroup root) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyAlertDialog);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_orange_custom, root);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.titrepopup)).setText(headerTitle);
        ((TextView) view.findViewById(R.id.description)).setText(contentText);
        ((Button) view.findViewById(R.id.boutonOk)).setText(buttonText);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.boutonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    public static void showContactPopup(Context context, ViewGroup root) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.MyAlertDialog);
        View view = LayoutInflater.from(context).inflate(R.layout.popup_contact, root);
        builder.setView(view);
        ((TextView) view.findViewById(R.id.titrepopup)).setText(R.string.contactTitle);

        view.findViewById(R.id.email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //// ouvrir appplication email
            }
        });

        view.findViewById(R.id.tel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri num = Uri.parse("tel: 01 23 45 67 89");
                Intent appel = new Intent(Intent.ACTION_DIAL,num);
                context.startActivity(appel);
            }
        });

        ((Button) view.findViewById(R.id.boutonOk)).setText(R.string.retour);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.boutonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

}
