package ar.edu.unlam.pb2.criaturasElementales;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Reportes {

	private Collection<Maestro> maestros;

	public Reportes(Collection<Maestro> maestros) {
		this.maestros = maestros;
	}

	public List<Criatura> listarTodasLasCriaturas() {
		List<Criatura> lista = new ArrayList<>();

		for (Maestro maestro : maestros) {
			lista.addAll(maestro.getCriaturas().values());
		}
		return lista;
	}

	public Criatura obtenerCriaturaConMayorEnergia() {
		List<Criatura> criaturas = listarTodasLasCriaturas();

		if (criaturas.isEmpty()) {
			return null;
		}

		Criatura mayor = criaturas.get(0);

		for (Criatura criatura : criaturas) {
			if (criatura.getEnergia() > mayor.getEnergia()) {
				mayor = criatura;
			}
		}

		return mayor;
	}

	public Maestro obtenerMaestroConMasTransformadas() {

		if (maestros.isEmpty()) {
			return null;
		}

		Maestro mayor = null;
		int maxTransformadas = -1;

		for (Maestro maestro : maestros) {
			int contador = 0;

			for (Criatura criatura : maestro.getCriaturas().values()) {
				if (criatura instanceof Transformacion) {
					contador++;
				}
			}
			if (contador > maxTransformadas) {
				maxTransformadas = contador;
				mayor = maestro;
			}
		}
		return mayor;
	}

	public HashMap<Afinidad, Integer> cantidadDeCriaturasPorAfinidad() {
		HashMap<Afinidad, Integer> mapa = new HashMap<>();

		for (Maestro maestro : maestros) {
			for (Criatura criatura : maestro.getCriaturas().values()) {
				mapa.put(criatura.getAfinidad(), mapa.getOrDefault(criatura.getAfinidad(), 0) + 1);
			}
		}
		return mapa;
	}

}
