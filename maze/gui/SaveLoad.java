package maze.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import maze.logic.*;

public class SaveLoad {
	private JFileChooser fc;

	public SaveLoad() {
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Saves", "dat");
        fc.addChoosableFileFilter(filter);


	}

	public int save(Object gm) throws IOException {
		File file;
		int returnVal = fc.showSaveDialog(new JFrame("save"));
		do {
			if (returnVal == JFileChooser.CANCEL_OPTION) {
				return 1;
			}
			File tpfile = fc.getSelectedFile();
			String stmp = tpfile.getName();
			if(stmp.endsWith(".dat")){
				file= tpfile;
			}else{
			file = new File(tpfile + ".dat");
			}

			
			

		} while (returnVal != JFileChooser.APPROVE_OPTION);
		FileOutputStream saveFile = new FileOutputStream(file);
		ObjectOutputStream save = new ObjectOutputStream(saveFile);

		save.writeObject(gm);
		save.close();
		return 0;
	}

	public Object load() throws IOException, ClassNotFoundException {
		Object obj;
		File file;
		int returnVal = fc.showOpenDialog(new JFrame("load"));
		do {

			file = fc.getSelectedFile();

			if (returnVal == JFileChooser.CANCEL_OPTION) {
				return null;
			}

		} while (returnVal != JFileChooser.APPROVE_OPTION);
		FileInputStream saveFile = new FileInputStream(file);
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		obj = restore.readObject();
		
		restore.close();
		if(obj instanceof Game){
		return obj;
		}
		else
			return null;

	}

}
