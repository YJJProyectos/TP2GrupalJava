package algo3.algocraft.modelo.unidades.unidadesSoldados;

import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public class EstadoNoAtaco extends EstadoDeAtaque {
	
	public void atacarEnemigo(UnidadSoldado atacante, Unidad enemigo) throws YaEstaDestruidoError {
		if (atacante.posicion().distanciaA(enemigo.posicion()) <= atacante.getRangoTerrestre()){
			enemigo.recibirDanio(atacante.getDanioTerrestre());
			atacante.nuevoEstadoDeAtaque(new EstadoYaAtaco());
		}
	}

}
