package services;

import domain.EditorApi;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    private final EditorApi editor;
    private File currentFile;

    public FileService(EditorApi editor) {
        this.editor = editor;
    }

    public void newFile() {
        editor.setContent("");
        currentFile = null;
        editor.setDirty(false);
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (FileReader reader = new FileReader(currentFile)) {
                editor.getTextField().read(reader, null);
                editor.setDirty(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile() {
        if (currentFile == null) {
            saveFileAs();
        } else {
            try (FileWriter writer = new FileWriter(currentFile)) {
                writer.write(editor.getContent());
                editor.setDirty(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFileAs() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            saveFile();
        }
    }
}
