package algo3.algocraft.vista;

import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class Sonido {
	
	private static Sonido INSTANCIA;
	
	private Clip clipMetralleta;
	private Clip clipMetralletaGolliat;
	private Clip clipError;
	private Clip clipDestruccionEdificio;
	private Clip muerteMarine,voz;
	
	private Sonido(){
		try {
			clipMetralleta = AudioSystem.getClip();
			clipMetralletaGolliat = AudioSystem.getClip();
			clipError = AudioSystem.getClip();
			clipDestruccionEdificio = AudioSystem.getClip();
			muerteMarine = AudioSystem.getClip();
			voz = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void atacar(UnidadSoldado soldado) {
		soldado.sonidoAtacar();
	}

	public void ataqueDeMarine() {
		clipMetralleta.close();
		try {
			clipMetralleta.open(AudioSystem.getAudioInputStream
			(getClass().getResourceAsStream("/algo3/algocraft/sonidos/metralleta.wav")));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clipMetralleta.start();
	}
	
	public void ataqueDeGolliat() {
		clipMetralletaGolliat.close();
		try {
			clipMetralletaGolliat.open(AudioSystem.getAudioInputStream
			(getClass().getResourceAsStream("/algo3/algocraft/sonidos/golliatMetralleta.wav")));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clipMetralletaGolliat.start();
		
	}
	
	public void error(){
		clipError.close();
		try {
			clipError.open(AudioSystem.getAudioInputStream
			(getClass().getResourceAsStream("/algo3/algocraft/sonidos/PError.wav")));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		clipError.start();
	}

	public static Sonido getInstance() {
		if ( INSTANCIA == null ){
			INSTANCIA = new Sonido();
		}
		return INSTANCIA;
	}

	public void destruccionEdificio() {
		clipDestruccionEdificio.close();
		try {
			clipDestruccionEdificio.open(AudioSystem.getAudioInputStream
					(getClass().getResourceAsStream("/algo3/algocraft/sonidos/destruccionEdificio.wav")));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clipDestruccionEdificio.start();
	}

	public void muerteMarine() {
		muerteMarine.close();
		try {
			muerteMarine.open(AudioSystem.getAudioInputStream
					(getClass().getResourceAsStream("/algo3/algocraft/sonidos/MarineMuerte.wav")));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}
		muerteMarine.start();
	}

	public void voz() {
		voz.close();
		try {
			voz.open(AudioSystem.getAudioInputStream
					(getClass().getResourceAsStream("/algo3/algocraft/sonidos/voz.wav")));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		voz.start();
	}

}
