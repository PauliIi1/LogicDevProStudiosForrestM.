package co.edu.unbosque.model;

import javax.sound.sampled.*;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * La clase ReproductorMP3 representa un reproductor de música simple que reproduce archivos MP3.
 * Utiliza la API Java Sound para reproducir archivos de audio.
 */
public class ReproductorMP3 {
 // Variables de instancia
    
    /**
     * Lista de pistas de música a reproducir.
     */
    private ArrayList<Parrilla> parrillaList;
    /**
     * Índice de la canción actual en la lista de pistas.
     */
    private int currentSongIndex;
    /**
     * Objeto Clip utilizado para reproducir la música.
     */
    private Clip clip;
    /**
     * Constructor de la clase ReproductorMP3.
     * @param parrillaList Lista de pistas de música a reproducir.
     */
    
    public ReproductorMP3() {
		// TODO Auto-generated constructor stub
	}
    public ReproductorMP3(ArrayList<Parrilla> parrillaList) {
        this.parrillaList = parrillaList;
        this.currentSongIndex = 0;
    }

    /**
     * Método para reproducir la canción actual.
     * Carga el archivo de audio correspondiente y lo reproduce.
     */
    public Boolean playCurrentSong() {
    	
        String filePath = "src/mp3/" + parrillaList.get(currentSongIndex).getArchivo(); // Ajusta la ruta según tu estructura de carpetas
        File audioFile = new File(filePath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            return true;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Método para reproducir la siguiente canción en la lista de pistas.
     * Si alcanza el final de la lista, vuelve a la primera pista.
     */
    public void playNextSong() {
        currentSongIndex++;
        if (currentSongIndex >= parrillaList.size()) {
            currentSongIndex = 0;
        }
        playCurrentSong();
    }
    /**
     * Método para detener la reproducción de la canción actual.
     * Si la canción está en reproducción, la detiene y la devuelve al inicio.
     */
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.setFramePosition(0);
        }
    }
}
