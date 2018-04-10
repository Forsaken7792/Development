package forsaken.apps.hotslore;


import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by android on 08.09.2017.
 */

public class ActivityOne extends AppCompatActivity {
    private static final String TAG = "myLogs";
    DBHelper dbHelper;
    SQLiteDatabase database;
    Cursor cursor;
    public Integer[] heroPic = {R.drawable.abathur, R.drawable.alarak, R.drawable.anub_arak, R.drawable.artanis, R.drawable.arthas,
        R.drawable.auriel, R.drawable.azmodan, R.drawable.brightwing, R.drawable.buthcher, R.drawable.cassia, R.drawable.chen, R.drawable.cho_gall, R.drawable.chromie,
    R.drawable.d_va, R.drawable.dehaka, R.drawable.diablo, R.drawable.etc, R.drawable.falstad, R.drawable.garrosh, R.drawable.gazlowe, R.drawable.genji, R.drawable.greymane,
    R.drawable.gul_dan, R.drawable.illidan, R.drawable.jaina, R.drawable.johanna, R.drawable.kaelthas, R.drawable.kel_thuzad, R.drawable.kerrigan, R.drawable.kharazim,
    R.drawable.leoric, R.drawable.li_li, R.drawable.li_ming, R.drawable.lt_morales, R.drawable.lucio, R.drawable.lunara, R.drawable.malfurion, R.drawable.malthael,
    R.drawable.medivh, R.drawable.muradin, R.drawable.murky, R.drawable.nazeebo, R.drawable.nova, R.drawable.probius, R.drawable.ragnaros, R.drawable.raynor, R.drawable.rehgar,
    R.drawable.rexxar, R.drawable.samuro, R.drawable.sgt_hammer, R.drawable.sonya, R.drawable.stitches, R.drawable.stukov, R.drawable.sylvanas, R.drawable.tassadar, R.drawable.the_lost_vikings,
    R.drawable.thrall, R.drawable.tracer, R.drawable.tychus, R.drawable.tyrael, R.drawable.tyrande, R.drawable.uther, R.drawable.valeera, R.drawable.valla, R.drawable.varian,
    R.drawable.xul, R.drawable.zagara, R.drawable.zarya, R.drawable.zeratul, R.drawable.zul_jin, R.drawable.junkrat, R.drawable.ana, R.drawable.alextrasza, R.drawable.hanzo, R.drawable.blaze, R.drawable.maiev };
    String i = "";
    Intent intent;
    ImageView imageView;
    TextView textView, textView1,textView2,textView3,textView4;
    String nameDB = "hots.db";
    String SQLReq ="create table if not exists heroes (_id integer primary key autoincrement, _name text, _name2 text, _role text, _universe text, _bio text);";
    HelperMethodClass helperMethodClass = new HelperMethodClass();
    int currentString=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        imageView = (ImageView)findViewById(R.id.imgV);
        textView = (TextView) findViewById(R.id.bio);
        textView1 = (TextView) findViewById(R.id.heroName);
        textView2 = (TextView) findViewById(R.id.heroName2);
        textView3 = (TextView) findViewById(R.id.role);
        textView4 = (TextView) findViewById(R.id.universe);
        intent = getIntent();
        i=intent.getStringExtra("pos");
        int k = Integer.parseInt(i);
        currentString=Integer.parseInt(i);
        Log.d(TAG, "intent"+i);
        imageView.setImageResource(heroPic[k]);
        Resources res = getResources();
        nameDB = res.getString(R.string.dbName);
        helperMethodClass.onCreateDBAPK(this, nameDB, SQLReq);
        helperMethodClass.onViewDataFromFieldTable(this, nameDB, "heroes", "_name",currentString,textView1);
        helperMethodClass.onViewDataFromFieldTable(this, nameDB, "heroes", "_name2",currentString,textView2);
        helperMethodClass.onViewDataFromFieldTable(this, nameDB, "heroes", "_role",currentString,textView3);
        helperMethodClass.onViewDataFromFieldTable(this, nameDB, "heroes", "_universe",currentString,textView4);
        helperMethodClass.onViewDataFromFieldTable(this, nameDB, "heroes", "_bio",currentString,textView);
    }
}
