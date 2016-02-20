package br.edu.devmedia.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.exception.NegocioException;

/**
 * Interface para o padr�o Command
 * 
 * @author George
 * 
 */
public interface Command {

	/**
	 * M�todo de execu��o do comando
	 * 
	 * @param request
	 * @return
	 * @throws NegocioException
	 */
	public String execute(HttpServletRequest request);

}
