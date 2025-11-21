package ar.edu.unlam.pb2.criaturasElementales;

public abstract class Transformacion extends Criatura {
	
	protected Criatura envuelta;

	public Transformacion(Criatura envuelta) {
		
		super(envuelta.getNombre(), envuelta.getEnergia(), envuelta.getAfinidad(), envuelta.getComportamiento());
		this.envuelta = envuelta;
		
	}


}
