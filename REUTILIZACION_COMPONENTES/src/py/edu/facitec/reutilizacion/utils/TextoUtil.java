package py.edu.facitec.reutilizacion.utils;

import java.text.Normalizer;

public class TextoUtil {
	public static String normalizarText(String texto) {
//		CAMBIAMOS ESPACIOS POR GUION BAJO Y CONVERTIMOS A MINUSCULAS
		texto = texto.replaceAll(" ", "_").toLowerCase();

//		ELIMINAMOS LOS ACENTOS DEL TEXTO
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("\\p{InCombiningDiacriticalMarks}", "");

		return texto;

	}
}
