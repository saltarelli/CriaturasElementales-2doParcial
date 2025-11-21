package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaSalvaje extends Criatura {

	public CriaturaSalvaje(String nombre,  int energia, Afinidad afinidad) {
		super(nombre, energia, afinidad, Comportamiento.INESTABLE);
	}

	@Override
	public void entrenar() {

		int aumento = (int)(Math.random() * 30) + 10;
		modificarEnergia(aumento);
		
		if(this.getEnergia() > 200) {
			throw new EnergiaDesbordadaException("La criatura salvaje excedió su limite natural");
		}
	}

	@Override
	public void pacificar() {

		int reduccion = (int)(Math.random() * 20) + 10;
		modificarEnergia(-reduccion);
	}
	
} 
