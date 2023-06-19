package project_files;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyfunctions implements KeyListener{
	
	GUI gui;

	public Keyfunctions(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.fl.save();
		}
		if (e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.fl.saveas();
		}
		if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {
			gui.fl.newFile();
		}
		if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {
			gui.fl.openfile();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			gui.um.undo();
		}
		if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y) {
			gui.um.redo();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
