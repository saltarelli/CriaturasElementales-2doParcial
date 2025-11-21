package ar.edu.unlam.pb2.criaturasElementales;

public class AscensoDelViento extends CriaturaDecorada {

    public AscensoDelViento(Criatura criatura) {
        super(criatura);
    }

    @Override
    public Afinidad getAfinidad() {
        return Afinidad.AIRE;
    }
}
