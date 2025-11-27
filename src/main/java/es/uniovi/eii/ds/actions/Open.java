package es.uniovi.eii.ds.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

import es.uniovi.eii.ds.editor.Editor;

public class Open implements Action{
	
	private StringBuilder text = new StringBuilder();
	
	public Open(String fileName) {
		try {
			text = new StringBuilder(readFile(fileName));
		} catch (Exception e) {
			System.out.println("Document could not be opened");
		}
	}
	
	@Override
	public void execute(Editor editor) {
		editor.setText(text);
		
	}

	private String readFile(String filename) {
		InputStream in = getClass().getResourceAsStream("/" + filename);
		if (in == null)
			throw new IllegalArgumentException("File not found: " + filename);

		try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder result = new StringBuilder();
			String line;
			boolean firstLine = true;
			while ((line = input.readLine()) != null) {
				if (!firstLine)
					result.append(System.lineSeparator());
				result.append(line);
				firstLine = false;
			}
			return result.toString();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	} 
	 
}
