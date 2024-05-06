package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPanel extends JPanel{
	
	private JLabel img;
	private JTextField emisora_txt;
	private JComboBox genero_cbx, modo_cbx;
	private JButton add_btn, back_btn;
	
	public AddPanel() {
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
		back_btn.setActionCommand("backEmisora");
		add(back_btn);
		
		add_btn = new JButton();
		add_btn.setBounds(200,640,200,60);
		add_btn.setBorder(null);
		add_btn.setBackground(null);
		add_btn.setOpaque(false);
		add_btn.setActionCommand("addEmisora");
		add(add_btn);
		
		emisora_txt = new JTextField();
		emisora_txt.setBounds(225, 390, 210, 30);
		emisora_txt.setOpaque(false);
		emisora_txt.setBorder(null);
		add(emisora_txt);
		
		genero_cbx = new JComboBox();
		genero_cbx.setBounds(225,545,210,30);
		genero_cbx.addItem("Rock");
		genero_cbx.addItem("Regueton");
		genero_cbx.addItem("Salsa");
		genero_cbx.addItem("Vallenato");
		genero_cbx.addItem("De planchar");
		add(genero_cbx);
		
		
		modo_cbx = new JComboBox();
		modo_cbx.setBounds(225,470,210,30);
		modo_cbx.addItem("AM");
		modo_cbx.addItem("FM");
		modo_cbx.addItem("STREAMING");
		add(modo_cbx);
		
		
		
		img = new JLabel();
		img.setBounds(0,0,600,800);
		img.setIcon(new ImageIcon("src/images/anadir.png"));
		add(img);
	}

	public JLabel getImg() {
		return img;
	}

	public void setImg(JLabel img) {
		this.img = img;
	}

	public JTextField getEmisora_txt() {
		return emisora_txt;
	}

	public void setEmisora_txt(JTextField emisora_txt) {
		this.emisora_txt = emisora_txt;
	}

	public JComboBox getGenero_cbx() {
		return genero_cbx;
	}

	public void setGenero_cbx(JComboBox genero_cbx) {
		this.genero_cbx = genero_cbx;
	}

	public JComboBox getModo_cbx() {
		return modo_cbx;
	}

	public void setModo_cbx(JComboBox modo_cbx) {
		this.modo_cbx = modo_cbx;
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
	
	
	
}
