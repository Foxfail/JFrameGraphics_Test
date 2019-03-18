package com.company;

import java.awt.*;

/**
 * Класс который поможет мне взаимодействовать и отрисовывать круги на форме
 * Он берет на себя ответственность за отрисовку круга по заданным параметрам
 * Реализует такие действия, которые нельзя сделать со стандартной графикой
 * Такие как отрисовка круга с радиусом по заданным координатам центра
 * Также можно указать толщину границы, и цвет внутренностей круга
 */
public class Circle {
    private Color color;
    private int border, radius;
    private Point center;

    public Circle(Point center, int radius, int border, Color color) {
        this.color = color;
        this.border = border;
        this.center = center;
        this.radius = radius;
    }

    public Circle(Point center, Color color) {
        this.color = color;
        this.center = center;

        // установка параметров по умолчанию
        this.border = 3;
        this.radius = 20;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics graphics) {
        Color defaultColor = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillOval(
                center.x - (radius / 2) - border,
                center.y - (radius / 2) - border,
                (radius) + (border * 2),
                (radius) + (border * 2));
        graphics.setColor(color);
        graphics.fillOval(
                center.x - (radius / 2),
                center.y - (radius / 2),
                (radius),
                (radius));
        graphics.setColor(defaultColor);
    }

    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }
}
