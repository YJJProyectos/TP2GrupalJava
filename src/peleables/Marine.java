package peleables;

public class Marine extends UnidadSoldado {

	protected int danioAereo;
	protected int danioTerrestre;
	protected int transporte;
	protected int vision;
	protected int suministro;
	protected int rangoAereo;
	protected int rangoTerrestre;

	public Marine() {

		this.danioAereo = 6;
		this.danioTerrestre = 6;
		this.vida = 40;
		this.rangoAereo = 4;
		this.rangoTerrestre = 4;
		this.suministro = 1;
		this.vision = 7;
		this.transporte = 1;
	}
}