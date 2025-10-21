package ui;

import commands.CopyCommand;
import commands.CutCommand;
import commands.PasteCommand;
import domain.EditorApi;
import services.FileService;
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

    private final FileService fileService;
    private Action newAction;
    private Action openAction;
    private Action saveAction;

    public EditorUI(EditorApi editor, FileService fileService) {
        this.editor = editor;
        this.fileService = fileService;
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
        JMenuBar menuBar = MenuBarFactory.createMenuBar(newAction, openAction, saveAction, copyAction, cutAction, pasteAction, undoAction);
        frame.setJMenuBar(menuBar);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        editor.getTextField().getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateTitle();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateTitle();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateTitle();
            }
        });

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (editor.isDirty()) {
                    int choice = JOptionPane.showConfirmDialog(frame,
                            "Do you want to save the changes?", "Save Changes",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (choice == JOptionPane.YES_OPTION) {
                        fileService.saveFile();
                        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    } else if (choice == JOptionPane.NO_OPTION) {
                        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    } else {
                        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    }
                } else {
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                }
            }
        });

        frame.setVisible(true);
    }

    private void updateTitle() {
        if (editor.isDirty()) {
            frame.setTitle("* Text Editor");
        } else {
            frame.setTitle("Text Editor");
        }
    }

    private void createActions() {
        newAction = createAction("New", "/icons8-add-new-48.png");
        openAction = createAction("Open", "/icons8-open-48.png");
        saveAction = createAction("Save", "/icons8-save-48.png");
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
                    case "New":
                        if (editor.isDirty()) {
                            int choice = JOptionPane.showConfirmDialog(frame,
                                    "Do you want to save the changes?", "Save Changes",
                                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                            if (choice == JOptionPane.YES_OPTION) {
                                fileService.saveFile();
                                fileService.newFile();
                            } else if (choice == JOptionPane.NO_OPTION) {
                                fileService.newFile();
                            }
                        } else {
                            fileService.newFile();
                        }
                        break;
                    case "Open":
                        fileService.openFile();
                        break;
                    case "Save":
                        fileService.saveFile();
                        break;
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
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(iconPath)));
        action.putValue(Action.LARGE_ICON_KEY, new ImageIcon(icon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        action.putValue(Action.SMALL_ICON, new ImageIcon(icon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        action.putValue(Action.SHORT_DESCRIPTION, name);
        return action;
    }

    private JToolBar createToolBar(JScrollPane scrollPane) {
        JToolBar toolBar = new JToolBar();
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

    private void createToolbarButtons(JToolBar toolBar, Action newAction, Action openAction, Action saveAction) {
        JButton newButton = new JButton(newAction);
        newButton.setText(null);
        toolBar.add(newButton);
        JButton openButton = new JButton(openAction);
        openButton.setText(null);
        toolBar.add(openButton);
        JButton saveButton = new JButton(saveAction);
        saveButton.setText(null);
        toolBar.add(saveButton);
        toolBar.addSeparator();
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
        KeyStroke newKeyStroke = KeyStroke.getKeyStroke("control N");
        KeyStroke openKeyStroke = KeyStroke.getKeyStroke("control O");
        KeyStroke saveKeyStroke = KeyStroke.getKeyStroke("control S");
        KeyStroke copyKeyStroke = KeyStroke.getKeyStroke("control C");
        KeyStroke cutKeyStroke = KeyStroke.getKeyStroke("control X");
        KeyStroke pasteKeyStroke = KeyStroke.getKeyStroke("control V");
        KeyStroke undoKeyStroke = KeyStroke.getKeyStroke("control Z");
        InputMap inputMap = editor.getTextField().getInputMap();
        inputMap.put(newKeyStroke, "New");
        inputMap.put(openKeyStroke, "Open");
        inputMap.put(saveKeyStroke, "Save");
        inputMap.put(copyKeyStroke, "Copy");
        inputMap.put(cutKeyStroke, "Cut");
        inputMap.put(pasteKeyStroke, "Paste");
        inputMap.put(undoKeyStroke, "Undo");
        ActionMap actionMap = editor.getTextField().getActionMap();
        actionMap.put("New", newAction);
        actionMap.put("Open", openAction);
        actionMap.put("Save", saveAction);
        actionMap.put("Copy", copyAction);
        actionMap.put("Cut", cutAction);
        actionMap.put("Paste", pasteAction);
        actionMap.put("Undo", undoAction);
    }
}
