package ar.edu.unlam.pb2.criaturasElementales;

public class LlamaInterna extends CriaturaDecorada {

    private int energiaModificada;
    private Comportamiento comportamientoModificado;

    public LlamaInterna(Criatura criatura) {
        super(criatura);

        if (criatura.getAfinidad() == Afinidad.FUEGO) {
            energiaModificada = criatura.getEnergia() + 30;
            comportamientoModificado = criatura.getComportamiento();
        } else {
            energiaModificada = criatura.getEnergia();
            comportamientoModificado = Comportamiento.INESTABLE;
        }
    }

    @Override
    public int getEnergia() {
        return energiaModificada;
    }

    @Override
    public Comportamiento getComportamiento() {
        return comportamientoModificado;
    }
}
