package domain.estados;

import domain.mascotas.Mascota;
import domain.ubicacion.Ubicacion;

public class Hambriento extends EstadoMascota {

    public Hambriento(Mascota mascota) {
        super(mascota);
    }

    public void juga() {

    }

    public void come() {
        super.mascota.cambiarEstado(new Contento(super.mascota));
    }

    public Boolean podesJugar() {
        return false;
    }

    @Override
    public void caminarHacia(Ubicacion unaUbicacion) {
        super.mascota.come();
    }

    @Override
    public void cambiarDeEstadoSiTieneHambre() {

    }

    @Override
    public void cambiarEstadoSegunElAnimo() {
            super.mascota.cambiarEstado(new Contento(super.mascota));
    }

    @Override
    public void cambiarEstadoSegunEnergia() {

    }

    @Override
    public void descansar() {

    }
}
