package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import org.junit.Test;

public class AscensoDelVientoTest {

	@Test
	public void queCambieAfinidadAAire() {
		Criatura base = new CriaturaDomesticada("Leaf", 80, Afinidad.TIERRA);

		Criatura transformada = new AscensoDelViento(base);

		assertEquals(Afinidad.AIRE, transformada.getAfinidad());
	}

}
