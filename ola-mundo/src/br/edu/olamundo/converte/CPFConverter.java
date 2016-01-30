package br.edu.olamundo.converte;

import br.edu.alomundo.util.Util;

public class CPFConverter {

	public String converter(Object objeto) {
		String cpf = (String) objeto;
		
		return Util.imprimeCPF(cpf);
	}
	
}
