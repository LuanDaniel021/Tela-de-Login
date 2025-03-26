package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class Panel_R extends JPanel {
	
	public Panel_R() {
		this.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.setLayout(new BorderLayout(0, 0));
		
		{ // CENTRO
			
			Panel panel_RC = new Panel();
			this.add(panel_RC);
			
			GridBagLayout gbl_panel_RC = new GridBagLayout();
			gbl_panel_RC.rowHeights = new int[] {14};
			
			panel_RC.setLayout(gbl_panel_RC);
			
			JLabel lblBemVindo = new JLabel("Bem Vindo");
			lblBemVindo.setFont(new Font("Arial", Font.BOLD, 35));
			
			GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
			gbc_lblBemVindo.insets = new Insets(10, 10, 10, 10);
			gbc_lblBemVindo.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblBemVindo.gridx = 0;
			gbc_lblBemVindo.gridy = 0;
			
			panel_RC.add(lblBemVindo, gbc_lblBemVindo);
			
		}
		
		{ // BAIXO
			
			Panel panel_RB = new Panel();
			this.add(panel_RB, BorderLayout.SOUTH);
			panel_RB.setLayout(new BorderLayout(0, 0));
			
			Label versao_Label = new Label("Versão "+Main.VERSAO);
			panel_RB.add(versao_Label, BorderLayout.WEST);
			
		}
	}
	
	public void addMouseListenerInPanels(MouseAdapter mouseAdapter) {
		
		this.getComponent(0).addMouseListener(mouseAdapter);	// panel_RC
		this.getComponent(1).addMouseListener(mouseAdapter);	// panel_RB
		
	}
}
