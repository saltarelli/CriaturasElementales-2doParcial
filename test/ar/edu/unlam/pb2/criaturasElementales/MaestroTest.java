package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaestroTest {

	@Test
    public void queSePuedaAgregarCriatura() {
        Maestro maestro = new Maestro("Pepe", 20, Afinidad.FUEGO);
        Criatura criatura = new CriaturaDomesticada("Luna", 50, Afinidad.AGUA);

        maestro.agregarCriatura(criatura);

        assertTrue(maestro.getCriaturas().containsKey("Luna"));
    }
	
	@Test
	public void queElMaestroEntreneCorrectamente() throws FaltaDeMaestriaException {
	    Maestro maestro = new Maestro("Sol", 20, Afinidad.FUEGO);
	    Criatura criatura = new CriaturaDomesticada("Brisa", 50, Afinidad.AIRE);

	    maestro.agregarCriatura(criatura);

	    maestro.entrenar("Brisa");
  
	    assertEquals(60, criatura.getEnergia());
	}
	 
	 @Test(expected = FaltaDeMaestriaException.class)
	 public void queFalleEntrenamientoPorFaltaDeMaestria() throws FaltaDeMaestriaException {
	     Maestro maestro = new Maestro("Aang", 2, Afinidad.AIRE);
	     Criatura criatura = new CriaturaDomesticada("Rayo", 80, Afinidad.FUEGO);

	     maestro.agregarCriatura(criatura);

	     maestro.entrenar("Rayo");
	  }
	 
	 
	  @Test
	  public void queElMaestroPacifiqueUnaCriatura() {
	      Maestro maestro = new Maestro("Rocky", 30, Afinidad.TIERRA);

	      Criatura criatura = new CriaturaDomesticada("Sol", 40, Afinidad.AGUA);

	      maestro.agregarCriatura(criatura);

	      maestro.pacificar("Sol");

	      assertEquals(30, criatura.getEnergia());
	   }

	   @Test
	   public void queElMaestroApliqueBendicionDelRio() {
	       Maestro maestro = new Maestro("Katara", 20, Afinidad.AGUA);
	       Criatura criatura = new CriaturaDomesticada("Nube", 60, Afinidad.AGUA);

	       maestro.agregarCriatura(criatura);

	       maestro.transformar("Nube", new BendicionDelRio(criatura));

	       Criatura transformada = maestro.getCriaturas().get("Nube");

	       assertEquals(120, transformada.getEnergia());
	       assertTrue(transformada instanceof BendicionDelRio);
	    }

	    @Test
	    public void queElMaestroApliqueTransformacionesEncadenadas() {
	        Maestro maestro = new Maestro("Vientin", 40, Afinidad.AIRE);

	        Criatura criatura = new CriaturaDomesticada("Eco", 50, Afinidad.FUEGO);
	        maestro.agregarCriatura(criatura);

	        maestro.transformar("Eco", new LlamaInterna(criatura));

	        Criatura primera = maestro.getCriaturas().get("Eco");
	        assertTrue(primera instanceof LlamaInterna);

	        maestro.transformar("Eco", new BendicionDelRio(primera));

	        Criatura segunda = maestro.getCriaturas().get("Eco");
	        assertTrue(segunda instanceof BendicionDelRio);

	        assertEquals(Math.min((50 + 30) * 2, 180), segunda.getEnergia());
	    }


	    @Test
	    public void queAscensoDelVientoCambieAfinidadTemporalmente() {
	        Maestro maestro = new Maestro("Roberto", 50, Afinidad.AIRE);
	        Criatura criatura = new CriaturaDomesticada("Aura", 40, Afinidad.TIERRA);

	        maestro.agregarCriatura(criatura);

	        maestro.transformar("Aura", new AscensoDelViento(criatura));

	        Criatura t = maestro.getCriaturas().get("Aura");

	        assertEquals(Afinidad.AIRE, t.getAfinidad());
	    }
	    


}
