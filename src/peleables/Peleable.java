package peleables;

import tp2.Accionable;

public interface Peleable extends Accionable {

	public void atacarEnemigo(Accionable enemigo);
	
	public void recibirDanio(int danio);

}
