package com.company;

import java.util.HashMap;

/**
 * данный класс представляет собой математическое представление связей узлов (узел назначения и вес ребра)
 * используется для того чтобы лучше понимать связи узлов и
 * реализации говорящих методов типа getWeight и getDestinationNodeName, чтобы не заморачиваться с HashMap напрямую
 * <p>
 * У связанных узлов обязательно есть узел из которого идет ребро(родительский узел) и узел, к которому идет ребро (узел-назначение)
 * нужен ли родительский узел как поле?
 * <p>
 * реализуется через хеш-таблицу, где ключ - имя узла до которого идет связь, а значение вес ребра
 */
public class LinkedNodes {
    private HashMap<String, Integer> linkedNodes;

    public LinkedNodes(HashMap<String, Integer> linkedNodes) {
        this.linkedNodes = linkedNodes;
    }

    public LinkedNodes() {
        this(new HashMap<>());
    }
}
