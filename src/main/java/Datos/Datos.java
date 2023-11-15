package Datos;

import Modelo.Pelicula;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Datos {
    List<Pelicula> peliculas = new ArrayList<>();
    List<String> generos = new ArrayList<>();

    public Datos(){
        ArrayList<File> json = new ArrayList<>();
        json.add(new File("src/main/resources/Datos.json"));

        ObjectMapper mapper = new ObjectMapper();
        try{
            for (File ruta: json){
                peliculas.addAll(mapper.readValue(ruta,
                        new TypeReference<List<Pelicula>>() {}));
            }
        }catch(Exception e) {
            System.out.println("Error al leer el archivo Json "+ e);
        }

        instanciarDatos();
    }

    public void instanciarDatos(){
        for (Pelicula pelicula: peliculas){
            if (!generos.contains(pelicula.getGenero())){
                generos.add(pelicula.getGenero());
            }
        }
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<String> getGeneros(){
        return generos;
    }
}
