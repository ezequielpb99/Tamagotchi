package domain.estados;


import domain.mascotas.Mascota;
import domain.ubicacion.Ubicacion;

public abstract class EstadoMascota {
    protected Mascota mascota;

    public EstadoMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public abstract void juga();
    public abstract void come();
    public abstract Boolean podesJugar();
    public abstract void caminarHacia(Ubicacion unaUbicacion);
    public abstract void cambiarDeEstadoSiTieneHambre();
    public abstract void cambiarEstadoSegunElAnimo();
    public abstract void cambiarEstadoSegunEnergia();
    public abstract void descansar();
}
