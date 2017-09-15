package com.othercompany.customappone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.othercompany.customappone.util.Alert;

public class CustomAppOneMainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_app_one_main);

        button = (Button) findViewById(R.id.show_alert_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert("This alert is from the library 1", "Do you want to hide this alert?", android.R.drawable.ic_dialog_alert, false);
            }
        });
    }

    public void showAlert(String title, String msg, int icon, Boolean isCancelable){
        final Alert platFormAlert = new Alert(this);
        platFormAlert.setTitle(title);
        platFormAlert.setIcon(icon);
        platFormAlert.setMessage(msg);
        platFormAlert.setCancelable(isCancelable);
        platFormAlert.setPositveButton("Yes", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                platFormAlert.dismiss();
            }
        });

        platFormAlert.setNegativeButton("No", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        platFormAlert.show();
    }
}
