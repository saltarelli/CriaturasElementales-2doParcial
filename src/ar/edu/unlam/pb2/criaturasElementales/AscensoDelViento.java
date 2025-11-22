package ar.edu.unlam.pb2.criaturasElementales;

public class AscensoDelViento extends Transformacion {

	public AscensoDelViento(Criatura criatura) {
		super(criatura);
	}

	@Override
	protected Transformacion crear(Criatura criatura) {
		return new AscensoDelViento(criatura);
	}

	@Override
	public Afinidad getAfinidad() {
		return Afinidad.AIRE;
	}

	@Override
	public int getEnergia() {
		return criatura.getEnergia();
	}

	@Override
	public String getNombre() {
		return criatura.getNombre();
	}
}