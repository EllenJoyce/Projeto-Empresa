package br.com.projeto.projeto.projetoempresa.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import br.com.projeto.projeto.projetoempresa.controllers.ControllerFuncionario;
import br.com.projeto.projeto.projetoempresa.controllers.ControllerProjeto;
import br.com.projeto.projeto.projetoempresa.controllers.Relacao;
import br.com.projeto.projeto.projetoempresa.models.Projeto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaProjeto {

	private JFrame frame;
	private JTextField textFieldIDProj;
	private JTextField textFieldCliente;
	private JTextField textFieldNomeProj;
	private JTextField textFieldGestor;
	private JTextField textFieldSetorId;

	/**
	 * Launch the application.
	 */
	public static void projeto() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProjeto window = new TelaProjeto();
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
	public TelaProjeto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(28, 45, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Id do Projeto");
		lblNewLabel.setBounds(28, 57, 88, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(28, 82, 59, 14);
		frame.getContentPane().add(lblCliente);
		
		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto");
		lblNomeDoProjeto.setBounds(28, 107, 93, 14);
		frame.getContentPane().add(lblNomeDoProjeto);
		
		JLabel lblGestor = new JLabel("Gestor");
		lblGestor.setBounds(28, 132, 59, 14);
		frame.getContentPane().add(lblGestor);
		
		JLabel lblIdDoSetor = new JLabel("Id do Setor");
		lblIdDoSetor.setBounds(28, 157, 88, 14);
		frame.getContentPane().add(lblIdDoSetor);
		
		JLabel lblProjeto = new JLabel("Projetos");
		lblProjeto.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblProjeto.setBounds(121, 11, 200, 37);
		frame.getContentPane().add(lblProjeto);
		
		textFieldIDProj = new JTextField();
		textFieldIDProj.setBounds(131, 54, 118, 20);
		frame.getContentPane().add(textFieldIDProj);
		textFieldIDProj.setColumns(10);
		
		textFieldCliente = new JTextField();
		textFieldCliente.setColumns(10);
		textFieldCliente.setBounds(131, 79, 118, 20);
		frame.getContentPane().add(textFieldCliente);
		
		textFieldNomeProj = new JTextField();
		textFieldNomeProj.setColumns(10);
		textFieldNomeProj.setBounds(131, 104, 118, 20);
		frame.getContentPane().add(textFieldNomeProj);
		
		textFieldGestor = new JTextField();
		textFieldGestor.setColumns(10);
		textFieldGestor.setBounds(131, 129, 118, 20);
		frame.getContentPane().add(textFieldGestor);
		
		textFieldSetorId = new JTextField();
		textFieldSetorId.setColumns(10);
		textFieldSetorId.setBounds(131, 154, 118, 20);
		frame.getContentPane().add(textFieldSetorId);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setForeground(Color.WHITE);
		btnInserir.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnInserir.setBackground(Color.BLACK);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerProjeto.adicionaProjeto(textFieldCliente.getText(), textFieldNomeProj.getText(), textFieldGestor.getText(), Integer.parseInt(textFieldSetorId.getText()));
					JOptionPane.showMessageDialog(frame, "Inserido com sucesso", "Inserir Projeto", JOptionPane.WARNING_MESSAGE);
				} 
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na formatação do número", "Inserir Projeto", JOptionPane.WARNING_MESSAGE);
					
					
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Inserir Projeto", JOptionPane.WARNING_MESSAGE);
				
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Inserir Projeto", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				}
				
			}
		});
		btnInserir.setBounds(9, 200, 89, 23);
		frame.getContentPane().add(btnInserir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnExcluir.setBackground(Color.BLACK);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Relacao.deleteRelacaoProj(Integer.parseInt(textFieldIDProj.getText()));
					ControllerProjeto.deleteProjeto(Integer.parseInt(textFieldIDProj.getText()));
					JOptionPane.showMessageDialog(frame, "Excluído com sucesso", "Excluir Projeto", JOptionPane.WARNING_MESSAGE);
				
				} catch (InstantiationException e1) {	
					JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Excluir Projeto", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				} catch (SQLException e1) {	
					JOptionPane.showMessageDialog(frame, "Erro no SQL", "Excluir Projeto", JOptionPane.WARNING_MESSAGE);
					
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(108, 200, 98, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAlterar.setBackground(Color.BLACK);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto p = new Projeto(Integer.parseInt(textFieldIDProj.getText()), textFieldCliente.getText(), textFieldNomeProj.getText(), textFieldGestor.getText(), Integer.parseInt(textFieldSetorId.getText()));
			 try {
				 ControllerProjeto.alterarProjeto(p);
				 JOptionPane.showMessageDialog(frame, "Alterado com sucesso", "Alterar Projeto", JOptionPane.WARNING_MESSAGE);
			 
			} catch (InstantiationException e1) {
				JOptionPane.showMessageDialog(frame, "Erro na instancia do objeto", "Alterar Projeto", JOptionPane.WARNING_MESSAGE);
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(frame, "Erro no SQL", "Alterar Projeto", JOptionPane.WARNING_MESSAGE);
				
				e1.printStackTrace();
			}
		}
			
			
		});
		btnAlterar.setBounds(216, 200, 93, 23);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(Color.BLACK);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Projeto p = ControllerProjeto.consultaProj(textFieldNomeProj.getText());
					textFieldCliente.setText(p.getCliente());
					textFieldIDProj.setText(String.valueOf(p.getid()));
					textFieldNomeProj.setText(p.getNome_projeto());
					textFieldGestor.setText(p.getGestor());					
					textFieldSetorId.setText(String.valueOf(p.getid_setor()));
					
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnConsultar.setBounds(316, 200, 108, 23);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br.com.projeto.projeto.projetoempresa.Views.TelaPrincipal.main(null);
			}
		});
		btnNewButton.setBounds(160, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
