package app;

import domain.Editor;
import ui.EditorUI;

public class EditorApplication {

    public static void main(String[] args) {
        Editor editor = new Editor();
        EditorUI editorUI = new EditorUI(editor);
        editorUI.init();
    }
}
