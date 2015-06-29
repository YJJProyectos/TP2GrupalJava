package algo3.algocraft.vista;

import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import algo3.algocraft.modelo.juego.NombresInvalidosError;
import algo3.algocraft.modelo.mapa.CoordenadaInvalidaError;

@SuppressWarnings("rawtypes")
public class ConjuntoDeExcepciones {

	private HashMap<Class, JLabel> excepciones;

	public ConjuntoDeExcepciones() {
		this.excepciones = new HashMap<Class, JLabel>();
		this.excepciones.put(NombresInvalidosError.class, new JLabel(
				"<html>Nombres Invalidos <html>", SwingConstants.CENTER));
		this.excepciones.put(CoordenadaInvalidaError.class, new JLabel(
				"<html>Nombres Invalidos <html>", SwingConstants.CENTER));
	}

	public JLabel getExcepcion(Class error) {
		return this.excepciones.get(error);
	}

}
