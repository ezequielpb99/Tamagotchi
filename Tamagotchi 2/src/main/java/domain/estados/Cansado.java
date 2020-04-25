package domain.estados;

import domain.mascotas.Mascota;
import domain.ubicacion.Ubicacion;

public class Cansado extends EstadoMascota {
    public Cansado(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void juga() {

    }

    @Override
    public void come() {

    }

    @Override
    public Boolean podesJugar() {
        return null;
    }

    @Override
    public void caminarHacia(Ubicacion unaUbicacion) {
        super.mascota.disminuirNivelDeAnimo(20);
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
        super.mascota.cambiarEstado(new Aburrido(super.mascota));
    }

    @Override
    public void descansar() {
        super.mascota.aumentarNivelDeEnergia(20);
    }
}
