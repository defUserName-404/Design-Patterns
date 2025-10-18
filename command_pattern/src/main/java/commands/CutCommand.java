package commands;

import domain.EditorApi;

public class CutCommand extends Command {

    public CutCommand(EditorApi editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.getTextField().getSelectedText() == null || editor.getTextField().getSelectedText().isEmpty()) return false;
        backup();
        String source = editor.getTextField().getText();
        editor.setClipboard(editor.getTextField().getSelectedText());
        editor.getTextField().setText(cutString(source));
        return true;
    }

    private String cutString(String source) {
        String start = source.substring(0, editor.getTextField().getSelectionStart());
        String end = source.substring(editor.getTextField().getSelectionEnd());
        return start + end;
    }
}
