package login;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import app.Main;
import fields.MPasswordField;
import fields.MTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	protected static final Icons ICON = new Icons();
	
	private MouseAdapter mouseAdapter = new MouseAdapter() {
		
		@Override
		public void mousePressed(MouseEvent e) {
			Component focus = getFocusOwner();
			
			if (focus instanceof MTextField || focus instanceof MPasswordField) {
	            if (!SwingUtilities.isDescendingFrom(e.getComponent(), focus)) {
	                requestFocusInWindow();
	            }
	        }
		}
	};
	
	public Login() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setSize(Main.CONFIG.WIDTH,Main.CONFIG.HEIGHT);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new GridLayout(0, 2, 0, 0));
		
		{ // ESQUERDA
			Panel_L panel_L = new Panel_L();
			panel_L.addMouseListenerInPanels(mouseAdapter);
			this.add(panel_L);
		}
		
		{ // DIREITA
			Panel_R panel_R = new Panel_R();
			panel_R.addMouseListenerInPanels(mouseAdapter);
			this.add(panel_R);
		}
		
		setFocusable(true);
		
		this.setVisible(true);
	}
	
	protected static class Icons {
		public final ImageIcon USER_ICON = new ImageIcon(Main.CAMINHO.USER_ICON);
    }
}
