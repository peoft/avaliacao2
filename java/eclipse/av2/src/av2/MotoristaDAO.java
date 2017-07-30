package av2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
	
public class MotoristaDAO implements IMotoristaDAO {

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
	public boolean criar(Motorista motorista) {
		boolean ret = false;
		Connection connection = null;
		PreparedStatement ptmt = null;
		// TODO Auto-generated method stub
		try {			
			String queryString = "INSERT INTO Motorista(pessoa_id, numeroCNH) VALUES(?,?)";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, motorista.getId());
			ptmt.setString(2, motorista.getNumeroCNH());
			System.out.println("Motorista - id = " + motorista.getId());
			ptmt.executeUpdate();
			connection.commit();
			System.out.println("Registro inserido na tabela motorista!");
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
	public boolean recuperar(Motorista motorista) {		
		// TODO Auto-generated method stub
		boolean ret = false;
		String queryString = "SELECT pessoa_id FROM motorista where numeroCNH = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setString(1, motorista.getNumeroCNH());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("Id" + resultSet.getInt("pessoa_id"));
					motorista.setId(resultSet.getInt("pessoa_id"));
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
	
	public boolean recuperarPeloId(Motorista motorista) {
		boolean ret = false;
		String queryString = "SELECT * FROM motorista where pessoa_id = ?";
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			ptmt.setInt(1, motorista.getId());
			try (ResultSet resultSet = ptmt.executeQuery()){			
				while (resultSet.next()) {
					System.out.println("Id" + resultSet.getInt("pessoa_id"));
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
	
	public ArrayList<Motorista> recuperarTodos() {		
		// TODO Auto-generated method stub
	String queryString = "SELECT pessoa_id FROM motorista";
		ArrayList<Motorista> todos = null;
		try (
			Connection connection = getConnection();
			PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
			try (ResultSet resultSet = ptmt.executeQuery()){
				resultSet.last();
				if (resultSet.getRow()> 0) {
					todos = new ArrayList<Motorista> ();
					resultSet.beforeFirst();					
				}
				while (resultSet.next()) {
					Motorista motorista = new Motorista(resultSet.getInt("pessoa_id"), null, null, null, null, null);
					System.out.println("Id" + resultSet.getInt("pessoa_id"));
					todos.add(motorista);					
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
		return todos;
	}


	@Override
	public boolean atualizar(Motorista motorista) {
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
	public boolean deletar(Motorista motorista) {
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
		MotoristaDAO f = new MotoristaDAO();
		connection = f.getConnection();
		if (connection != null) {
			System.out.print("Conectou!!!");
		}
	}

}
