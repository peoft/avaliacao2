package av2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.ButtonGroup;

public class GUIMotorista {

	private JFrame frmCadastroMotorista;
	private JTextField nome;
	private JTextField dataNascimento;
	private JTextField cpf;
	private JTextField numeroCNH;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton masculino = null;
	JRadioButton feminino = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMotorista window = new GUIMotorista();
					window.frmCadastroMotorista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMotorista() {
		initialize();
	}
	
	/**
	 * Clean fields from GUI.
	 */
	
	public void cleanFields() {
		numeroCNH.setText("");
		nome.setText("");
		dataNascimento.setText("");		
		buttonGroup.clearSelection();
		cpf.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroMotorista = new JFrame();
		frmCadastroMotorista.setResizable(false);
		frmCadastroMotorista.setTitle("Cadastro Motorista");
		frmCadastroMotorista.setBounds(100, 100, 536, 188);
		JRadioButton masculino = new JRadioButton("M");
		buttonGroup.add(masculino);
		
		JRadioButton feminino = new JRadioButton("F");
		buttonGroup.add(feminino);
		
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				if (pessoaDAO != null) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date date;
					try {
						SEXO sexo = null;
						date = dateFormat.parse(dataNascimento.getText());
						if (masculino.isSelected()) {
							sexo = SEXO.Masculino;
						} else if (feminino.isSelected()) {
							sexo = SEXO.Feminino;
						}
						Motorista motorista = new Motorista(0, nome.getText().length() > 0 ? nome.getText() : null, date, cpf.getText().length() > 0 ? cpf.getText() : null, sexo, numeroCNH.getText().length() > 0 ? numeroCNH.getText() : null);						
						if (motorista != null) {
							Pessoa pessoa = (Pessoa) motorista;
							if (pessoaDAO.criar(pessoa) == true) {
								if (pessoaDAO.recuperarPeloCPF(pessoa) == true) {
									MotoristaDAO motoristaDAO = new MotoristaDAO();
									if (motoristaDAO != null) {
										motorista.setId(pessoa.getId());
										if (motoristaDAO.criar(motorista) == true) {
											cleanFields();
										} else {
											pessoaDAO.deletar(pessoa);
										}
									}																		
								}								
							}							
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}				
			}
		});
		
		JButton btnRecuperar = new JButton("Recuperar");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MotoristaDAO motoristaDAO = new MotoristaDAO();					
					if (motoristaDAO != null) {
						Motorista motorista = new Motorista(0, null, null, null, null, numeroCNH.getText());
						if (motoristaDAO.recuperar(motorista) == true) {
							PessoaDAO pessoaDAO = new PessoaDAO();
							System.out.println("Motorista encontrado!");
							System.out.println("Id="+motorista.getId());
							if (pessoaDAO != null) {
								Pessoa pessoa = motorista;
								if (pessoaDAO.recuperar(pessoa) == true) {
									nome.setText(pessoa.getNome());
									SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
									dataNascimento.setText(dateFormat.format(pessoa.getDataNascimento()));
									if (pessoa.getSexo() == SEXO.Masculino) {
										masculino.setSelected(true);
									} else {
										feminino.setSelected(true);										
									}
									cpf.setText(pessoa.getCpf());
								}
							}
							
						} else {
							System.out.println("Motorista nao encontrado!");
						}
					}					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotoristaDAO motoristaDAO = new MotoristaDAO();
				if (motoristaDAO != null) {
					try {					
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date date;
						SEXO sexo;
						date = dateFormat.parse(dataNascimento.getText());
						if (masculino.isSelected()) {
							sexo = SEXO.Masculino;
						} else {
							sexo = SEXO.Feminino;
						}
						Motorista motorista = new Motorista(0, nome.getText().length() > 0 ? nome.getText() : null, date, cpf.getText().length() > 0 ? cpf.getText() : null, sexo, numeroCNH.getText().length() > 0 ? numeroCNH.getText() : null);
						if (motorista != null) {
							if (motoristaDAO.recuperar(motorista) == true) {
								PessoaDAO pessoaDAO = new PessoaDAO();
								if (pessoaDAO != null) {
									Pessoa pessoa = (Pessoa) motorista;
									pessoaDAO.atualizar(pessoa);
								}
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MotoristaDAO motoristaDAO = new MotoristaDAO();
				if (motoristaDAO != null) {
					try {						
						Motorista motorista = new Motorista(0, null, null, null, null, numeroCNH.getText());
						if (motorista != null) {
							if (motoristaDAO.recuperar(motorista) == true) {
								PessoaDAO pessoaDAO = new PessoaDAO();
								if (pessoaDAO != null) {
									Pessoa pessoa = (Pessoa) motorista;
									if (pessoaDAO.deletar(pessoa) == true) {
										cleanFields();
									}									
								}
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JLabel labelNome = new JLabel("Nome:");
		
		nome = new JTextField();
		nome.setColumns(10);
		
		JLabel labelSexo = new JLabel("Sexo:");
		
		JLabel labelDataNascimento = new JLabel("Data Nascimento:");
		
		dataNascimento = new JTextField();
		dataNascimento.setColumns(10);
		
		JLabel labelCPF = new JLabel("CPF:");
		
		cpf = new JTextField();
		cpf.setColumns(10);
		
		JLabel lblNumeroCnh = new JLabel("N\u00FAmero CNH:");
		
		numeroCNH = new JTextField();
		numeroCNH.setColumns(10);
		
		
		GUITextComponentLimit.addTo(numeroCNH, 11);
		GUITextComponentLimit.addTo(nome, 50);
		GUITextComponentLimit.addTo(dataNascimento, 10);
		GUITextComponentLimit.addTo(cpf, 11);

		
		JButton btnAluguel = new JButton("Aluguel");
		btnAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIAluguel window = new GUIAluguel();
				window.GetFrameAluguel().setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCadastroMotorista.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAluguel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCriar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRecuperar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAtualizar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeletar)
					.addContainerGap(421, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelSexo)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(masculino)
									.addGap(2)
									.addComponent(feminino)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nome, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelNome)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumeroCnh)
								.addComponent(numeroCNH, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(labelDataNascimento)
									.addGap(41)
									.addComponent(labelCPF))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cpf, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
					.addGap(50))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNumeroCnh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numeroCNH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelDataNascimento)
								.addComponent(labelCPF))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(labelSexo)
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(masculino)
								.addComponent(feminino)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(labelNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeletar)
						.addComponent(btnAtualizar)
						.addComponent(btnRecuperar)
						.addComponent(btnCriar)
						.addComponent(btnAluguel))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnCriar, btnRecuperar, btnAtualizar, btnDeletar, btnAluguel});
		frmCadastroMotorista.getContentPane().setLayout(groupLayout);
		frmCadastroMotorista.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{numeroCNH, dataNascimento, cpf, masculino, feminino, nome, btnAluguel, btnCriar, btnRecuperar, btnAtualizar, btnDeletar}));
	}
}
