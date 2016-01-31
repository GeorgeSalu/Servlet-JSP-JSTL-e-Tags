package br.edu.olamundo.converte;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverter implements Converter {
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public String converterParaString(Object objeto) {
		Date data = (Date) objeto;
		
		return dateFormat.format(data);
	}
	
	public Object converterParaObjeto(String valor) {
		Date data = null;
		try {
			data = dateFormat.parse(valor);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
