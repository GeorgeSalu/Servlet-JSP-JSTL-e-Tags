package br.edu.devmedia.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.exception.NegocioException;

/**
 * Interface para o padrão Command
 * 
 * @author George
 * 
 */
public interface Command {

	/**
	 * Método de execução do comando
	 * 
	 * @param request
	 * @return
	 * @throws NegocioException
	 */
	public String execute(HttpServletRequest request);

}
