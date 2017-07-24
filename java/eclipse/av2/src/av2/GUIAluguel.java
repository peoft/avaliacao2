package av2;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;

public class GUIAluguel {

	private JFrame frmCadastroAluguel;
	private JTextField dataPedido;

	private JTextField dataEntrega;
	private JTextField dataDevolucao;
	private JTextField valorTotal;
	DefaultListModel<String> model;
	private JTable alugueis;
	private String motoristaSelecionado;
	private JScrollPane scrollAlugueis;
	private ListSelectionModel listSelectionModel;
	private int idAluguelSelecionado = 0;
	enum aluguelColumnHeader { ID, DataPedido, DataEntrega, DataDevolucao, ValorTotal };
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAluguel window = new GUIAluguel();
					window.frmCadastroAluguel.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIAluguel() {
		addMotoristas();
		initialize();
	}

	JFrame GetFrameAluguel() {
		return frmCadastroAluguel;
	}

	public void addMotoristas() {
		try {
			MotoristaDAO motoristaDAO = new MotoristaDAO();
			ArrayList<Motorista> motoristaList = motoristaDAO.recuperarTodos();
			if (motoristaList != null) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				model = new DefaultListModel<String>();
				for (Motorista motorista : motoristaList) {

					Pessoa pessoa = new Motorista(motorista.getId(), null, null, null, null, null);
					if (pessoaDAO.recuperar(pessoa) == true) {
						model.addElement(pessoa.getNome());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizaAlugueis(String nomeMotorista) {
//		try {
//			String[] columnNames = { aluguelColumnHeader.ID.toString(), aluguelColumnHeader.DataPedido.toString(), aluguelColumnHeader.DataEntrega.toString(), aluguelColumnHeader.DataDevolucao.toString(), aluguelColumnHeader.ValorTotal.toString() };
//	
//			PessoaDAO pessoaDAO = new PessoaDAO();
//			Motorista motorista = new Motorista(0, nomeMotorista, null, null, null, null);
//			Pessoa pessoa = motorista;
//			if (alugueis != null) {
//				DefaultTableModel dtm = (DefaultTableModel) alugueis.getModel();
//				if (dtm.getRowCount() > 0) {
//					dtm.setRowCount(0);
//				}
//			}
//			if (pessoaDAO.recuperarPeloNome(pessoa) == true) {
//				AluguelDAO aluguelDAO = new AluguelDAO();
//				ArrayList<Aluguel> alugueisList = aluguelDAO.recuperarAlugueis(pessoa);
//				if (alugueisList != null) {
//					Object[][] data = new Object[alugueisList.size()][5];
//					Object[] element = alugueisList.toArray();
//					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//					for (int i = 0; i < alugueisList.size(); i++) {
//						Aluguel aluguel = (Aluguel) element[i];
//						data[i][0] = String.valueOf(aluguel.getId());
//						data[i][1] = dateFormat.format(aluguel.getDataPedido().getTime());
//						data[i][2] = dateFormat.format(aluguel.getDataEntrega());
//						data[i][3] = dateFormat.format(aluguel.getDataDevolucao());
//						data[i][4] = aluguel.getValorTotal();
//					}
//			
//					DefaultTableModel model = new DefaultTableModel(data, columnNames);
//					alugueis = new JTable(model) {
//					     private static final long serialVersionUID = 1L;
//
//					        public boolean isCellEditable(int row, int column) {                
//					                return false;               
//					        };						
//					}; 					
//					
//					listSelectionModel = alugueis.getSelectionModel();
//			        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
//			        alugueis.setSelectionModel(listSelectionModel);
//					alugueis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
//					scrollAlugueis.setViewportView(alugueis);
//				} else {
//					idAluguelSelecionado = 0;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) { 
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
 
            boolean isAdjusting = e.getValueIsAdjusting(); 
 
            if (!isAdjusting) {
                if (!lsm.isSelectionEmpty()) {
                    // Find out which indexes are selected.
                    int minIndex = lsm.getMinSelectionIndex();
                    int maxIndex = lsm.getMaxSelectionIndex();
                    for (int i = minIndex; i <= maxIndex; i++) {
                        if (lsm.isSelectedIndex(i)) {
                        	// Atualizar campos de texto
                        	Object data = alugueis.getValueAt(i, aluguelColumnHeader.ID.ordinal());
                        	idAluguelSelecionado = Integer.valueOf(data.toString());
                        	System.out.println("ID = " + idAluguelSelecionado);
                        	data = alugueis.getValueAt(i, aluguelColumnHeader.DataDevolucao.ordinal());
                        	dataDevolucao.setText(data.toString());
                        	data = alugueis.getValueAt(i, aluguelColumnHeader.DataEntrega.ordinal());
                        	dataEntrega.setText(data.toString());
                        	data = alugueis.getValueAt(i, aluguelColumnHeader.DataPedido.ordinal());
                        	dataPedido.setText(data.toString());
                        	data = alugueis.getValueAt(i, aluguelColumnHeader.ValorTotal.ordinal());
                        	valorTotal.setText(data.toString());
                        }
                    }
                }            	
            }
        }
    }

	/**
	 * Clean fields from GUI.
	 */
	public void cleanFields() {
		dataDevolucao.setText("");
		dataEntrega.setText("");
		dataPedido.setText("");
		valorTotal.setText("");
		idAluguelSelecionado = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroAluguel = new JFrame();
		frmCadastroAluguel.setResizable(false);
		frmCadastroAluguel.setTitle("Cadastro Aluguel");
		frmCadastroAluguel.setBounds(100, 100, 507, 352);
		JList<String> motoristas = new JList<String>(model);

		JLabel lblMotorista = new JLabel("Selecione o Motorista:");

		JButton criar = new JButton("Criar");
		criar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				String nome = motoristas.getSelectedValue().toString();
//				PessoaDAO pessoaDAO = new PessoaDAO();
//				if (pessoaDAO != null) {
//					Pessoa motorista = new Motorista(0, nome, null, null, null, null);
//					if (pessoaDAO.recuperarPeloNome(motorista) == true) {
//						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//						Date dtEntrega, dtDeVolucao;
//						Calendar dtPedido = Calendar.getInstance();
//						try {
//							dtPedido.setTime(dateFormat.parse(dataPedido.getText()));
//							dtEntrega = dateFormat.parse(dataEntrega.getText());
//							dtDeVolucao = dateFormat.parse(dataDevolucao.getText());
//							BigDecimal vlTotal = new BigDecimal(valorTotal.getText());
//							Aluguel aluguel = new Aluguel(motorista.getId(), dtPedido, dtEntrega, dtDeVolucao, vlTotal);
//							if (aluguel != null) {
//								AluguelDAO aluguelDAO = new AluguelDAO();
//								if (aluguelDAO.criar(aluguel) == true) {
//									cleanFields();
//									atualizaAlugueis(motoristaSelecionado);
//								}
//							}
//						} catch (ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					}
//				}

			}
		});

		JButton atualizar = new JButton("Atualizar");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idAluguelSelecionado != 0) {
//					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//					Date dtEntrega, dtDeVolucao;
//					Calendar dtPedido = Calendar.getInstance();
//					try {
//						dtPedido.setTime(dateFormat.parse(dataPedido.getText()));
//						dtEntrega = dateFormat.parse(dataEntrega.getText());
//						dtDeVolucao = dateFormat.parse(dataDevolucao.getText());
//						BigDecimal vlTotal = new BigDecimal(valorTotal.getText());
//						Aluguel aluguel = new Aluguel(idAluguelSelecionado, dtPedido, dtEntrega, dtDeVolucao, vlTotal);
//						if (aluguel != null) {
//							AluguelDAO aluguelDAO = new AluguelDAO();
//							if (aluguelDAO.atualizar(aluguel) == true) {
//								atualizaAlugueis(motoristaSelecionado);								
//							}
//						}
//					} catch (ParseException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
			}
		});

		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idAluguelSelecionado != 0) {
//					try {
//						Aluguel aluguel = new Aluguel(idAluguelSelecionado, null, null, null, null);
//						if (aluguel != null) {
//							AluguelDAO aluguelDAO = new AluguelDAO();
//							if (aluguelDAO.deletar(aluguel) == true) {
//								cleanFields();
//								atualizaAlugueis(motoristaSelecionado);								
//							}
//						}
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
			}
		});

		JLabel lblDataPedido = new JLabel("Data Pedido:");

		JLabel lblDataEntrega = new JLabel("Data Entrega:");

		JLabel lblDataDevolucao = new JLabel("Data Devolu\u00E7\u00E3o:");

		JLabel lblValorTotal = new JLabel("Valor Total:");

		dataPedido = new JTextField();
		dataPedido.setColumns(10);

		dataEntrega = new JTextField();
		dataEntrega.setColumns(10);

		dataDevolucao = new JTextField();
		dataDevolucao.setColumns(10);

		valorTotal = new JTextField();
		valorTotal.setColumns(10);

		GUITextComponentLimit.addTo(dataPedido, 10);
		GUITextComponentLimit.addTo(dataDevolucao, 10);
		GUITextComponentLimit.addTo(dataEntrega, 10);
		GUITextComponentLimit.addTo(valorTotal, 12);

		JScrollPane scrollMotoristas = new JScrollPane();
		scrollMotoristas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMotoristas.setAutoscrolls(true);

		JLabel lblAluguis = new JLabel("Alugu\u00E9is:");

		scrollAlugueis = new JScrollPane();
		scrollAlugueis.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		GroupLayout groupLayout = new GroupLayout(frmCadastroAluguel.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblMotorista))
						.addGroup(groupLayout.createSequentialGroup().addGap(25).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblDataPedido).addComponent(dataPedido,
														GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(16)
														.addComponent(lblDataEntrega))
												.addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(
														dataEntrega, GroupLayout.PREFERRED_SIZE, 78,
														GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblDataDevolucao).addComponent(dataDevolucao,
														GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE))
										.addGap(17)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(valorTotal, GroupLayout.PREFERRED_SIZE, 97,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblValorTotal, GroupLayout.PREFERRED_SIZE, 74,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(72).addComponent(criar).addGap(29)
										.addComponent(atualizar).addGap(28).addComponent(deletar))))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblAluguis))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(scrollMotoristas, Alignment.LEADING).addComponent(scrollAlugueis,
												Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 459,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(32, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblMotorista)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollMotoristas, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblAluguis)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollAlugueis, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addGap(21)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(lblDataEntrega, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addComponent(lblDataDevolucao))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(dataPedido, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(dataEntrega, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(dataDevolucao, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addComponent(lblDataPedido)))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblValorTotal).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(valorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(deletar)
						.addComponent(criar).addComponent(atualizar))
				.addGap(28)));
		groupLayout.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { dataPedido, dataEntrega, dataDevolucao, valorTotal });
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { criar, atualizar, deletar });

		motoristas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					JList<String> source = (JList<String>) arg0.getSource();
					motoristaSelecionado = source.getSelectedValue().toString();
					cleanFields();
					atualizaAlugueis(motoristaSelecionado);
					System.out.println("Selecionado=" + motoristaSelecionado);
					
				}
			}
		});

		motoristas.setSelectedIndex(0);		

		scrollMotoristas.setViewportView(motoristas);
		frmCadastroAluguel.getContentPane().setLayout(groupLayout);
		frmCadastroAluguel.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { dataPedido, dataEntrega, dataDevolucao, valorTotal, criar, atualizar, deletar }));
		frmCadastroAluguel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { motoristas, dataPedido,
				dataEntrega, dataDevolucao, valorTotal, criar, atualizar, deletar }));
	}
}
