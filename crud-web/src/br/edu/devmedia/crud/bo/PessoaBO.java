package br.edu.devmedia.crud.bo;

import java.util.HashMap;
import java.util.Map;

import br.edu.devmedia.crud.dto.CidadeDTO;
import br.edu.devmedia.crud.dto.PessoaDTO;
import br.edu.devmedia.crud.exception.NegocioException;
import br.edu.devmedia.crud.util.MensagemContantes;
import br.edu.devmedia.crud.validator.CPFValidator;
import br.edu.devmedia.crud.validator.DataValidator;

/**
 * Classe responsável por gerenciar os métodos de negócio da pessoa
 * 
 * @author George
 * 
 */
public class PessoaBO {

	/**
	 * Método resposável por validar a pessoa
	 * 
	 * @param request
	 * @return
	 * @throws NegocioException 
	 */
	public boolean validarUsuario(PessoaDTO pessoaDTO) throws NegocioException {
		boolean isValido = true;
		try {
			if (pessoaDTO.getNome() == null || "".equals(pessoaDTO.getNome())) {
				throw new NegocioException("Campo Nome obrigatório!");
			}
			
			// Valida campos obg
			Map<String, Object> valores = new HashMap<>();
			valores.put("CPF", pessoaDTO.getCpf());
			if (new CPFValidator().validar(valores)) {
				isValido = true;
			}
			
			valores = new HashMap<>();
			valores.put("Data Nascimento", pessoaDTO.getDtNasc());
			if (new DataValidator().validar(valores)) {
				isValido = true;
			}
			
			if (pessoaDTO.getSexo() == ' ') {
				throw new NegocioException("Campo Sexo obrigatório!");
			}
			
			CidadeDTO cidade = pessoaDTO.getEndereco().getCidade();
			if (cidade.getUf().getIdUF() == null) {
				throw new NegocioException("Campo Estado obrigatório!");
			}
			
			if (cidade.getIdCidade() == null) {
				throw new NegocioException("Campo Cidade obrigatório!");
			}
			
			if (pessoaDTO.getEndereco().getLogradouro() == null || "".equals(pessoaDTO.getEndereco().getLogradouro())) {
				throw new NegocioException("Campo Logradouro obrigatório!");
			}
			
			if (!isValido) {
				throw new NegocioException(MensagemContantes.MSG_ERR_PESSOA_DADOS_INVALIDOS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return isValido;
	}

}
