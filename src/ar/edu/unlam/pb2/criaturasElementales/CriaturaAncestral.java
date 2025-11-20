package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaAncestral extends Criatura {
	
	public CriaturaAncestral(String nombre,  int energia, Afinidad afinidad) {
		super(nombre, Math.max(energia, 100), afinidad, Comportamiento.TRANQUILA);
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
