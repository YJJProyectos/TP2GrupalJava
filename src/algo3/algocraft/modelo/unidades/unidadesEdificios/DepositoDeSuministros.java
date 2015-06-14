package algo3.algocraft.modelo.unidades.unidadesEdificios;

public class DepositoDeSuministros extends UnidadEdificio {

	private boolean enConstruccion;
	private int turnosRestantes;

	public DepositoDeSuministros() {
		this.vida = 1;
		this.enConstruccion = true;
		this.turnosRestantes = 12;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int tiempoDeConstruccion() {
		return 6;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 1000;
			this.enConstruccion = false;
		}
	}

	public void pasarTurno() {
		if (this.enConstruccion) {
			this.continuarConstruccion();
		}
	}

	public boolean enConstruccion() {
		return enConstruccion;
	}

}