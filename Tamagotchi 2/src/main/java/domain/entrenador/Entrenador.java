package domain.entrenador;

import domain.mascotas.Mascota;
import domain.ubicacion.Ubicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Entrenador {
    private String nombre;
    private Integer edad;
    private List<Mascota> mascotasAEntrenar;

    public Entrenador(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.mascotasAEntrenar = new ArrayList<>();
    }

    public void caminarHacia(Ubicacion unaUbicacion){
        this.mascotasAEntrenar.forEach(m -> m.caminarHacia(unaUbicacion));
    }

    public void descansar(){
        this.mascotasAEntrenar.stream()
                .filter(m -> m.getEstado().equals("Cansado"))
                .collect(Collectors.toList())
                .forEach(m -> m.descansar());
    }

    public void agregarMascota(Mascota unaMascota){
        this.mascotasAEntrenar.add(unaMascota);
    }
}
