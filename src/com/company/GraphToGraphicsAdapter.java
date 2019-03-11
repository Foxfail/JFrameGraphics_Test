package com.company;

import java.awt.*;

/**
 * Этот класс помогает перевести граф в его графическое представление
 * <p>
 * То есть я передаю в него объект "узел" и объект "графика", а он на графике делает кружочек который показывает узел
 * затем передаю объект LinkedNodes и Graphics, а мне возвращается графика с линией и кружочками
 * <p>
 * но мне нужно откуда то брать координаты кружочков. Кто это будет считать форма, граф?
 * Скорее это функционал как раз адаптера.
 * Тогда адаптер должен иметь всю информацию об отрисованных уже объектах.
 * Какая это информация? Координаты только кружочков или ещё и линий?
 * координат кружочков достаточно, но если они уже нарисованы?
 * Значит надо передавать в этот класс объекты не узлов по отдельности, а весь граф целиком.
 * <p>
 * Значит принимаю граф, начинаю разбирать его на узлы, вычисляю лучшие позиции для узлов(padding между ними)
 * Затем когда все координаты расчитаны можно уже брать графику и отрисовывать её.
 * <p>
 * Линии
 * Линии должны идти к краю кружочка, а не к центру. То есть координаты кружочка не подойдут.
 * надо отнимать радиус кружочка от линии с двух сторон.
 * <p>
 * Расстояние между кружками
 * Для первого узла позиция заранее определена,
 * последующий узел
 * если он один то располагоается горизонтально вправо на некое расстояние
 * если узлов несколько то они располагаются на такое же расстояние вправо,
 * если узлов четное количество
 * то они должены быть отклонение от центральной оси равномерно друг от друга
 * <p>
 * если узлов нечетное количество
 * то один узел должен быть центральным
 * а остальные отклонены от него на некоторое расстояние
 * <p>
 * Следовательно в этом классе я буду оперировать несколькими значениями:
 * Объект графики
 * Объект графа
 * Позиция первого элемента
 * Радиус узлов
 * Расстояние вправо
 * Расстояние вверх/вниз между несколькими узлами одного шага
 */

public class GraphToGraphicsAdapter {
    Graphics graphics;
    Graph graph;
    Point firstElemPos;


    //CONSTRUCTOR
    public GraphToGraphicsAdapter(Graph graph, Graphics graphics, Point firstElemPos) {
        this.graph = graph;
        this.graphics = graphics;
        this.firstElemPos = firstElemPos;
    }

    public void testdraw() {
        graphics.fillOval(firstElemPos.x, firstElemPos.y, 10, 10);
    }
}