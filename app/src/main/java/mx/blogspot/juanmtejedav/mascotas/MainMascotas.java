package mx.blogspot.juanmtejedav.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasFav;
    private RecyclerView listaMascotas;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mascotas);

        Toolbar miActionBar = toolbar(R.id.toolB1);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        layoutSetting();

        inicializarVistasGen();

        inicializarAdaptador();
    }

    public void inicializarVistasGen(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(getResources().getString(R.string.duke), R.drawable.duke, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.max), R.drawable.max, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.mel), R.drawable.mel, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.sal), R.drawable.salchicha, 0));
        mascotas.add(new Mascota(getResources().getString(R.string.snow), R.drawable.snowball, 0));
    }

    public void layoutSetting(){
        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    public void inicializarAdaptador(){
        Adapter adapter = new Adapter(mascotas);
        listaMascotas.setAdapter(adapter);
    }

    public void clickEstrella(View v){
        mascotasFav = new ArrayList<Mascota>();
        Intent i = new Intent(MainMascotas.this, MascotasFav.class);
            for (Mascota mascota: mascotas){
                if(mascota.getLikes()>0){
                    mascotasFav.add(mascota);
                }
            }
            i.putExtra(getResources().getString(R.string.arrayMascotas), mascotasFav);
        startActivity(i);
    }

        public Toolbar toolbar(int id) {
            Toolbar t = (Toolbar) findViewById(id);
            setSupportActionBar(t);
            return t;
        }

}
