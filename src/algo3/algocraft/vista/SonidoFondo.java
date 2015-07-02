package algo3.algocraft.vista;

//import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SonidoFondo{
	
	private Clip clip;
	
	public SonidoFondo(){
		//InputStream path = getClass().getResourceAsStream("/algo3/algocraft/sonidos/TerranFondo.wav");
		try {
			this.clip = AudioSystem.getClip();
			this.clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/algo3/algocraft/sonidos/TerranFondo.wav")));
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
