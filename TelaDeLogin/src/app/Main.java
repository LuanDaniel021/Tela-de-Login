package app;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import MComponentes.enums.StatusFields;
import configs.FrameEvents;
import configs.MessageDialog;
import database.DataBase;
import fields.MComponenteField;
import frame.Login;


public class Main {
	
	private static Login LOGIN;
	
	public static void main(String[] args) {

		LOGIN = new Login(new FrameEvents() {
			
			@Override
			public MouseAdapter createMouseAdapter() {
				return new MouseAdapter() {
					
					@Override
					public void mousePressed(MouseEvent e) {
						Component focus = LOGIN.getFocusOwner();
						
						if (focus instanceof MComponenteField) {
				            if (!SwingUtilities.isDescendingFrom(e.getComponent(), focus)) {
				            	LOGIN.requestFocusInWindow();
				            }
				        }
					}
					
				};
			}
			
			@Override
			public ActionListener[] createActions() {
				
				ActionListener[] events = {
					
					new ActionListener() { // Evento do botão "btnEntrar", index : 0
						
						@Override
						public void actionPerformed(ActionEvent e) {
							processLoginResult(DataBase.tryLogin(LOGIN.getUsuario()));
						}		
			
					}
					
				};
				
				return events;
			}
			
		});
		
		LOGIN.setVisible(true);
		
	}
	
	private static void processLoginResult(boolean isSuccessful) {
	    StatusFields status = isSuccessful ? StatusFields.CONFIRM : StatusFields.ERROR;
	    LOGIN.getTxtUsuario().setStatus(status);
	    LOGIN.getTxtSenha().setStatus(status);
	    MessageDialog.showMessageFields(status);
	}
	
}
