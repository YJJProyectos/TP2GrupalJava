package interfaces;

public interface Ubicable {
	
	public void setFila(int fila);
	
	public void setColumna(int columna);
	
	public int getFila();
	
	public int getColumna();
	
	public int codigoUnico();
	
	public boolean esLaMismaUbicacion(Object Objeto);

}
