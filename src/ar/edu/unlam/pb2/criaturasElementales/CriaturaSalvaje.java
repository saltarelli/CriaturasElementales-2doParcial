package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaSalvaje extends Criatura {

	public CriaturaSalvaje(String nombre,  int energia, Afinidad afinidad) {
		super(nombre, energia, afinidad, Comportamiento.INESTABLE);
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
