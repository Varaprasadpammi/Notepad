package project_files;

import java.awt.Color;

public class Function_Color {
	
	GUI gui;
	
	public Function_Color(GUI gui) {
		
		this.gui = gui;
	}
	
	public void changeColor(String color) {
		
		switch (color) {
		case "White" :
			gui.window.getContentPane().setBackground(Color.white);
			gui.textarea.setBackground(Color.white);
			gui.textarea.setForeground(Color.black);
			break;
			
		case "Black" :
			gui.window.getContentPane().setBackground(Color.black);
			gui.textarea.setBackground(Color.black);
			gui.textarea.setForeground(Color.white);
			break;
			
		case "Blue" :
			gui.window.getContentPane().setBackground(Color.blue);
			gui.textarea.setBackground(Color.blue);
			gui.textarea.setForeground(Color.white);
			break;
		
		}
	}

}
