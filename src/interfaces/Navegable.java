package interfaces;

import excepciones.CoordenadaInvalidaError;

public interface Navegable {
	
	public int distanciaEntre(Ocupable posicion1, Ocupable posicion2);
	
	public int distanciaEntre(Ubicable coordenadaA, Ubicable coordenadaB) 
			throws CoordenadaInvalidaError;
	
	public void agregarElementoEnPosicion(Accionable elemento, Ubicable coordenada);
	
	public Accionable obtenerElementoEnPosicion(Ubicable coordenada);

}
