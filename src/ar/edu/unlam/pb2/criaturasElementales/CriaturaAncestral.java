package ar.edu.unlam.pb2.criaturasElementales;

public class CriaturaAncestral extends Criatura {
	
	public CriaturaAncestral(String nombre,  int energia, Afinidad afinidad) {
		super(nombre, Math.max(energia, 100), afinidad, Comportamiento.TRANQUILA);
	}

	@Override
	public void entrenar() {
		this.energia += 15;
		
		if(this.energia < 100) {
			this.energia = 100;
		}
		
	}

	@Override
	public void pacificar() {
		this.energia -= 5;
		
		if(this.energia < 100) {
			this.energia = 100;
		}
	}
	
}
