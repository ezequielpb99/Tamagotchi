package domain.mascotas;

import domain.estados.Cansado;
import domain.estados.Contento;
import domain.estados.EstadoMascota;
import domain.ubicacion.Ubicacion;

public abstract class Mascota {
    protected EstadoMascota estado;
    private String nombre;
    private Integer nivelDeFelicidad;
    private Integer nivelDeEnergia;
    private Integer nivelDeAnimo;

    public Mascota(String nombre){
        this.nombre = nombre;
        this.nivelDeFelicidad = 5;
        this.nivelDeEnergia = 100;
        this.nivelDeAnimo = 0;
        this.estado = new Contento(this);
    }

    public EstadoMascota getEstado() {
        return estado;
    }
    public String getNombre() {
        return nombre;
    }
    public Integer getNivelDeFelicidad() {
        return nivelDeFelicidad;
    }
    public Integer getNivelDeEnergia() {
        return nivelDeEnergia;
    }
    public Integer getNivelDeAnimo() {
        return nivelDeAnimo;
    }


    public void come(){
        this.estado.come();
    }

    public void juga(){
        this.estado.juga();
    }

    public boolean podesJugar(){
        return this.estado.podesJugar();
    }

    public void cambiarEstado(EstadoMascota estado){
        this.estado = estado;
    }

    public void incrementarNivelDeFelicidadEn(Integer i){
        this.nivelDeFelicidad+=i;
    }

    public void disminuirNivelDeEnergia(Integer i){
        nivelDeEnergia=-i;
        if (nivelDeEnergia < 40){
            cambiarEstadoSegunEnergia();
        }

        if (nivelDeEnergia < 0){
            nivelDeEnergia = 0;
        }
    }

    public void aumentarNivelDeEnergia(Integer i){
        nivelDeEnergia=+i;
        if (estaCansado() && nivelDeEnergia > 80){
            this.estado.cambiarEstadoSegunEnergia();
        }
        if (nivelDeEnergia > 100){
            nivelDeEnergia = 100;
        }
    }

    private boolean estaCansado() {
        return this.getEstado() instanceof Cansado;
    }


    public void disminuirNivelDeAnimo(Integer i){
        nivelDeAnimo=-i;
        if (nivelDeAnimo < 0){
            nivelDeAnimo = 0;
        }
    }

    public void aumentarNivelDeAnimo(Integer i){
        nivelDeAnimo=+i;
        if (nivelDeAnimo > 15){
            cambiarEstadoSegunElAnimo();
        }
        if (nivelDeAnimo > 100){
            nivelDeAnimo = 100;
        }
    }

    public void caminarHacia(Ubicacion unaUbicacion) {
        this.estado.caminarHacia(unaUbicacion);
    }

    public void cambiarEstadoSegunEnergia(){
        this.estado.cambiarEstadoSegunEnergia();
    }

    public void cambiarEstadoSegunElAnimo(){
        this.estado.cambiarEstadoSegunElAnimo();
    }

    public void descansar() {
        this.estado.descansar();
    }
}
