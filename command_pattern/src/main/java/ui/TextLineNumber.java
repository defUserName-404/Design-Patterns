package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import java.awt.*;

public class TextLineNumber extends JComponent implements DocumentListener {
    private final JTextArea textArea;
    private final FontMetrics fontMetrics;
    private int lastDigit;

    public TextLineNumber(JTextArea textArea) {
        this.textArea = textArea;
        fontMetrics = textArea.getFontMetrics(textArea.getFont());
        setBorder(new EmptyBorder(0, 5, 0, 5));
        textArea.getDocument().addDocumentListener(this);
        updateWidth();
    }

    private void updateWidth() {
        int lineCount = textArea.getLineCount();
        int digits = String.valueOf(lineCount).length();
        if (digits != lastDigit) {
            lastDigit = digits;
            int width = fontMetrics.charWidth('0') * digits + getInsets().left + getInsets().right;
            setPreferredSize(new Dimension(width, 0));
            revalidate();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());
        int start = textArea.viewToModel(getVisibleRect().getLocation());
        int end = textArea.viewToModel(new Point(getVisibleRect().x, getVisibleRect().y + getVisibleRect().height));
        Element root = textArea.getDocument().getDefaultRootElement();
        int startLine = root.getElementIndex(start);
        int endLine = root.getElementIndex(end);
        for (int i = startLine; i <= endLine; i++) {
            String lineNumber = String.valueOf(i + 1);
            try {
                int y = textArea.modelToView(root.getElement(i).getStartOffset()).y + fontMetrics.getAscent();
                g.drawString(lineNumber, getInsets().left, y);
            } catch (Exception e) {
                // ignore
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateWidth();
        repaint();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateWidth();
        repaint();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // not needed
    }
}
