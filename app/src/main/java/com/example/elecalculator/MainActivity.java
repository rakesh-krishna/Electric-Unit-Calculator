package com.example.elecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText editText;
    EditText editText2;
    Button button;
    TextView textView;
    String[] types ={"Amps","kW","kVA","VA","volts","watts","joules","mAh","Wh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView3);
        editText = (EditText)findViewById(R.id.textView);
         editText2 = (EditText) findViewById(R.id.textView2);
        spinner = (Spinner)findViewById(R.id.spinner);
        button =(Button)findViewById(R.id.button);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,types);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(this);
        editText.setHint("Amps");
        editText2.setHint("Volts");
    }

    @Override
    public void onClick(View v){
        try{
            double rad=0;
            String from = editText.getText().toString();
            String to = editText2.getText().toString();

//            numberCon con = new numberCon();
            switch (spinner.getSelectedItemPosition()) {
                case 0: {
                    editText.setHint("Watts");
                    editText2.setHint("volts");
                    textView.setText(String.valueOf(Double.parseDouble(from)/Double.parseDouble(to)));
                    break;
                }
                case 1: {
//                    editText.setHint("Amps");
//                    editText2.setHint("Volts");
                    textView.setText(String.valueOf(1000/(Double.parseDouble(from)*Double.parseDouble(to))));
                    break;
                }
                case 2: {
                    textView.setText(String.valueOf(Double.parseDouble(from)/Double.parseDouble(to)));
//                    textView.setText(String.valueOf(Math.tan(rad)));
                    break;
                }
                case 3: {
                    textView.setText(String.valueOf(Double.parseDouble(from)*Double.parseDouble(to)));
                    break;
                }
                case 4: {
                    textView.setText(String.valueOf(Double.parseDouble(from)/Double.parseDouble(to)));
                    break;
                }
                case 5: {
                    textView.setText(String.valueOf(Double.parseDouble(from)*Double.parseDouble(to)));
                    break;
                }
                case 6: {
                    textView.setText(String.valueOf(Double.parseDouble(from)*Double.parseDouble(to)));
                    break;
                }
                case 7: {
                    textView.setText(String.valueOf(Double.parseDouble(from)/Double.parseDouble(to)));
                    break;
                }
                case 8: {
                    textView.setText(String.valueOf(Double.parseDouble(from)*Double.parseDouble(to)));
                    break;
                }
            }
        }catch (Exception e){
            editText.setError("Invalid input");
            editText2.setError("Invalid input");
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position)
        {
            case 0:{
                editText.setHint("Watts");
                editText2.setHint("Volts");
            }
            case 1: {
                editText.setHint("Amps");
                editText2.setHint("Volts");
//                textView.setText(String.valueOf(1000/(Double.parseDouble(from)*Double.parseDouble(to))));
                break;
            }//                    Apparent power (kVA) x power factor (pf) = actual power (kW)
//                textView.setText(String.valueOf(Double.parseDouble(from)/Double.parseDouble(to)));
//                    textView.setText(String.valueOf(Math.tan(rad)));
            case 2: {
                editText.setHint("power factor (pf)");
                editText2.setHint("kW");
//                textView.setText(String.valueOf(1 / Math.cos(rad)));
                break;
            }
            case 3: {
                editText.setHint("Vrms");
                editText2.setHint("Irms");
//                textView.setText(String.valueOf(1 / Math.sin(rad)));
                break;
            }
            case 4: {
                editText.setHint("Watts");
                editText2.setHint("Amps");
//                textView.setText(String.valueOf(1 / Math.tan(rad)));
                break;
            }
            case 5: {
                editText.setHint("Amps");
                editText2.setHint("Volts");
//                textView.setText(String.valueOf(Math.asin(rad)));
                break;
            }
            case 6: {
//                textView.setText(String.valueOf(Math.acos(rad)));
                editText.setHint("Watts");
                editText2.setHint("time in sec");
                break;
            }
            case 7: {
                editText.setHint("Watt - Hour");
                editText2.setHint("Volts");
                break;
            }
            case  8:
            {
                editText.setHint("Watts");
                editText2.setHint("Hours");
                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}