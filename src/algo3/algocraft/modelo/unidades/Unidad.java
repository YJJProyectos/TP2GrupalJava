package algo3.algocraft.modelo.unidades;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos.PlanoAccion;

public abstract class Unidad {

	protected Jugador jugador;
	protected Casilla posicion;
	protected int vida;
	protected PlanoAccion plano;
	protected int costoMineral;
	protected int costoGas;
	protected int suministro;
	protected String nombre;

	protected Unidad(Jugador jugador, int vida, PlanoAccion plano,
			int costoMineral, int costoGas, int unSuministro, String nombre) {
		this.jugador = jugador;
		this.vida = vida;
		this.plano = plano;
		this.vida = vida;
		this.costoMineral = costoMineral;
		this.costoGas = costoGas;
		this.suministro = unSuministro;
		this.nombre = nombre;
	}

	public void recibirDanio(int danio) {
		this.vida = this.vida - danio;
		if (this.vida <= 0) {
			this.plano.remover(this.posicion);
		}
	}

	public int vidaRestante() {
		return this.vida;
	}

	public boolean estaDestruido() {
		return (this.vida <= 0);
	}

	public Casilla posicion() {
		return this.posicion;
	}

	public void nuevaPosicion(Casilla casilla) {
		this.posicion = casilla;
	}

	public void posicionar(Casilla casilla) throws CasillaOcupadaError {
		this.plano.mover(this, casilla);
	}

	public abstract void pasarTurno();

	public Jugador getJugador() {
		return this.jugador;
	}

	public boolean esAliado(Unidad otro) {
		return (this.jugador == otro.getJugador());
	}

	public boolean entraEnElRango(Casilla posicion, int rangoAereo,
			int rangoTerrestre) {
		return (this.posicion.distanciaA(posicion) <= plano.entraEnElRango(
				rangoAereo, rangoTerrestre));
	}

	public PlanoAccion getPlano() {
		return this.plano;
	}

	public int getSuministro() {
		return this.suministro;
	}

	public String getNombre() {
		return this.nombre;
	}

}
