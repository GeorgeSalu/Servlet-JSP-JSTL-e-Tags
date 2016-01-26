package br.edu.alomundo.validator;

import br.edu.alomundo.exception.ValidationException;

public interface Validator {
	
	public boolean validar(Object objeto) throws ValidationException;

}
