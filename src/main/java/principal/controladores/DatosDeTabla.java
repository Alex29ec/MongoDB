package principal.controladores;

import java.util.List;

import principal.entidades.Provincia;


public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Code", "Parent Code", "Label"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Provincia> personas = (List<Provincia>) ControladorProvincia.getAllProvincias();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][7];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Provincia persona = personas.get(i);
			datos[i][0] = persona.getCode();
			datos[i][1] = persona.getParent_code();
			datos[i][2] = persona.getLabel();
		}
		
		return datos;
	}
	
	
}
