package domain.estados;

import domain.mascotas.Mascota;
import domain.ubicacion.Ubicacion;

import java.time.Duration;
import java.time.LocalTime;

public class Aburrido extends EstadoMascota {
    private LocalTime horaInicio;

    public Aburrido(Mascota mascota) {
        super(mascota);
        this.horaInicio = LocalTime.now();
    }

    public void juga() {
        super.mascota.cambiarEstado(new Contento(super.mascota));
    }

    public void come() {
        if(this.haceMuchoEstaAburrida()){
            super.mascota.cambiarEstado(new Contento(super.mascota));
        }
    }

    public Boolean podesJugar() {
        return true;
    }

    @Override
    public void caminarHacia(Ubicacion unaUbicacion) {
        super.mascota.disminuirNivelDeEnergia(unaUbicacion.getPosicionX());
        super.mascota.aumentarNivelDeAnimo(unaUbicacion.sumaDeXeY());
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
        super.mascota.cambiarEstado(new Cansado(super.mascota));
    }

    @Override
    public void descansar() {
        super.mascota.aumentarNivelDeEnergia(2);
    }

    protected boolean haceMuchoEstaAburrida(){
        LocalTime ahora = LocalTime.now();
        long diferencia = Duration.between(horaInicio, ahora).toMinutes();
        return diferencia > 80;
    }
}
