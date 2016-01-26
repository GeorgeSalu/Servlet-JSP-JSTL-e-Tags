package br.edu.alomundo.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.edu.alomundo.comum.MensagemContantes;
import br.edu.alomundo.exception.ValidationException;

public class DataValidator implements Validator {

	public boolean validar(Object objeto) throws ValidationException {
		String data = (String) objeto;
		try {
			new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			throw new ValidationException(MensagemContantes.MSG_ERR_DATA_VALIDATOR);
		}
		return true;
	}
	
}
