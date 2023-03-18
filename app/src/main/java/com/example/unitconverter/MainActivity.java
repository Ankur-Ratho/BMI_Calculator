package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView welcome_text,result_text,result_text2;
    EditText edittext,edittext2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome_text=findViewById(R.id.welcome_textview);
        result_text=findViewById(R.id.result_textview);
        result_text2=findViewById(R.id.result_textview2);
        btn=findViewById(R.id.btn);
        edittext=findViewById(R.id.editText);
        edittext2=findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double kilos_entered=Double.parseDouble(edittext.getText().toString());
                double meter_entered=Double.parseDouble(edittext2.getText().toString());

                double result=bmiCalculator(kilos_entered,meter_entered);

                result_text.setText("Your BMI is : "+result);
                result_text2.setText("BMI categorie : "+condition(result));
            }
        });
    }

    public double bmiCalculator(double kilo,double meter)
    {
        return kilo/(meter*meter);
    }

    public String condition(double result)
    {
        if(result<18.5)
        {
            return "Underweight";
        }
        else if(result>=18.5 && result<=24.9)
        {
            return "Normal Weight";
        }
        else if(result>=25 && result<=29.9)
        {
            return "Overweight";
        }
        else if(result>30)
        {
            return "Obesity";
        }
        return null;
    }
}