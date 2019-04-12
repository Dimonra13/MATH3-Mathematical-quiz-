package model;

import java.awt.Font;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import view.Ejecutable;
/**
 * Modelo del Jtable de la Aplicacion
 */
public class ModeloTabla {
	private HashMap<Integer, ImageIcon> imagenes = new HashMap<Integer, ImageIcon>();
	/**
	 * Metodo que estable el modelo por defecto de la aplicacion y carga los jugadores de la lista.
	 * @param list Lista de juagdores
	 * @return Modelo de la tabla con los jugadores 
	 */
	public DefaultTableModel getTablaModel(ListaDeJugadores list)
	 {
		String[] nombres = {"","Posición", "Apodo","Puntación"};
		DefaultTableModel modelo = new DefaultTableModel(nombres, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
				case 0:
					return ImageIcon.class;
				default:
					return String.class;
				}
			}
		};
		int posicion = 1;
		for (Jugador dato :list.getLista())
		{
			if(posicion <=10) {
				if(posicion<=3) {
					Object[] datos = {imagenes.get(posicion),"#"+posicion,dato.getName(),dato.getPuntuacion()};
					modelo.addRow(datos);
				}else{
					Object[] datos = {null,"#"+posicion,dato.getName(),dato.getPuntuacion()};
					modelo.addRow(datos);
				}
				posicion++;
			} 
		}
		int resto = (10-posicion);
		if(resto < 10) {
			for (int i = posicion; i <=10; i++) {
				if(i<=3) {
					Object[] datos = {imagenes.get(i),"#"+i,"----","----"};
					modelo.addRow(datos);
				}else{
				Object[] datos = {null,"#"+i,"----","----"};
				modelo.addRow(datos);
				}
			}
		}
		return modelo;
	}
	/**
	 * Metodo que establece los ajustes de la tabla
	 * @param datos Tabla
	 */
	public void ajustes(JTable datos) {
		JTableHeader jt ;
		Font fuente = new Font("Arial",Font.BOLD,19);
		jt = datos.getTableHeader();
		jt.setFont(fuente);
		DefaultTableCellRenderer left = new DefaultTableCellRenderer();
		left.setHorizontalAlignment(JLabel.LEFT);
		datos.getColumnModel().getColumn(0).setMaxWidth(21);
		datos.getColumnModel().getColumn(1).setCellRenderer(left);
		datos.getColumnModel().getColumn(2).setCellRenderer(left);
		datos.getColumnModel().getColumn(3).setCellRenderer(left);
	}
	/**
	 * Metodo que carga todas la imagenes
	 */
	public void cargarImagenes() {
		imagenes.put(1, new ImageIcon(Ejecutable.class.getResource("/Resource/GoldMedal.gif")));
		imagenes.put(2, new ImageIcon(Ejecutable.class.getResource("/Resource/SilverMedal.gif")));
		imagenes.put(3, new ImageIcon(Ejecutable.class.getResource("/Resource/BronzeMedal.gif")));
	}
}
