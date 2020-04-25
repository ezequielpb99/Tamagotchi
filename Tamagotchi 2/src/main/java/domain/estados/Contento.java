package domain.estados;

import domain.mascotas.Mascota;
import domain.ubicacion.Ubicacion;

public class Contento extends EstadoMascota {
    private int cantidadDeVecesJugadas;

    public Contento(Mascota mascota) {
        super(mascota);
        this.cantidadDeVecesJugadas = 0;
    }

    public void juga() {
        this.cantidadDeVecesJugadas++;
        super.mascota.incrementarNivelDeFelicidadEn(2);
        this.cambiarDeEstadoSiEsNecesario();
    }

    private void cambiarDeEstadoSiEsNecesario() {
        if (this.cantidadDeVecesJugadas > 5){
            super.mascota.cambiarEstado(new Hambriento(super.mascota));
        }
    }

    public void come() {
        super.mascota.incrementarNivelDeFelicidadEn(1);
    }

    public Boolean podesJugar() {
        return true;
    }

    @Override
    public void caminarHacia(Ubicacion unaUbicacion) {
        super.mascota.disminuirNivelDeEnergia(unaUbicacion.getPosicionY());
        super.mascota.aumentarNivelDeAnimo(unaUbicacion.sumaDeXeY()*2);
    }

    public void cambiarDeEstadoSiTieneHambre(){
        super.mascota.cambiarEstado(new Hambriento(super.mascota));
    }

    @Override
    public void cambiarEstadoSegunElAnimo() {

    }

    @Override
    public void cambiarEstadoSegunEnergia() {
        super.mascota.cambiarEstado(new Cansado(super.mascota));
    }

    @Override
    public void descansar() {

    }
}
