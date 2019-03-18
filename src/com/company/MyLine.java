package com.company;

import java.awt.*;

/**
 * класс для представления линии в виде объекта
 * хранит в себе координаты, цвет, толщину
 * и позволяет отрисовывать себя где угодно принимая объект графики
 *
 * можно модифицировать как класс графического ребра, который будет принимать два круга
 * брать из них координаты и цвет, и по ним уже считать координаты линии. толщину
 * менять не буду. также можно реализовать метод типа changeColor
 * который будет менять цвет линии(просто перерисовывать поверх)
 *
 */
public class MyLine {
    private Point p1, p2; // начальные координаты и координаты конца
    private BasicStroke stroke; // тут хранится тощина линии
    private Color color;
    private int strokeWidth;


    public MyLine(Point p1, Point p2, Color color, int strokeWidth) {
        this.p1 = p1;
        this.p2 = p2;
        this.stroke = new BasicStroke(strokeWidth);
        this.color = color;
        this.strokeWidth = strokeWidth;
    }

    public MyLine(Circle startCircle, Circle endCircle) {
        // Устанавливаем параметры по умолчанию
        this.stroke = new BasicStroke(2);
        this.strokeWidth = 2;
        this.color = Color.BLACK;

        // Считаем начальную и конечную точки линии
        Point startCircleCenter = startCircle.getCenter();
        this.p1 = new Point(
                startCircleCenter.x + (startCircle.getRadius() / 2) + strokeWidth,
                startCircleCenter.y);

        Point endCircleCenter = endCircle.getCenter();
        this.p2 = new Point(
                endCircleCenter.x - (endCircle.getRadius() / 2) - strokeWidth,
                endCircleCenter.y
        );
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor(Graphics graphics, Color color) {
        this.color = color;
        draw(graphics);
    }

    public void draw(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(stroke);
        graphics.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}
