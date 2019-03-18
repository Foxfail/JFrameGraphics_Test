package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame();
        myJFrame.setBounds(600, 200, 700, 700);
        myJFrame.showWindow();

        Graph graph = new Graph();
        graph.putNode("first");
        graph.addLinkedNode("first", 3, "secondFromFirst");
        graph.addLinkedNode("first", 4, "thirdFromFirst");
        graph.addLinkedNode("secondFromFirst", 5, "Forth");
        graph.addLinkedNode("thirdFromFirst", 7, "Forth");

        myJFrame.setOnButtonClickListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // расчет точки рисования
                int y = myJFrame.getContentPane().getHeight() / 2;
                Point firstElemPos = new Point(10, y);

                // сбо всего воедино и рисование
                GraphToGraphicsAdapter graphToGraphicsAdapter = new GraphToGraphicsAdapter(graph, myJFrame.getPanelGraphics(), firstElemPos);
                graphToGraphicsAdapter.testdraw();
            }
        });
    }
}




