package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public class EstadoNoAtaco extends EstadoDeAtaque {
	
	public void atacarEnemigo(UnidadSoldado atacante, Unidad enemigo) throws YaEstaDestruidoError {
		
		if (enemigo.entraEnElRango(atacante.posicion(),atacante.getRangoAereo(), atacante.getRangoTerrestre())){
			
			enemigo.recibirDanio(atacante.getDanioAereo(), atacante.getDanioTerrestre());
			atacante.nuevoEstadoDeAtaque(new EstadoYaAtaco());
		
		}
		
	}

}
