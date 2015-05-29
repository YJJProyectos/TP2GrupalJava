package Algo3;

import org.junit.Assert;
import org.junit.Test;


public class RecoleccionTest {

	@Test
	public void deberiaRecolectarGas() {
      Gas gas = new Gas();
      Refineria refineria = new Refineria();
      refineria.recolectar(gas);
      Assert.assertEquals(5, refineria.getGas());
	}

}