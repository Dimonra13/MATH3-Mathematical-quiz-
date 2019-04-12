package persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.ListaDeJugadores;
/**
 * Clase que almacena, carga y actualiza la listade jugadores
 */
public class BaseDeDatos {
	
	private ObjectOutputStream ous;
	private ObjectInputStream ois;
	private ObjectOutputStream ous2;
	/**
	 * Metodo que Guarda la lista de los jugadores en la carpeta raiz de la aplicacion.
	 * @param jl No se podido crear el objeto
	 * @throws IOException Carpeta no encontrada
	 */
	public void guardarListaJugadores(ListaDeJugadores jl) throws IOException {
		FileOutputStream fos = new FileOutputStream("ListaJugadores.out");
		ous = new ObjectOutputStream(fos);
		ous.writeObject(jl);
	}
	/**
	 * Metodo que Carga la lista de los jugadores en la carpeta raiz de la aplicacion.
	 * @return Lista de los jugadores
	 * @throws IOException Carpeta no encontrada
	 * @throws ClassNotFoundException No se ha encontrado el objeto
	 */
	public ListaDeJugadores cargarListaJugadores() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("ListaJugadores.out");
		ois = new ObjectInputStream(fis);
		return (ListaDeJugadores)ois.readObject();
	}
	/**
	 * Metodo que crea la lista de los jugadores vacia en la carpeta raiz de la aplicacion.
	 * @throws IOException Carpeta no encontrada
	 */
	public void crearListaJugadores() throws IOException {
		ListaDeJugadores listaVacia = new ListaDeJugadores();
		FileOutputStream fos = new FileOutputStream("ListaJugadores.out");
		ous2 = new ObjectOutputStream(fos);
		ous2.writeObject(listaVacia);
	}
}
