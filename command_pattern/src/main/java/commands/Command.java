package commands;

import domain.EditorApi;

public abstract class Command {

    protected EditorApi editor;
    private String backup;

    protected Command(EditorApi editor) {
        this.editor = editor;
    }

    public void backup() {
        backup = editor.getTextField().getText();
    }

    public void undo() {
        editor.getTextField().setText(backup);
    }

    public abstract boolean execute();

}
