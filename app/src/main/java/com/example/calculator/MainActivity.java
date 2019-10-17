package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText screen = null, history=null;
    private String oldValue = "", currentValue = "", opertaion = "",history1="";
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.editText);
        history = findViewById( R.id.his );
    }

    public void onDigitClick(View v) {
        /*if(flag>1)
            oldValue = currentValue;*/
        currentValue = screen.getText().toString();
        currentValue = currentValue + ((Button) v).getText().toString();
        /*if(flag>1)
            currentValue = oldValue+currentValue;
        flag +=1;*/
        screen.setText(currentValue);
        history1 = history1 + currentValue;
        history.setText( "" );
        history.setText(history1);


    }

    public void onFuncClick(View v) {
        screen.setText("");
        opertaion = screen.getText().toString();
        opertaion = opertaion + ((Button) v).getText().toString();
        oldValue = currentValue;
        screen.setText(opertaion);
        history1 = history1 + opertaion;
        history.setText( "" );
        history.setText(history1);

    }

    public void onEqualClick(View v) {
        float t1,t2;

        t1 = Float.parseFloat(oldValue);
        t2 = Float.parseFloat(currentValue);
        float t3=0;
        if("+".equals(opertaion)) {
            t3 = t1 + t2;
        }
        else if("-".equals(opertaion))
        {
            t3 = t1-t2;
        }
        else if("/".equals(opertaion))
        {
            t3 = t1/t2;
        }
        else if("*".equals(opertaion))
            t3 = t1 * t2;
        else
            screen.setText("Invalid");
        screen.setText(String.valueOf( t3 ));
        history1 = history1 + t3;
        history.setText("=" +history1);

    }


    public void onCLearClick(View v){
        screen.setText("");
        history.setText( "" );
        history1="";
        currentValue="";
        oldValue="";
        opertaion="";
        flag = 0;
    }
}
