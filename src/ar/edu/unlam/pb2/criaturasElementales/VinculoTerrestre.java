package ar.edu.unlam.pb2.criaturasElementales;

public class VinculoTerrestre extends Transformacion {

    public VinculoTerrestre(Criatura envuelta) {
        super(envuelta);
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new VinculoTerrestre(criatura);
    }

    @Override
    public int getEnergia() {
        int energiaActual = envuelta.getEnergia();
        return (energiaActual < 50) ? 50 : energiaActual;
    }

    @Override
    public Afinidad getAfinidad() {
        return envuelta.getAfinidad();
    }

    @Override
    public String getNombre() {
        return envuelta.getNombre();
    }
}
