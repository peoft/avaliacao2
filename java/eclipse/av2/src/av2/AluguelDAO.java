package av2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AluguelDAO implements IAluguelDAO {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection("jdbc:mysql://localhost:3306/av2", "root", "root");
			conn.setAutoCommit(false);
		} catch (SQLException ex) {
			Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return conn;
	}

	@Override
	public boolean criar(Aluguel aluguel) {
		boolean ret = false;
		Connection connection = null;
		PreparedStatement ptmt = null;
		// TODO Auto-generated method stub
		try {
			String queryString = "INSERT INTO Aluguel(pessoa_id, dataPedido, dataEntrega, dataDevolucao, valorTotal) VALUES(?,?,?,?,?)";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, aluguel.getId());
			ptmt.setDate(2, new java.sql.Date(aluguel.getDataPedido().getTimeInMillis()));
			ptmt.setDate(3, new java.sql.Date(aluguel.getDataEntrega().getTime()));
			ptmt.setDate(4, new java.sql.Date(aluguel.getDataDevolucao().getTime()));
			ptmt.setBigDecimal(5, aluguel.getValorTotal());
			ptmt.executeUpdate();
			connection.commit();
			System.out.println("Registro inserido na tabela aluguel!");
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
	public boolean recuperar(Aluguel aluguel) {
		// TODO Auto-generated method stub
		boolean ret = false;
		String queryString = "SELECT pessoa_id, dataPedido, dataEntrega, dataDevolucao, valorTotal FROM aluguel where id = ?";
		try (Connection connection = getConnection();
				PreparedStatement ptmt = connection.prepareStatement(queryString);) {
			ptmt.setInt(1, aluguel.getId());
			try (ResultSet resultSet = ptmt.executeQuery()) {
				while (resultSet.next()) {
					aluguel.setId(resultSet.getInt("pessoa_id"));
					Calendar dataPedido;
					dataPedido = Calendar.getInstance();
					dataPedido.setTime(resultSet.getDate("dataPedido"));
					aluguel.setDataPedido(dataPedido);
					aluguel.setDataEntrega(new java.util.Date(resultSet.getDate("dataEntrega").getTime()));
					aluguel.setDataDevolucao(new java.util.Date(resultSet.getDate("dataDevolucao").getTime()));
					aluguel.setValorTotal(resultSet.getBigDecimal("valorTotal"));
					ret = true;
				}
			} catch (SQLTimeoutException e) {
				System.out.println("Erro ao recuperar dados do aluguel = " + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Erro ao recuperar dados do aluguel = " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao recuperar dados do aluguel = " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar dados aluguel = " + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	public ArrayList<Aluguel> recuperarAlugueis(Pessoa pessoa) {
		// TODO Auto-generated method stub
		ArrayList<Aluguel> alugueis = null;
		String queryString = "SELECT id, dataPedido, dataEntrega, dataDevolucao, valorTotal FROM aluguel where pessoa_id = ?";
		try (Connection connection = getConnection();
				PreparedStatement ptmt = connection.prepareStatement(queryString);) {
			ptmt.setInt(1, pessoa.getId());
			try (ResultSet resultSet = ptmt.executeQuery()) {
				resultSet.last();
				if (resultSet.getRow() > 0) {
					alugueis = new ArrayList<Aluguel>();
					resultSet.beforeFirst();
				}

				while (resultSet.next()) {
					Aluguel aluguel = new Aluguel(resultSet.getInt("id"), null,
							new java.util.Date(resultSet.getDate("dataEntrega").getTime()),
							new java.util.Date(resultSet.getDate("dataDevolucao").getTime()),
							resultSet.getBigDecimal("valorTotal"));
					Calendar dataPedido;
					dataPedido = Calendar.getInstance();
					dataPedido.setTime(resultSet.getDate("dataPedido"));
					aluguel.setDataPedido(dataPedido);
					alugueis.add(aluguel);
				}
			} catch (SQLTimeoutException e) {
				System.out.println("Erro ao recuperar dados do aluguel = " + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Erro ao recuperar dados do aluguel = " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao recuperar dados do aluguel = " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Erro ao recuperar dados aluguel = " + e.getMessage());
			e.printStackTrace();
		}
		return alugueis;
	}

	@Override
	public boolean atualizar(Aluguel aluguel) {
		// TODO Auto-generated method stub
		boolean ret = false;
		String queryString = "UPDATE aluguel SET dataPedido=?, dataEntrega=?, dataDevolucao=?, valorTotal=?"
							+ "WHERE id=?";
				
		Connection connection = null;
		connection = getConnection();
		if (connection != null ) {
			try (
					PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {			
				ptmt.setDate(1, new java.sql.Date(aluguel.getDataPedido().getTimeInMillis()));
				ptmt.setDate(2, new java.sql.Date(aluguel.getDataEntrega().getTime()));
				ptmt.setDate(3, new java.sql.Date(aluguel.getDataDevolucao().getTime()));
				ptmt.setBigDecimal(4, aluguel.getValorTotal());
				ptmt.setInt(5, aluguel.getId());
				ptmt.executeUpdate();
				connection.commit();
				ret = true;
				System.out.println("Tabela atualizada com sucesso!");
			} catch (SQLException e) {
				System.out.println("Erro ao atualizar os dados do aluguel = " + e.getMessage());
				e.printStackTrace();
				if (connection != null) {
					try {
						connection.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Erro ao realizar rollback = " + e1.getMessage());						
						e1.printStackTrace();
					}
				}
			} finally { 
				try { 
					if (connection != null) {
						connection.close();						
					}											 
				} 
				catch (SQLException e) {
					System.out.println("Erro ao fechar conexao = " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return ret;
		
	}

	@Override
	public boolean deletar(Aluguel aluguel) {
		// TODO Auto-generated method stub
		boolean ret = false;
		Connection connection = null;		
		connection = getConnection();
		if (connection != null ) {
			String queryString = "DELETE FROM aluguel WHERE id=?";
			try (
					PreparedStatement ptmt = connection.prepareStatement(queryString);
			) {
				ptmt.setInt(1, aluguel.getId()); 
				ptmt.executeUpdate();
				connection.commit();
				System.out.println("Registro removido com sucesso!");
				ret = true;
			} catch (SQLException e) {
				try {
					if (connection != null) {
						connection.rollback();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Erro ao realizar rollback = " + e1.getMessage());
					e1.printStackTrace();
				}
			} finally { 
				try { 
					if (connection != null) {
						connection.close();						
					}											 
				} 
				catch (SQLException e) {
					System.out.println("Erro ao fechar conexao = " + e.getMessage());
					e.printStackTrace();
				}
			}
			
		}
		return ret;
	}

	public static void main(String[] args) {
		Connection connection;
		AluguelDAO f = new AluguelDAO();
		connection = f.getConnection();
		if (connection != null) {
			System.out.print("Conectou!!!");
		}
	}
}
