package br.edu.alomundo.validator;

import java.util.Map;

import br.edu.alomundo.comum.MensagemContantes;
import br.edu.alomundo.exception.ValidationException;

public class CPFValidator implements Validator {

	@Override
	public boolean validar(Map<String, Object> valores) throws ValidationException {
		String msgErro = "";
		for (String key : valores.keySet()) {
			String cpf = (String) valores.get(key);

			if (!"".equals(cpf)) {
				if (cpf.length() != 11) {				
					msgErro += MensagemContantes.MSG_ERR_CAMPO_INVALIDO.replace("?", key).concat("<br/>");
				}
				if (cpf.length() < 11) {
					msgErro += MensagemContantes.MSG_ERR_CAMPO_CPF_MENOR_RECOMENDADO.replace("?", key).concat("<br/>");
				}
				if (cpf.length() > 11) {				
					msgErro += MensagemContantes.MSG_ERR_CAMPO_CPF_MAIOR_RECOMENDADO.replace("?", key).concat("<br/>");
				}
			}
		}
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}

		return true;
	}

}
