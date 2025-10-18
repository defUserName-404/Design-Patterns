package domain;

import commands.Command;

import javax.swing.JTextArea;

public class Editor implements EditorApi {
    private JTextArea textField;
    private String clipboard;
    private final CommandHistory history = new CommandHistory();

    public Editor() {
        this.textField = new JTextArea();
        this.textField.setLineWrap(true);
    }

    @Override
    public JTextArea getTextField() {
        return textField;
    }

    @Override
    public String getClipboard() {
        return clipboard;
    }

    @Override
    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    @Override
    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    @Override
    public void undo() {
        if (history.isEmpty()) return;
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}
