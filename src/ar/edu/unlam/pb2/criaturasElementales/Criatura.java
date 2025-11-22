package ar.edu.unlam.pb2.criaturasElementales;

public abstract class Criatura {
	protected String nombre;
	protected int energia;
	protected Afinidad afinidad;
	protected Comportamiento comportamiento;

	public Criatura(String nombre, int energia, Afinidad afinidad, Comportamiento comportamiento) {
		this.nombre = nombre;
		this.energia = energia;
		this.afinidad = afinidad;
		this.comportamiento = comportamiento;
	}

	public abstract void entrenar();

	public abstract void pacificar();

	public String getNombre() {
		return nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public Afinidad getAfinidad() {
		return afinidad;
	}

	public Comportamiento getComportamiento() {
		return comportamiento;
	}

	public void interactuar(Criatura otraCriatura) {

		if (this instanceof CriaturaAncestral) {
			this.modificarEnergia(20);
			otraCriatura.modificarEnergia(-15);
			return;

		} else if (otraCriatura instanceof CriaturaAncestral) {
			otraCriatura.modificarEnergia(20);
			this.modificarEnergia(-15);
			return;
		}

		if (this.afinidad == otraCriatura.getAfinidad()) {
			this.modificarEnergia(10);
			otraCriatura.modificarEnergia(10);
			return;
		}

		if (this.afinidad == afinidad.AGUA && otraCriatura.getAfinidad() == afinidad.FUEGO
				|| this.afinidad == afinidad.FUEGO && otraCriatura.getAfinidad() == afinidad.AGUA
				|| this.afinidad == afinidad.AIRE && otraCriatura.getAfinidad() == afinidad.TIERRA
				|| this.afinidad == afinidad.TIERRA && otraCriatura.getAfinidad() == afinidad.AIRE) {

			this.comportamiento = Comportamiento.INESTABLE;
			otraCriatura.comportamiento = Comportamiento.INESTABLE;
			return;
		}
	}

	public void modificarEnergia(int cantidad) {
		this.energia += cantidad;
		if (this.energia < 0)
			this.energia = 0;
	}
}