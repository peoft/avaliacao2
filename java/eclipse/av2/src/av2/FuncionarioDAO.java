package av2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
	
public class FuncionarioDAO implements IFuncionarioDAO {

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
	public boolean criar(Funcionario funcionario) {
		boolean ret = false;
		Connection connection = null;
		PreparedStatement ptmt = null;
		// TODO Auto-generated method stub
		try {			
			String queryString = "INSERT INTO Funcionario(pessoa_id, matricula) VALUES(?,?)";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, funcionario.getId());
			ptmt.setString(2, funcionario.getMatricula());
			System.out.println("Funcionaio - id = " + funcionario.getId());
			ptmt.executeUpdate();
			connection.commit();
			System.out.println("Registro inserido na tabela funcionario!");
			ret = true;
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar =" + e.getMessage());
			e.printStackTrace();
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	@Override
	public boolean recuperar(Funcionario funcionario) {		
		// TODO Auto-generated method stub
		boolean ret = false;
		String queryString = "SELECT pessoa_id FROM funcionario where matricula = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setString(1, funcionario.getMatricula());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("Id" + resultSet.getInt("pessoa_id"));
					funcionario.setId(resultSet.getInt("pessoa_id"));
					ret = true;
				}				
			} catch (SQLTimeoutException e) {
				System.out.println("Erro ao recuperar dados do funcionario = " + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Erro ao recuperar dados do funcionario = " + e.getMessage());
				e.printStackTrace();				
			}				
		} catch (SQLException e) {
			System.out.println("Erro ao recuperar dados do funcionario = " + e.getMessage());
			e.printStackTrace();			
		} catch (Exception e) {
			System.out.println("Erro ao recuperar dados funcionario = " + e.getMessage());
			e.printStackTrace();			
		}
		return ret;
	}

	@Override
	public boolean atualizar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		boolean ret = false;
/*		try {
			String queryString = "UPDATE student SET Name=? WHERE RollNo=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, student.getName());
			ptmt.setInt(2, student.getRollNo());
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
			} catch (Exception e) {
			}
		}*/
		return ret;
		
	}

	@Override
	public boolean deletar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		boolean ret = false;
/*		try {
			String queryString = "DELETE FROM student WHERE RollNo=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, rollNo);
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			} catch (Exception e) {
			}

		}
		
	*/	
		return ret;
	}
	public static void main(String[] args) {
		Connection connection;
		FuncionarioDAO f = new FuncionarioDAO();
		connection = f.getConnection();
		if (connection != null) {
			System.out.print("Conectou!!!");
		}
	}
}
