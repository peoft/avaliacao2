package av2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class GUIFuncionario {

	private JFrame frmCadastroFuncionario;
	private JTextField nome;
	private JTextField dataNascimento;
	private JTextField cpf;
	private JTextField matricula;
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
					GUIFuncionario window = new GUIFuncionario();
					window.frmCadastroFuncionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIFuncionario() {
		initialize();
	}
	
	/**
	 * Clean fields from GUI.
	 */
	
	public void cleanFields() {
		matricula.setText("");
		nome.setText("");
		dataNascimento.setText("");		
		buttonGroup.clearSelection();
		cpf.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		masculino = new JRadioButton("M");
		buttonGroup.add(masculino);;
		frmCadastroFuncionario = new JFrame();
		frmCadastroFuncionario.setResizable(false);
		frmCadastroFuncionario.setTitle("Cadastro Funcion\u00E1rio");
		frmCadastroFuncionario.setBounds(100, 100, 561, 216);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						Funcionario funcionario = new Funcionario(0, nome.getText().length() > 0 ? nome.getText() : null, date, cpf.getText().length() > 0 ? cpf.getText() : null, sexo, matricula.getText().length() > 0 ? matricula.getText() : null);						
						if (funcionario != null) {
							Pessoa pessoa = (Pessoa) funcionario;
							if (pessoaDAO.criar(pessoa) == true) {
								if (pessoaDAO.recuperarPeloCPF(pessoa) == true) {
									FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
									if (funcionarioDAO != null) {
										funcionario.setId(pessoa.getId());
										if (funcionarioDAO.criar(funcionario) == true) {
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
		
		JButton btnNewButton_1 = new JButton("Recuperar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();					
					if (funcionarioDAO != null) {
						Funcionario funcionario = new Funcionario(0, null, null, null, null, matricula.getText());
						if (funcionarioDAO.recuperar(funcionario) == true) {
							PessoaDAO pessoaDAO = new PessoaDAO();
							System.out.println("Funcionario encontrado!");
							System.out.println("Id="+funcionario.getId());
							if (pessoaDAO != null) {
								Pessoa pessoa = funcionario;
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
							System.out.println("Funcionario nao encontrado!");
						}
					}					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				if (funcionarioDAO != null) {
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
						Funcionario funcionario = new Funcionario(0, nome.getText().length() > 0 ? nome.getText() : null, date, cpf.getText().length() > 0 ? cpf.getText() : null, sexo, matricula.getText().length() > 0 ? matricula.getText() : null);
						if (funcionario != null) {
							if (funcionarioDAO.recuperar(funcionario) == true) {
								PessoaDAO pessoaDAO = new PessoaDAO();
								if (pessoaDAO != null) {
									Pessoa pessoa = (Pessoa) funcionario;
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
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				if (funcionarioDAO != null) {
					try {						
						Funcionario funcionario = new Funcionario(0, null, null, null, null, matricula.getText());
						if (funcionario != null) {
							if (funcionarioDAO.recuperar(funcionario) == true) {
								PessoaDAO pessoaDAO = new PessoaDAO();
								if (pessoaDAO != null) {
									Pessoa pessoa = (Pessoa) funcionario;
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
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		
		JLabel lblCPF = new JLabel("CPF:");
		
		JLabel lblSexo = new JLabel("Sexo:");
		
		nome = new JTextField();
		nome.setColumns(10);
		
		dataNascimento = new JTextField();
		dataNascimento.setColumns(10);
		
		cpf = new JTextField();
		cpf.setColumns(10);	
		
		
		feminino = new JRadioButton("F");
		buttonGroup.add(feminino);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula:");
		
		matricula = new JTextField();
		matricula.setColumns(10);
		
		GUITextComponentLimit.addTo(matricula, 15);
		GUITextComponentLimit.addTo(nome, 50);
		GUITextComponentLimit.addTo(dataNascimento, 10);
		GUITextComponentLimit.addTo(cpf, 11);
		
		GroupLayout groupLayout = new GroupLayout(frmCadastroFuncionario.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatrcula)
						.addComponent(matricula, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSexo)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(masculino)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(feminino)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNome)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCPF)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDataNascimento)
						.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(178, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMatrcula)
						.addComponent(lblNome)
						.addComponent(lblDataNascimento))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(matricula)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSexo)
						.addComponent(lblCPF))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(masculino)
						.addComponent(cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(feminino))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(30))
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3});
		frmCadastroFuncionario.getContentPane().setLayout(groupLayout);
		frmCadastroFuncionario.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{matricula, nome, dataNascimento, masculino, feminino, cpf, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3}));
	}
}
