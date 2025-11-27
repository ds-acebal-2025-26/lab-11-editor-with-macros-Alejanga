package es.uniovi.eii.ds.actions;

import es.uniovi.eii.ds.editor.Editor;

public class Delete implements Action{

	@Override
	public void execute(Editor editor) {
		
		int indexOfLastWord = editor.getText().toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			editor.setText(new StringBuilder(""));
		else
			editor.getText().setLength(indexOfLastWord);
	}

}
