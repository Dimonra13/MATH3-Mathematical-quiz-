package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import model.ListaDeJugadores;
import model.ModeloTabla;
import model.Musica;
import model.RellenaSemillas;
import model.Temporizador;
import persistence.BaseDeDatos;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.SystemColor;
/**
 * Clase que lanza la Aplicacion.
 */
public class Ejecutable extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int NUMERO_PREGUNTAS = 20;
	private static final ImageIcon ICONOAPP = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Ejecutable.class.getResource("/Resource/i.png")));
	private static final int CFACIL = 3;
	private static final int CMEDIO = 10;
	protected static String name;
	
	private JPanel contentPane;
	private JPanel cambiador;
	private JPanel Inicio;
	private JPanel Ranking;
	private JPanel ajustes;
	
	private JButton btnSonido;
	private JButton btnInicioDePartida;
	private JButton btnEntrenamiento;
	private JButton btnRanking;
	private JButton btnvolverInicio;
	private JButton btnFondo;
	private JButton btnAjustes;
	private JButton btnSalir;
	private JButton btnTutorial;
	private JButton btnAceptar;
	private JLabel lblpuntuacion;
	private JLabel lblPuntuacionM;
	private JLabel lblRecord;
	private JLabel lblFlecha;
	
	protected boolean indicadorSound;
	protected JButton btnVolverking;
	protected BaseDeDatos bdo = new BaseDeDatos();
	protected RellenaSemillas rs = new RellenaSemillas();
	protected JTable table;
	protected JPanel GameOver;
	protected ListaDeJugadores list = new ListaDeJugadores();
	protected Musica mus = new Musica();
	protected int puntuacionNueva = 0;
	protected Color colorPreGameOver;
	protected static boolean tiempo = false;
	private JLabel lblTu;
	private JLabel lblCorona;
	private JButton txtClasificacin;
	
	
	/**
	 * Lanza la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				boolean retorno= false;
				UIManager.put("OptionPane.background",new ColorUIResource(247,184,188));
				UIManager.put("Panel.background",new ColorUIResource(247,184,188));
				UIManager.put("Button.background",new Color(175,221,233));
				BaseDeDatos bdo = new BaseDeDatos();			
				do {
					try {
						bdo.cargarListaJugadores();
						String nickname = JOptionPane.showInputDialog(null,"Nombre: ","Inicio",JOptionPane.QUESTION_MESSAGE);
						if(nickname==null) {
							int op = JOptionPane.showConfirmDialog(null,"¿Estás seguro?",null,JOptionPane.YES_NO_OPTION);
							if(op==0) {
								JOptionPane.showMessageDialog(null, "Adiós, hasta pronto",null , JOptionPane.INFORMATION_MESSAGE);
								System.exit(0);
							}
						}else if (nickname.isEmpty())
						{
							JOptionPane.showMessageDialog(null, "No ha introducido un usuario","¡Error!", JOptionPane.ERROR_MESSAGE);
						}else {
							retorno=true;
							name = nickname;
							Ejecutable frame = new Ejecutable();
							frame.setVisible(true);	
						}
					} catch (ClassNotFoundException e) {
						System.exit(0);
					} catch (IOException e) {
						int opcion = JOptionPane.showConfirmDialog(null, "Lista no encontrada, ¿Desea crear una nueva?","¡Error!", JOptionPane.YES_NO_OPTION);
						if(opcion==0) {
							try {
								bdo.crearListaJugadores();
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(null, "¡Error!");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Adiós, hasta pronto",null,JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						}
					}
				}while (retorno!=true);
			}
		});
	}

	/**
	 * Crea el frame de la aplicacion.
	 */
	public Ejecutable() {
		try {
			list = bdo.cargarListaJugadores();
		} catch (ClassNotFoundException | IOException e2) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
		if(list.existeJugador(name)==false) {
			list.AgregarJugador(name, 0);
		}else {
			JOptionPane.showMessageDialog(null, "Hola, bienvenido de nuevo "+name, " ",JOptionPane.DEFAULT_OPTION);
		}
		setIconImage(ICONOAPP.getImage());
		rs.generar();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 605, 641);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		ImageIcon escape = new ImageIcon(Ejecutable.class.getResource("/Resource/salirnoelia.png"));
		Icon iconoescape = new ImageIcon(escape.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		
		cambiador = new JPanel();
		cambiador.setBorder(null);
		contentPane.add(cambiador, "name_493007091883600");
		cambiador.setBounds(500, 100, 334, 389);
		cambiador.setLayout(new CardLayout(0, 0));
		
		Inicio = new JPanel();
		Inicio.setBackground(new Color(240, 240, 240));
		cambiador.add(Inicio, "inicio");
		Inicio.setLayout(null);
		
		Ranking = new JPanel();
		cambiador.add(Ranking, "name_497322994889600");
		Ranking.setLayout(null);
		
		
		btnVolverking = new JButton("");
		btnVolverking.setBounds(0, 0, 70, 70);
		btnVolverking.setIcon(iconoescape);
		Ranking.add(btnVolverking);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 81, 589, 521);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Ranking.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Posición", "Nickname","Puntación"}));
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		table.getColumnModel().getColumn(1).setPreferredWidth(131);
		table.getColumnModel().getColumn(2).setPreferredWidth(131);

		scrollPane.setViewportView(table);
		
		txtClasificacin = new JButton();
		txtClasificacin.setBackground(SystemColor.controlHighlight);
		txtClasificacin.setHorizontalAlignment(SwingConstants.CENTER);
		txtClasificacin.setFont(new Font("Dubai Medium", Font.PLAIN, 60));
		txtClasificacin.setText("Clasificaci\u00F3n");
		txtClasificacin.setBounds(82, 0, 507, 70);
		Ranking.add(txtClasificacin);
		btnVolverking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiara(Inicio);
			}
		});
		
		btnInicioDePartida = new JButton("Clásico");
		btnInicioDePartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Juego(0);
			}
		});
		btnInicioDePartida.setBounds(90, 296, 390, 70);
		Inicio.add(btnInicioDePartida);
		
		ajustes = new JPanel();
		cambiador.add(ajustes, "name_493375351101400");
		ajustes.setLayout(null);

		btnSonido = new JButton("");
		btnSonido.setBounds(200, 155, 178, 160);
		ajustes.add(btnSonido);
		ImageIcon sound = new ImageIcon(Ejecutable.class.getResource("/Resource/sound.png"));
		Icon iconoSound = new ImageIcon(sound.getImage().getScaledInstance(btnSonido.getWidth(),btnSonido.getHeight(),Image.SCALE_DEFAULT));
		ImageIcon nsound = new ImageIcon(Ejecutable.class.getResource("/Resource/notSound.png"));
		Icon niconoSound = new ImageIcon(nsound.getImage().getScaledInstance(btnSonido.getWidth(),btnSonido.getHeight(),Image.SCALE_DEFAULT));
		indicadorSound=true;
		btnSonido.setIcon(iconoSound);
		btnSonido.repaint();
		btnSonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indicadorSound == true)
				{
					btnSonido.setIcon(niconoSound);
					btnSonido.repaint();
					indicadorSound = false;
				}else {
					btnSonido.setIcon(iconoSound);
					btnSonido.repaint();
					indicadorSound = true;
				} 
			}
		});
		
		btnvolverInicio = new JButton("");
		btnvolverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiara(Inicio);
			}
		});
		btnvolverInicio.setBounds(0, 0, 70, 70);
		btnvolverInicio.setIcon(iconoescape);
		ajustes.add(btnvolverInicio);
		
		btnFondo = new JButton("Fondo");
		btnFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor();
			}
		});
		btnFondo.setBounds(200, 343, 178, 83);
		ajustes.add(btnFondo);
		
		btnAjustes = new JButton("");
		ImageIcon configuracion= new ImageIcon(Ejecutable.class.getResource("/Resource/settingsnoelia.png"));
		Icon iconoconfiguracion = new ImageIcon(configuracion.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
		btnAjustes.setIcon(iconoconfiguracion);
		btnAjustes.repaint();
		btnAjustes.setBorder(null);
		btnAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiara(ajustes);
			}
		});
		btnAjustes.setBounds(519, 0, 70, 70);
		Inicio.add(btnAjustes);
		
		btnEntrenamiento = new JButton("Entrenamiento");
		btnEntrenamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juego(21);
			}
		});
		btnEntrenamiento.setBounds(90, 382, 390, 70);
		Inicio.add(btnEntrenamiento);
		
		btnRanking = new JButton("Clasificación");
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiara(Ranking);				
				actualizarRanking();
			}
		});
		btnRanking.setBounds(90, 465, 390, 70);
		Inicio.add(btnRanking);
		
		btnSalir = new JButton("");
		btnSalir.setForeground(Color.ORANGE);
		btnSalir.setBackground(new Color(255, 200, 0));
		btnSalir.setBounds(0, 0, 70, 70);
		btnSalir.setIcon(iconoescape);
		btnSalir.repaint();
		btnSalir.setBorder(null);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null,"¿Estás seguro?",null,JOptionPane.YES_NO_OPTION);
				if(op==0) {
					JOptionPane.showMessageDialog(null, "Adiós, hasta pronto",null , JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		});
		Inicio.add(btnSalir);
		
		btnTutorial = new JButton("");
		btnTutorial.setBounds(519, 526, 70, 70);
		btnTutorial.setIcon(iconoescape);
		btnTutorial.repaint();
		btnTutorial.setBorder(null);
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Guía de juego:\r\n" + 
							"\r\n" + 
							"Math3 es un juego quiz sobre matemáticas donde el jugador deberá elegir la respuesta correcta a la pregunta formulada. Consta de dos modos de juego:\r\n" + 
							"\r\n" + 
							"       -El modo Clásico consiste en 20 preguntas, con 15 segundos para responder a cada una de ellas.\r\n" + 
							"\r\n" + 
							"       -En el modo entrenamiento no habrá límite de tiempo ni un número de preguntas fijo, ¡juega hasta que te canses! Ideal para prepararte para el modo Clásico.\r\n" + 
							"",null , JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Inicio.add(btnTutorial);
		
		JButton logo = new JButton("");
		logo.setBounds(90, 68, 390, 194);
		ImageIcon logot= new ImageIcon(Ejecutable.class.getResource("/Resource/logo.png"));
		Icon iconologo = new ImageIcon(logot.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_DEFAULT));
		logo.setIcon(iconologo);
		logo.repaint();
		logo.setBorder(null);
		logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Inicio.add(logo);
		
		GameOver = new JPanel();
		cambiador.add(GameOver, "name_546262432923499");
		GameOver.setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Stencil", Font.PLAIN, 64));
		lblGameOver.setForeground(Color.WHITE);
		lblGameOver.setBounds(0, 0, 589, 111);
		GameOver.add(lblGameOver);
		
		JLabel lblTuPuntuacion = new JLabel("Tu puntuación:");
		lblTuPuntuacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblTuPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblTuPuntuacion.setForeground(Color.WHITE);
		lblTuPuntuacion.setBounds(25, 198, 147, 46);
		GameOver.add(lblTuPuntuacion);
		
		JLabel lblPuntuacionMax = new JLabel("Récord:");
		lblPuntuacionMax.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntuacionMax.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblPuntuacionMax.setForeground(Color.WHITE);
		lblPuntuacionMax.setBounds(25, 150, 147, 46);
		GameOver.add(lblPuntuacionMax);
		
		lblpuntuacion = new JLabel("");
		lblpuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpuntuacion.setBounds(184, 198, 107, 46);
		GameOver.add(lblpuntuacion);
		
		lblPuntuacionM = new JLabel("");
		lblPuntuacionM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntuacionM.setBounds(184, 150, 107, 46);
		GameOver.add(lblPuntuacionM);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarPartida(puntuacionNueva);
				contentPane.setBackground(colorPreGameOver);
				cambiara(Inicio);
			}
		});
		btnAceptar.setBounds(331, 197, 97, 46);
		GameOver.add(btnAceptar);
		
		JButton btnBarra = new JButton("");
		btnBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBarra.setSelectedIcon(null);
		btnBarra.setBounds(12, 441, 565, 22);
		ImageIcon barra= new ImageIcon(Ejecutable.class.getResource("/Resource/Barrasin.png"));
		Icon iconoBarra = new ImageIcon(barra.getImage().getScaledInstance(btnBarra.getWidth(),btnBarra.getHeight(),Image.SCALE_DEFAULT));
		btnBarra.setIcon(iconoBarra);
		
		GameOver.add(btnBarra);
		
		JLabel lblFacil = new JLabel("Nivel bajo");
		lblFacil.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFacil.setForeground(Color.WHITE);
		lblFacil.setBounds(12, 476, 203, 44);
		GameOver.add(lblFacil);
		
		JLabel lblNivelMedio = new JLabel("Nivel medio");
		lblNivelMedio.setForeground(Color.WHITE);
		lblNivelMedio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNivelMedio.setBounds(206, 476, 191, 44);
		GameOver.add(lblNivelMedio);
		
		JLabel lblNivelDifcil = new JLabel("Nivel alto");
		lblNivelDifcil.setForeground(Color.WHITE);
		lblNivelDifcil.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNivelDifcil.setBounds(430, 476, 147, 44);
		GameOver.add(lblNivelDifcil);
		
		lblRecord = new JLabel("\u00A1Mejor puntuaci\u00F3n!");
		lblRecord.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecord.setForeground(Color.WHITE);
		lblRecord.setBounds(0, 88, 589, 97);
		GameOver.add(lblRecord);
		
		
		lblFlecha = new JLabel("");
		lblFlecha.setBackground(Color.YELLOW);
		lblFlecha.setForeground(Color.PINK);
		lblFlecha.setVerticalAlignment(SwingConstants.CENTER);
		lblFlecha.setBounds(12, 302, 56, 137);
		ImageIcon flecha= new ImageIcon(Ejecutable.class.getResource("/Resource/FlechaD.png"));
		Icon iconoFlecha = new ImageIcon(flecha.getImage().getScaledInstance(lblFlecha.getWidth(),lblFlecha.getHeight(),Image.SCALE_DEFAULT));
		lblFlecha.setIcon(iconoFlecha);
		GameOver.add(lblFlecha);
		
		
		lblTu = new JLabel("T\u00DA");
		lblTu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTu.setForeground(Color.WHITE);
		lblTu.setBounds(12, 238, 56, 64);
		GameOver.add(lblTu);
		
		lblCorona = new JLabel("");
		lblCorona.setBounds(71, 239, 43, 43);
		ImageIcon corona= new ImageIcon(Ejecutable.class.getResource("/Resource/Corona.png"));
		Icon iconoCorona = new ImageIcon(corona.getImage().getScaledInstance(lblCorona.getWidth(),lblCorona.getHeight(),Image.SCALE_DEFAULT));
		lblCorona.setIcon(iconoCorona);
		GameOver.add(lblCorona);
		lblCorona.setVisible(false);
		lblRecord.setVisible(false);
		ColorDefecto();
	}
	/**
	 * Metodo que permite cambiar de panel
	 * @param panel Nombre del panel a cambiar
	 */
	private void cambiara(JPanel panel) {
		cambiador.removeAll();
		cambiador.add(panel);
		cambiador.repaint();
		cambiador.revalidate();
	}
	/**
	 * Metodo que establece el color de fondo por defecto que en este caso es blanco
	 */
	private void ColorDefecto() {
		Color color = new Color(247,184,188);
		Color btones = new Color(175,221,233);
		UIManager.put("OptionPane.background",new ColorUIResource(247,184,188));
		UIManager.put("Panel.background",new ColorUIResource(247,184,188));
		UIManager.put("Button.background",new Color(175,221,233));
		btnInicioDePartida.setBackground(btones);
		btnEntrenamiento.setBackground(btones);
		btnRanking.setBackground(btones);
		btnvolverInicio.setBackground(color);
		btnVolverking.setBackground(color);
		btnAjustes.setBackground(color);
		btnSalir.setBackground(color);
		btnTutorial.setBackground(color);
		btnAceptar.setBackground(btones);
		contentPane.setBackground(color);
		cambiador.setBackground(color);
		Inicio.setBackground(color);
		Ranking.setBackground(color);
		ajustes.setBackground(color);
		GameOver.setBackground(Color.BLACK);
		GameOver.setForeground(Color.WHITE);
		lblpuntuacion.setForeground(Color.WHITE);
		lblPuntuacionM.setForeground(Color.WHITE);
		colorPreGameOver = color;
	}
	/**
	 * Metodo que permite cambiar el color de los fondos de la aplicacion
	 */
	private void cambiarColor() {
		String[] colores = {"BLANCO","AMARILLO","ROSA"};
		String color = (String) JOptionPane.showInputDialog(null, "Seleccione color", "Colores", JOptionPane.DEFAULT_OPTION,null, colores, colores[2]);
		if(color == null){
			/*NADA*/
		}else if(color.toUpperCase()== "BLANCO") {
			UIManager.put("OptionPane.background",new ColorUIResource(Color.WHITE));
			UIManager.put("Panel.background",new ColorUIResource(Color.WHITE));
			UIManager.put("Button.background",new Color(175,221,233));
			btnvolverInicio.setBackground(Color.WHITE);
			btnVolverking.setBackground(Color.WHITE);
			btnAjustes.setBackground(Color.WHITE);
			btnSalir.setBackground(Color.WHITE);
			btnTutorial.setBackground(Color.WHITE);
			contentPane.setBackground(Color.WHITE);
			cambiador.setBackground(Color.WHITE);
			Inicio.setBackground(Color.WHITE);
			Ranking.setBackground(Color.WHITE);
			ajustes.setBackground(Color.WHITE);
			colorPreGameOver = Color.WHITE;
		}else if(color.toUpperCase()== "AMARILLO") {
			Color ama = new Color(251,255,133);
			UIManager.put("OptionPane.background",new ColorUIResource(251,255,133));
			UIManager.put("Panel.background",new ColorUIResource(251,255,133));
			UIManager.put("Button.background",new Color(175,221,233));
			btnvolverInicio.setBackground(ama);
			btnVolverking.setBackground(ama);
			btnAjustes.setBackground(ama);
			btnSalir.setBackground(ama);
			btnTutorial.setBackground(ama);
			contentPane.setBackground(ama);
			cambiador.setBackground(ama);
			Inicio.setBackground(ama);
			Ranking.setBackground(ama);
			ajustes.setBackground(ama);
			colorPreGameOver = ama;
		}else if(color.toUpperCase()== "ROSA") {
			Color ama = new Color(247,184,188);
			UIManager.put("OptionPane.background",new ColorUIResource(247,184,188));
			UIManager.put("Panel.background",new ColorUIResource(247,184,188));
			UIManager.put("Button.background",new Color(175,221,233));
			btnvolverInicio.setBackground(ama);
			btnVolverking.setBackground(ama);
			btnAjustes.setBackground(ama);
			btnSalir.setBackground(ama);
			btnTutorial.setBackground(ama);
			contentPane.setBackground(ama);
			cambiador.setBackground(ama);
			Inicio.setBackground(ama);
			Ranking.setBackground(ama);
			ajustes.setBackground(ama);
			colorPreGameOver = ama;
		}
	}
	/**
	 * Metodo que actualiza el ranking al iniciar la aplicacion
	 */
	private void actualizarRanking() {
		ModeloTabla mt = new ModeloTabla();
		mt.cargarImagenes();
		list.ordenar();
		table.setModel(mt.getTablaModel(list));
		mt.ajustes(table);
	}
	/**
	 * Metodo que Lanza un venta con el juego a reproducir
	 */
	private void Juego(int modo) {
		Temporizador temp = new Temporizador();
		boolean salir = false;
		int seleccion = 0;
		int npregunta = 0;
		int naleatorip = 0;
		String [] option = null;
		if(modo==0) {
			/*MODO CLASICO*/
			this.setVisible(false);
			temp.setVisible(false);
			int puntuacionNivel = 0;
			for (int pregunta = 0; pregunta < NUMERO_PREGUNTAS; pregunta++) {
				temp.inicio();
				tiempo = false;
				if(puntuacionNivel<=CFACIL) {
					npregunta = 0+(int)(Math.random() * 999);
					naleatorip = 0+(int)(Math.random() * 2);
					option = opcionesJuego(naleatorip, npregunta);
					seleccion = JOptionPane.showOptionDialog(null, ""+rs.getPreguntas().get(npregunta), "Nivel fácil pregunta "+(pregunta+1), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
					if(tiempo == false) {
						if(seleccion==naleatorip) {
							try {
								if (indicadorSound) {
									mus.Success();
								}
								temp.reiniciar();
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Correcto");
								puntuacionNivel++;
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Musica no encontrada");
							}
						}
						else{
							if(seleccion==-1) {
								temp.destruir();
								this.setVisible(true);
								salir = true;
								break;
							}
							try {
								if (indicadorSound) {
									mus.Fail();
								}
								temp.reiniciar();
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Incorrecto, la respuesta correcta es: "+rs.getRespuestaBuena().get(npregunta).toString());
								puntuacionNivel-=3;
								if(puntuacionNivel<0){
									puntuacionNivel=0;
								}
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}						
						}
					}else {
						JOptionPane.showMessageDialog(null,"Incorrecto, esta pregunta contará como fallida");
						puntuacionNivel-=3;
						if(puntuacionNivel<0){
							puntuacionNivel=0;
						}
					}
				}else if(puntuacionNivel<=CMEDIO) {
					npregunta = 1000 + (int)(Math.random() * 999);
					naleatorip = 0+(int)(Math.random() * 2);
					option = opcionesJuego(naleatorip, npregunta);
					seleccion = JOptionPane.showOptionDialog(null, ""+rs.getPreguntas().get(npregunta), "Nivel medio pregunta "+(pregunta+1), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
					if(tiempo == false) {
						if(seleccion==naleatorip) {
							try {
								if (indicadorSound) {
									mus.Success();
								}
								temp.reiniciar();
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Correcto");
								puntuacionNivel+=2;
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}
						}
						else{
							if(seleccion==-1) {
								temp.destruir();
								this.setVisible(true);
								salir = true;
								break;
							}
							try {
								if (indicadorSound) {
									mus.Fail();
								}
								temp.reiniciar();
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Incorrecto, la respuesta correcta es: "+rs.getRespuestaBuena().get(npregunta).toString());
								puntuacionNivel-=2;
								if(puntuacionNivel<0){
									puntuacionNivel=0;
								}
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}						
						}
					}else {
						JOptionPane.showMessageDialog(null,"Incorrecto, esta pregunta contará como fallida");
						puntuacionNivel-=2;
						if(puntuacionNivel<0){
							puntuacionNivel=0;
						}
					}
				}else {
					npregunta = 2000 + (int)(Math.random() * 1000);
					naleatorip = 0+(int)(Math.random() * 2);
					option = opcionesJuego(naleatorip, npregunta);
					seleccion = JOptionPane.showOptionDialog(null, ""+rs.getPreguntas().get(npregunta), "Nivel difícil pregunta "+(pregunta+1), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
					if(tiempo == false) {
						if(seleccion==naleatorip) {
							try {
								if (indicadorSound) {
									mus.Success();
								}
								temp.reiniciar();
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Correcto");
								puntuacionNivel+=3;
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}
						}
						else{
							if(seleccion==-1) {
								temp.destruir();
								this.setVisible(true);
								salir = true;
								break;
							}
							try {
								if (indicadorSound) {
									mus.Fail();
								}
								temp.reiniciar();
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Incorrecto, la respuesta correcta es: "+rs.getRespuestaBuena().get(npregunta).toString());
								puntuacionNivel--;
								if(puntuacionNivel<0){
									puntuacionNivel=0;
								}
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}						
						}
					}else {
						JOptionPane.showMessageDialog(null,"Incorrecto, esta pregunta contará como fallida");
						puntuacionNivel--;
						if(puntuacionNivel<0){
							puntuacionNivel=0;
						}
					}
				}
			}
			temp.destruir();
			this.setVisible(true);
			if (salir == true) {
				cambiara(Inicio);
			}else {
				formulaDePuntuacion(puntuacionNivel);
				/*try {
					mus.Gameover();
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
					JOptionPane.showMessageDialog(null, "Sonido no encontrado");
				}*/
				fondoGameOver(Color.BLACK);
				cambiara(GameOver);
			}
		}else {
			/*MODO ENTRENAMIENTO*/
			temp.setVisible(false);
			this.setVisible(false);
			int pregunta = 0;
			String[] niveles = {"Fácil","Medio","Difícil"};
			String nivelSelected = (String) JOptionPane.showInputDialog(null, "Seleccione el nivel a practicar", "Dificultad", JOptionPane.DEFAULT_OPTION,null, niveles, niveles[0]);
			if(nivelSelected==null) {
				this.setVisible(true);
				cambiara(Inicio);
			}
			else {
				while(nivelSelected!=null){
					pregunta++;
					if(nivelSelected.equalsIgnoreCase("Fácil")) {
						npregunta = 0+(int)(Math.random() * 999);
						naleatorip = 0+(int)(Math.random() * 2);
						option = opcionesJuegoEnt(naleatorip, npregunta);
						seleccion = JOptionPane.showOptionDialog(null, ""+rs.getPreguntas().get(npregunta), "Nivel fácil pregunta "+(pregunta+1), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
						if(seleccion == 3) {
							temp.setVisible(false);
							pregunta--;
						}else if(seleccion==naleatorip) {
							try {
								if (indicadorSound) {
									mus.Success();
								}
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Correcto");
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}
						}
						else{
							if(seleccion==-1) {
								temp.destruir();
								this.setVisible(true);
								salir = true;
								break;
							}
							try {
								if (indicadorSound) {
									mus.Fail();
								}
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Incorrecto, la respuesta correcta es: "+rs.getRespuestaBuena().get(npregunta).toString());
								
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}						
						}
					}else if(nivelSelected.equalsIgnoreCase("Medio")) {
						npregunta = 1000 + (int)(Math.random() * 999);
						naleatorip = 0+(int)(Math.random() * 2);
						option = opcionesJuegoEnt(naleatorip, npregunta);
						seleccion = JOptionPane.showOptionDialog(null, ""+rs.getPreguntas().get(npregunta), "Nivel medio pregunta "+(pregunta+1), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
						if(seleccion == 3) {
							temp.setVisible(false);
							pregunta--;
						}else if(seleccion==naleatorip) {
							try {
								if (indicadorSound) {
									mus.Success();
								}
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Correcto");
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}
						}
						else{
							if(seleccion==-1) {
								temp.destruir();
								this.setVisible(true);
								break;
							}
							try {
								if (indicadorSound) {
									mus.Fail();
								}
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Incorrecto, la respuesta correcta es: "+rs.getRespuestaBuena().get(npregunta).toString());
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}						
						}
					}else {
						npregunta = 2000 + (int)(Math.random() * 1000);
						naleatorip = 0+(int)(Math.random() * 2);
						option = opcionesJuegoEnt(naleatorip, npregunta);
						seleccion = JOptionPane.showOptionDialog(null, ""+rs.getPreguntas().get(npregunta), "Nivel difícil pregunta "+(pregunta+1), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
						if(seleccion == 3) {
							temp.setVisible(false);
							pregunta--;
						}else if(seleccion==naleatorip) {
							try {
								if (indicadorSound) {
									mus.Success();
								}
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Correcto");
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}
						}
						else{
							if(seleccion==-1) {
								temp.destruir();
								this.setVisible(true);
								break;
							}
							try {
								if (indicadorSound) {
									mus.Fail();
								}
								temp.setVisible(false);
								JOptionPane.showMessageDialog(null,"Incorrecto, la respuesta correcta es: "+rs.getRespuestaBuena().get(npregunta).toString());
							} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
								JOptionPane.showMessageDialog(null, "Música no encontrada");
							}						
						}
					}
					nivelSelected = (String) JOptionPane.showInputDialog(null, "Seleccione nivel a practicar", "Dificultad", JOptionPane.DEFAULT_OPTION,null, niveles, niveles[0]);
					if(nivelSelected==null) {
						temp.destruir();
					}
				};
				this.setVisible(true);
				cambiara(Inicio);
			}
		}
	}
	/**
	 * Formula que aplicando la formula que calcula la puntuacion despues de una partida se la asigna a la variable puntuacion
	 * @param pf variable preguntas fallidas del juego
	 */
	private void formulaDePuntuacion(int pf) {
		puntuacionNueva = pf;
		lblpuntuacion.setText(""+puntuacionNueva);
		list.ordenar();
		lblPuntuacionM.setText(""+list.getLista().get(0).getPuntuacion());
	}
	
	/**
	 * Metodo que devuelve las respuestas a la pregunta del juego
	 * @param naleatorip numero aleatorio de set de preguntas 
	 * @param npregunta numero aleatorio de pregunta de la lista
	 * @return Devuelve el set de respuestas del juego
	 */
	private String [] opcionesJuego(int naleatorip,int npregunta) {
		String [] option = null;
		if (naleatorip==0) {
			option = new String [] {rs.getRespuestaBuena().get(npregunta).toString(),rs.getRespuestaMala1().get(npregunta).toString(),rs.getRespuestaMala2().get(npregunta).toString()};
		}else if(naleatorip==1){
			option = new String [] {rs.getRespuestaMala1().get(npregunta).toString(),rs.getRespuestaBuena().get(npregunta).toString(),rs.getRespuestaMala2().get(npregunta).toString()};
		}else if (naleatorip==2){
			option = new String [] {rs.getRespuestaMala2().get(npregunta).toString(),rs.getRespuestaMala1().get(npregunta).toString(),rs.getRespuestaBuena().get(npregunta).toString()};
		}
		return option;
	}
	
	public static void timeout() {
		tiempo=true;
		JOptionPane.showMessageDialog(null, "\t¡Tiempo!\nEsta pregunta no contará");
	}
	/**
	 * Metodo que devuelve las respuestas a la pregunta del juego modo Entrenamiento
	 * @param naleatorip numero aleatorio de set de preguntas 
	 * @param npregunta numero aleatorio de pregunta de la lista
	 * @return Devuelve el set de respuestas del juego
	 */
	private String [] opcionesJuegoEnt(int naleatorip,int npregunta) {
		String [] option = null;
		if (naleatorip==0) {
			option = new String [] {rs.getRespuestaBuena().get(npregunta).toString(),rs.getRespuestaMala1().get(npregunta).toString(),rs.getRespuestaMala2().get(npregunta).toString(),"Saltar"};
		}else if(naleatorip==1){
			option = new String [] {rs.getRespuestaMala1().get(npregunta).toString(),rs.getRespuestaBuena().get(npregunta).toString(),rs.getRespuestaMala2().get(npregunta).toString(),"Saltar"};
		}else if (naleatorip==2){
			option = new String [] {rs.getRespuestaMala2().get(npregunta).toString(),rs.getRespuestaMala1().get(npregunta).toString(),rs.getRespuestaBuena().get(npregunta).toString(),"Saltar"};
		}
		return option;
	}
	
	/**
	 * Metodo que actualiza la lista con la nueva puntuacion del jugador
	 * @param puntuacion puntuacion del jugador
	 */
	private void guardarPartida(int puntuacion){
		list.actualizar(name,puntuacion);
		list.ordenar();
		try {
			bdo.guardarListaJugadores(list);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al guardar los datos, lista no encontrada", "¡Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Metodo que cambia el fondo del contenc Panel.
	 * @param c Color del Contenc Panel
	 */
	private void fondoGameOver(Color c) {
		int puntuacionNivel = list.getLista().get(0).getPuntuacion();
		int desplazaminetofacil = (puntuacionNueva*42);
		int desplazaminetoMedio = (puntuacionNueva*23);
		int desplazaminetoDificil = (puntuacionNueva*3);
		lblFlecha.setBounds(-17, 317, 56, 137);
		lblTu.setBounds(-17, 260, 56, 64);
		lblCorona.setBounds(-4, 245, 43, 40);
		lblFlecha.setVisible(true);
		lblTu.setVisible(true);

		if(puntuacionNueva<= CFACIL) {
			lblFlecha.setBounds((-17+desplazaminetofacil), 317, 56, 125);
			lblTu.setBounds((-17+desplazaminetofacil), 273, 56, 64);
			lblCorona.setBounds((-4+desplazaminetofacil), 250, 43, 40);
		}else if(puntuacionNueva<=CMEDIO){
			lblFlecha.setBounds((142+desplazaminetoMedio), 317, 56, 125);
			lblTu.setBounds((142+desplazaminetoMedio), 273, 56, 64);
			lblCorona.setBounds((151+desplazaminetoMedio), 250, 43, 40);
		}else{
			lblFlecha.setBounds((372+desplazaminetoDificil), 317, 56, 125);
			lblTu.setBounds((372+desplazaminetoDificil), 273, 56, 64);
			lblCorona.setBounds((381+desplazaminetoDificil),  250, 43, 40);
		}
		
		lblFlecha.setVisible(true);
		lblTu.setVisible(true);
		
		if(puntuacionNueva > puntuacionNivel) {
			lblRecord.setVisible(true);
			lblCorona.setVisible(true);
		}else {
			lblCorona.setVisible(false);
			lblRecord.setVisible(false);
		}
		contentPane.setBackground(c);
	}
}