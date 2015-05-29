package Algo3;

public class Refineria {
	
	private int cantidadGas;
    public Refineria(){
    	
    	this.cantidadGas = 0;
    }
	public int getGas() {
		
		return this.cantidadGas;
	}
	public void recolectar(Gas gas) {
		
		this.cantidadGas += 5;
	}

}
