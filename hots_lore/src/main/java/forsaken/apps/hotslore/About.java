package forsaken.apps.hotslore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Forsaken on 20.09.2017.
 */

public class About extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        textView = (TextView) findViewById(R.id.aboutText);
        textView.setText(getText(R.string.About));
    }
}
