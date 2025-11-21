package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaSalvaje extends Criatura {

	public CriaturaSalvaje(String nombre,  int energia, Afinidad afinidad) {
		super(nombre, energia, afinidad, Comportamiento.INESTABLE);
	}

	@Override
	public void entrenar() {

		int aumento = (int)(Math.random() * 30) + 10;
		
		this.energia += aumento;
		
		if(this.energia > 200) {
			throw new EnergiaDesbordadaException("La criatura salvaje excedió su limite natural");
		}
	}

	@Override
	public void pacificar() {

		int reduccion = (int)(Math.random() * 20) + 10;
		
		this.energia -= reduccion;
		
		if(this.energia < 0) {
			this.energia = 0;
		}
	}
	
} 
