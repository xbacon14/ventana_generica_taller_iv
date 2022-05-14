package py.edu.facitec.proyecto_ventas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	public static Date stringToDate(String date) throws ParseException {
		Date result = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		return result;

	}

	public static String dateToString(Date fecha) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		return dateFormat.format(fecha);
	}

}
