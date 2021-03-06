package com.company;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

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

@SuppressWarnings("WeakerAccess")
public class GraphToGraphicsAdapter {
    Graphics graphics;
    Graph graph;
    Point circlePoint;

    // на самом деле это диаметр, надо както это поправить в классе Круг
    int radius = 20;

    // толщина границы кружка
    int border = 3;

    // шаг между узлами в глубину графа, возможно надо его высчитывать по ширине окна
    int stepX = 100;

    // шаг в высоту между узлами если их несколько на одном шаге
    int stepY = 50;

    //CONSTRUCTOR
    public GraphToGraphicsAdapter(Graph graph, Graphics graphics, Point firstElemPos) {
        this.graph = graph;
        this.graphics = graphics;
        this.circlePoint = firstElemPos;
        firstElemPos.x = firstElemPos.x + 50;
    }

    private void testMeasureLines() {
        graphics.setColor(Color.GREEN);
        graphics.drawLine(0, 800, 500, 800);
        graphics.setColor(Color.RED);
        graphics.drawLine(0, 737, 500, 737);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(0, 700, 500, 700);
        graphics.drawLine(0, 600, 500, 600);
        graphics.drawLine(0, 500, 500, 500);
        graphics.setColor(Color.RED);
        graphics.drawLine(0, 400, 500, 400);
        graphics.setColor(Color.GREEN);
        graphics.drawLine(0, 300, 500, 300);
        graphics.drawLine(0, 200, 500, 200);
        graphics.drawLine(0, 100, 500, 100);
        graphics.drawLine(0, 0, 500, 0);
        graphics.setColor(Color.BLACK);
    }

    public void testdraw() {
//        //TODO тут надо понять алгоритм, как это всё загнать в цикл
//        // как упростить, может вынести какие то элементы в классы
//        // сейчас я думаю что надо круги вынести в отдельный стек массивов,
//        // и отрисовывать их по шагам. т.е. берем сверху первый элемент - это первый шаг, начало пути
//        // далее берем второй элемент стека - это будет массив с узлами прилегающими к первому узлу
//        // далее берем третий элемент стека - это будет массив с узлами прилегающими ко всем элементам из второго шага
//        // и вот тут начинаются проблемы, потому что надо хранить, отрисовывать связи, между узлами
//        // либо их надо записывать в отдельный стек и рисовать потом
//        // (на самом деле рисовать надо первыми связи, а потом узлы, чтобы можно было ребро отрисовать от центра
//        // узла до другого центра узла - так красивее) либо рисовать всё вместе, либо рисовать сначала одну ветку,
//        // затем другую, но как в таком случае отобразить связи к одинаковым узлам?
//
//        // круг 1
//        Circle circle1 = new Circle(circlePoint, Color.RED);
//        circle1.draw(graphics);
//
//        // круг 2
//        // считаем центр для круга 2 на основании координат первого круга
//        Point circle2point = new Point(circlePoint.x + stepX, circlePoint.y - stepY);
//        Circle circle2 = new Circle(circle2point, Color.GREEN);
//        circle2.draw(graphics);
//
//        // линия от первого круга до второго
//        MyLine line1 = new MyLine(circle1, circle2);
//        line1.draw(graphics);
//
//        // круг 3
//        Point circle3point = new Point(circle2point.x, circlePoint.y + stepY);
//        Circle circle3 = new Circle(circle3point, Color.CYAN);
//        circle3.draw(graphics);
//
//        // линия от круга 1 до круга 3
//        MyLine line2 = new MyLine(circle1, circle3);
//        line2.draw(graphics);

//
//        Iterator iterator = graph.getIterator();
//        LinkedNodes linkedNodes;
//        while (iterator.hasNext()) {
//            linkedNodes = graph.getLinkedNodes((String) iterator.next());
//            assert linkedNodes != null;
//            String[] destinationNodes = linkedNodes.getDestinationNodeNames();
//
//            for (int j = 0; j < destinationNodes.length; j++) {
//                Circle circle = new Circle(circlePoint, Color.orange);
//                circle.draw(graphics);
//            }
//        }

        // создаем переменные для цикла
        Iterator iterator = graph.getIterator(); // итератор по графу
        String currentNodeName = null;           // текущий узел, точнее его имя
        LinkedNodes linkedNodes = null;          // связи с текущим узлом
        LinkedList<Circle> previousCircles = new LinkedList<>();    // отрисованные на предыдущем шаге круги

        while (iterator.hasNext()) {
            if (linkedNodes == null) { // срабатывает на первом проходе
                // Рисуем первый узел
                // Получаем ид первого узла
                currentNodeName = (String) iterator.next();
                Circle circle1 = new Circle(circlePoint, Color.orange);
                circle1.draw(graphics);
                // Добавляем его в список чтобы от него рисовать связи к последующим узлам
                previousCircles.add(circle1);
            } else {
                // Сначала думлируем список с которым будем работать
                //noinspection unchecked
                LinkedList<Circle> previousCirclesCopy = (LinkedList<Circle>) previousCircles.clone();
                // И очищаем старый, который будем заполнять текущими узлами
                previousCircles.clear();

                Circle currentCircle; // графическое представление узла
                // В этом цикле для каждого связанного с текущим узла делам круг и рисуем его
                for (String s : linkedNodes.getDestinationNodeNames()) {
                    currentNodeName = s;
                    // Сдвигаем точку выше
                    circlePoint = new Point(circlePoint.x, circlePoint.y - stepY);
                    // Создаем в точке новый круг и рисуем его
                    currentCircle = new Circle(circlePoint, Color.RED);
                    currentCircle.draw(graphics);

                    // отрисовываем все связи с предыдущими кругами
                    for (Circle c : previousCirclesCopy) {
                        MyLine line = new MyLine(c, currentCircle);
                        line.draw(graphics);
                    }
                    // добавляем текущий круг в те, связи с которыми будут отрисованы на следующем шаге
                    previousCircles.add(currentCircle);
                }
            }

            // далее подготовка к следующему шагу графа

            // высчитываем координаты новой точки, основанные на предыдущей
            // пока что просто сдвигаю точку вправо и вниз
            circlePoint = new Point(circlePoint.x + stepX, circlePoint.y + stepY);
            // заполняем список связанных узлов
            linkedNodes = graph.getLinkedNodes(currentNodeName);
        }
    }
}
