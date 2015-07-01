package algo3.algocraft.modelo.unidades.unidadesMoviles;

import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.comportamientos.PlanoAccion;

public class EstadoNoAtaco extends EstadoDeAtaque {

	public void atacar(UnidadSoldado atacante, Unidad enemigo)
			throws DistanciaFueraDeRangoError {
		PlanoAccion plano = enemigo.getPlano();
		int distanciaRequerida = atacante.posicion().distanciaA(
				enemigo.posicion());
		int rangoAereo = atacante.getRangoAereo();
		int rangoTerrestre = atacante.getRangoTerrestre();
		int distanciaAtaque = plano.entraEnElRango(rangoAereo, rangoTerrestre);
		if (distanciaRequerida > distanciaAtaque) {
			throw new DistanciaFueraDeRangoError();
		}
		int danioAereo = atacante.getDanioAereo();
		int danioTerrestre = atacante.getDanioTerrestre();
		int danio = plano.recibirDanio(danioAereo, danioTerrestre);
		enemigo.recibirDanio(danio);
		atacante.nuevoEstadoDeAtaque(new EstadoYaAtaco());
	}
}
