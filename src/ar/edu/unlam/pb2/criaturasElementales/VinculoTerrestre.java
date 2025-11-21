package ar.edu.unlam.pb2.criaturasElementales;

public class VinculoTerrestre extends CriaturaDecorada {

	protected Criatura criatura;
	
    public VinculoTerrestre(Criatura criatura) {
        super(criatura);
        this.criatura = criatura;
    }

    @Override
    public int getEnergia() {
        return Math.max(50, criatura.getEnergia());
    }
}
