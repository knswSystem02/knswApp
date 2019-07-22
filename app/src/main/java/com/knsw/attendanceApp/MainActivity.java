package com.knsw.attendanceApp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class MainActivity extends AppCompatActivity {

    private TextView titleText;
    private Button setiniButton, inputButton, chooseButton, sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setiniButton = findViewById(R.id.setiniButton);
        setiniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SetIniActivity.class);
                startActivity(intent);
            }
        });

        Button chooseButton = findViewById(R.id.chooseButton);
        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), CalenderActivity.class);
                startActivity(intent);
            }
        });

        BootstrapButton bsButton = findViewById(R.id.bootstrap_button);
        bsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    public void showDialog() {
        //コンテキストからインフレータを取得
        LayoutInflater inflater = LayoutInflater.from(this);
        //ダイアログを構成
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO
                // 不要アラート
                dialog.dismiss();
            }
        });
        builder.setTitle("Bootstrapサンプルボタン");
        builder.show();
    }


}