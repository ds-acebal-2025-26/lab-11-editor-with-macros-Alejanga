package es.uniovi.eii.ds.editor;

import es.uniovi.eii.ds.actions.Delete;
import es.uniovi.eii.ds.actions.Insert;
import es.uniovi.eii.ds.actions.Open;
import es.uniovi.eii.ds.actions.Replace;

public class Editor {
	
	private StringBuilder text = new StringBuilder();
	private ActionManager actionManager = new ActionManager(this);
	
	public StringBuilder getText() {
		return text;
	}
	
	public void setText(StringBuilder text) {
		this.text = text;
	}
	
	public void open(String[] args) {
		if (checkArguments(args, 1, "open <file>"))
			return;
		actionManager.execute(new Open(args[0]));
	}
	
	public void insert(String[] args) {
		actionManager.execute(new Insert(args));
	}
	
	public void delete() {
		actionManager.execute(new Delete());
	}
	
	public void replace(String[] args) {
		if (checkArguments(args, 2, "replace <find> <replace>"))
			return;
		actionManager.execute(new Replace(args[0],args[1]));
	}
	
	public void recordMacro(String macroName) {
		actionManager.record(macroName);
	}
	
	public void stop() {
		actionManager.stop();
	}
	
	public void executeMacro(String macroName) {
		actionManager.executeMacro(macroName);
	}
	
	public static boolean checkArguments(String[] args, int expected, String syntax) {
        if (args.length != expected) {
            System.out.println("Invalid number of arguments => " + syntax);
            return false;
        }
        return true;
    }
}
