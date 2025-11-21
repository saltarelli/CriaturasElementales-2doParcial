package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaDomesticada extends Criatura {

	public CriaturaDomesticada(String nombre,  int energia, Afinidad afinidad) {
		super(nombre, energia, afinidad, Comportamiento.TRANQUILA);
	}

	@Override
	public void entrenar() {
		this.energia += 10;
	}

	@Override
	public void pacificar() {
		this.energia -= 10;
		
		if(this.energia < 0) {
			this.energia = 0;
		}
		
	}
	
}
