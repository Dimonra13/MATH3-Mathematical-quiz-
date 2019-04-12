package model;

import java.util.Comparator;
/**
 * Clase que establece el criterio de comparacion entre jugadores.
 *
 */
public class ComparadorPunt implements Comparator<Jugador>{
	@Override
	public int compare(Jugador o1, Jugador o2) {
		if(o1.getPuntuacion() == o2.getPuntuacion()) {
			return 0;
		}else if(o1.getPuntuacion() < o2.getPuntuacion()){
			return 1;
		}else {
			return -1;
		}
	}
	
}
