package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unitcoverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText input;
    String[] convertionArr = {"Fah to cel", "Pounds to Kg", "Inches to Feet", "Ounces to Ml"};
    double result;
    TextView display;
    Toast toast;
    ActivityMainBinding activityMainBinding;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        // button setup
        activityMainBinding.convertBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("INFO", "value:" + result);
                toast = Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_LONG);
                String newValue = String.valueOf(result);
                activityMainBinding.celciusText.setText(newValue);
            }
        });

        //Spinner and arr adapter
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, convertionArr);
        activityMainBinding.spinner.setAdapter(adapter);

        // input
        input = findViewById(R.id.input);
        display = findViewById(R.id.celcius_text);

       activityMainBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(input.getText().length() == 0){
                    return;
                }
                if(parent.getItemAtPosition(position).equals(0)){

                }
                else {


                    switch (position) {
                        case 0:  // fah to cel
                        {
                            Log.i("INFO", "FAH!" + input.getText().toString());
                            result = Converter.toCelcius(Double.parseDouble(input.getText().toString()));
                            break;
                        }
                        case 1:  // pounds to kg
                        {
                            Log.i("INFO", "1");
                            result = Converter.toKilograms(Float.parseFloat(input.getText().toString()));
                            break;
                        }
                        case 2: // inches to feet
                        {
                            result = Converter.toFeet(Float.parseFloat(input.getText().toString()));
                            Log.i("INFO", "2");
                            break;
                        }
                        case 3:  // ounces to Ml
                        {
                            result = Converter.toMl(Float.parseFloat(input.getText().toString()));
                            Log.i("INFO", "3");
                            break;
                        }
                        default:
                            break;

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}