package ar.edu.unlam.pb2.criaturasElementales;

public class LlamaInterna extends Transformacion {

    public LlamaInterna(Criatura envuelta) {
        super(envuelta);
    }

    @Override
    public int getEnergia() {
        if (envuelta.getAfinidad() == Afinidad.FUEGO) {
            return envuelta.getEnergia() + 30;
        }
        return envuelta.getEnergia();
    }

    @Override
    public Comportamiento getComportamiento() {
        if (envuelta.getAfinidad() != Afinidad.FUEGO) {
            return Comportamiento.INESTABLE;
        }
        return envuelta.getComportamiento();
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new LlamaInterna(criatura);
    }
}