package com.company;

import java.awt.*;

/**
 * класс для представления линии в виде объекта
 * хранит в себе координаты, цвет, толщину
 * и позволяет отрисовывать себя где угодно принимая объект графики
 */
public class MyLine {
    Point p1, p2; // начальные координаты и координаты конца
    BasicStroke stroke; // тут хранится тощина линии
    Color color;

    public MyLine(Point p1, Point p2, Color color, int strokeWidth) {
        this.p1 = p1;
        this.p2 = p2;
        this.stroke = new BasicStroke(strokeWidth);
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(stroke);
        graphics.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}
