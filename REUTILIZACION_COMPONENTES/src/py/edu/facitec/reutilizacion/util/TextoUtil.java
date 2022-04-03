package py.edu.facitec.reutilizacion.util;

import java.text.Normalizer;

public class TextoUtil {
	public static String normalizarTexto(String texto) {
		//cambiamos espacios por guion bajo y convertimos a minusculas 
		texto = texto.replace(" ","_").toLowerCase();
		
		//remover acentos del string 
		texto = Normalizer.normalize(texto, Normalizer.Form.NFC);
		texto = texto.replace("\\p{InCombiningDiacriticalMarks}", "");
		
		return texto;
	}
}
