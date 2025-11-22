package ar.edu.unlam.pb2.criaturasElementales;

public class VinculoTerrestre extends Transformacion {

	public VinculoTerrestre(Criatura criatura) {
		super(criatura);
	}

	@Override
	protected Transformacion crear(Criatura criatura) {
		return new VinculoTerrestre(criatura);
	}

	@Override
	public int getEnergia() {
		int energiaActual = criatura.getEnergia();
		return (energiaActual < 50) ? 50 : energiaActual;
	}

	@Override
	public Afinidad getAfinidad() {
		return criatura.getAfinidad();
	}

	@Override
	public String getNombre() {
		return criatura.getNombre();
	}
}
