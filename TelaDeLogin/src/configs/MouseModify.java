package configs;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import app.Login;
import fields.MPasswordField;
import fields.MTextField;

public class MouseModify extends MouseAdapter {
	private Login login;
	
	public MouseModify(Login login) {
		this.login = login;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Component focus = login.getFocusOwner();
		
		if (focus instanceof MTextField || focus instanceof MPasswordField) {
            if (!SwingUtilities.isDescendingFrom(e.getComponent(), focus)) {
            	login.requestFocusInWindow();
            }
        }
	}
}
