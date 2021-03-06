package algo3.algocraft.modelo.unidades.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.Unidad;

public class PlanoAereo extends PlanoAccion {

	private static final PlanoAereo INSTANCIA = new PlanoAereo();

	private PlanoAereo() {
	}

	public static PlanoAereo getInstancia() {
		return INSTANCIA;
	}

	public void mover(Unidad unidad, Casilla casilla)
			throws CasillaOcupadaError {
		Casilla casillaAnterior = unidad.posicion();
		casilla.ocuparAereo(unidad);
		if (casillaAnterior != null){
			casillaAnterior.desocuparAire();
		}
	}

	public int recibirDanio(int danioAereo, int danioTerrestre) {
		return danioAereo;
	}

	public int entraEnElRango(int rangoAereo, int rangoTerrestre) {
		return rangoAereo;
	}

	@Override
	public void remover(Casilla posicion) {
		if ( posicion != null){
			posicion.desocuparAire();
		}
	}

}
