package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {
        MyJFrame jFrame = new MyJFrame();
        MyJPanel jPanel = new MyJPanel(jFrame);

//        jFrame.addMouseListener(jPanel);
        jFrame.add(jPanel);
        jPanel.addMouseListener(jPanel);
        jPanel.addMouseMotionListener(jPanel);

        jFrame.pack();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}

class MyJFrame extends JFrame {

}


class MyJPanel extends JPanel implements MouseInputListener {
    int[] xPoints = new int[]{65, 122, 77, 20};
    int[] yPoints = new int[]{226, 258, 341, 310};

    int x = 65;
    int y = 65;
    int ovalWidth = 20;
    int ovalHeight = 20;

    JFrame jFrame;

    public MyJPanel(MyJFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
//            g.drawPolygon(x,y,x.length);
        g.drawOval(x, y, ovalWidth, ovalHeight);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked");
//            Point ePoint= e.getPoint();
//            x = new int[]{ePoint.x, 122, 77, 20};
//            y = new int[]{ePoint.y, 258, 341, 310};
//        x = e.getX() - (ovalWidth / 2);
//        y = e.getY() - (ovalHeight / 2);
//        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
//            int mouseX = MouseInfo.getPointerInfo().getLocation().x - this.getLocation().x;
//            int mouseY = MouseInfo.getPointerInfo().getLocation().y - this.getLocation().y;
//            x = mouseX;
//            y = mouseY;
//            repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("drag");
        x = e.getX() - (ovalWidth / 2);
        y = e.getY() - (ovalHeight / 2);
        getGraphics().fillOval(x,y,ovalWidth,ovalHeight);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("moved");
        x = e.getX() - (ovalWidth / 2);
        y = e.getY() - (ovalHeight / 2);

        Graphics g = getGraphics();
        g.setColor(Color.RED);
        g.drawOval(x,y,ovalWidth,ovalHeight);
        repaint();
    }
}
