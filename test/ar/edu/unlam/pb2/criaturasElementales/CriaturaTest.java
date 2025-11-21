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
	public void queEntrenarUnaCriaturaSalvajeAlDesbordarDeEnergiaTireExcepcion() {
		Criatura criaturaSalvaje = new CriaturaSalvaje("Carlos", 195, Afinidad.FUEGO);
		
		try {
			criaturaSalvaje.entrenar();
			fail("Debio lanzar exception");
		} catch (EnergiaDesbordadaException error) {
			assertEquals("La criatura salvaje excedió su limite natural", error.getMessage());
		}
	}
	
	
	
	

}
