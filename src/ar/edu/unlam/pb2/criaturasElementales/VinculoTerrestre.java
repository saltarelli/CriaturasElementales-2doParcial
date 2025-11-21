package ar.edu.unlam.pb2.criaturasElementales;

public class VinculoTerrestre extends Transformacion {

    public VinculoTerrestre(Criatura envuelta) {
        super(envuelta);
    }

    @Override
    public int getEnergia() {
        return Math.max(envuelta.getEnergia(), 50);
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new VinculoTerrestre(criatura);
    }
}
