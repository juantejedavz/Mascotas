package mx.blogspot.juanmtejedav.mascotas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by juantejeda1 on 03/08/16.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MascotaVHolder> {

    ArrayList<Mascota> mascotas;

    public Adapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_mascota, parent, false);
        return new MascotaVHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaVHolder mascotaVHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaVHolder.fotoPet.setImageResource(mascota.getFoto());
        mascotaVHolder.nombrePet.setText(mascota.getNombre());
        mascotaVHolder.likesPet.setText("" + mascota.getLikes());

        mascotaVHolder.imgHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setUpLikes();
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaVHolder extends RecyclerView.ViewHolder{
        ImageView fotoPet;
        TextView nombrePet;
        TextView likesPet;
        ImageView imgHueso;
        ImageView btnEstrella;


        public MascotaVHolder(View itemView) {
            super(itemView);
            fotoPet = (ImageView) itemView.findViewById(R.id.ivFotoPet);
            nombrePet = (TextView) itemView.findViewById(R.id.tvNombrePet);
            likesPet = (TextView) itemView.findViewById(R.id.tvLikesPet);
            imgHueso = (ImageView) itemView.findViewById(R.id.imgHueso);
            btnEstrella = (ImageView) itemView.findViewById(R.id.btnEstrella);
        }
    }
}
