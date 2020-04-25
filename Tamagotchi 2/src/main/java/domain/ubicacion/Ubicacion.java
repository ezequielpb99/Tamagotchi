package domain.ubicacion;

public class Ubicacion {
    private Integer posicionX;
    private Integer posicionY;

    public Ubicacion(Integer posicionX, Integer posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Integer getPosicionX() {
        return posicionX;
    }
    public Integer getPosicionY() {
        return posicionY;
    }
    public Integer sumaDeXeY(){
        return posicionX + posicionY;
    }
}
