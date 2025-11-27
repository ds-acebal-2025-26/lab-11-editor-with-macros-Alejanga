package es.uniovi.eii.ds.editor;

import java.util.HashMap;
import java.util.Map;

import es.uniovi.eii.ds.actions.Action;
import es.uniovi.eii.ds.actions.Macro;

public class ActionManager {
	
	private Editor editor;
	
	private boolean macroIsRecording;
	
	private Macro macro;
	
	private Map<String, Macro> macros = new HashMap<>();
	
	public ActionManager(Editor editor) {
		this.editor = editor;
	}
	
	public void execute(Action action) {
		action.execute(editor);
		if(macroIsRecording) {
			macro.addAction(action);
		}
	}
	
	public void record(String macroName) {
		macro = new Macro(macroName);
		macroIsRecording = true;
	}
	
	public void stop() {
		macroIsRecording = false;
		macros.put(macro.getMacro(), macro);
	}
	
	public void executeMacro(String macroName) {
		Macro macro = macros.get(macroName);
		execute(macro);
	}
}
