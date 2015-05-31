package algo3tests;

import org.junit.Assert;
import org.junit.Test;

import algo3.CasillaTerrestre;
import algo3.Ocupable;

public class CasillaTest {
	
	@Test
	public void deberiaNoEstarOcupada (){
		Ocupable casilla = new CasillaTerrestre();
		
		Assert.assertFalse(casilla.esta_ocupada());
	}

}
