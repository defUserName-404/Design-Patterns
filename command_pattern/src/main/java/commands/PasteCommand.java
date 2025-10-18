package commands;

import domain.EditorApi;

public class PasteCommand extends Command {

    public PasteCommand(EditorApi editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.getClipboard() == null || editor.getClipboard().isEmpty()) return false;
        backup();
        editor.getTextField().replaceSelection(editor.getClipboard());
        return true;
    }
}
