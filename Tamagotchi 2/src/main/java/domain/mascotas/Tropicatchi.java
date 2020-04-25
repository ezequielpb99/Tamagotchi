package domain.mascotas;

import domain.ubicacion.Ubicacion;

import java.time.Duration;
import java.time.LocalTime;

public class Tropicatchi extends Mascota {
    private LocalTime ultimaCaminata;
    private Integer cantidadDeMasaMuscular;
    private String estadoFisico;

    public Tropicatchi(String nombre) {
        super(nombre);
        this.cantidadDeMasaMuscular = 0;
        this.estadoFisico = "Debil";
    }

    @Override
    public void caminarHacia(Ubicacion unaUbicacion){
        getEstadoFisico();
        checkEstadoFisico();
        ultimaCaminata = LocalTime.now();
        super.caminarHacia(unaUbicacion);
        this.cantidadDeMasaMuscular=+10;
    }

    public void checkEstadoFisico(){
        if (this.cantidadDeMasaMuscular > 90){
            this.estadoFisico = "En Forma";
        }
        else {
            this.estadoFisico = "Debil";
        }
    }

    public void getEstadoFisico(){
        LocalTime ahora = LocalTime.now();
        Long diferencia = Duration.between(ultimaCaminata, ahora).toMinutes();
        if (diferencia > 20){
            this.cantidadDeMasaMuscular = 0;
        }
    }
}
