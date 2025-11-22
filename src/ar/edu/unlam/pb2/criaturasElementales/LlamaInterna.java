package ar.edu.unlam.pb2.criaturasElementales;

public class LlamaInterna extends Transformacion {

    public LlamaInterna(Criatura envuelta) {
        super(envuelta);

        if (envuelta.getAfinidad() != Afinidad.FUEGO) {
            this.comportamiento = Comportamiento.INESTABLE;
        }
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new LlamaInterna(criatura);
    }

    @Override
    public int getEnergia() {
        if (envuelta.getAfinidad() == Afinidad.FUEGO) {
            return envuelta.getEnergia() + 30;
        }
        return envuelta.getEnergia();
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