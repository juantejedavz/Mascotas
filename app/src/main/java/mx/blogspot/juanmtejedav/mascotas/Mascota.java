package mx.blogspot.juanmtejedav.mascotas;

import java.io.Serializable;

/**
 * Created by juantejeda1 on 03/08/16.
 */
public class Mascota  implements Serializable{

    private String nombre;
    private int foto;
    private int likes=0;

    public Mascota(String nombre, int foto, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setUpLikes() {
        this.likes = ++likes;
    }
}
