package br.edu.devmedia.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.crud.dto.UfDTO;
import br.edu.devmedia.crud.exception.PersistenciaException;
import br.edu.devmedia.crud.util.ConexaoUtil;


/**
 * Classe DAO de acesso a dados referentes aos cadastros da aplicação
 * 
 * @author George
 * 
 */
public class CadastroDAO {

	/**
	 * Método que retorna a lista de UF's
	 * 
	 * @return
	 * @throws PersistenciaException
	 */
	public List<UfDTO> listarUFs() throws PersistenciaException {
		List<UfDTO> lista = new ArrayList<>();
		try {
			Connection conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_UF");
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UfDTO ufDTO = new UfDTO();
				ufDTO.setIdUF(resultSet.getInt(1));
				ufDTO.setDescricao(resultSet.getString(3));
				
				lista.add(ufDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		}
		return lista;
	}
	
}
