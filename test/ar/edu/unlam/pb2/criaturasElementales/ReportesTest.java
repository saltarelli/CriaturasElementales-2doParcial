package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class ReportesTest {

	@Test
	public void queListeTodasLasCriaturas() {
	    Maestro m1 = new Maestro("A", 10, Afinidad.FUEGO);
	    Maestro m2 = new Maestro("B", 10, Afinidad.AGUA);

	    m1.agregarCriatura(new CriaturaDomesticada("Rayo", 50, Afinidad.AIRE));
	    m2.agregarCriatura(new CriaturaDomesticada("Aqua", 60, Afinidad.AGUA));

	    Reportes repo = new Reportes(Arrays.asList(m1, m2));

	    List<Criatura> todas = repo.listarTodasLasCriaturas();

	    assertEquals(2, todas.size());
	}
	
	@Test
	public void queObtengaLaCriaturaConMayorEnergia() {
	    Maestro m = new Maestro("A", 10, Afinidad.FUEGO);

	    Criatura c1 = new CriaturaDomesticada("Rayo", 50, Afinidad.AIRE);
	    Criatura c2 = new CriaturaDomesticada("Aqua", 90, Afinidad.AGUA);

	    m.agregarCriatura(c1);
	    m.agregarCriatura(c2);

	    Reportes repo = new Reportes(Arrays.asList(m));

	    assertEquals(c2, repo.obtenerCriaturaConMayorEnergia());
	}
	
    @Test
    public void queDevuelvaElMaestroConMasCriaturasTransformadas() {

        Maestro m1 = new Maestro("A", 50, Afinidad.AIRE);
        Maestro m2 = new Maestro("B", 40, Afinidad.FUEGO);

        Criatura base1 = new CriaturaDomesticada("Toto", 30, Afinidad.AGUA);
        Criatura base2 = new CriaturaDomesticada("Poki", 40, Afinidad.FUEGO);
        Criatura base3 = new CriaturaDomesticada("Mimi", 20, Afinidad.AIRE);

        Criatura t1 = new BendicionDelRio(base1);
        Criatura t2 = new LlamaInterna(base2);

        m1.agregarCriatura(t1);  
        m1.agregarCriatura(base3);

        m2.agregarCriatura(t2);   
        m2.agregarCriatura(new AscensoDelViento(base3)); 
        Reportes r = new Reportes(Arrays.asList(m1, m2));

        Maestro resultado = r.obtenerMaestroConMasTransformadas();

        assertEquals("B", resultado.getNombre());
    }
    
    @Test
    public void queCuenteCriaturasPorAfinidad() {

        Maestro m1 = new Maestro("A", 50, Afinidad.AIRE);
        Maestro m2 = new Maestro("B", 40, Afinidad.FUEGO);

        m1.agregarCriatura(new CriaturaDomesticada("Toto", 30, Afinidad.AGUA));
        m1.agregarCriatura(new CriaturaDomesticada("Poki", 40, Afinidad.FUEGO));

        m2.agregarCriatura(new CriaturaDomesticada("Mimi", 20, Afinidad.AIRE));
        m2.agregarCriatura(new CriaturaDomesticada("Lolo", 25, Afinidad.FUEGO));

        Reportes r = new Reportes(Arrays.asList(m1, m2));

        HashMap<Afinidad, Integer> mapa = r.cantidadDeCriaturasPorAfinidad();

        assertEquals((Integer)2, mapa.get(Afinidad.FUEGO));
        assertEquals((Integer)1, mapa.get(Afinidad.AGUA));  
        assertEquals((Integer)1, mapa.get(Afinidad.AIRE)); 
    }

}
