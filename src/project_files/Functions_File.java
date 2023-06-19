package project_files;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Functions_File {
	
	GUI gui;
	String filename,fileaddress;
	public Functions_File(GUI gui) {
		this.gui = gui;
	}
	public void newFile() {
		gui.textarea.setText("");
		gui.window.setTitle("New");	
		filename = null;
		fileaddress = null; 
	}
	public void openfile() {
		
		FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		if (fd.getFile()!=null) {
			filename = fd.getFile();
			fileaddress = fd.getDirectory();
			gui.window.setTitle(filename);
		}
		System.out.println("File Address and File Name: " + fileaddress + filename);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileaddress + filename));
			
			gui.textarea.setText("");
			
			String line = null;
			
			while((line = br.readLine())!= null) {
				gui.textarea.append(line + "\n");
			}
			br.close();
		} catch (Exception e) {
			System.out.println("File Not Opened!");
		}
	}
	public void save() {
		if (filename == null) {
			saveas();
		}
		else{
			try {
				FileWriter fw = new FileWriter(fileaddress + filename);
				fw.write(gui.textarea.getText());
				gui.window.setTitle(filename);
				fw.close();
			} catch (Exception e) {
				System.out.println("Something Wrong..!");
			}
		}
	}
	public void saveas() {
		FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
		fd.setVisible(true);
		
		if (fd.getFile()!=null) {
			filename = fd.getFile();
			fileaddress = fd.getDirectory();
			gui.window.setTitle(filename);
		}
		try {
			FileWriter fw = new FileWriter(fileaddress + filename);
			fw.write(gui.textarea.getText());
			fw.close();
		} catch (Exception e) {
			System.out.println("Something Wrong..!");
		}
	}
	public void exit() {
		System.exit(0);
	}
}
