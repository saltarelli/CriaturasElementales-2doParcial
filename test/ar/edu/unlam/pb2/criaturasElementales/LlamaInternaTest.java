package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import org.junit.Test;

public class LlamaInternaTest {

	@Test
	public void queAumenteEnergiaSiEsDeFuego() {
		Criatura base = new CriaturaDomesticada("Pyro", 50, Afinidad.FUEGO);

		Criatura transformada = new LlamaInterna(base);

		assertEquals(80, transformada.getEnergia());
	}

	@Test
	public void queSeVuelvaInestableSiNoEsDeFuego() {
		Criatura base = new CriaturaDomesticada("Vientin", 70, Afinidad.AIRE);

		Criatura transformada = new LlamaInterna(base);

		assertEquals(Comportamiento.INESTABLE, transformada.getComportamiento());
	}
}
