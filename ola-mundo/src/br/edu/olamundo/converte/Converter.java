package br.edu.olamundo.converte;

public interface Converter {

	public String converterParaString(Object objeto);
	
	public Object converterParaObjeto(String valor);
	
}
