package br.com.devmos.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.devmos.escola.dominio.aluno.Aluno;
import br.com.devmos.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.devmos.escola.dominio.aluno.CPF;
import br.com.devmos.escola.dominio.aluno.Email;
import br.com.devmos.escola.dominio.aluno.RepositorioAlunos;
import br.com.devmos.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunosComJDBC implements RepositorioAlunos {
	
	private final Connection connection;
	
	public RepositorioDeAlunosComJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {
		StringBuilder sb = new StringBuilder();

		try {
			
			sb.append("INSER INTO ALUNO ")
				.append("VALUES(?,?,?)");
			
			PreparedStatement ps = connection.prepareStatement(sb.toString());
			
			ps.setString(1, aluno.getCpf().getNumero());
			ps.setString(1, aluno.getNome());
			ps.setString(1, aluno.getEmail().getEndereco());
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());
			
			ResultSet rs = ps.executeQuery();
			
			boolean encontrou = rs.next();
			
			if(!encontrou) {
				throw new AlunoNaoEncontrado(cpf);
			}
			
			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Aluno aluno = new Aluno(cpf, nome, email);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				aluno.adicionarTelefone(new Telefone(ddd, numero));

			}
			
			return aluno;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Aluno> listarTodosAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

}
