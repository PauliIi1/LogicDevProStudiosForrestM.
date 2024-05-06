package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ViewR extends JPanel{

	private JLabel img;
	private JButton  back_btn,rep_btn,next_btn;
	private JTextArea txa_musica;
	private JComboBox genero_cbx;
	private JPanel buttonPanel;

	public ViewR() {
	
	
		setBounds(0,0,600,800);
		setVisible(false);
		setLayout(null);
		setBackground(Color.BLACK);
		initComponents();
	}

		private void initComponents() {
		
			rep_btn = new JButton();
			rep_btn.setBounds(450,370,70,60);
			rep_btn.setBorder(null);
			rep_btn.setBackground(null);
			rep_btn.setOpaque(false);
			rep_btn.setActionCommand("startParrilla");
			add(rep_btn);
			
			
			next_btn = new JButton();
			next_btn.setBounds(450,470,70,60);
			next_btn.setBorder(null);
			next_btn.setBackground(null);
			next_btn.setOpaque(false);
			next_btn.setActionCommand("nextParrilla");
			add(next_btn);
			
			
			back_btn = new JButton();
			back_btn.setBounds(450,580,70,60);
			back_btn.setBorder(null);
			back_btn.setBackground(null);
			back_btn.setOpaque(false);
			back_btn.setActionCommand("backEjecucion");
			add(back_btn);
			
		
			
			txa_musica = new JTextArea();
			txa_musica.setBounds(65,450,315,200);
			txa_musica.setOpaque(true);
			add(txa_musica);
			
			
			
			genero_cbx = new JComboBox();
			genero_cbx.setBounds(155,360,210,30);
			genero_cbx.setActionCommand("ComboBoxP");
			add(genero_cbx);
			
			
		   
			img = new JLabel();
			img.setBounds(0,0,600,800);
			img.setIcon(new ImageIcon("src/images/rep.png"));
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

		public JButton getRep_btn() {
			return rep_btn;
		}

		public void setRep_btn(JButton rep_btn) {
			this.rep_btn = rep_btn;
		}

		public JButton getNext_btn() {
			return next_btn;
		}

		public void setNext_btn(JButton next_btn) {
			this.next_btn = next_btn;
		}

		public JTextArea getTxa_musica() {
			return txa_musica;
		}

		public void setTxa_musica(JTextArea txa_musica) {
			this.txa_musica = txa_musica;
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

		public void setButtonPanel(JPanel buttonPanel) {
			this.buttonPanel = buttonPanel;
		}
		
		
}
		
		
		
