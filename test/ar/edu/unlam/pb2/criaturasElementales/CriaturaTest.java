package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturaTest {

	@Test
	public void queSePuedaCrearUnaCriaturaSalvaje() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 120, Afinidad.FUEGO);
		
		assertEquals("Carlos", criaturaSalvaje.getNombre());
		assertEquals(120, criaturaSalvaje.getEnergia());
		assertEquals(Afinidad.FUEGO, criaturaSalvaje.getAfinidad());
		assertEquals(Comportamiento.INESTABLE, criaturaSalvaje.getComportamiento());
	}
	
	@Test
	public void queSePuedaCrearUnaCriaturaDomesticada() {
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 80, Afinidad.TIERRA);
		
		assertEquals("Juan", criaturaDomesticada.getNombre());
		assertEquals(80, criaturaDomesticada.getEnergia());
		assertEquals(Afinidad.TIERRA, criaturaDomesticada.getAfinidad());
		assertEquals(Comportamiento.TRANQUILA, criaturaDomesticada.getComportamiento());
	}
	
	@Test
	public void queLaCriaturaAncestralSePuedaCrearYTengaComoMinimo100DeEnergia() {
		Criatura criaturaAncestral = new CriaturaAncestral("Jose", 50, Afinidad.AGUA);
		
		assertEquals("Jose", criaturaAncestral.getNombre());
		assertTrue(criaturaAncestral.getEnergia() >= 100);
		assertEquals(Afinidad.AGUA, criaturaAncestral.getAfinidad());
		assertEquals(Comportamiento.TRANQUILA, criaturaAncestral.getComportamiento());
	}
	
	@Test
	public void queEntrenarModifiqueLaEnergia() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 120, Afinidad.FUEGO);
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 80, Afinidad.TIERRA);
		Criatura criaturaAncestral = new CriaturaAncestral("Jose", 50, Afinidad.AGUA);
		
		int antesS = criaturaSalvaje.getEnergia();
		int antesD = criaturaDomesticada.getEnergia();
		int antesA = criaturaAncestral.getEnergia();
		
		criaturaSalvaje.entrenar();
		criaturaDomesticada.entrenar();
		criaturaAncestral.entrenar();
		
		assertNotEquals(antesS, criaturaSalvaje.getEnergia());
		assertNotEquals(antesD, criaturaDomesticada.getEnergia());
		assertNotEquals(antesA, criaturaAncestral.getEnergia());
	}
	
	@Test
	public void quePacificarModifiqueLaEnergia() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 120, Afinidad.FUEGO);
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 80, Afinidad.TIERRA);
		Criatura criaturaAncestral = new CriaturaAncestral("Jose", 150, Afinidad.AGUA);
		
		int antesS = criaturaSalvaje.getEnergia();
		int antesD = criaturaDomesticada.getEnergia();
		int antesA = criaturaAncestral.getEnergia();
		
		criaturaSalvaje.pacificar();
		criaturaDomesticada.pacificar();
		criaturaAncestral.pacificar();
		
		assertNotEquals(antesS, criaturaSalvaje.getEnergia());
		assertNotEquals(antesD, criaturaDomesticada.getEnergia());
		assertNotEquals(antesA, criaturaAncestral.getEnergia());
	}
	
	@Test
	public void queEntrenarAncestralesNoModifiqueLaEnergiaPorDebajoDeCien() {
		Criatura criaturaAncestral = new CriaturaAncestral("Jose", 25, Afinidad.AGUA);
		criaturaAncestral.entrenar();
		assertTrue(criaturaAncestral.getEnergia() >= 100);
	}
	
	@Test
	public void quePacificarAncestralesNoModifiqueLaEnergiaPorDebajoDeCien() {
		Criatura criaturaAncestral = new CriaturaAncestral("Jose", 5, Afinidad.AGUA);
		criaturaAncestral.pacificar();
		assertTrue(criaturaAncestral.getEnergia() >= 100);
	}
	
	@Test
	public void queEntrenarUnaCriaturaSalvajeAlDesbordarDeEnergiaTireExcepcion() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 195, Afinidad.FUEGO);
		
		try {
			criaturaSalvaje.entrenar();
			fail("Debio lanzar exception");
		} catch (EnergiaDesbordadaException error) {
			assertEquals("La criatura salvaje excedió su limite natural", error.getMessage());
		}
	}
	
	@Test
	public void queCriaturasConAfinidadCompartidasGanenEnergiaAlInteractuar() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 120, Afinidad.FUEGO);
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 80, Afinidad.FUEGO);

		criaturaDomesticada.interactuar(criaturaSalvaje);
		
		assertEquals(130, criaturaSalvaje.getEnergia());
		assertEquals(90, criaturaDomesticada.getEnergia());

	}
	
	@Test
	public void queCriaturasConAfinidadesOpuestasSeVuelvanInestables() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 120, Afinidad.AGUA);
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 80, Afinidad.FUEGO);

		criaturaDomesticada.interactuar(criaturaSalvaje);
		
		assertEquals(Comportamiento.INESTABLE, criaturaSalvaje.getComportamiento());
		assertEquals(Comportamiento.INESTABLE, criaturaDomesticada.getComportamiento());

	}
	
	@Test
	public void queLaCriaturaAncestralDomineLaInteraccion() {
		Criatura criaturaAncestral = new CriaturaAncestral("Carlos", 120, Afinidad.TIERRA);
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 80, Afinidad.AIRE);

		criaturaDomesticada.interactuar(criaturaAncestral);
		
		assertEquals(140, criaturaAncestral.getEnergia());
		assertEquals(65, criaturaDomesticada.getEnergia());

	}
	
	@Test
	public void queLaEnergiaDeLaCriaturaNoAncestralnNoBajeDeCero() {
		Criatura criaturaAncestral = new CriaturaAncestral("Carlos", 120, Afinidad.TIERRA);
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 10, Afinidad.AIRE);

		criaturaAncestral.interactuar(criaturaDomesticada);
		
		assertEquals(0, criaturaDomesticada.getEnergia());

	}
	
	@Test
	public void queInteraccionesSinReglasEspecialesNoModifiquenNada() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 120, Afinidad.FUEGO);
		Criatura criaturaDomesticada = new CriaturaDomesticada("Juan", 10, Afinidad.AIRE);

		criaturaDomesticada.interactuar(criaturaSalvaje);
		
		assertEquals(120, criaturaSalvaje.getEnergia());
		assertEquals(10, criaturaDomesticada.getEnergia());
	}
	

}