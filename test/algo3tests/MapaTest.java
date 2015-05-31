package algo3tests;

import org.junit.Assert;
import org.junit.Test;
import algo3.Mapa;

public class MapaTest {
	
	@Test
	public void deberiaTenerTamanio64 (){
		Mapa mapa = new Mapa(8);
		
		Assert.assertEquals(mapa.tamanio(), 64);
	}

}
