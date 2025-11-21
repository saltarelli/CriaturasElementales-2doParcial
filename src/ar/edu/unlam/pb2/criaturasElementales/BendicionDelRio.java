package ar.edu.unlam.pb2.criaturasElementales;

public class BendicionDelRio extends CriaturaDecorada {

    private int energiaModificada;

    public BendicionDelRio(Criatura criatura) {
        super(criatura);
        int energia = criatura.getEnergia() * 2;
        if (energia > 180) energia = 180;
        this.energiaModificada = energia;
    }

    @Override
    public int getEnergia() {
        return energiaModificada;
    }
}
