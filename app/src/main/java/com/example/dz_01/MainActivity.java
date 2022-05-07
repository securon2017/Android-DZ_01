package com.example.dz_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText lcdSize;
    private EditText horizontalSize;
    private EditText verticalSize;
    private TextView textView;
    private TextView density;
    private Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View view){
        lcdSize = findViewById(R.id.lcdSize);
        horizontalSize = findViewById(R.id.horizontalSize);
        verticalSize = findViewById(R.id.verticalSize);
        textView = findViewById(R.id.textView6);
        density = findViewById(R.id.density);

        double vertical = Double.parseDouble(horizontalSize.getText().toString());
        double horizontal = Double.parseDouble(verticalSize.getText().toString());
        double diagonal = Double.parseDouble(lcdSize.getText().toString());
        result = Math.sqrt(Math.pow(vertical,2) + Math.pow(horizontal,2))/diagonal;
        textView.setText("DPI экрана: " + new DecimalFormat("##").format(result) + " пикселей на дюйм");
        if (result <= 120) {
            density.setText("Классификатор плотности: ldpi");
        }
        else if (result > 120 && result <= 160 ) {
            density.setText("Классификатор плотности: mdpi");
        }
        else if (result <= 240) {
            density.setText("Классификатор плотности: hdpi");
        }
        else if (result <= 320) {
            density.setText("Классификатор плотности: xhdpi");
        }
        else if (result <= 480) {
            density.setText("Классификатор плотности: xxhdpi");
        }
        else if (result <= 640) {
            density.setText("Классификатор плотности: xxxhdpi");
        }
    }
}