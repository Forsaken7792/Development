package forsaken.apps.hotslore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Forsaken on 28.02.2018.
 */

public class DonateActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_activity);
        textView = (TextView)findViewById(R.id.donTV);
        textView.setText(R.string.donText);
    }
}
