package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.YaEstaDestruidoError;

public class EstadoNoAtaco extends EstadoDeAtaque {
	
	public void atacarEnemigo(UnidadSoldado atacante, Unidad enemigo, int danio) throws YaEstaDestruidoError {
		
		if (atacante.alcanzaPosicion(enemigo.posicion())){
			
			enemigo.recibirDanio(danio);
			atacante.nuevoEstadoDeAtaque(new EstadoYaAtaco());
		
		}
		
	}

}
