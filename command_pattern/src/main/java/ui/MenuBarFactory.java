package ui;

import javax.swing.*;

public class MenuBarFactory {

    public static JMenuBar createMenuBar(Action newAction, Action openAction, Action saveAction,
                                         Action copyAction, Action cutAction, Action pasteAction, Action undoAction) {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem(newAction));
        fileMenu.add(new JMenuItem(openAction));
        fileMenu.add(new JMenuItem(saveAction));
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(new JMenuItem(copyAction));
        editMenu.add(new JMenuItem(cutAction));
        editMenu.add(new JMenuItem(pasteAction));
        editMenu.add(new JMenuItem(undoAction));
        menuBar.add(editMenu);
        return menuBar;
    }
}
