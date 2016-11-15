package com.example.quickcode02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int myNum = 77;
    int trying = 0;
    int start = 0; int end = 500;
    int comNum = (int)Math.round(Math.random() * 500);
    public void setNum(View v){
        EditText et = (EditText) findViewById(R.id.editText);
        myNum = Integer.parseInt(et.getText().toString());

        if (myNum >= 0 && myNum <= 500) {
            TextView tt = (TextView) findViewById(R.id.textView);
            tt.setText(myNum + "");

            trying = 0;
            start = 0; end = 500;
            comNum = (int)Math.round(Math.random() * 500);

            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setText("your num is " + comNum + "?");
        }
        else{
            Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    public void findNumB(View v){
        trying += 1;
        start = comNum; comNum = (start + end) / 2;
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("your num is " + comNum + "?");
    }

    public void findNumS(View v){
        trying += 1;
        end = comNum; comNum = (start + end) / 2;
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("your num is " + comNum + "?");
    }

    public void findNumC(View v){
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("your num : " + myNum + "\ntrying : " + trying);
    }
}
