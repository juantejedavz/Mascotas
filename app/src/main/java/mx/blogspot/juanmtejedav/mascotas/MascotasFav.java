package mx.blogspot.juanmtejedav.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by juantejeda1 on 06/08/16.
 */
public class MascotasFav extends AppCompatActivity {

    ArrayList<Mascota> mascotasFav;
    private RecyclerView listaMascotasFav;
    private LinearLayoutManager llm;
    Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_fav);

       toolbar(miActionBar);


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
    }

    public void inicializarAdaptador(){
        Adapter adapter = new Adapter(mascotasFav);
        listaMascotasFav.setAdapter(adapter);
    }


    public void toolbar(Toolbar miActionBar) {
        miActionBar = (Toolbar) findViewById(R.id.toolB2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        miActionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}

