package co.edu.unbosque.view;

import javax.swing.JFrame;

public class View extends JFrame{
	
	private PrincipalPane pp;
	private AddPanel ap;
	private CreateP cp;
	private ViewP vp;
	private ViewR vr;
	
	public View() {
		
		setVisible(true);
		setSize(600,800);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initComoponents();
	}

	private void initComoponents() {


	
		pp = new PrincipalPane();
		pp.repaint();
		this.add(pp);
		
		
		ap = new AddPanel();
		ap.repaint();
		this.add(ap);
		
		cp = new CreateP();
		cp.repaint();
		this.add(cp);
		
		vp = new ViewP();
		vp.repaint();
		this.add(vp);
		
		vr = new ViewR();
		vr.repaint();
		this.add(vr);
	}

	public PrincipalPane getPp() {
		return pp;
	}

	public void setPp(PrincipalPane pp) {
		this.pp = pp;
	}

	public AddPanel getAp() {
		return ap;
	}

	public void setAp(AddPanel ap) {
		this.ap = ap;
	}

	public CreateP getCp() {
		return cp;
	}

	public void setCp(CreateP cp) {
		this.cp = cp;
	}

	public ViewP getVp() {
		return vp;
	}

	public void setVp(ViewP vp) {
		this.vp = vp;
	}

	public ViewR getVr() {
		return vr;
	}

	public void setVr(ViewR vr) {
		this.vr = vr;
	}
	
	
	
}
