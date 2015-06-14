package algo3.algocraft.modelo.juego;

public class Jugador {
	
	protected int cantidadMineral;
	
	public int cantidadMineral(){
		return this.cantidadMineral;
	}

	public void aumentarMineral(int cantidadMineralRecolectado) {
		this.cantidadMineral += cantidadMineralRecolectado;
	}

}
