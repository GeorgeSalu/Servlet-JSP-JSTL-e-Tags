package br.edu.olamundo.converte.dto;

import java.io.Serializable;
import java.util.Date;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = -7673950932119924560L;

	private String nome;

	private String endereco;

	private Long cpf;

	private Date dtNasc;

	private Date dtExpedicao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Date getDtExpedicao() {
		return dtExpedicao;
	}

	public void setDtExpedicao(Date dtExpedicao) {
		this.dtExpedicao = dtExpedicao;
	}

}
