package ar.edu.unlam.pb2.criaturasElementales;

public class AscensoDelViento extends Transformacion {

    public AscensoDelViento(Criatura envuelta) {
        super(envuelta);
    }

    @Override
    public Afinidad getAfinidad() {
        return Afinidad.AIRE;
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new AscensoDelViento(criatura);
    }
}