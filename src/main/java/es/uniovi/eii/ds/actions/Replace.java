package es.uniovi.eii.ds.actions;

import es.uniovi.eii.ds.editor.Editor;

public class Replace implements Action{
	
	private String find;
	
	private String replace;
	
	
	public  Replace(String find, String replace) {
		this.find = find;
		this.replace = replace;
	}


	@Override
	public void execute(Editor editor) {
		
		editor.setText(new StringBuilder(editor.getText().toString().replace(find, replace)));
		
	}
}
