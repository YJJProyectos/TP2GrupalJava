package tp2;

import interfaces.Accionable;
import interfaces.Ocupable;
import interfaces.Navegable;

public abstract class Casilla implements Ocupable {

	protected Coordenada ubicacion;
	protected Accionable ocupante;
	protected Navegable mapa;

	public boolean estaOcupada() {
		return (ocupante != null);
	}

	public Accionable ocupante() {
		return ocupante;
	}

	public abstract boolean ocupar(Accionable unidad);
	
	public void desocupar() {
		ocupante = null;
	}
	
	public void situar(Coordenada posicion, Navegable escenario) {
		ubicacion = posicion;
		mapa = escenario;
	}
	
	public Coordenada posicion(){
		return ubicacion;
	}
	
	public int distanciaA(Ocupable otraPosicion) {
		return mapa.distanciaEntre(this,otraPosicion);
	}
}