package br.edu.alomundo.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import br.edu.alomundo.comum.MensagemContantes;
import br.edu.alomundo.exception.ValidationException;

public class DataValidator implements Validator {

	public boolean validar(Map<String, Object> valores) throws ValidationException {
		String msgErro = "";
		for (String key : valores.keySet()) {
			String data = (String) valores.get(key);
			try {
				new SimpleDateFormat("dd/MM/yyyy").parse(data);
			} catch (ParseException e) {
				msgErro += MensagemContantes.MSG_ERR_DATA_VALIDATOR.replace("?", key).concat("<br/>");
			}
		}
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}
		
		return true;
	}
	
}
