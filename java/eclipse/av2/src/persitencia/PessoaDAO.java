package persitencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

import av2.ConnectionFactory;
import av2.Pessoa;
import enums.Sexo;

public class PessoaDAO implements IPessaoDAO {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().getConnection("jdbc:mysql://localhost:3306/av2","root","root");
            conn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
	}

	@Override
	public boolean criar(Pessoa pessoa) {
		boolean ret = false;
		Connection connection = null;
		// TODO Auto-generated method stub
		if (pessoa.getSexo() == null) {
			System.out.println("Sexo não selecionado!");
			return ret;
		}
		try {
			connection = getConnection();
			String queryString = "INSERT INTO Pessoa(id, nome, dataNascimento, cpf, sexo) VALUES(?,?,?,?,?)";
			try (PreparedStatement ptmt = connection.prepareStatement(queryString)) {				
				ptmt.setInt(1, pessoa.getId());
				ptmt.setString(2, pessoa.getNome());
				ptmt.setDate(3,  new java.sql.Date(pessoa.getDataNascimento().getTime()));
				ptmt.setString(4, pessoa.getCpf());
				ptmt.setString(5, pessoa.getSexo().toString());
				ptmt.executeUpdate();
			}
			connection.commit();
			ret = true;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar =" + e.getMessage());
			e.printStackTrace();
			if (connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	@Override
	public boolean recuperar(Pessoa pessoa) {
		boolean ret = false;
		String queryString = "SELECT * FROM pessoa where id = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setInt(1, pessoa.getId());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("id=" + resultSet.getInt("id"));
					System.out.println("dataNascimento=" + resultSet.getDate("dataNascimento"));
					System.out.println("nome=" + resultSet.getString("nome"));
					System.out.println("sexo=" + resultSet.getString("sexo"));
					System.out.println("cpf=" + resultSet.getString("cpf"));
					pessoa.setCpf(resultSet.getString("cpf"));
										
					pessoa.setDataNascimento(new java.util.Date(resultSet.getDate("dataNascimento").getTime()));
					pessoa.setNome(resultSet.getString("nome"));
					String sexo;
					sexo = resultSet.getString("sexo");
					if (sexo.equalsIgnoreCase("Masculino")) {
						pessoa.setSexo(Sexo.Masculino);
					} else {
						pessoa.setSexo(Sexo.Feminino);
					}
				}				
				ret = true;
			} catch (SQLTimeoutException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;		
	}
	
	public boolean recuperarPeloNome(Pessoa pessoa) {		
		// TODO Auto-generated method stub
		boolean ret = false;
		String queryString = "SELECT id FROM pessoa where nome = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setString(1, pessoa.getNome());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("Id" + resultSet.getInt("id"));
					pessoa.setId(resultSet.getInt("id"));
					ret = true;
				}				
			} catch (SQLTimeoutException e) {
				System.out.println("Erro ao recuperar dados do motorista = " + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Erro ao recuperar dados do motorista = " + e.getMessage());
				e.printStackTrace();				
			}				
		} catch (SQLException e) {
			System.out.println("Erro ao recuperar dados do motorista = " + e.getMessage());
			e.printStackTrace();			
		} catch (Exception e) {
			System.out.println("Erro ao recuperar dados motorista = " + e.getMessage());
			e.printStackTrace();			
		}
		return ret;
	}

	@Override
	public boolean atualizar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		boolean ret = false;
		Connection connection = null;
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String queryString = "UPDATE Pessoa SET nome=?, dataNascimento=?, cpf=?, sexo=? WHERE id=?";
			try (PreparedStatement ptmt = connection.prepareStatement(queryString)) {				
				ptmt.setString(1, pessoa.getNome());
				ptmt.setDate(2, new java.sql.Date(pessoa.getDataNascimento().getTime()));
				ptmt.setString(3, pessoa.getCpf());
				ptmt.setString(4, pessoa.getSexo().toString());
				ptmt.setInt(5, pessoa.getId());
				ptmt.executeUpdate();
			}
			connection.commit();
			System.out.println("Registro da tabela atualizado!");
			ret = true;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar =" + e.getMessage());
			e.printStackTrace();
			if (connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;

		
	}

	@Override
	public boolean deletar(Pessoa pessoa) {
		// TODO Auto-generated method stub
		boolean ret = false;
		Connection connection = null;
		// TODO Auto-generated method stub
		try {
			connection = getConnection();
			String queryString = "DELETE FROM Pessoa WHERE id = ?";
			try (PreparedStatement ptmt = connection.prepareStatement(queryString)) {				
				ptmt.setInt(1, pessoa.getId());
				ptmt.executeUpdate();				
			} catch (SQLException e) {
				System.out.println("Erro ao remover =" + e.getMessage());
				e.printStackTrace();
			}
			connection.commit();
			System.out.println("Registro removido da tabela!");
			ret = true;
		} catch (SQLException e) {
			System.out.println("Erro ao remover =" + e.getMessage());
			e.printStackTrace();
			if (connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
		
	}
	
	public static void main(String[] args) {
		Connection connection;
		PessoaDAO p = new PessoaDAO();
		connection = p.getConnection();
		if (connection != null) {
			System.out.print("Conectou!!!");
		}
	}

	@Override
	public boolean recuperarPeloCPF(Pessoa pessoa) {
		// TODO Auto-generated method stub
		boolean ret = false;
		String queryString = "SELECT id FROM pessoa where cpf = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setString(1, pessoa.getCpf());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("id " + resultSet.getInt("id"));
					pessoa.setId(resultSet.getInt("id"));
					ret = true;
				}				
			} catch (SQLTimeoutException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;		
	}

}
