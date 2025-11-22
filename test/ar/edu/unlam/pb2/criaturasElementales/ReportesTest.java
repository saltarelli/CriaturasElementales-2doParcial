package ar.edu.unlam.pb2.criaturasElementales;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class ReportesTest {

	@Test
	public void queListeTodasLasCriaturas() {
		Maestro maestro1 = new Maestro("A", 10, Afinidad.FUEGO);
		Maestro maestro2 = new Maestro("B", 10, Afinidad.AGUA);

		maestro1.agregarCriatura(new CriaturaDomesticada("Rayo", 50, Afinidad.AIRE));
		maestro2.agregarCriatura(new CriaturaDomesticada("Aqua", 60, Afinidad.AGUA));

		Reportes reporte = new Reportes(Arrays.asList(maestro1, maestro2));

		List<Criatura> todas = reporte.listarTodasLasCriaturas();

		assertEquals(2, todas.size());
	}

	@Test
	public void queObtengaLaCriaturaConMayorEnergia() {
		Maestro maestro = new Maestro("A", 10, Afinidad.FUEGO);

		Criatura criatura1 = new CriaturaDomesticada("Rayo", 50, Afinidad.AIRE);
		Criatura criatura2 = new CriaturaDomesticada("Aqua", 90, Afinidad.AGUA);

		maestro.agregarCriatura(criatura1);
		maestro.agregarCriatura(criatura2);

		Reportes reporte = new Reportes(Arrays.asList(maestro));

		assertEquals(criatura2, reporte.obtenerCriaturaConMayorEnergia());
	}

	@Test
	public void queDevuelvaElMaestroConMasCriaturasTransformadas() {

		Maestro maestro1 = new Maestro("A", 50, Afinidad.AIRE);
		Maestro maestro2 = new Maestro("B", 40, Afinidad.FUEGO);

		Criatura base1 = new CriaturaDomesticada("Toto", 30, Afinidad.AGUA);
		Criatura base2 = new CriaturaDomesticada("Poki", 40, Afinidad.FUEGO);
		Criatura base3 = new CriaturaDomesticada("Mimi", 20, Afinidad.AIRE);

		Criatura transformada1 = new BendicionDelRio(base1);
		Criatura transformada2 = new LlamaInterna(base2);

		maestro1.agregarCriatura(transformada1);
		maestro1.agregarCriatura(base3);

		maestro2.agregarCriatura(transformada2);
		maestro2.agregarCriatura(new AscensoDelViento(base3));
		Reportes reporte = new Reportes(Arrays.asList(maestro1, maestro2));

		Maestro resultado = reporte.obtenerMaestroConMasTransformadas();

		assertEquals("B", resultado.getNombre());
	}

	@Test
	public void queCuenteCriaturasPorAfinidad() {

		Maestro maestro1 = new Maestro("A", 50, Afinidad.AIRE);
		Maestro maestro2 = new Maestro("B", 40, Afinidad.FUEGO);

		maestro1.agregarCriatura(new CriaturaDomesticada("Toto", 30, Afinidad.AGUA));
		maestro1.agregarCriatura(new CriaturaDomesticada("Poki", 40, Afinidad.FUEGO));

		maestro2.agregarCriatura(new CriaturaDomesticada("Mimi", 20, Afinidad.AIRE));
		maestro2.agregarCriatura(new CriaturaDomesticada("Lolo", 25, Afinidad.FUEGO));

		Reportes reporte = new Reportes(Arrays.asList(maestro1, maestro2));

		HashMap<Afinidad, Integer> mapa = reporte.cantidadDeCriaturasPorAfinidad();

		assertEquals((Integer) 2, mapa.get(Afinidad.FUEGO));
		assertEquals((Integer) 1, mapa.get(Afinidad.AGUA));
		assertEquals((Integer) 1, mapa.get(Afinidad.AIRE));
	}

}
