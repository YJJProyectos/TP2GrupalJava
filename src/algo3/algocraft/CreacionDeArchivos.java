package algo3.algocraft;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CreacionDeArchivos {
	
	public static void crearSonido(InputStream input, OutputStream output)
			throws IOException{
		
		byte[] buf = new byte[1024];
		int longitud;
		while ( ( longitud = input.read(buf) ) > 0) {
			output.write(buf, 0, longitud);		
		}
		input.close();
		output.close();
	}

}
