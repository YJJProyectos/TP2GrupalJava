package algo3.algocraft.modelo.unidades.unidadesEdificios;

import algo3.algocraft.modelo.juego.Jugador;
import algo3.algocraft.modelo.unidades.unidadesSoldados.Marine;

public class Barraca extends UnidadEdificio {

	private boolean enConstruccion;
	private int turnosRestantes;
	private Marine marineEnEntrenamiento;
	private int turnosRestantesParaTerminarMarine;

	public Barraca(Jugador unJugador) {
		super(unJugador,1);
		this.enConstruccion = true;
		this.turnosRestantes = 12;
		this.turnosRestantesParaTerminarMarine = 3;
	}

	public boolean entrenarMarine() {
		if (this.enConstruccion || this.marineEnEntrenamiento != null) {
			return false;
		}
		this.marineEnEntrenamiento = new Marine(this.jugador);
		return true;
	}

	public int tiempoDeConstruccion() {
		return turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 1000;
			this.enConstruccion = false;
		}
	}
	
	public void continuarEntrenamientoDeMarine(){
		if (this.marineEnEntrenamiento != null)
			this.turnosRestantesParaTerminarMarine -= 1;
			if (this.turnosRestantesParaTerminarMarine == 0){
				this.jugador.agregarSoldadoParaPosicionar(this.marineEnEntrenamiento );
				this.marineEnEntrenamiento = null;
				this.turnosRestantesParaTerminarMarine = 3;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		}
		this.continuarEntrenamientoDeMarine();
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}
}
