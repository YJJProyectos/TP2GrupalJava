package algo3.algocraft.modelo.juego;

public class Turno {

	private int turnoActual;
	
	public Turno(){
		this.turnoActual = 0;
	}
	
	public int getTurno(){
		return this.turnoActual;
	}
	public void pasarTurno(){
		this.turnoActual += 1;
	}
	
}
