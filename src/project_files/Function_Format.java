package project_files;

import java.awt.Font;

public class Function_Format {
	GUI gui;
	Font arial, comicSansMS,timesNewRoman;
	String selectedFont;
	
	public Function_Format(GUI gui) {
		
		this.gui = gui;
	}
	
	public void wordWarp() {
		
		if (gui.wordWrapOn == false) {
			gui.wordWrapOn=true;
			gui.textarea.setLineWrap(true);
			gui.textarea.setWrapStyleWord(true);
			gui.Warp.setText("WordWarp: On");
		}
		else if(gui.wordWrapOn == true){
			gui.wordWrapOn = false;
			gui.textarea.setLineWrap(false);
			gui.textarea.setWrapStyleWord(false);
			gui.Warp.setText("WordWarp: Off");
		}
	}
	
	public void createFont(int fontsize) {
		arial = new Font("Arial", Font.PLAIN, fontsize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontsize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontsize);
		
		setFont(selectedFont);
	}
	
	public void setFont(String font) {
		selectedFont = font;
		
		switch (selectedFont) {
		case "Arial":
				gui.textarea.setFont(arial);
			break;
		case "Comic San MS":
			gui.textarea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textarea.setFont(timesNewRoman);
		default:
			break;
		}
	}
}
