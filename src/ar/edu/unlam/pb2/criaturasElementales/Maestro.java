package ar.edu.unlam.pb2.criaturasElementales;

import java.util.HashMap;

public class Maestro {

	private String nombre;
	private int nivelMaestria;
	private Afinidad afinidadPrincipal;
	private HashMap<String,Criatura> criaturas = new HashMap<>();
	
	public Maestro (String nombre, int nivelMaestria, Afinidad afinidadPrincipal) {
		this.nombre = nombre;
		this.nivelMaestria = nivelMaestria;
		this.afinidadPrincipal = afinidadPrincipal;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNivelMaestria() {
		return nivelMaestria;
	}

	public Afinidad getAfinidadPrincipal() {
		return afinidadPrincipal;
	}

	public HashMap<String, Criatura> getCriaturas() {
		return criaturas;
	}
	
	
	public void entrenar(String nombreCriatura) throws FaltaDeMaestriaException {
		
	}
	
	public void pacificar(String nombreCriatura) {
		
	}
	
	public void transformar(String nombreCriatura) {
		
	}
}
