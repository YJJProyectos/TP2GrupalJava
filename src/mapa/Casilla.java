package mapa;

import imponibles.Recolector;
import recolectables.Recolectable;
import accionables.Accionable;

public class Casilla {

	private Coordenada ubicacion;
	private Accionable ocupanteTerrestre;
	private Accionable ocupanteAereo;
	private Recolectable recurso;

	public Casilla() {
		this.ubicacion = null;
		this.ocupanteTerrestre = null;
		this.ocupanteAereo = null;
		this.recurso = null;
	}

	public boolean estaOcupadaLaTierra() {
		return (this.ocupanteTerrestre != null);
	}

	public boolean estaOcupadoElAire() {
		return (this.ocupanteAereo != null);
	}

	public boolean estaOcupadoElRecurso() {
		return (this.recurso != null);
	}

	public Accionable getOcupanteTerrestre() {
		return this.ocupanteTerrestre;
	}

	public Accionable getOcupanteAereo() {
		return this.ocupanteTerrestre;
	}

	public Recolectable getRecurso() {
		return this.recurso;
	}

	private boolean ocuparTerrestre(Accionable unidad) {
		if ((this.ocupanteTerrestre == null) && (this.recurso == null)) {
			this.ocupanteTerrestre = (Accionable) unidad;
			return true;
		}
		return false;

	}

	private boolean ocuparAereo(Accionable unidad) {
		if (this.ocupanteAereo == null) {
			this.ocupanteAereo = (Accionable) unidad;
			return true;
		}
		return false;

	}

	public boolean ocupar(Accionable unidad) {
		if (unidad.esTerrestre()) {
			return ocuparTerrestre(unidad);
		}
		return ocuparAereo(unidad);
	}

	public boolean ocupar(Recolector unidad) {
		if ((this.ocupanteTerrestre == null) && (this.recurso != null)) {
			this.ocupanteTerrestre = (Accionable) unidad;
			return true;
		}
		return false;
	}

	public boolean agregarRecurso(Recolectable unRecurso) {
		if ((this.ocupanteTerrestre == null) && (this.recurso == null)) {
			this.recurso = unRecurso;
			return true;
		}
		return false;
	}

	public boolean desocuparTierra() {
		if (this.ocupanteTerrestre == null) {
			return false;
		}
		this.ocupanteTerrestre = null;
		return true;
	}

	public boolean desocuparAire() {
		if (this.ocupanteAereo == null) {
			return false;
		}
		this.ocupanteAereo = null;
		return true;
	}

	// /

	public void situar(Coordenada posicion) {
		this.ubicacion = posicion;
	}

	public Coordenada posicion() {
		return this.ubicacion;
	}

	public int distanciaA(Casilla otraPosicion) {
		Coordenada otraCoordenada = otraPosicion.posicion();

		return distanciaEntre(this.ubicacion, otraCoordenada);
	}
	private int distanciaEntre(Coordenada coordenadaA, Coordenada coordenadaB){
		int filaA = coordenadaA.getFila();
		int columnaA = coordenadaA.getColumna();
		int filaB = coordenadaB.getFila();
		int columnaB = coordenadaB.getColumna();
		double X = Math.pow((filaA - filaB), 2);
		double Y = Math.pow((columnaA - columnaB), 2);
		double resultadoRaiz = Math.sqrt(X + Y);
		int distancia = (int) Math.round(resultadoRaiz);

		return distancia;

	}
}