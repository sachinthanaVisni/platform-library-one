package visni.com.platformlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import visni.com.platformlibrary.util.Alert;
import visni.com.visnicorelibrary.activity.VisniCoreMainActivity;

public class LibraryMainActivity extends VisniCoreMainActivity{
    private static final String TAG = "LibraryMainActivity";
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_main);
        button = (Button) findViewById(R.id.show_alert_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert("This alert is from the library 1", "Do you want to hide this alert?", android.R.drawable.ic_dialog_alert, false);
            }
        });
    }

    public void printLog(){
        Log.d(TAG, "This is the library 1");
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
                printLog();
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
