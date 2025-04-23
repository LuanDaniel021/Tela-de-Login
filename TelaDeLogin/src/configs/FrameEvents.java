package configs;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public abstract class FrameEvents {
	
	public MouseAdapter createMouseAdapter() {return null;}
	
	public ActionListener[] createActions() {return null;}
	
}
