package peleables;

import tp2.Unidad;

public class UnidadSoldado extends Unidad implements Peleable {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int transporte;
	protected int vision;
	protected int suministro;
	protected int rangoAereo;
	protected int rangoTerrestre;
	
	public UnidadSoldado(int tipo) {
		if (tipo == 1) this.settearInfo(1, 7, 6, 6, 1, 4, 4, 40);
			else this.settearInfo(2, 8, 10, 12, 2, 5, 6, 125);
	}

	private void settearInfo(int transporte, int vision, int danioAereo, int danioTerrestre,
			int suministro, int rangoAereo, int rangoTerrestre, int vida ){
		
		this.danioAereo = danioAereo;
		this.danioTerrestre = danioTerrestre;
		this.vida = vida;
		this.rangoAereo = rangoAereo;
		this.rangoTerrestre = rangoTerrestre;
		this.suministro = suministro;
		this.vision = vision;
		this.transporte = transporte;
		
	}
	
	public void atacarEnemigo(Peleable enemigo) {
		return;
	}

	public void recibirDanio(int danio) {
		this.vida = (this.vida - danio);
	}

	@Override
	public int vidaRestante() {
		return this.vida;
	}

}
