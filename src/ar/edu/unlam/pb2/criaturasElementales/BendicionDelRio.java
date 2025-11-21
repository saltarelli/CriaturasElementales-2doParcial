package ar.edu.unlam.pb2.criaturasElementales;

public class BendicionDelRio extends Transformacion {

    public BendicionDelRio(Criatura envuelta) {
        super(envuelta);
    }

    @Override
    public int getEnergia() {
        return Math.min(envuelta.getEnergia() * 2, 180);
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new BendicionDelRio(criatura);
    }
}