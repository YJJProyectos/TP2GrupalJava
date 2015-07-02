package algo3.algocraft.vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import algo3.algocraft.CreacionDeArchivos;

public class SonidoFondo{
	
	private Clip clip;
	
	public SonidoFondo(){
		try {
			File carpeta = new File("\\AlgoCraft\\Sonidos\\"); // esto es creacion 
			carpeta.mkdirs();                                  // de carpertas 
			InputStream mp3enjar = getClass().getResourceAsStream("/algo3/algocraft/sonidos/TerranFondo.wav");
			String url = "/AlgoCraft/Sonidos/TerranFondo.wav";
			OutputStream musica = new FileOutputStream("/AlgoCraft/Sonidos/TerranFondo.wav");
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(url);
			this.clip = AudioSystem.getClip();
			this.clip.open(AudioSystem.getAudioInputStream(file_mp3));
			this.clip.start();
			
		} catch (Exception fallo){
			System.out.println(fallo);
			System.exit(0);
		}
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void reproducir() {
		this.clip.start();
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void detener() {
		this.clip.stop();
	}

	public boolean estaActivo() {
		boolean activo = this.clip.isActive();
		return activo;
	}
	


}
