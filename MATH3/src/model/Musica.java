package model;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 * Clase que maneja todo lo relacionado con los archivos de sonido de la aplicacion. 
 *
 */
public class Musica {
	/**
	 * Metodo que carga y reproduce el archivo de fallo de pregunta
	 * @throws LineUnavailableException Archivo corrupto
	 * @throws IOException Musica no Encontrada
	 * @throws UnsupportedAudioFileException Archivo incomplatible
	 */
	public void Fail() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		BufferedInputStream bi = new BufferedInputStream(getClass().getResourceAsStream("/Resource/Fail.wav"));
		AudioInputStream is = AudioSystem.getAudioInputStream(bi);
		Clip son = AudioSystem.getClip();
		son.open(is);
		son.start();
	}
	/**
	 * Metodo que carga y reproduce el archivo de acierto de pregunta
	 * @throws LineUnavailableException Archivo corrupto
	 * @throws IOException Musica no Encontrada
	 * @throws UnsupportedAudioFileException Archivo incomplatible
	 */
	public void Success() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		BufferedInputStream bi = new BufferedInputStream(getClass().getResourceAsStream("/Resource/Success.wav"));
		AudioInputStream ai = AudioSystem.getAudioInputStream(bi);
		Clip son = AudioSystem.getClip();
		son.open(ai);
		son.start();
	}
	
	/**
	 *  Metodo que carga y reproduce el archivo de GameOver del Juego
	 * @throws LineUnavailableException Archivo corrupto
	 * @throws IOException Musica no Encontrada
	 * @throws UnsupportedAudioFileException Archivo incomplatible
	 */
	/*
	public void Gameover() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		BufferedInputStream bi = new BufferedInputStream(getClass().getResourceAsStream("/Resource/GameOver.wav"));
		AudioInputStream ai = AudioSystem.getAudioInputStream(bi);
		Clip son = AudioSystem.getClip();
		son.open(ai);
		son.start();
	}*/
}
