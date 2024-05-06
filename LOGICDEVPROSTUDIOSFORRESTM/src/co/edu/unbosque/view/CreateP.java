package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateP extends JPanel{
	
	private JLabel img;
	private JTextField pista_txt,autor_txt;
	private JComboBox genero_cbx;
	private JButton add_btn, back_btn,file_btn;
	
	public CreateP() {
		
		setBounds(0,0,600,800);
		setVisible(false);
		setLayout(null);
		setBackground(Color.BLACK);
		initComponents();
	}

	private void initComponents() {
		
		back_btn = new JButton();
		back_btn.setBounds(450,640,70,60);
		back_btn.setBorder(null);
		back_btn.setBackground(null);
		back_btn.setOpaque(false);
		back_btn.setActionCommand("backPista");
		add(back_btn);
		
		add_btn = new JButton();
		add_btn.setBounds(200,640,200,60);
		add_btn.setBorder(null);
		add_btn.setBackground(null);
		add_btn.setOpaque(false);
		add_btn.setActionCommand("addPista");
		add(add_btn);
		
		
		file_btn = new JButton();
		file_btn.setBounds(460,450,70,60);
		file_btn.setBorder(null);
		file_btn.setBackground(null);
		file_btn.setOpaque(false);
		file_btn.setActionCommand("addFile");
		add(file_btn);
		
		pista_txt = new JTextField();
		pista_txt.setBounds(225, 390, 210, 30);
		pista_txt.setOpaque(false);
		pista_txt.setBorder(null);
		add(pista_txt);
		
		autor_txt = new JTextField();
		autor_txt.setBounds(225, 470, 210, 30);
		autor_txt.setOpaque(false);
		autor_txt.setBorder(null);
		add(autor_txt);
		
		genero_cbx = new JComboBox();
		genero_cbx.setBounds(225,545,210,30);
		genero_cbx.addItem("Rock");
		genero_cbx.addItem("Regueton");
		genero_cbx.addItem("Salsa");
		genero_cbx.addItem("Bachata");
		genero_cbx.addItem("De planchar");
		add(genero_cbx);
		
	
		
		
		
		img = new JLabel();
		img.setBounds(0,0,600,800);
		img.setIcon(new ImageIcon("src/images/anadirP.png"));
		add(img);
	
		
	}

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
		this.img = img;
	}

	public JTextField getPista_txt() {
		return pista_txt;
	}

	public void setPista_txt(JTextField pista_txt) {
		this.pista_txt = pista_txt;
	}

	public JTextField getAutor_txt() {
		return autor_txt;
	}

	public void setAutor_txt(JTextField autor_txt) {
		this.autor_txt = autor_txt;
	}

	public JComboBox getGenero_cbx() {
		return genero_cbx;
	}

	public void setGenero_cbx(JComboBox genero_cbx) {
		this.genero_cbx = genero_cbx;
	}

	public JButton getAdd_btn() {
		return add_btn;
	}

	public void setAdd_btn(JButton add_btn) {
		this.add_btn = add_btn;
	}

	public JButton getBack_btn() {
		return back_btn;
	}

	public void setBack_btn(JButton back_btn) {
		this.back_btn = back_btn;
	}

	public JButton getFile_btn() {
		return file_btn;
	}

	public void setFile_btn(JButton file_btn) {
		this.file_btn = file_btn;
	}
	
	
	
	
}
