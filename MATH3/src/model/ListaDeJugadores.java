package model;

import java.util.List;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Clase Lista de jugadores que posee una lista de los jugadores le la aplicacion
 * 
 */
public class ListaDeJugadores implements Serializable {
	private static final long serialVersionUID = -4113463400534838593L;
	private List<Jugador> lista = new ArrayList<>();

	/**
	 * Metodo que permite agregar un jugador a la lista
	 * @param name Nombre del Jugador
	 * @param puntuacion Puntuacion del Jugador
	 */
	public void AgregarJugador(String name,int puntuacion) {
		this.lista.add(new Jugador(name, puntuacion));
	}
	/**
	 * Metodo que devuelve true o false dependiendo de si la lista de jugadores contiene al jugador que contiene
	 * @param name Nombre del jugador buscado
	 * @return True o False dependiendo de si existe o no
	 */
	public boolean existeJugador(String name) {
		boolean op = false;
		for (Jugador jugador : lista) {
			if(jugador.getName().equals(name)) {
				op = true;
				break;
			}
		}
		return op;
	}
	/**
	 * Metodo que devuelve el objeto jugador
	 * @param name Nombre del jugador 
	 * @return Objeto Jugador
	 */
	public Jugador getJugador(String name) {
		Jugador j = null ;
		for (Jugador jugador : lista) {
			if(jugador.getName().equals(name)) {
				j = jugador;
				break;
			}
		}
		return j;
	}
	/**
	 * Metodo que devuelve la lista de los jugadores
	 * @return Lista de los jugadores
	 */
	public List<Jugador> getLista(){
		return lista;
	}
	
	/**
	 * Metodo que ordena segun el criterio de puntuacion la lista
	 */
	 public void ordenar() {
		 this.lista.sort(new ComparadorPunt());
	 }
	 /**
	  * Metodo que busca y cambia la puntuacion de los jugadores en caso de no encontrarlo lo crea y añade a la lista
	  * @param name Nombre del Jugador
	  * @param puntuacionNueva Puntuacion del Jugador
	  */
	public void actualizar(String name,int puntuacionNueva) {
		boolean op = false;
		int posicion=0;
		for (Jugador jugador : lista) {
			if(jugador.getName().equals(name)) {
				op = true;
				break;
			}
			posicion++;
		}
		if(op == true) {
			if(puntuacionNueva > lista.get(posicion).getPuntuacion())
			{
				lista.get(posicion).setPuntuacion(puntuacionNueva);
			}
		}else {
			lista.add(new Jugador(name, puntuacionNueva));
		}
	}
}
