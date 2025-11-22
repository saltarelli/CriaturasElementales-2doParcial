package ar.edu.unlam.pb2.criaturasElementales;

public class BendicionDelRio extends Transformacion {

	public BendicionDelRio(Criatura criatura) {
		super(criatura);
	}

	@Override
	protected Transformacion crear(Criatura criatura) {
		return new BendicionDelRio(criatura);
	}

	@Override
	public int getEnergia() {
		int energiaDuplicada = criatura.getEnergia() * 2;
		return Math.min(energiaDuplicada, 180);
	}

	@Override
	public Afinidad getAfinidad() {
		return criatura.getAfinidad();
	}

	@Override
	public Comportamiento getComportamiento() {
		return criatura.getComportamiento();
	}

	@Override
	public String getNombre() {
		return criatura.getNombre();
	}
}