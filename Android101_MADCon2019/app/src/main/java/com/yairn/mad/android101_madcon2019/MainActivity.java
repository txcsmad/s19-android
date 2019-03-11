package com.yairn.mad.android101_madcon2019;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button explicitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explicitButton = findViewById(R.id.topButton);

        // If there is any data sent to this activity,
        // we need to check
        Bundle extras = getIntent().getExtras();
        String text = null;

        if(extras != null) {
            text = extras.getString("text");
        }

        if(text == null) {
            text = explicitButton.getText().toString();
        }

        explicitButton.setText(text);
    }

    /*
    * This method is the onClick event for the explicit button.
    * When the button is clicked, the Explicit activity/screen
    * will open up and start.
    * */
    public void onClickExplicitButton(View view) {
        Intent mainActivityIntent = new Intent(this, ExplicitActivity.class);
        startActivity(mainActivityIntent);
    }

    /*
     * This method is the onClick event for the implicit button.
     * When the button is clicked, the Implicit activity
     * will open up and start. In this case, the internet browser will
     * open up with the url txcsmad.com. If there does not exists a browser
     * app on the phone, then the app will show us a toast message
     * */
    public void onClickImplicitButton(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_BROWSER);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Sets the url to open
        intent.setData(Uri.parse("https://www.txcsmad.com/"));

        try {
            startActivity(intent);
        } catch (Exception e) {
            // Will ensure that the app does not crash if there is no Maps app found
            Toast.makeText(this, "No Browser App Found.", Toast.LENGTH_LONG).show();
        }
    }
}
