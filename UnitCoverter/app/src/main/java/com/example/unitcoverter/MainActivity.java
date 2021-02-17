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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText title = findViewById(R.id.convert_title);

        // spinner
        Spinner spinner = findViewById(R.id.spinner);
        // array adapter with list of conversations
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.conversations_array, R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        // item selected listener for spinner
        spinner.setOnItemSelectedListener(this);

        Button fbtn = findViewById(R.id.convert_btn);

        EditText finput = findViewById(R.id.input);
        TextView ctxt = findViewById(R.id.celcius_text);

        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        //EditText title = view.findViewById(R.id.convert_title);
        switch(position){
            case 0 :  // pound
                // change title
                //title.setText("FAH TO CEL".toString());
                // user input
                // convert
                Log.i("INFO", parent.getItemAtPosition(0).toString());
                break;
            case 1 : // fah
                Log.i("INFO", parent.getItemAtPosition(1).toString());
                break;
            case 2 : // inches
                Log.i("INFO", parent.getItemAtPosition(2).toString());
                break;
            case 3 : // ounces
                Log.i("INFO", parent.getItemAtPosition(3).toString());
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

