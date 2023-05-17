package com.example.admin.internship;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.admin.internship.EXTRA_TEXT";
    public static final String EXTRA_Gender="com.example.admin.internship.EXTRA_Gender";
    public static final String EXTRA_NUM="com.example.admin.internship.EXTRA_NUM";
    public static final String EXTRA_AGE="com.example.admin.internship.EXTRA_AGE";
    public static final String EXTRA_Weight="com.example.admin.internship.EXTRA_Weight";
    public static final String EXTRA_Height="com.example.admin.internship.EXTRA_Height";
    public static final String EXTRA_Bmi="com.example.admin.internship.EXTRA_Bmi";

    private EditText etName, etAge, etHeight, etWeight;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        init();

        Button button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                openActivity2();

                @SuppressLint("WrongViewCast")
                RadioGroup rg = findViewById(R.id.male);
                String selectedRadioValue = ((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();
                String selectedRadioValue2 =((RadioButton)findViewById(rg.getCheckedRadioButtonId() )).getText().toString();
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra("radioGroup1Selected", selectedRadioValue);
                intent.putExtra("radioGroup2Selected", selectedRadioValue2);
                startActivity(intent);

                EditText editText3=findViewById(R.id.edit_weight);
                double weight=Double.parseDouble(editText3.getText().toString());

                EditText editText4=findViewById(R.id.edit_height);
                double height=Double.parseDouble(editText4.getText().toString());

                Intent in= new Intent(getApplicationContext(),Activity2.class);
                in.putExtra("USER_WEIGHT_EXTRA",editText3 .getText().toString());
                in.putExtra("USER_HEIGHT_EXTRA", editText4.getText().toString());
                startActivity(in);

                TextView result = findViewById(R.id.bmi2);

                double height2 = height /100;
                double BMI = (weight*1.0)/(height2*height2);


                if (BMI < 20.0) {
                    result.setText("You are: UNDERWEIGHT");

                } else if (BMI > 20.0 && BMI < 25.0) {
                    result.setText("You are: NORMAL WEIGHT");

                } else if (BMI > 25) {
                    result.setText("You are: OVERWEIGHT");

                }
            }


        });
    }

    private void bindViews() {
        etName = findViewById(R.id.activity_main_etName);
        btnSave = findViewById(R.id.activity_main_btnSave);
    }

    private void init() {

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        if (checkValidateData()) {

        }
    }

    private boolean checkValidateData() {
        return true;
    }



    public void openActivity2(){
          EditText editText= findViewById(R.id.edit_name);
        String text=editText.getText().toString();

        @SuppressLint("CutPasteId") EditText editText1=findViewById(R.id.edit_age);
        int number=Integer.parseInt(editText1.getText().toString());

        @SuppressLint("CutPasteId") EditText editText2=findViewById(R.id.edit_age);
        int numberage=Integer.parseInt(editText2.getText().toString());

        EditText editText3=findViewById(R.id.edit_weight);
        double weight=Double.parseDouble(editText3.getText().toString());

        EditText editText4=findViewById(R.id.edit_height);
        double height=Double.parseDouble(editText4.getText().toString());

        Intent intent=new Intent(this,Activity2.class);
        intent.putExtra(EXTRA_TEXT,text);
        intent.putExtra(EXTRA_NUM,number);
        intent.putExtra(EXTRA_AGE,numberage);
        intent.putExtra(EXTRA_Weight,weight);
        intent.putExtra(EXTRA_Height,height);


        startActivity(intent);
    }
}
