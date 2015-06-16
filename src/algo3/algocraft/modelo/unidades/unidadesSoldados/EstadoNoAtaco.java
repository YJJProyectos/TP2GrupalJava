package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.mapa.Casilla;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public class EstadoNoAtaco extends EstadoDeAtaque {
	
	public EstadoNoAtaco(UnidadSoldado unidad){
		this.unidad = unidad;
	}

	@Override
	public void atacarEnemigo(Unidad enemigo) throws YaEstaDestruidoError {
		Casilla casillaDeMiUnidad = this.unidad.posicion();
		Casilla casiillaDelEnemigo = enemigo.posicion();
		if ( casillaDeMiUnidad.distanciaA(casiillaDelEnemigo) <= this.unidad.getRangoTerrestre()){
			enemigo.recibirDanio(this.unidad.getDanioTerrestre());
		}
	}

}
