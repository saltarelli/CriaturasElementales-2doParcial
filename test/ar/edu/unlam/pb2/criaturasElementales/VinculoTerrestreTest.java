package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import org.junit.Test;

public class VinculoTerrestreTest {

	@Test
	public void queNoBajeDe50() {
		Criatura base = new CriaturaDomesticada("Rocky", 30, Afinidad.TIERRA);

		Criatura transformada = new VinculoTerrestre(base);

		assertEquals(50, transformada.getEnergia());
	}

	@Test
	public void queRespeteEnergiaSiEsMayorA50() {
		Criatura base = new CriaturaDomesticada("Rocky", 90, Afinidad.TIERRA);

		Criatura transformada = new VinculoTerrestre(base);

		assertEquals(90, transformada.getEnergia());
	}

}
