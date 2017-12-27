package br.com.projeto.projeto.projetoempresa.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.com.projeto.projeto.projetoempresa.controllers.Relacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaVinculo {

	private JFrame frame;
	private JTextField textFieldCpf;
	private JTextField textFieldProjetoID;

	/**
	 * Launch the application.
	 */
	public static void vinculo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVinculo window = new TelaVinculo();
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
	public TelaVinculo() {
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
		
		JLabel lblAlocarEmProjeto = new JLabel("Alocar em Projeto");
		lblAlocarEmProjeto.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblAlocarEmProjeto.setBounds(22, 11, 390, 49);
		frame.getContentPane().add(lblAlocarEmProjeto);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(145, 81, 86, 20);
		frame.getContentPane().add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldProjetoID = new JTextField();
		textFieldProjetoID.setBounds(145, 124, 86, 20);
		frame.getContentPane().add(textFieldProjetoID);
		textFieldProjetoID.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(78, 84, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblIdProjeto = new JLabel("Id Projeto");
		lblIdProjeto.setBounds(61, 127, 63, 14);
		frame.getContentPane().add(lblIdProjeto);
		
		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Relacao.adicionaRelacao(Integer.parseInt(textFieldProjetoID.getText()), textFieldCpf.getText());
					JOptionPane.showMessageDialog(frame, "Alocado com sucesso", "Alocar", JOptionPane.WARNING_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na formatação de número", "Alocar", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Alocar", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Alocar", JOptionPane.WARNING_MESSAGE);
				
					e1.printStackTrace();
				}
			}
		});
		btnAlocar.setBounds(142, 193, 89, 23);
		frame.getContentPane().add(btnAlocar);
	}

}
