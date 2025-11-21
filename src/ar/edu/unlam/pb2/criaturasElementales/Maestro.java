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
	
	public void agregarCriatura(Criatura criatura) {
		if(criatura == null) {
			return;
		}
		
		criaturas.put(criatura.getNombre(), criatura);
	}
	
	public void entrenar(String nombreCriatura) throws FaltaDeMaestriaException {
		
		Criatura criatura = criaturas.get(nombreCriatura);
		
		if(criatura == null) {
			throw new IllegalArgumentException("La criatura no pertenece a la coleccion del maestro");
		}
		else if(this.nivelMaestria < criatura.getEnergia() / 10) {
			throw new FaltaDeMaestriaException("El maestro no tiene suficiente nivel para entrenar a: " + nombreCriatura);
		}
		
		criatura.entrenar();
		
	}
	
	public void pacificar(String nombreCriatura) {
		
		Criatura criatura = criaturas.get(nombreCriatura);
		
		if(criatura == null) {
			throw new IllegalArgumentException("La criatura no pertenece a la coleccion del maestro");
		}
		
		criatura.pacificar();
	}
	
	public void transformar(String nombreCriatura, Transformacion transformacion) {
		
		Criatura criatura = criaturas.get(nombreCriatura);
		
		if(criatura == null) {
			throw new IllegalArgumentException("La criatura no pertenece a la coleccion del maestro");
		}
		else if(transformacion == null) {
			throw new IllegalArgumentException("La transformacion ingresada no es valida");
		}
		
		Criatura criaturaTransformada = transformacion.aplicar(criatura);
		
		criaturas.put(nombreCriatura, criaturaTransformada);
		
	}
}
