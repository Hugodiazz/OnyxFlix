
package ReproductorMP4;

import Modelo.Pelicula;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReproductorMP4{
    private MediaPlayer peliculaReproduciendo;
    private double volumen = 0.5;
    private Pelicula peliculaActual;
    private List<Pelicula> peliculaList;
    private int indiceEnLista;
    private List<Pelicula> miListaDeReproduccion = new ArrayList<>();

    public ReproductorMP4() {
        peliculaList = Collections.emptyList();
    }

    public MediaPlayer getPeliculaReproduciendo() {
        return peliculaReproduciendo;
    }

    public void reproducirPelicula(Pelicula pelicula) throws URISyntaxException {
        this.peliculaActual = pelicula;

        Media media = new Media(new File(pelicula.getRuta()).toURI().toString());
        peliculaReproduciendo = new MediaPlayer(media);
        peliculaReproduciendo.play();
        peliculaReproduciendo.setVolume(volumen);
    }

    public void playPause(){
        if (peliculaReproduciendo != null){
            if (peliculaReproduciendo.getStatus() == MediaPlayer.Status.PLAYING){
                peliculaReproduciendo.pause();
            }else {
                peliculaReproduciendo.play();
            }
        }
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
        if (peliculaReproduciendo != null) {
            peliculaReproduciendo.setVolume(volumen);
        }
    }

    public List<Pelicula> getMiListaDeReproduccion() {
        return miListaDeReproduccion;
    }

    public void setMiListaDeReproduccion(Pelicula nuevaPelicula){
        if (!miListaDeReproduccion.contains(nuevaPelicula)){
            this.miListaDeReproduccion.add(nuevaPelicula);
        }else{
            System.out.println("Ya existe en la lista");
        }
    }

    public void eliminarPelicula(Pelicula pelicula) {
        miListaDeReproduccion.remove(pelicula);
    }
}
