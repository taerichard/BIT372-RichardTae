package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        Button poundKgButton = findViewById(R.id.poundToKg_Button);

        EditText poundInput = findViewById(R.id.pound_input);
        TextView kgText = findViewById(R.id.kg_text);

        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);
        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });

        poundKgButton.setOnClickListener((v) ->{
            if(poundInput.getText().length() == 0){
                return;
            }
            double kg = Converter.poundToKg(Double.parseDouble(poundInput.getText().toString()));
            Log.i("INFO", "Value " + kg);
            kgText.setText(Double.toString(kg));

        });
    }
}