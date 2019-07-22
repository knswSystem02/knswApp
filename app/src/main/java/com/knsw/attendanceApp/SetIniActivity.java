package com.knsw.attendanceApp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SetIniActivity extends AppCompatActivity {

    private TextView titleText;
    private Button homeButton;
    private PopupWindow mPopupWindow;
    private NumberPicker numPicker0, numPicker1, numPicker2, numPicker3;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private String[] figures = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_ini);

        titleText = findViewById(R.id.titleText);
        Button returnButton = findViewById(R.id.homeButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        EditText startTimeForm = findViewById(R.id.startTimeForm);
        startTimeForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        EditText endTimeForm = findViewById(R.id.endTimeForm);
        endTimeForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        //コンテキストからインフレータを取得
        LayoutInflater inflater = LayoutInflater.from(SetIniActivity.this);
        View view = inflater.inflate(R.layout.popup_numpick, null, false);

        NumberPicker startHour = view.findViewById(R.id.startHour);
        startHour.setMaxValue(23);
        startHour.setMinValue(1);
        NumberPicker startMinute = view.findViewById(R.id.startMinute);
        startMinute.setMaxValue(12);
        startMinute.setMinValue(1);
        startMinute.setDisplayedValues(
                new String[]{"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"});

        NumberPicker endHour = view.findViewById(R.id.endHour);
        endHour.setMaxValue(23);
        endHour.setMinValue(1);
        NumberPicker endMinute = view.findViewById(R.id.endMinute);
        endMinute.setMaxValue(12);
        endMinute.setMinValue(1);
        endMinute.setDisplayedValues(
                new String[]{"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"});

        AlertDialog.Builder builder = new AlertDialog.Builder(SetIniActivity.this);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // OKクリック時の処理
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.setView(view);
        builder.show();
    }
}