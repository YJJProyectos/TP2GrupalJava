package algo3.algocraft.vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import algo3.algocraft.CreacionDeArchivos;
import algo3.algocraft.modelo.unidades.unidadesMoviles.UnidadSoldado;

public class Sonido {
	
	private static Sonido INSTANCIA;
	
	private Clip clipMetralleta;
	private Clip clipMetralletaGolliat;
	private Clip clipError;
	private Clip clipDestruccionEdificio;
	private Clip muerteMarine,voz;
	private Clip clipMisilesEspectro;
	
	private Sonido(){
		try {
			clipMetralleta = AudioSystem.getClip();
			clipMetralletaGolliat = AudioSystem.getClip();
			clipError = AudioSystem.getClip();
			clipDestruccionEdificio = AudioSystem.getClip();
			muerteMarine = AudioSystem.getClip();
			voz = AudioSystem.getClip();
			clipMisilesEspectro = AudioSystem.getClip();
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
			InputStream mp3enjar = getClass()
					.getResourceAsStream("/algo3/algocraft/sonidos/metralleta.wav");
			String url = "/AlgoCraft/Sonidos/metralleta.wav";
			OutputStream musica = new FileOutputStream(url);
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(url);
			clipMetralleta.open(AudioSystem.getAudioInputStream(file_mp3));
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
			InputStream mp3enjar = getClass()
					.getResourceAsStream("/algo3/algocraft/sonidos/golliatMetralleta.wav");
			String url = "/AlgoCraft/Sonidos/golliatMetralleta.wav";
			OutputStream musica = new FileOutputStream(url);
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(url);
			clipMetralletaGolliat.open(AudioSystem.getAudioInputStream(file_mp3));
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
			InputStream mp3enjar = getClass()
					.getResourceAsStream("/algo3/algocraft/sonidos/PError.wav");
			String url = "/AlgoCraft/Sonidos/PError.wav";
			OutputStream musica = new FileOutputStream(url);
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(url);
			clipError.open(AudioSystem.getAudioInputStream(file_mp3));
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
			InputStream mp3enjar = getClass()
					.getResourceAsStream("/algo3/algocraft/sonidos/destruccionEdificio.wav");
			String url = "/AlgoCraft/Sonidos/destruccionEdificio.wav";
			OutputStream musica = new FileOutputStream(url);
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(url);
			clipDestruccionEdificio.open(AudioSystem.getAudioInputStream(file_mp3));
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
			InputStream mp3enjar = getClass()
					.getResourceAsStream("/algo3/algocraft/sonidos/MarineMuerte.wav");
			String url = "/AlgoCraft/Sonidos/MarineMuerte.wav";
			OutputStream musica = new FileOutputStream(url);
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(url);
			muerteMarine.open(AudioSystem.getAudioInputStream(file_mp3));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}
		muerteMarine.start();
	}

	public void voz() {
		voz.close();
		try {
			int numero = (int) Math.round(Math.random() * 3);
			String url = "/algo3/algocraft/sonidos/voz";
			String urlOtro = "/AlgoCraft/Sonidos/voz";
			InputStream mp3enjar = getClass().getResourceAsStream(url + numero + ".wav");
			OutputStream musica = new FileOutputStream(urlOtro + numero);
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(urlOtro + numero);
			voz.open(AudioSystem.getAudioInputStream(file_mp3));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		voz.start();
	}

	public void ataqueDeEspectro() {
		clipMisilesEspectro.close();
		try {
			InputStream mp3enjar = getClass()
					.getResourceAsStream("/algo3/algocraft/sonidos/Misil.wav");
			String url = "/AlgoCraft/Sonidos/Misil.wav";
			OutputStream musica = new FileOutputStream(url);
			CreacionDeArchivos.crearSonido(mp3enjar, musica);
			File file_mp3 = new File(url);
			clipMisilesEspectro.open(AudioSystem.getAudioInputStream(file_mp3));
		} catch (LineUnavailableException | IOException
				| UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		}
		clipMisilesEspectro.start();
	}

}
