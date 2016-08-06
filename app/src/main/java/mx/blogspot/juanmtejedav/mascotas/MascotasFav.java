package mx.blogspot.juanmtejedav.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import java.util.ArrayList;

/**
 * Created by juantejeda1 on 06/08/16.
 */
public class MascotasFav extends AppCompatActivity {

    ArrayList<Mascota> mascotasFav;
    private RecyclerView listaMascotasFav;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_fav);

        Toolbar miActionBar = toolbar(R.id.miActionBar);

        listaMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);

        layoutSetting();

        inicializarVistasFav();

        inicializarAdaptador();
    }

    public void layoutSetting(){
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFav.setLayoutManager(llm);
    }

    public void inicializarVistasFav(){
        Bundle extras = getIntent().getExtras();
        mascotasFav = (ArrayList<Mascota>) extras.getSerializable(getResources().getString(R.string.arrayMascotas));
      //  Collections.sort(mascotasFav.)
    }

    public void inicializarAdaptador(){
        Adapter adapter = new Adapter(mascotasFav);
        listaMascotasFav.setAdapter(adapter);
    }


    public Toolbar toolbar(int id) {
        Toolbar t = (Toolbar) findViewById(id);
        setSupportActionBar(t);
        return t;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

