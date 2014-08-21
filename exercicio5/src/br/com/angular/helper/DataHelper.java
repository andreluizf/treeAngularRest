package br.com.angular.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHelper {
	static DateFormat formatter;

	public static String formataData(String formato, Date data) {
		formatter = new SimpleDateFormat(formato);
		return formatter.format(data);
	}
}
