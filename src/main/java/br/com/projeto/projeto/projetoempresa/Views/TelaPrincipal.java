package br.com.projeto.projeto.projetoempresa.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaPrincipal {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
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
	public TelaPrincipal() {
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
		
		JButton btnFuncionario = new JButton("Funcionários");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFuncionario nw = TelaFuncionario();
				nw.funcionario();
			}
		});
		btnFuncionario.setBounds(28, 179, 113, 23);
		frame.getContentPane().add(btnFuncionario);
		
		JButton btnProjetos = new JButton("Projetos");
		btnProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProjeto nw = TelaProjeto();
				nw.projeto();
			}
		});
		btnProjetos.setBounds(165, 179, 113, 23);
		frame.getContentPane().add(btnProjetos);
		
		JButton btnSetores = new JButton("Setores");
		btnSetores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					TelaSetor nw = TelaSetor();
					nw.setor();
			}
		});
		btnSetores.setBounds(291, 179, 99, 23);
		frame.getContentPane().add(btnSetores);
		
		JLabel lblSistemaEmpresa = new JLabel("Sistema Empresa");
		lblSistemaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSistemaEmpresa.setBounds(98, 57, 229, 39);
		frame.getContentPane().add(lblSistemaEmpresa);
		
		JButton btnAlocarEmProjetos = new JButton("Alocar em Projetos");
		btnAlocarEmProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVinculo nw = TelaVinculo();
				nw.vinculo();
				
			}
		});
		btnAlocarEmProjetos.setBounds(145, 213, 167, 23);
		frame.getContentPane().add(btnAlocarEmProjetos);
	}

	protected TelaSetor TelaSetor() {
		// TODO Auto-generated method stub
		return null;
	}

	protected TelaProjeto TelaProjeto() {
		// TODO Auto-generated method stub
		return null;
	}

	protected TelaFuncionario TelaFuncionario() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected TelaVinculo TelaVinculo() {
		// TODO Auto-generated method stub
		return null;
	}


}
