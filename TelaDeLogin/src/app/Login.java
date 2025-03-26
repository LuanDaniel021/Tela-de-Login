package app;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fields.MPasswordField;
import fields.MTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
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
		this.setSize(800,700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		{ // DIREITA
			Panel_R panel_R = new Panel_R();
			
			panel_R.addMouseListenerInPanels(mouseAdapter);
			
			this.getContentPane().add(panel_R);
		}
		
		{ // ESQUERDA
			Panel_L panel_L = new Panel_L();
			
			panel_L.addMouseListenerInPanels(mouseAdapter);
			
			this.getContentPane().add(panel_L);
		}
		
		setFocusable(true);
		
		this.setVisible(true);
	}
}
