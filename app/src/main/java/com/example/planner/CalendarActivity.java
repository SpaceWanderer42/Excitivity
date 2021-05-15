package com.example.planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

public class CalendarActivity extends AppCompatActivity{

    private Button button;
    CalendarView calendarr;
    TextView date_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarr = (CalendarView)
                findViewById(R.id.calendarView);
        date_view = (TextView)
                findViewById(R.id.textView2);

        calendarr
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth) {
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                date_view.setText(Date);
                            }
                        }
                );

        button = (Button) findViewById(R.id.button_second);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openProgramsActivity();

            }
        });
    }

            public void openProgramsActivity() {


            Intent intent = new Intent(this, ProgramsActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }

    }


