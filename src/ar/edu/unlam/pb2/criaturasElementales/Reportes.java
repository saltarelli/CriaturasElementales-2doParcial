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

    // Métodos pedidos por el TP
    public List<Criatura> listarTodasLasCriaturas(){
    	
    	List<Criatura> lista = new ArrayList<>();
    	
    	for(Maestro m : maestros) {
    		lista.addAll(m.getCriaturas().values());
    	}
    	
    	return lista;
    }

    public Criatura obtenerCriaturaConMayorEnergia(){
    	
    	List<Criatura> criaturas = listarTodasLasCriaturas();

        if (criaturas.isEmpty()) {
            return null;
        }

        Criatura mayor = criaturas.get(0);

        for (Criatura c : criaturas) {
            if (c.getEnergia() > mayor.getEnergia()) {
                mayor = c;
            }
        }

        return mayor;
    }

    public Maestro obtenerMaestroConMasTransformadas(){
    	
    	if (maestros.isEmpty()) {
            return null;
        }

        Maestro mayor = null;
        int maxTransformadas = -1;

        for (Maestro m : maestros) {

            int contador = 0;

            for (Criatura c : m.getCriaturas().values()) {
                if (c instanceof Transformacion) {
                    contador++;
                }
            }
         
            if (contador > maxTransformadas) {
                maxTransformadas = contador;
                mayor = m;
            }
        }

        return mayor;
    }

    public HashMap<Afinidad, Integer> cantidadDeCriaturasPorAfinidad(){
    	
    	HashMap<Afinidad, Integer> mapa = new HashMap<>();

    	  for (Maestro m : maestros) {
    	     for (Criatura c : m.getCriaturas().values()) {
    	         mapa.put(c.getAfinidad(), mapa.getOrDefault(c.getAfinidad(), 0) + 1);
    	    }
    	 }

    	 return mapa;
    }

}
