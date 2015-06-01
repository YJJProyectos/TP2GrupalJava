package peleables;

public class Golliat extends UnidadSoldado {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int transporte;
	protected int vision;
	protected int suministro;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public Golliat() {

		this.danioAereo = 10;
		this.danioTerrestre = 12;
		this.vida = 125;
		this.rangoAereo = 5;
		this.rangoTerrestre = 6;
		this.suministro = 2;
		this.vision = 8;
		this.transporte = 2;

	}
}