package domain;

import commands.Command;

import javax.swing.*;

public class Editor implements EditorApi {
    private final JTextArea textField;
    private String clipboard;
    private final CommandHistory history = new CommandHistory();
    private boolean isDirty = false;

    public Editor() {
        this.textField = new JTextArea();
        this.textField.setLineWrap(true);
        this.textField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                isDirty = true;
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                isDirty = true;
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                isDirty = true;
            }
        });
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

    @Override
    public String getContent() {
        return textField.getText();
    }

    @Override
    public void setContent(String content) {
        textField.setText(content);
    }

    @Override
    public boolean isDirty() {
        return isDirty;
    }

    @Override
    public void setDirty(boolean isDirty) {
        this.isDirty = isDirty;
    }
}
