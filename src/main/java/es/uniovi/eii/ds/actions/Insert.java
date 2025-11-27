package es.uniovi.eii.ds.actions;

import es.uniovi.eii.ds.editor.Editor;

public class Insert implements Action{

	private StringBuilder text = new StringBuilder();
	
	public Insert(String[] args) {
		
		for (String word : args) {
			text.append(" ").append(word);
		}
	}
	
	@Override
	public void execute(Editor editor) {
		
		editor.setText(editor.getText().append(text));
		
	}
	
	

}
