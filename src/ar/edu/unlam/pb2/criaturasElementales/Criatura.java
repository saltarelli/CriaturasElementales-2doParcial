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
		
	}
}
