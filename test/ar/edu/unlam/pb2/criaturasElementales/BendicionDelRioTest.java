package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import org.junit.Test;

public class BendicionDelRioTest {

    @Test
    public void queDupliqueLaEnergiaSinSuperar180() {
        Criatura base = new CriaturaDomesticada("Aqua", 100, Afinidad.AGUA);

        Criatura transformada = new BendicionDelRio(base);

        assertEquals(180, transformada.getEnergia()); 
    }
    
    @Test
    public void queDupliqueCorrectamenteSiNoAlcanzaElMaximo() {
        Criatura base = new CriaturaDomesticada("Aqua", 60, Afinidad.AGUA);

        Criatura transformada = new BendicionDelRio(base);

        assertEquals(120, transformada.getEnergia());
    }

}
