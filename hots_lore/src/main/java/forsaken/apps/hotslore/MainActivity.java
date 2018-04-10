package forsaken.apps.hotslore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity implements OnItemClickListener {
    private final static String TAG= "myLogs";
    private InterstitialAd interstitialAd;

    private String[] heroes = {};
    GridView gridView;
    MyAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MobileAds.initialize(this, "ca-app-pub-9134424877176633~7241047738");
//        interstitialAd = new InterstitialAd(this);
//        interstitialAd.setAdUnitId(getString(R.string.strorinka));
//        AdRequest request = new AdRequest.Builder().build();
//        interstitialAd.loadAd(request);

        gridView = (GridView) findViewById(R.id.gridView);
        adapter1 = new MyAdapter(this, heroes);
        gridView.setAdapter(adapter1);
        gridView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//        if(interstitialAd.isLoaded()){
            Intent intent = new Intent(this, ActivityOne.class);
            intent.putExtra("pos",""+arg2);
            startActivity(intent);
//            interstitialAd.show(); interstitialAd = new InterstitialAd(this);
//            interstitialAd.setAdUnitId(getString(R.string.strorinka));
//            AdRequest request = new AdRequest.Builder().build();
//            interstitialAd.loadAd(request);
//        }
//        else{Intent intent = new Intent(this, ActivityOne.class);
//            intent.putExtra("pos",""+arg2);
//            startActivity(intent);
//            Log.d(TAG, "row inserted, ID ="+arg2);
//            interstitialAd = new InterstitialAd(this);
//            interstitialAd.setAdUnitId(getString(R.string.strorinka));
//            AdRequest request = new AdRequest.Builder().build();
//            interstitialAd.loadAd(request);
        }

    }
