package domain.mascotas;

import domain.estados.EstadoMascota;
import domain.estados.Hambriento;
import domain.ubicacion.Ubicacion;

public class Memetchi extends Mascota {
    private Integer hambre;

    public Memetchi(String nombre) {
        super(nombre);
        this.hambre = 0;
    }

    @Override
    public void caminarHacia(Ubicacion unaUbicacion){
        super.caminarHacia(unaUbicacion);
        this.hambre=+5;
        estaHambriento();
    }

    @Override
    public void come(){
        super.come();
        this.hambre = 0;
    }

    public void estaHambriento(){
        if (this.hambre > 25){
            super.estado.cambiarDeEstadoSiTieneHambre();
        }
    }
}
