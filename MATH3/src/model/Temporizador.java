package model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import view.Ejecutable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Temporizador extends JFrame implements Runnable{
	private static final long serialVersionUID = 2L;
	private int tiempo = 1;
	private Thread h1;
	private JPanel contentPane;
	private JLabel lblTiempo;
	private boolean timeBomb;
	/**
	 * Crea el frame del temporizador.
	 */
	public Temporizador() {
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(880,385, 212, 69);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTiempo = new JLabel("");
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempo.setBounds(0, 0, 212, 69);
		contentPane.add(lblTiempo);
		setTitle("Temporizador");
		setUndecorated(true); 
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setVisible(true);
	}
	@Override
	public void run() {
		timeBomb=true;
		while(tiempo!= 15) {
			aumenta();
			lblTiempo.setText("Tiempo: "+tiempo);
			try {
				Thread.sleep(999);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		if(timeBomb==true) {
			Ejecutable.timeout();
		}
	}
	private void aumenta() {
		this.tiempo++;	
	}
	/**
	 * Metodo que reinicia el temporizador
	 */
	public void reiniciar(){
		timeBomb=false;
		h1.interrupt();
	}
	/**
	 * Metodo que esconde el temporizador
	 */
	public void destruir() {
		timeBomb=false;
		this.setVisible(false);
	}
	/**
	 * Metodo que inicia el temporizador
	 */
	public void inicio() {
		h1 = new Thread(this);
		this.tiempo = 0;
		h1.start();
		this.setVisible(true);
	}
}
