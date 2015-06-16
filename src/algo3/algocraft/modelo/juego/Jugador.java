package algo3.algocraft.modelo.juego;

public class Jugador {

	protected int cantidadMineral;
	protected int poblacion;

	public int cantidadMineral() {
		return this.cantidadMineral;
	}

	public void aumentarMineral(int cantidadMineralRecolectado) {
		this.cantidadMineral += cantidadMineralRecolectado;
	}

	public int cantidadPoblacion() {
		return this.poblacion;
	}

	public void aumentarPoblacion() {
		this.poblacion += 10;
		if (this.poblacion > 200) {
			this.poblacion = 200;
		}
	}

}
