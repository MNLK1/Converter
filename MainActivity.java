//Пушкарский 303
package com.example.converter.pushkarskiy303;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerFrom;
    Spinner spinnerTo;
    EditText editTextFromStr;
    TextView textViewToStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        editTextFromStr = findViewById(R.id.editTextFrom);
        textViewToStr = findViewById(R.id.textViewTo);

        ArrayAdapter<String> arrayAdapter = new <String>ArrayAdapter(this, android.R.layout.simple_list_item_1);
        arrayAdapter.add("mm");
        arrayAdapter.add("cm");
        arrayAdapter.add("m");
        arrayAdapter.add("km");

        spinnerFrom.setAdapter(arrayAdapter);
        spinnerTo.setAdapter(arrayAdapter);
    }

    public void convert_click(View v) {
        double from = 0.0, to = 0.0, m = 0.0;

        try {
            from = Double.parseDouble(editTextFromStr.getText().toString());
        } catch (Exception e) {
            editTextFromStr.setError("Введите число!");
            return;
        }

        String sFrom = (String) spinnerFrom.getSelectedItem();
        String sTo = (String) spinnerTo.getSelectedItem();

        if (sFrom.equals("mm")) m = from / 1000.0;
        if (sFrom.equals("cm")) m = from / 100.0;
        if (sFrom.equals("m")) m = from / 1.0;
        if (sFrom.equals("km")) m = from * 1000.0;

        if (sTo.equals("mm")) to = m * 1000.0;
        if (sTo.equals("cm")) to = m * 100.0;
        if (sTo.equals("m")) to = m * 1.0;
        if (sTo.equals("km")) to = m / 1000.0;

        textViewToStr.setText(String.valueOf(to));
    }
}
//Пушкарский 303