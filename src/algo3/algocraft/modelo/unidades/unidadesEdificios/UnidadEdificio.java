package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.Unidad;
import algo3.algocraft.modelo.unidades.comportamientos.PlanoTerrestre;
import algo3.algocraft.vista.Sonido;

public abstract class UnidadEdificio extends Unidad {

	protected int tiempoDeConstruccion;
	protected boolean enConstruccion;
	protected int turnosRestantes;

	protected UnidadEdificio(Jugador jugador, int vida, int costoMineral,
			int costoGas, String nombre) {
		super(jugador, vida, PlanoTerrestre.getInstancia(), costoMineral,
				costoGas, 0, nombre);

	}

	public boolean esTerrestre() {
		return true;
	}
	
	@Override
	public void sonidoDestruccion(){
		Sonido sonido = Sonido.getInstance();
		sonido.destruccionEdificio();
	}

	public abstract int tiempoDeConstruccion();

}
