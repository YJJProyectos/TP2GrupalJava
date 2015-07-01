package algo3.algocraft.modelo.unidades.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.mapa.CasillaOcupadaError;
import algo3.algocraft.modelo.unidades.Unidad;

public class PlanoTerrestre extends PlanoAccion {

	private static final PlanoTerrestre INSTANCIA = new PlanoTerrestre();

	private PlanoTerrestre() {
	}

	public static PlanoTerrestre getInstancia() {
		return INSTANCIA;
	}

	public void mover(Unidad unidad, Casilla casilla)
			throws CasillaOcupadaError {
		Casilla casillaAnterior = unidad.posicion();
		casilla.ocuparTerrestre(unidad);
		if (casillaAnterior != null){
			casillaAnterior.desocuparTierra();
		}
	}

	public int recibirDanio(int danioAereo, int danioTerrestre) {
		return danioTerrestre;
	}

	public int entraEnElRango(int rangoAereo, int rangoTerrestre) {
		return rangoTerrestre;
	}

	@Override
	public void remover(Casilla posicion) {
		if ( posicion != null){
			posicion.desocuparTierra();
		}
	}

}
