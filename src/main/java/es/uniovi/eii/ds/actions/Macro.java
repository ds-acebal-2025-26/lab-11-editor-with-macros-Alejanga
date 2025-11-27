package es.uniovi.eii.ds.actions;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.eii.ds.editor.Editor;

public class Macro implements Action{
	
	private String macroName;
	
	private List<Action> actions = new ArrayList<>();
	
	public Macro(String macroName) {
		this.macroName = macroName;
	}

	@Override
	public void execute(Editor editor) {
		for(Action action : actions) {
			action.execute(editor);
		}
		
	}
	
	public void addAction(Action action) {
		actions.add(action);
	}
	
	public String getMacro() {
		return macroName;
	}
	
	

}
