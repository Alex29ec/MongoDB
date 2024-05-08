package principal;

import javax.swing.JFrame;

import principal.vistas.PanelPrincipal;

public class Principal extends JFrame {

	static Principal instance = null;
	public static Principal getInstance() {
		if(instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);
		
	}
	public Principal() {
		super("Gestion de Provincias");
		this.setBounds(0,0,800,600);

		PanelPrincipal panelp = new PanelPrincipal();
		this.getContentPane().add(panelp);
	}

}
