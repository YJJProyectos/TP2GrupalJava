package mapa;

import accionables.Accionable;

public abstract class Casilla  {

	protected Coordenada ubicacion;
	protected Accionable ocupante;
	protected Mapa mapa;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public Accionable ocupante() {
		return ocupante;
	}

	public abstract boolean ocupar(Accionable unidad);

	public abstract boolean esTerrestre();

	public void desocupar() {
		ocupante = null;
	}

	public void situar(Coordenada posicion, Mapa escenario) {
		ubicacion = posicion;
		mapa = escenario;
	}

	public Coordenada posicion() {
		return ubicacion;
	}

	public int distanciaA(Casilla otraPosicion) {
		return mapa.distanciaEntre(this, otraPosicion);
	}
}