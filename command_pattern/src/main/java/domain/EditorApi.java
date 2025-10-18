package domain;

import commands.Command;

import javax.swing.JTextArea;

public interface EditorApi {
    JTextArea getTextField();
    String getClipboard();
    void setClipboard(String clipboard);
    void executeCommand(Command command);
    void undo();
}
