package ar.edu.unlam.pb2.criaturasElementales;

public class AscensoDelViento extends Transformacion {

    public AscensoDelViento(Criatura envuelta) {
        super(envuelta);
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new AscensoDelViento(criatura);
    }

    @Override
    public Afinidad getAfinidad() {
        return Afinidad.AIRE; 
    }

    @Override
    public int getEnergia() {
        return envuelta.getEnergia();
    }

    @Override
    public String getNombre() {
        return envuelta.getNombre();
    }
}