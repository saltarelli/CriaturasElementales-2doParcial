package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaDecorada extends Criatura {

	protected Criatura criatura;

	public CriaturaDecorada(Criatura criatura) {
		super(criatura.getNombre(), criatura.getEnergia(), criatura.getAfinidad(), criatura.getComportamiento());
		this.criatura = criatura;
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
