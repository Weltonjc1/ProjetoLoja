package br.com.loja.janelas.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaLogin {

	private JFrame janela;
	private JPanel painelPrincipal;

	public static void main(String[] args) {
		new TelaLogin().montaTela();
	}
	public void montaTela() {
		  preparaJanela();
		  preparaPainelPrincipal();
		  preparaTxtNome();
		  preparaBotaoSair();
		  mostraJanela();
	}
	
	@SuppressWarnings("unused")
	private void preparaJanela() {
		janela = new JFrame("Loja");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@SuppressWarnings("unused")
	private void preparaBotaoCarregar() {
		// TODO Auto-generated method stub
		
	}
	private void preparaPainelPrincipal() {
		// TODO Auto-generated method stub
		painelPrincipal = new JPanel();
		janela.add(painelPrincipal);
		
	}
	private void mostraJanela() {
		// TODO Auto-generated method stub
		janela.pack();
		janela.setSize(540, 540);
		janela.setVisible(true);
	}

	
	private void preparaBotaoSair() {
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		painelPrincipal.add(botaoSair);
	}
	
	
	@SuppressWarnings("unused")
	private void preparaTxtNome() {
		
		JLabel lbTexto = new JLabel("LOJA INFOMIX");
		JLabel lbNome = new JLabel("Usuário");
		JTextField txtUsuario = new JTextField("Digite o usuário");
		
		painelPrincipal.add(lbTexto);
		painelPrincipal.add(lbNome);
		painelPrincipal.add(txtUsuario);
		
	}
	
	}
