package ar.edu.unlam.pb2.criaturasElementales;

public abstract class Transformacion extends Criatura {

    protected Criatura envuelta;

    public Transformacion(Criatura envuelta) {
        super(envuelta.getNombre(),
              envuelta.getEnergia(),
              envuelta.getAfinidad(),
              envuelta.getComportamiento());
        this.envuelta = envuelta;
    }

    protected abstract Transformacion crear(Criatura criatura);

    public Criatura envolver(Criatura criatura) {
        return crear(criatura);
    }

    @Override
    public void entrenar() {
        envuelta.entrenar(); 
    }

    @Override
    public void pacificar() {
        envuelta.pacificar();
    }
}