package model;

import java.io.Serializable;
/**
 * Clase jugador que establece la estructura del objeto Jugador
 *
 */
public class Jugador implements Serializable{
	private static final long serialVersionUID = -7303744550593272602L;
	private String name;
	private int puntuacion;
	/**
	 * Constructor de la clase Jugador
	 * @param name Nombre del Jugador
	 * @param puntuacion Puntuacion del jugador
	 */
	public Jugador(String name, int puntuacion) {
		this.name = name;
		this.puntuacion = puntuacion;
	}
	/**
	 * Metodo que devuelve el nombre del jugador
	 * @return Nombre del Jugador
	 */
	public String getName() {
		return name;
	}
	/**
	 * Metodo que establece el nombre del jugador
	 * @param name Nombre del jugador
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Metodo que devuelve el puntuacion del jugador
	 * @return Puntuacion del jugador
	 */
	public int getPuntuacion() {
		return puntuacion;
	}
	/**
	 * Metodo que establece el puntuacion del jugador
	 * @param puntuacion Puntuacion del Jugador
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}	
}
