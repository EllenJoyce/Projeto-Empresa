package br.com.projeto.projeto.projetoempresa.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.projeto.projeto.projetoempresa.controllers.ControllerFuncionario;
import br.com.projeto.projeto.projetoempresa.models.FuncionarioEmpresa;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaFuncionario {

	private JFrame frame;
	private JTextField textFieldCpf;
	private JTextField textFieldNome;
	private JTextField textFieldCargo;
	private JTextField textFieldDataNasc;
	private JTextField textFieldSetorId;

	/**
	 * Launch the application.
	 */
	public static void funcionario() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFuncionario window = new TelaFuncionario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaFuncionario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerFuncionario.adicionaFuncionario(textFieldCpf.getText(), textFieldNome.getText(), textFieldCargo.getText(), textFieldDataNasc.getText());
					JOptionPane.showMessageDialog(frame, "Inserido com sucesso", "Inserir Funcionario", JOptionPane.WARNING_MESSAGE);
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Inserir Funcionario", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Inserir Funcionario", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(23, 192, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerFuncionario.deleteFunc(textFieldCpf.getText());
					JOptionPane.showMessageDialog(frame, "Excluído com sucesso", "Excluir Funcionario", JOptionPane.WARNING_MESSAGE);
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Excluir Funcionario", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Excluir Funcionario", JOptionPane.WARNING_MESSAGE);
				
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(122, 192, 89, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioEmpresa f = new FuncionarioEmpresa(textFieldCpf.getText(), textFieldNome.getText(), textFieldCargo.getText(), textFieldDataNasc.getText(), Integer.parseInt(textFieldSetorId.getText()));
				try {
					ControllerFuncionario.alterarFuncionario(f);
					JOptionPane.showMessageDialog(frame, "Alterado com sucesso", "Alterar Funcionario", JOptionPane.WARNING_MESSAGE);
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Alterar Funcionario", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Alterar Funcionario", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				}
			}
		});
		btnAlterar.setBounds(221, 192, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FuncionarioEmpresa f = ControllerFuncionario.consultaFunc(textFieldCpf.getText());
					textFieldNome.setText(f.getNome());
					textFieldCargo.setText(f.getCargo());
					textFieldDataNasc.setText(f.getDt_nasc());					
					textFieldSetorId.setText(String.valueOf(f.getid_setor()));
					
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConsultar.setBounds(320, 192, 89, 23);
		frame.getContentPane().add(btnConsultar);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(23, 46, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(23, 71, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(23, 96, 46, 14);
		frame.getContentPane().add(lblCargo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(23, 121, 111, 14);
		frame.getContentPane().add(lblDataDeNascimento);
		
		JLabel lblIdDoSetor = new JLabel("Id do Setor");
		lblIdDoSetor.setBounds(23, 146, 89, 14);
		frame.getContentPane().add(lblIdDoSetor);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(125, 43, 86, 20);
		frame.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(125, 68, 86, 20);
		frame.getContentPane().add(textFieldNome);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(125, 93, 86, 20);
		frame.getContentPane().add(textFieldCargo);
		
		textFieldDataNasc = new JTextField();
		textFieldDataNasc.setColumns(10);
		textFieldDataNasc.setBounds(125, 118, 86, 20);
		frame.getContentPane().add(textFieldDataNasc);
		
		textFieldSetorId = new JTextField();
		textFieldSetorId.setColumns(10);
		textFieldSetorId.setBounds(125, 143, 86, 20);
		frame.getContentPane().add(textFieldSetorId);
		
		JLabel lblFuncionrios = new JLabel("Funcionários");
		lblFuncionrios.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFuncionrios.setBounds(126, 2, 218, 30);
		frame.getContentPane().add(lblFuncionrios);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.com.projeto.projeto.projetoempresa.Views.TelaPrincipal.main(null);
			}
		});
		btnNewButton_1.setBounds(161, 226, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

	protected TelaPrincipal TelaPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

}
