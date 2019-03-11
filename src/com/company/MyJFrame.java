package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * В этом классе реализовано окно и все компоненты окна
 * Компоненты окна добавляются в конструкторе
 * <p>
 * За отрисовку графа отвечает класс MyJPanel
 */

public class MyJFrame extends JFrame {
    private MyJPanel panel;
    private Button button1;

    //CONSTRUCTOR
    public MyJFrame() throws HeadlessException {
        super();
        panel = new MyJPanel(this);

        add(panel);
        panel.addMouseListener(panel);
        panel.addMouseMotionListener(panel);

        button1 = new Button("Кнопа");

        add(button1, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }

    public void showWindow() {
        setVisible(true);
    }

    public Graphics getPanelGraphics() {
        return panel.getGraphics();
    }

    public void setOnButtonClickListener(ActionListener listener) {
        button1.addActionListener(listener);
    }
}
