package br.com.projeto.projeto.projetoempresa.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.com.projeto.projeto.projetoempresa.controllers.ControllerSetor;
import br.com.projeto.projeto.projetoempresa.models.SetorEmpresa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaSetor {

	private JFrame frame;
	private JTextField textFieldSetorId;
	private JTextField textFieldNomeSetor;
	private JTextField textFieldGerente;

	/**
	 * Launch the application.
	 */
	public static void setor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSetor window = new TelaSetor();
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
	public TelaSetor() {
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
		
		JLabel lblSetores = new JLabel("Setores");
		lblSetores.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSetores.setBounds(149, 11, 127, 29);
		frame.getContentPane().add(lblSetores);
		
		JLabel lblNewLabel = new JLabel("Id do Setor");
		lblNewLabel.setBounds(30, 68, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNomeDoSetor = new JLabel("Nome do Setor");
		lblNomeDoSetor.setBounds(30, 93, 84, 14);
		frame.getContentPane().add(lblNomeDoSetor);
		
		JLabel lblGerente = new JLabel("Gerente");
		lblGerente.setBounds(30, 118, 46, 14);
		frame.getContentPane().add(lblGerente);
		
		textFieldSetorId = new JTextField();
		textFieldSetorId.setBounds(124, 65, 86, 20);
		frame.getContentPane().add(textFieldSetorId);
		textFieldSetorId.setColumns(10);
		
		textFieldNomeSetor = new JTextField();
		textFieldNomeSetor.setColumns(10);
		textFieldNomeSetor.setBounds(124, 90, 86, 20);
		frame.getContentPane().add(textFieldNomeSetor);
		
		textFieldGerente = new JTextField();
		textFieldGerente.setColumns(10);
		textFieldGerente.setBounds(124, 115, 86, 20);
		frame.getContentPane().add(textFieldGerente);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerSetor.adicionaSetor(textFieldNomeSetor.getText(), textFieldGerente.getText());
					JOptionPane.showMessageDialog(frame, "Inserido com sucesso", "Inserir Setor", JOptionPane.WARNING_MESSAGE);
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Inserir Setor", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Inserir Setor", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				}
			}
		});
		btnInserir.setBounds(25, 198, 89, 23);
		frame.getContentPane().add(btnInserir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerSetor.deleteSetor(Integer.parseInt(textFieldSetorId.getText()));
					JOptionPane.showMessageDialog(frame, "Excluído com sucesso", "Excluir Setor", JOptionPane.WARNING_MESSAGE);
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Excluir Setor", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Excluir Setor", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(121, 198, 89, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetorEmpresa s = new SetorEmpresa(Integer.parseInt(textFieldSetorId.getText()), textFieldNomeSetor.getText(), textFieldGerente.getText());
				try {
					ControllerSetor.alterarSetor(s);
					JOptionPane.showMessageDialog(frame, "Alterado com sucesso", "Alterar Setor", JOptionPane.WARNING_MESSAGE);
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Alterar Setor", JOptionPane.WARNING_MESSAGE);
				
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Alterar Setor", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				}
			}
		});
		btnAlterar.setBounds(220, 198, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SetorEmpresa s = ControllerSetor.consultaSetorEmp(Integer.parseInt(textFieldSetorId.getText()));
					textFieldGerente.setText(s.getgerente());
					textFieldNomeSetor.setText(s.getnomesetor());
					
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnConsultar.setBounds(321, 198, 89, 23);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.com.projeto.projeto.projetoempresa.Views.TelaPrincipal.main(null);
				
			}
		});
		btnNewButton.setBounds(158, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
