package Recolectables;


public abstract class EstructuraRecoleccionGas implements Recolectable{
	
	protected int cantidadGas;
	
	public EstructuraRecoleccionGas(){
		
		cantidadGas = 0;
	}
	
	public abstract boolean Recolectar(Object object);
    
	public int getGas(){
		
		return cantidadGas;
	}
}
