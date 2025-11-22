package ar.edu.unlam.pb2.criaturasElementales;

public class LlamaInterna extends Transformacion {

	public LlamaInterna(Criatura criatura) {
		super(criatura);

		if (criatura.getAfinidad() != Afinidad.FUEGO) {
			this.comportamiento = Comportamiento.INESTABLE;
		}
	}

	@Override
	protected Transformacion crear(Criatura criatura) {
		return new LlamaInterna(criatura);
	}

	@Override
	public int getEnergia() {
		if (criatura.getAfinidad() == Afinidad.FUEGO) {
			return criatura.getEnergia() + 30;
		}
		return criatura.getEnergia();
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