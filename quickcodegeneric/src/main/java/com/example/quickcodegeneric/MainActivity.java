package com.example.quickcodegeneric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> arrNum;
    private ArrayList<String>  arrStr;

    private EditText edt_Input;

    private TextView txt_Num;
    private TextView txt_Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Input = (EditText) findViewById(R.id.editText_Input);
        txt_Num = (TextView) findViewById(R.id.textView_Num);
        txt_Str = (TextView) findViewById(R.id.textView_Str);

        arrNum = new ArrayList<Integer>();
        arrStr = new ArrayList<String>();

        edt_Input.setText("");
    }

    public void Saving(View v){
        try{
            int testing = Integer.parseInt(edt_Input.getText().toString());
            arrNum.add(testing);
        }catch(Exception e){
            arrStr.add(edt_Input.getText().toString());
        }

        edt_Input.setText("");
    }

    public void Outing(View v){
        txt_Num.setText(arrNum.toString());
        txt_Str.setText(arrStr.toString());
    }
}
