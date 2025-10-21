package app;

import domain.Editor;
import services.FileService;
import ui.EditorUI;

public class EditorApplication {

    public static void main(String[] args) {
        Editor editor = new Editor();
        FileService fileService = new FileService(editor);
        EditorUI editorUI = new EditorUI(editor, fileService);
        editorUI.init();
    }
}
