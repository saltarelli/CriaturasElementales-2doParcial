package ar.edu.unlam.pb2.criaturasElementales;

public class BendicionDelRio extends Transformacion {

	public BendicionDelRio(Criatura envuelta) {
        super(envuelta);
    }

    @Override
    protected Transformacion crear(Criatura criatura) {
        return new BendicionDelRio(criatura);
    }

    @Override
    public int getEnergia() {
        int energiaDuplicada = envuelta.getEnergia() * 2;
        return Math.min(energiaDuplicada, 180);
    }

    @Override
    public Afinidad getAfinidad() {
        return envuelta.getAfinidad();
    }

    @Override
    public Comportamiento getComportamiento() {
        return envuelta.getComportamiento();
    }

    @Override
    public String getNombre() {
        return envuelta.getNombre();
    }
}