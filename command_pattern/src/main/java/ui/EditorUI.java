package ui;

import commands.CopyCommand;
import commands.CutCommand;
import commands.PasteCommand;
import domain.EditorApi;
import ui.themes.DarkTheme;
import ui.themes.LightTheme;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.util.Objects;

public class EditorUI {

    private final EditorApi editor;
    private Action copyAction;
    private Action cutAction;
    private Action pasteAction;
    private Action undoAction;
    private JFrame frame;

    public EditorUI(EditorApi editor) {
        this.editor = editor;
    }

    public void init() {
        frame = new JFrame("Text Editor");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(editor.getTextField());
        content.add(scrollPane, BorderLayout.CENTER);
        createActions();
        createContextMenu();
        JToolBar toolBar = createToolBar(scrollPane);
        content.add(toolBar, BorderLayout.NORTH);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createActions() {
        copyAction = createAction("Copy", "/icons8-copy-48.png");
        cutAction = createAction("Cut", "/icons8-cut-48.png");
        pasteAction = createAction("Paste", "/icons8-paste-48.png");
        undoAction = createAction("Undo", "/icons8-undo-48.png");
    }

    private Action createAction(String name, String iconPath) {
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                switch (name) {
                    case "Copy":
                        editor.executeCommand(new CopyCommand(editor));
                        break;
                    case "Cut":
                        editor.executeCommand(new CutCommand(editor));
                        break;
                    case "Paste":
                        editor.executeCommand(new PasteCommand(editor));
                        break;
                    case "Undo":
                        editor.undo();
                        break;
                }
            }
        };
        action.putValue(Action.NAME, name);
        action.putValue(Action.LARGE_ICON_KEY, new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(iconPath))).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        action.putValue(Action.SHORT_DESCRIPTION, name);
        return action;
    }

    private JToolBar createToolBar(JScrollPane scrollPane) {
        JToolBar toolBar = new JToolBar();
        JButton copyButton = new JButton(copyAction);
        copyButton.setText(null);
        toolBar.add(copyButton);
        JButton cutButton = new JButton(cutAction);
        cutButton.setText(null);
        toolBar.add(cutButton);
        JButton pasteButton = new JButton(pasteAction);
        pasteButton.setText(null);
        toolBar.add(pasteButton);
        JButton undoButton = new JButton(undoAction);
        undoButton.setText(null);
        toolBar.add(undoButton);
        toolBar.addSeparator();
        JToggleButton lineNumberButton = new JToggleButton("Line Number");
        TextLineNumber textLineNumber = new TextLineNumber(editor.getTextField());
        lineNumberButton.addActionListener(e -> {
            if (lineNumberButton.isSelected()) {
                scrollPane.setRowHeaderView(textLineNumber);
            } else {
                scrollPane.setRowHeaderView(null);
            }
        });
        toolBar.add(lineNumberButton);
        JComboBox<String> themeComboBox = getThemeComboBox();
        toolBar.add(themeComboBox);
        return toolBar;
    }

    private JComboBox<String> getThemeComboBox() {
        String[] themes = {"Metal Light", "Metal Dark"};
        JComboBox<String> themeComboBox = new JComboBox<>(themes);
        themeComboBox.setMaximumSize(themeComboBox.getPreferredSize());
        themeComboBox.addActionListener(e -> {
            String selectedTheme = (String) themeComboBox.getSelectedItem();
            try {
                if ("Metal Dark".equals(selectedTheme)) {
                    MetalLookAndFeel.setCurrentTheme(new DarkTheme());
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                } else {
                    MetalLookAndFeel.setCurrentTheme(new LightTheme());
                    UIManager.setLookAndFeel(new MetalLookAndFeel());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(frame);
        });
        return themeComboBox;
    }

    private void createContextMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem(copyAction));
        popupMenu.add(new JMenuItem(cutAction));
        popupMenu.add(new JMenuItem(pasteAction));
        popupMenu.add(new JMenuItem(undoAction));
        editor.getTextField().setComponentPopupMenu(popupMenu);
        createKeyStrokes();
    }

    private void createKeyStrokes() {
        KeyStroke copyKeyStroke = KeyStroke.getKeyStroke("control C");
        KeyStroke cutKeyStroke = KeyStroke.getKeyStroke("control X");
        KeyStroke pasteKeyStroke = KeyStroke.getKeyStroke("control V");
        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke("control Z");
        InputMap inputMap = editor.getTextField().getInputMap();
        inputMap.put(copyKeyStroke, "Copy");
        inputMap.put(cutKeyStroke, "Cut");
        inputMap.put(pasteKeyStroke, "Paste");
        inputMap.put(undoKeyStroke, "Undo");
        ActionMap actionMap = editor.getTextField().getActionMap();
        actionMap.put("Copy", copyAction);
        actionMap.put("Cut", cutAction);
        actionMap.put("Paste", pasteAction);
        actionMap.put("Undo", undoAction);
    }
}
