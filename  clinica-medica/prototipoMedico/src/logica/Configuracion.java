package logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
	
	private Properties propiedades = new Properties();    
    /**
     * FEDE DOCUMENTA
     */
	public Configuracion()
    {
    	try {
    		//leo archivo de configuracion para obtener la ruta default
    		FileInputStream entrada = new FileInputStream("./conf/config.properties");
    		propiedades.load(entrada);
			//listo las propiedades por consola			
			propiedades.list(System.out);
	
        	System.out.println("se carga correctamente la ruta default");
        }catch (FileNotFoundException e1) {
        	System.out.println("Ha ocurrido una excepcion al abrir el fichero, no se encuentra o está protegido");
        	e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ha ocurrido una excepcion de IO");
			e.printStackTrace();
		}
    }

	public String getValor(String referencia){
		return propiedades.getProperty(referencia);
	}

}
