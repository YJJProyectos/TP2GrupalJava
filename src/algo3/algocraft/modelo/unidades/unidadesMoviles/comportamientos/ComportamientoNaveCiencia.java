package algo3.algocraft.modelo.unidades.unidadesMoviles.comportamientos;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;

public class ComportamientoNaveCiencia {

	private static final ComportamientoNaveCiencia INSTANCIA= new ComportamientoNaveCiencia();
	
	private ComportamientoNaveCiencia() {}
	
	public static ComportamientoNaveCiencia getInstancia () {
		return INSTANCIA;
	}
	public int energiaPorTurno() {
		return 10;
	}
	
	public void magiaHaciaUnidad(Unidad unidad){
		return;
	}
	
	public boolean esTerrestre() {
		return false;
	}
	
	public boolean mover(Unidad unidad, Casilla casilla) {
		return casilla.ocuparAereo(unidad);
	}
	
	public void magiaHaciaLugar(Casilla casilla) {
		return;
	}
	
}
