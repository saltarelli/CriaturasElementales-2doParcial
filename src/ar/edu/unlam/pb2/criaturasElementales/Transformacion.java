package ar.edu.unlam.pb2.criaturasElementales;

public abstract class Transformacion extends Criatura {

	protected Criatura criatura;

	public Transformacion(Criatura criatura) {
		super(criatura.getNombre(), criatura.getEnergia(), criatura.getAfinidad(), criatura.getComportamiento());
		this.criatura = criatura;
	}

	protected abstract Transformacion crear(Criatura criatura);

	public Criatura adquirir(Criatura criatura) {
		return crear(criatura);
	}

	@Override
	public void entrenar() {
		criatura.entrenar();
	}

	@Override
	public void pacificar() {
		criatura.pacificar();
	}
}