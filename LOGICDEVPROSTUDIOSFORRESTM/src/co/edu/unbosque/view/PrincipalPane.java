package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrincipalPane extends JPanel{

	private JLabel img;
	private JButton pista_btn, emisora_btn,parrilla_btn;
	
	public PrincipalPane() {
	
		setBounds(0,0,600,800);
		setVisible(true);
		setLayout(null);
		setBackground(Color.BLACK);
		initComponents();
	}

	private void initComponents() {
		
		emisora_btn = new JButton();
		emisora_btn.setBounds(150,340,300,80);
		emisora_btn.setBorder(null); 
		emisora_btn.setBackground(null);
		emisora_btn.setOpaque(false);
		emisora_btn.setActionCommand("Emisora");
		add(emisora_btn);
		
		pista_btn = new JButton();
		pista_btn.setBounds(150,440,300,80);
		pista_btn.setBorder(null); 
		pista_btn.setBackground(null);
		pista_btn.setOpaque(false);
		pista_btn.setActionCommand("Pista");
		add(pista_btn);
		
		
		parrilla_btn = new JButton();
		parrilla_btn.setBounds(150,590,300,80);
		parrilla_btn.setBorder(null); 
		parrilla_btn.setBackground(null);
		parrilla_btn.setOpaque(false);
		parrilla_btn.setActionCommand("Parrilla");
		add(parrilla_btn);
		
		 
		
		img = new JLabel();
		img.setBounds(0,0,600,800);
		img.setIcon(new ImageIcon("src/images/principal.png"));
		add(img);
		
		
		
		
	}

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
		this.img = img;
	}

	public JButton getPista_btn() {
		return pista_btn;
	}

	public void setPista_btn(JButton pista_btn) {
		this.pista_btn = pista_btn;
	}

	public JButton getEmisora_btn() {
		return emisora_btn;
	}

	public void setEmisora_btn(JButton emisora_btn) {
		this.emisora_btn = emisora_btn;
	}

	public JButton getParrilla_btn() {
		return parrilla_btn;
	}

	public void setParrilla_btn(JButton parrilla_btn) {
		this.parrilla_btn = parrilla_btn;
	}
	
	
	
}
