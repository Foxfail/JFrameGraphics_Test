package com.company;

import java.util.HashMap;

/**
 * данный класс представляет собой математическое представление связей узлов (узел назначения и вес ребра)
 * используется для того чтобы лучше представлять связи между узлами
 * также реализует говорящие методы типа getWeight и getDestinationNodeName, чтобы не заморачиваться с HashMap напрямую
 *
 * У связанных узлов обязательно есть узел из которого идет ребро(родительский узел) и узел, к которому идет ребро (узел-назначение)
 *
 * нужен ли родительский узел как поле? возможно он излишен, но пусть будет, друг понадобится
 * нет, не нужен. он лишьусложняет создание и хранение объекта
 *
 * реализуется через хеш-таблицу, где ключ - имя узла до которого идет связь, а значение вес ребра
 *
 */
public class LinkedNodes {
    private HashMap<String, Integer> linkedNodes;

    //CONSTRUCTORS
    public LinkedNodes(HashMap<String, Integer> linkedNodes) {
        this.linkedNodes = linkedNodes;
    }

    public LinkedNodes(Integer value, String destinationNode) {
        linkedNodes = new HashMap<>();
        linkedNodes.put(destinationNode, value);
    }

    public LinkedNodes() {
        this(new HashMap<>());
    }

    //GETTERS

    /**
     * получает вес ребра между узлом и указанным узлом
     *
     * @param destinationNode узел до котрого получить ребро
     * @return вес ребра
     */
    public Integer getWeight(String destinationNode) {
        return linkedNodes.get(destinationNode);
    }

    /**
     * получает массив всех связанных узлов с исходным узлом
     *
     * @return массив связанных узлов
     */
    public String[] getDestinationNodeNames() {
        return linkedNodes.keySet().toArray(String[]::new);
    }

    //SETTERS

    /**
     * добавляет связь/ребро, если связь уже есть, то заменяет значение на новое
     *
     * @param destinationNode до какого узла ребро
     * @param weight          вес ребра
     */
    public void addLink(String destinationNode, int weight) {
        linkedNodes.put(destinationNode, weight);
    }

}
