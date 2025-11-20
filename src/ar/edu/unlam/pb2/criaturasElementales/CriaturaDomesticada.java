package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaDomesticada extends Criatura {

	public CriaturaDomesticada(String nombre,  int energia, Afinidad afinidad) {
		super(nombre, energia, afinidad, Comportamiento.TRANQUILA);
	}

	@Override
	public void entrenar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pacificar() {
		// TODO Auto-generated method stub
		
	}
	
}
