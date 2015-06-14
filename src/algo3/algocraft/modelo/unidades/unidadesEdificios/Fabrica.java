package algo3.algocraft.modelo.unidades.unidadesEdificios;

public class Fabrica extends UnidadEdificio {

	private Barraca barraca;
	private boolean enConstruccion;
	private int turnosRestantes;

	public Fabrica(Barraca unaBarraca) {
		this.barraca = unaBarraca;
		this.vida = 1;
		this.enConstruccion = true;
		this.turnosRestantes = 12;
	}

	public boolean entrenarGolliat() {
		if (this.enConstruccion || barraca.estaDestruido()) {
			return false;
		}
		return true;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int tiempoDeConstruccion() {
		return turnosRestantes;
	}

	public void continuarConstruccion() {
		this.turnosRestantes -= 1;
		if (this.turnosRestantes == 0) {
			this.vida = 1250;
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
