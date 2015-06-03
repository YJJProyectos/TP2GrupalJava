package interfaces;

import interfaces.Ubicable;
import interfaces.Navegable;

public interface Ocupable {

	public boolean estaOcupada();

	public boolean esTerrestre();
	
	public Accionable ocupante();

	public boolean ocupar(Accionable unidad);
	
	public void situar(Ubicable coordenada, Navegable escenario);
	
	public Ubicable posicion();
	
	public int distanciaA(Ocupable otroLugar);
	
}
