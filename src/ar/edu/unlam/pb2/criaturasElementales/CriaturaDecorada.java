package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaDecorada extends Criatura {
	
	protected Criatura envuelta;

	public CriaturaDecorada(Criatura envuelta) {
		super(envuelta.getNombre(), envuelta.getEnergia(), envuelta.getAfinidad(), envuelta.getComportamiento());
		this.envuelta = envuelta;
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
