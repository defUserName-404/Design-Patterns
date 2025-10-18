package domain;

import commands.Command;

import javax.swing.*;

public interface EditorApi {
    JTextArea getTextField();

    String getClipboard();

    void setClipboard(String clipboard);

    void executeCommand(Command command);

    void undo();

        String getContent();

        void setContent(String content);

        boolean isDirty();

        void setDirty(boolean isDirty);

    }
