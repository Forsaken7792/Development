package forsaken.apps.hotslore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by android on 08.09.2017.
 */

public class MyAdapter extends BaseAdapter {

    private final int[] heroes= {

            R.string.abathur,  R.string.alarak,  R.string.anubarak,  R.string.artanis,  R.string.arthas,  R.string.auriel,  R.string.azmodan,  R.string.brightwing,  R.string.butcher,  R.string.cassia,  R.string.chen,  R.string.chogall,  R.string.chromie,
            R.string.dva,  R.string.dehaka,  R.string.diablo,  R.string.etc,  R.string.falstad, R.string.garrosh,  R.string.gazlowe,  R.string.genji,  R.string.greymane,  R.string.guldan,  R.string.illidan,  R.string.jaina,  R.string.johanna,
            R.string.kaelthas,  R.string.kelthuzad,  R.string.kerrigan,  R.string.kharazim,  R.string.leoric,  R.string.lili,  R.string.liming,  R.string.ltmorales,  R.string.lucio,  R.string.lunara,  R.string.malfurion,
            R.string.malthael,  R.string.medivh,  R.string.muradin,  R.string.murky,  R.string.nazeebo,  R.string.nova,  R.string.probius,  R.string.ragnaros,  R.string.raynor,  R.string.rehgar,  R.string.rexxar,  R.string.samuro,  R.string.sgthammer,
            R.string.sonya,  R.string.stitches,  R.string.stukov,  R.string.sylvanas,  R.string.tassadar,  R.string.lostvikings,  R.string.thrall,  R.string.tracer,  R.string.tychus,  R.string.tyrael,  R.string.tyrande, R.string.uther,
            R.string.valeera,  R.string.valla,  R.string.varian,  R.string.xul,  R.string.zagara,  R.string.zarya,  R.string.zeratul,  R.string.zuljin,  R.string.junkrat,  R.string.ana, R.string.alextrasza, R.string.hanzo, R.string.blaze, R.string.maiev
    };

    private Context context;
    public MyAdapter(Context context, String[] recipes) {
        this.context = context;
    }


    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;// mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;// position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String TAG = "myLogs";
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if (convertView == null) {
            gridView = new View(context);
            //LayoutInflater inflater = getLayoutInflater();
            gridView = new View(context);
            gridView = inflater.inflate(R.layout.item, null);
        } else {
            gridView = (View) convertView;
        }

        ImageView imageView = (ImageView) gridView.findViewById(R.id.imageView);
        TextView textView = (TextView) gridView.findViewById(R.id.textView);
        imageView.setImageResource(mThumbIds[position]);
        textView.setText(heroes[position]);
        return gridView;
    }

    public Integer[] mThumbIds = {R.drawable.ic_abathur, R.drawable.ic_alarak, R.drawable.ic_anub_arak, R.drawable.ic_artanis, R.drawable.ic_arthas,
            R.drawable.ic_auriel, R.drawable.ic_azmodan, R.drawable.ic_brightwing, R.drawable.ic_butcher, R.drawable.ic_cassia, R.drawable.ic_chen, R.drawable.ic_cho_gall, R.drawable.ic_chromie,
            R.drawable.ic_d_va, R.drawable.ic_dehaka, R.drawable.ic_diablo, R.drawable.ic_etc, R.drawable.ic_falstad, R.drawable.ic_garrosh, R.drawable.ic_gazlowe, R.drawable.ic_genji, R.drawable.ic_greymane,
            R.drawable.ic_gul_dan, R.drawable.ic_illidan, R.drawable.ic_jaina, R.drawable.ic_johanna, R.drawable.ic_kael_thas, R.drawable.ic_kel_thuzad, R.drawable.ic_kerrigan, R.drawable.ic_kharazim,
            R.drawable.ic_leoric, R.drawable.ic_li_li, R.drawable.ic_li_ming, R.drawable.ic_lt_morales, R.drawable.ic_lucio, R.drawable.ic_lunara, R.drawable.ic_malfurion, R.drawable.ic_malthael,
            R.drawable.ic_medivh, R.drawable.ic_muradin, R.drawable.ic_murky, R.drawable.ic_nazeebo, R.drawable.ic_nova, R.drawable.ic_probius, R.drawable.ic_ragnaros, R.drawable.ic_raynor, R.drawable.ic_rehgar,
            R.drawable.ic_rexxar, R.drawable.ic_samuro, R.drawable.ic_sgt_hammer, R.drawable.ic_sonya, R.drawable.ic_stitches, R.drawable.ic_stukov, R.drawable.ic_sylvanas, R.drawable.ic_tassadar, R.drawable.ic_the_lost_vikings,
            R.drawable.ic_thrall, R.drawable.ic_tracer, R.drawable.ic_tychus, R.drawable.ic_tyrael, R.drawable.ic_tyrande, R.drawable.ic_uther, R.drawable.ic_valeera, R.drawable.ic_valla, R.drawable.ic_varian,
            R.drawable.ic_xul, R.drawable.ic_zagara, R.drawable.ic_zarya, R.drawable.ic_zeratul, R.drawable.ic_zul_jin,R.drawable.ic_junkrat, R.drawable.ic_ana, R.drawable.ic_alextrasza, R.drawable.ic_hanzo, R.drawable.ic_blaze, R.drawable.ic_maiev };
}
