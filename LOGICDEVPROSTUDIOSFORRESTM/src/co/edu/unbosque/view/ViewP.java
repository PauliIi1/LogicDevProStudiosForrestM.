package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import co.edu.unbosque.model.Emisora;
import co.edu.unbosque.model.Pista;

public class ViewP extends JPanel{
	

	private JLabel img;
	private JButton  back_btn,canciones_btn,agregar_btn,ejecutar_btn;
	private JTextArea txa_musica;
	private JComboBox genero_cbx,musica_cbx;
	private JPanel buttonPanel;

	public ViewP() {
	
	
		setBounds(0,0,600,800);
		setVisible(false);
		setLayout(null);
		setBackground(Color.BLACK);
		initComponents();
	}

		private void initComponents() {
			
			agregar_btn = new JButton("AGREGAR" );
			agregar_btn.setBounds(80,370,70,60);
			agregar_btn.setBorder(null);
			agregar_btn.setBackground(Color.white);
			agregar_btn.setActionCommand("agregarParrilla");
			add(agregar_btn);
			
			
			
			
			
			ejecutar_btn = new JButton( );
			ejecutar_btn.setBounds(450,370,80,80);
			ejecutar_btn.setBorder(null);
			ejecutar_btn.setBackground(null);
			ejecutar_btn.setOpaque(false);
			ejecutar_btn.setActionCommand("ejecutarParrilla");
			add(ejecutar_btn);
			
			
			back_btn = new JButton();
			back_btn.setBounds(450,580,70,60);
			back_btn.setBorder(null);
			back_btn.setBackground(null);
			back_btn.setOpaque(false);
			back_btn.setActionCommand("backParrilla");
			add(back_btn);
			
			musica_cbx = new JComboBox();
			musica_cbx.setBounds(185,400,210,30);
			musica_cbx.setActionCommand("ComboBox");
			add(musica_cbx);
			
			txa_musica = new JTextArea();
			txa_musica.setBounds(70,450,315,200);
			txa_musica.setOpaque(true);
			add(txa_musica);
			
			
			
			genero_cbx = new JComboBox();
			genero_cbx.setBounds(185,360,210,30);
			genero_cbx.setActionCommand("ComboBox");
			add(genero_cbx);
			
			
		   
			img = new JLabel();
			img.setBounds(0,0,600,800);
			img.setIcon(new ImageIcon("src/images/seleccion.png"));
			add(img);
		
		
		
		
	}
		
		
		

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
		this.img = img;
	}



	public JButton getBack_btn() {
		return back_btn;
	}

	public void setBack_btn(JButton back_btn) {
		this.back_btn = back_btn;
	}

	public JButton getCanciones_btn() {
		return canciones_btn;
	}

	public void setCanciones_btn(JButton canciones_btn) {
		this.canciones_btn = canciones_btn;
	}

	public JComboBox getGenero_cbx() {
		return genero_cbx;
	}

	public void setGenero_cbx(JComboBox genero_cbx) {
		this.genero_cbx = genero_cbx;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public JTextArea getTxa_musica() {
		return txa_musica;
	}

	public void setTxa_musica(JTextArea txa_musica) {
		this.txa_musica = txa_musica;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JComboBox getMusica_cbx() {
		return musica_cbx;
	}

	public void setMusica_cbx(JComboBox musica_cbx) {
		this.musica_cbx = musica_cbx;
	}

	public JButton getAgregar_btn() {
		return agregar_btn;
	}

	public void setAgregar_btn(JButton agregar_btn) {
		this.agregar_btn = agregar_btn;
	}

	public JButton getEjecutar_btn() {
		return ejecutar_btn;
	}

	public void setEjecutar_btn(JButton ejecutar_btn) {
		this.ejecutar_btn = ejecutar_btn;
	}


	
	
	
	
	

	
	
	
	
}

	
