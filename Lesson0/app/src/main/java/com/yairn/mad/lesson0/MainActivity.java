package com.yairn.mad.lesson0;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById() links the xml to the code by the corresponding ID
        textView = findViewById(R.id.textViewID);
        button = findViewById(R.id.buttonID);

        isHello = true;
    }

    /*
    * The method onClickStringChange is the button's click
    * listener. This method alternates the textView's text and color
    * for every time the button is clicked
    */
    public void onClickStringChange(View view) {
        isHello = !isHello;

        if(isHello) {
            textView.setText("Hello");
            textView.setTextColor(Color.RED);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            textView.setText("Button has been clicked!");
            textView.setTextColor(Color.BLUE);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
    }
}
