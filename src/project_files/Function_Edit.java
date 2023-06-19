package project_files;

public class Function_Edit {
	
	GUI gui;
	
	public Function_Edit(GUI gui) {
		
		this.gui = gui;
	
	}
	
	public void Undo(String Edit) {
		gui.um.undo();
	}
	
	public void Redo() {
		gui.um.redo();
	}

}
