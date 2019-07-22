package com.knsw.attendanceApp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CalenderActivity extends AppCompatActivity {

    private TextView titleText;
    private Button prevButton, nextButton;
    private CalendarAdapter mCalendarAdapter;
    private GridView calendarGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        titleText = findViewById(R.id.titleText);
        prevButton = findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarAdapter.prevMonth();
                titleText.setText(mCalendarAdapter.getTitle());
            }
        });
        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarAdapter.nextMonth();
                titleText.setText(mCalendarAdapter.getTitle());
            }
        });
        Button returnButton = findViewById(R.id.homeButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        calendarGridView = findViewById(R.id.calendarGridView);
        mCalendarAdapter = new CalendarAdapter(this);
        calendarGridView.setAdapter(mCalendarAdapter);
        titleText.setText(mCalendarAdapter.getTitle());

        // TODO
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        //コンテキストからインフレータを取得
        LayoutInflater inflater = LayoutInflater.from(CalenderActivity.this);
        View view = inflater.inflate(R.layout.popup_numpick, null, false);

        NumberPicker startHour = view.findViewById(R.id.startHour);
        startHour.setMaxValue(23);
        startHour.setMinValue(1);
        NumberPicker startMinute = view.findViewById(R.id.startMinute);
        startMinute.setMaxValue(59);
        startMinute.setMinValue(1);

        NumberPicker endHour = view.findViewById(R.id.endHour);
        endHour.setMaxValue(23);
        endHour.setMinValue(1);
        NumberPicker endMinute = view.findViewById(R.id.endMinute);
        endMinute.setMaxValue(59);
        endMinute.setMinValue(1);


        AlertDialog.Builder builder = new AlertDialog.Builder(CalenderActivity.this);
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