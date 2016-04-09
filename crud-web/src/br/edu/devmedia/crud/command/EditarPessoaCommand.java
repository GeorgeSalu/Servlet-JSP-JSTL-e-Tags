package br.edu.devmedia.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.edu.devmedia.crud.bo.PessoaBO;
import br.edu.devmedia.crud.dto.PessoaDTO;
import br.edu.devmedia.crud.exception.NegocioException;

public class EditarPessoaCommand implements Command {

	private String proximo;
	
	private PessoaBO pessoaBO;

	public String execute(HttpServletRequest request) {
		proximo = "edicaoPessoa.jsp";
		this.pessoaBO = new PessoaBO();
		
		try {
			Integer idPessoa = Integer.parseInt(request.getParameter("id_pessoa"));
			PessoaDTO pessoa = pessoaBO.consultarPessoaPorId(idPessoa);
			request.setAttribute("pessoa", pessoa);
		} catch (NegocioException e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
	}

}
