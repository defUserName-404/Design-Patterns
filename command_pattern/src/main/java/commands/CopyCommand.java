package commands;

import domain.EditorApi;

public class CopyCommand extends Command {

    public CopyCommand(EditorApi editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        editor.setClipboard(editor.getTextField().getSelectedText());
        return false;
    }
}
