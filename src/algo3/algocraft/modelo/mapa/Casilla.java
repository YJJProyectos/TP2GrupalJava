package algo3.algocraft.modelo.mapa;

import algo3.algocraft.modelo.recursos.Recurso;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.unidadesEdificios.recolectores.Recolector;

public class Casilla {

	private Coordenada ubicacion;
	private Unidad ocupanteTerrestre;
	private Unidad ocupanteAereo;
	private Recurso recurso;

	public Casilla(Coordenada coordenada) {
		this.ubicacion = coordenada;
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

	public Unidad getOcupanteTerrestre() {
		return this.ocupanteTerrestre;
	}

	public Unidad getOcupanteAereo() {
		return this.ocupanteTerrestre;
	}

	public Recurso getRecurso() {
		return this.recurso;
	}

	public void ocuparTerrestre(Unidad unidad) throws CasillaOcupadaError {
		if ((this.ocupanteTerrestre != null) || (this.recurso != null)) {
			throw new CasillaOcupadaError();
		}
		this.ocupanteTerrestre = unidad;
		unidad.nuevaPosicion(this);

	}

	public void ocuparAereo(Unidad unidad) throws CasillaOcupadaError {
		if (this.ocupanteAereo != null) {
			throw new CasillaOcupadaError();
		}
		this.ocupanteAereo = unidad;
		unidad.nuevaPosicion(this);

	}

	public void ocuparRecurso(Recolector unidad) throws CasillaOcupadaError {
		if ((this.ocupanteTerrestre != null) || (this.recurso == null)) {
			throw new CasillaOcupadaError();
		}
		this.ocupanteTerrestre = (Unidad) unidad;
	}

	public void agregarRecurso(Recurso unRecurso) throws CasillaOcupadaError {
		if ((this.ocupanteTerrestre != null) || (this.recurso != null)) {
			throw new CasillaOcupadaError();
		}
		this.recurso = unRecurso;
	}

	public Unidad desocuparTierra() {
		Unidad ocupante = this.ocupanteTerrestre;
		this.ocupanteTerrestre = null;
		return ocupante;
	}

	public Unidad desocuparAire() {
		Unidad ocupante = this.ocupanteAereo;
		this.ocupanteAereo = null;
		return ocupante;
	}

	public Coordenada posicion() {
		return this.ubicacion;
	}

	public int distanciaA(Casilla otraPosicion) {
		Coordenada otraCoordenada = otraPosicion.posicion();
		return this.ubicacion.distanciaA(otraCoordenada);
	}

}