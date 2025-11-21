package ar.edu.unlam.pb2.criaturasElementales;

public class Transformacion extends Criatura {
	
	protected Criatura envuelta;
	
	public Transformacion(Criatura envuelta) {
		super(envuelta.getNombre(), 
			  envuelta.getEnergia(), 
			  envuelta.getAfinidad(), 
			  envuelta.getComportamiento());
		this.envuelta=envuelta;
	}

	@Override
	public void entrenar() {
		envuelta.entrenar();
	}

	@Override
	public void pacificar() {
		envuelta.pacificar();
	}

	public static Criatura aplicar(Criatura criatura) {
		
		return new Transformacion(criatura);
	}

}