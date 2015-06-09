package algo3.algocraft.modelo.edificables;

public class Fabrica extends UnidadEdificio {

	public Fabrica() {
	}

	public boolean entrenarGolliat() {
		return true;
	}

	public boolean edificar() {
		return true;
	}

	public boolean esTerrestre() {
		return true;
	}

	public int tiempoDeConstruccion() {
		return 12;
	}

}
