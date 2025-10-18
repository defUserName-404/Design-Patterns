package editor;

import commands.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Editor {
    public JTextArea textField;
    public String clipboard;
    private final CommandHistory history = new CommandHistory();

    private Action copyAction;
    private Action cutAction;
    private Action pasteAction;
    private Action undoAction;

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BorderLayout());
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField, BorderLayout.CENTER);
        createActions();
        createContextMenu();
        JToolBar toolBar = createToolBar();
        content.add(toolBar, BorderLayout.NORTH);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createActions() {
        Editor editor = this;
        copyAction = new AbstractAction("Copy", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons8-copy-48.png")))) {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                executeCommand(new CopyCommand(editor));
            }
        };
        cutAction = new AbstractAction("Cut", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons8-cut-48.png")))) {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                executeCommand(new CutCommand(editor));
            }
        };
        pasteAction = new AbstractAction("Paste", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons8-paste-48.png")))) {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                executeCommand(new PasteCommand(editor));
            }
        };
        undoAction = new AbstractAction("Undo", new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons8-undo-48.png")))) {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                undo();
            }
        };
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JButton(copyAction));
        toolBar.add(new JButton(cutAction));
        toolBar.add(new JButton(pasteAction));
        toolBar.add(new JButton(undoAction));
        return toolBar;
    }

    private void createContextMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem(copyAction));
        popupMenu.add(new JMenuItem(cutAction));
        popupMenu.add(new JMenuItem(pasteAction));
        popupMenu.add(new JMenuItem(undoAction));
        textField.setComponentPopupMenu(popupMenu);
        createKeyStrokes();
    }

    private void createKeyStrokes() {
        KeyStroke copyKeyStroke = KeyStroke.getKeyStroke("control C");
        KeyStroke cutKeyStroke = KeyStroke.getKeyStroke("control X");
        KeyStroke pasteKeyStroke = KeyStroke.getKeyStroke("control V");
        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke("control Z");
        InputMap inputMap = textField.getInputMap();
        inputMap.put(copyKeyStroke, "Copy");
        inputMap.put(cutKeyStroke, "Cut");
        inputMap.put(pasteKeyStroke, "Paste");
        inputMap.put(undoKeyStroke, "Undo");
        ActionMap actionMap = textField.getActionMap();
        actionMap.put("Copy", copyAction);
        actionMap.put("Cut", cutAction);
        actionMap.put("Paste", pasteAction);
        actionMap.put("Undo", undoAction);
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void undo() {
        if (history.isEmpty()) return;
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}