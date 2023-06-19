package project_files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{
	
	JFrame window;
	
	JTextArea textarea;
	JScrollPane scrollpane;
	boolean wordWrapOn = false;
	
	JMenuBar menubar;
	JMenu file,edit,format,color;
	
	JMenuItem n, open, save, saveas,exit;
	
	JMenuItem Warp, FontArial, FontCSMS, FontTNR, FontSize08, FontSize12, FontSize16, FontSize20;
	JMenu Font,FontSize;
	
	JMenuItem color1, color2, color3, color4;
	
	JMenuItem undo, redo;
	
	Functions_File fl = new Functions_File(this);
	Function_Format ff = new Function_Format(this);
	Function_Color fc = new Function_Color(this);
	Function_Edit fe = new Function_Edit(this);
	
	Keyfunctions kf = new Keyfunctions(this);
	
	UndoManager um = new UndoManager();
	
	GUI(){
		CreateWindow();
		CreateTextArea();
		CreateMenubar();
		CreateMenuItem();
		createMenuFormat();
		createColormenu();
		CreateEditmenu();
		
		ff.selectedFont = "Arial";
		ff.createFont(20);
		ff.wordWarp();
		fc.changeColor("Black");
		window.setVisible(true);
	}
	public void CreateWindow() {
		window = new JFrame("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void CreateTextArea() {
		textarea = new JTextArea();
		textarea.setFont(ff.arial);
		
		textarea.addKeyListener(kf);
		
		textarea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
			}
		});
		
		scrollpane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		window.add(scrollpane);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		
	}
	
	public void CreateMenubar() {
		menubar = new JMenuBar();
		window.setJMenuBar(menubar);
		
		file = new JMenu("File");
		menubar.add(file);
		
		edit = new JMenu("Edit");
		menubar.add(edit);
		
		format = new JMenu("Format");
		menubar.add(format);
		
		color = new JMenu("Color");
		menubar.add(color);
	}
	
	public void CreateMenuItem() {
		n = new JMenuItem("New");
		n.addActionListener(this);
		n.setActionCommand("New");
		file.add(n);
		
		open = new JMenuItem("Open");
		open.addActionListener(this);
		open.setActionCommand("Open");
		file.add(open);
		
		save = new JMenuItem("Save");
		save.addActionListener(this);
		save.setActionCommand("Save");
		file.add(save);
		
		saveas = new JMenuItem("Save As");
		saveas.addActionListener(this);
		saveas.setActionCommand("Save As");
		file.add(saveas);
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		exit.setActionCommand("Exit");
		file.add(exit);
	}
	
	public void createMenuFormat() {
		Warp = new JMenuItem("Word Wrap: Off");
		Warp.addActionListener(this);
		Warp.setActionCommand("Word Warp");
		format.add(Warp);
		
		Font = new JMenu("Font");
		format.add(Font);
		
		FontArial = new JMenuItem("Arial");
		FontArial.addActionListener(this);
		FontArial.setActionCommand("Arial");
		Font.add(FontArial);
		
		FontCSMS = new JMenuItem("Comic Sans MS");
		FontCSMS.addActionListener(this);
		FontCSMS.setActionCommand("Comic Sans MS");
		Font.add(FontCSMS);
		
		FontTNR = new JMenuItem("Times New Roman");
		FontTNR.addActionListener(this);
		FontTNR.setActionCommand("Times New Roman");
		Font.add(FontTNR);
		
		FontSize = new JMenu("Font Size");
		format.add(FontSize);
		
		FontSize08 = new JMenuItem("8");
		FontSize08.addActionListener(this);
		FontSize08.setActionCommand("size 8");
		FontSize.add(FontSize08);
		
		FontSize12 = new JMenuItem("12");
		FontSize12.addActionListener(this);
		FontSize12.setActionCommand("size 12");
		FontSize.add(FontSize12);
		
		FontSize16 = new JMenuItem("16");
		FontSize16.addActionListener(this);
		FontSize16.setActionCommand("size 16");
		FontSize.add(FontSize16);
		
		FontSize20 = new JMenuItem("20");
		FontSize20.addActionListener(this);
		FontSize20.setActionCommand("size 20");
		FontSize.add(FontSize20);
	}
	
	public void createColormenu() {
		
		color1 = new JMenuItem("White");
		color1.addActionListener(this);
		color1.setActionCommand("White");
		color.add(color1);
		
		color2 = new JMenuItem("Black");
		color2.addActionListener(this);
		color2.setActionCommand("Black");
		color.add(color2);
		
		color3 = new JMenuItem("Blue");
		color3.addActionListener(this);
		color3.setActionCommand("Blue");
		color.add(color3);
		
	}
	
	public void CreateEditmenu() {
		undo = new JMenuItem("Undo");
		undo.addActionListener(this);
		undo.setActionCommand("Undo");
		edit.add(undo);
		
		redo = new JMenuItem("Redo");
		redo.addActionListener(this);
		redo.setActionCommand("Redo");
		edit.add(redo);
	}
	public static void main(String[] args) {
		new GUI();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		switch (command) {
		
		case "New":fl.newFile(); break;
		case "Open":fl.openfile(); break;
		case "Save":fl.save(); break;
		case "Save As":fl.saveas(); break;
		case "Exit":fl.exit(); break;
		
		case "Word Wrap":ff.wordWarp(); break;
		
		case "Arial":ff.setFont(command); break;
		case "Comic Sans MS":ff.setFont(command); break;
		case "Times New Roman":ff.setFont(command); break;
		
		case "Size 8" :ff.createFont(8); break;
		case "Size 12" :ff.createFont(12); break;
		case "Size 16" :ff.createFont(16); break;
		case "Size 20" :ff.createFont(20); break;
		
		case "White" : fc.changeColor(command); break;
		case "Black" : fc.changeColor(command); break;
		case "Blue"  : fc.changeColor(command); break;
		
		case "Undo" : fe.Undo(command); break;
		case "Redo" : fe.Redo(); break;
		}
	}
}
