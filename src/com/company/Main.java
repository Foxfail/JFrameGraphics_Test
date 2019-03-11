package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame();
        myJFrame.showWindow();

        Graph graph = new Graph();
        graph.putNode("first");
        graph.addLinkedNode("first", 3, "secondFromFirst");
        graph.addLinkedNode("first", 4, "thirdFromFirst");
        graph.addLinkedNode("secondFromFirst", 5, "ForthFromSecond");
        graph.addLinkedNode("thirdFromFirst", 7, "ForthFromThird");


        int y = myJFrame.getHeight() / 2;
        Point firstElemPos = new Point(10, y);

        GraphToGraphicsAdapter graphToGraphicsAdapter = new GraphToGraphicsAdapter(graph, myJFrame.getPanelGraphics(), firstElemPos);

        myJFrame.setOnButtonClickListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphToGraphicsAdapter.testdraw();
            }
        });
    }
}




