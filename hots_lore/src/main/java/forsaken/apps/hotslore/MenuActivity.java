package forsaken.apps.hotslore;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    Button buttonPlay, buttonSet, buttonRate, buttonDon, buttonQuit;
    Context context;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

//        MobileAds.initialize(this, "ca-app-pub-9134424877176633~7241047738");
//
//        mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//       mAdView.loadAd(adRequest);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonSet = (Button) findViewById(R.id.about);
        buttonSet.setOnClickListener(this);
        buttonRate = (Button) findViewById(R.id.rate);
        buttonRate.setOnClickListener(this);
        buttonDon = (Button) findViewById(R.id.donate);
        buttonDon.setOnClickListener(this);
//        buttonHelp = (Button) findViewById(R.id.lang);
//        buttonHelp.setOnClickListener(this);
        buttonQuit = (Button) findViewById(R.id.buttonQuit);
        buttonQuit.setOnClickListener(this);
        context = getBaseContext();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.buttonPlay:
                intent=new Intent(this,MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //finish();
                break;
            case R.id.about:
                intent=new Intent(this,About.class);
                //	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //finish();
                break;
//            case R.id.rate:
//                Log.d(TAG, "ButtonRate");
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=forsaken.apps.hotslore#details-reviews")));
//                break;
            case R.id.donate:
                intent=new Intent(this,DonateActivity.class);
                //	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                //finish();
                break;
            case R.id.buttonQuit:
                finish();
                break;
        }
    }
}
