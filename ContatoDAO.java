package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import br.com.agenda.factory.Conexao;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	public void save(Contato contato) {

		String sql = "INSERT INTO contatos (nome, idade, data_do_cadastro) VALUES (?, ?, ?)";

		try {
			Connection conexao = Conexao.getConexao();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			pstm.execute();

			pstm.close();
			conexao.close();

			System.out.println("\nContato salvo com sucesso\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Contato contato) {
		
		
		String sql = "UPDATE contatos SET nome = ?, idade = ? WHERE id = ?";
		
		try {
			Connection conexao = Conexao.getConexao();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());			
			pstm.setInt(3, contato.getId());
			pstm.execute();
			
			System.out.println("\nContato alterado com sucesso");
			
			pstm.close();
			conexao.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

	public List<Contato> getContatos () {	

		String sql = "SELECT * FROM contatos";

		List<Contato> contatos = new ArrayList<>();	

		try {

			Connection conexao = Conexao.getConexao();

			PreparedStatement pstm = conexao.prepareStatement(sql);
			ResultSet rset = pstm.executeQuery(sql);

			while (rset.next()) {
				Contato contato = new Contato();
				contato.setId(rset.getInt("ID"));
				contato.setNome(rset.getString("NOME"));
				contato.setIdade(rset.getInt("IDADE"));
				contato.setDataCadastro(rset.getDate("DATA_DO_CADASTRO"));
				
				contatos.add(contato);					
			}		
				System.out.println("\nLISTA DE CONTATOS SALVOS\n");
				System.out.printf("%s%7s%28s%19s%n", "ID", "NOME", "IDADE", "DATA DO CADASTRO");
				for (Contato c : contatos) {
				System.out.println(c.getId() + "    " + c.getNome() + "\t" +  c.getIdade() +"\t" + c.getDataCadastro());
			}
			
			rset.close();
			pstm.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return contatos;
  }

	public void remover (Contato contato) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		
		try {
			Connection conexao = Conexao.getConexao();
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, contato.getId());
			pstm.execute();
			
			System.out.println("\nCONTATO REMOVIDO COM SUCESSO");
			
			pstm.close();
			conexao.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		
	
}
