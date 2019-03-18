package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Класс отвечающий за математическое представление направленного графа
 * Реализация графа представляет собой хеш-таблицу, реализуемую через HashMap
 * где ключем является узлами, а значения ключей - связанные узлы с этим узлом
 * и вес ребер до этого узла, хранящиеся также в хеш-таблице. Таким образом
 * получается массив вида:
 * <p>
 * [
 * "key-NodeName"-[ "NodeName2"-"LineWeight1",
 * "NodeName3"-"LineWeight2"],
 * <p>
 * "key-NodeName2"-["NodeName4"-"LineWeight3"],
 * <p>
 * "key-NodeName3"-["NodeName4"-"LineWeight4"],
 * <p>
 * "key-NodeName4"-[            ]
 * ]
 * <p>
 * методы:
 * мне нужно по имени узла смочь получить все узлы к которым
 * идет направленное ребро графа, а также их вес
 * методо getLinkedNodes возвращает объект позволяющий взаимодействовать со связанными узлами
 * <p>
 * вес ребра графа
 * имя узла ребра
 * <p>
 * наполнить можно методами
 * после выполнения конструктора поле должно быть уже не-null
 * в поле передаем имя узла и узлы с которыми он связана
 * надо ли проверять существуют ли связанные узлы?
 * Если связаный узел не существует то создать его
 * Если существует то ничего с ним не делать
 */
public class Graph {
    //            имя узла | имя связанного узла|вес ребра
    private LinkedHashMap<String, HashMap<String, Integer>> graphLinkedHashMap;


    // CONSTRUCTOR
    public Graph(LinkedHashMap<String, HashMap<String, Integer>> graphLinkedHashMap) {
        this.graphLinkedHashMap = graphLinkedHashMap;
    }

    public Graph() {
        this(new LinkedHashMap<String, HashMap<String, Integer>>());
    }

    /**
     * Добавляет новый узел в граф, если граф с таким именем уже существет то удаляет его связи
     *
     * @param nodeName - имя нового узла
     */
    public void putNode(String nodeName) {
        putNode(nodeName, new HashMap<String, Integer>());
    }

    /**
     * Добавляет новый узел в граф, если граф с таким именем уже существет то заменяет его связи
     *
     * @param nodeName       - имя нового узла
     * @param connectedNodes - хеш-таблица связанных узлов и весов ребер
     */
    public void putNode(String nodeName, HashMap<String, Integer> connectedNodes) {
        graphLinkedHashMap.put(nodeName, connectedNodes);
    }

    /**
     * Добавляет связь к уже существующему узлу, если связь уже существует заменяет её значение
     *
     * @param sourceNode откуда связь выходит
     * @param value      вес ребра связи
     * @param nextNode   куда ребро идет
     */
    public void addLinkedNode(String sourceNode, Integer value, String nextNode) {
        if (!graphLinkedHashMap.containsKey(sourceNode)) {
            putNode(sourceNode);
        }
        if (!graphLinkedHashMap.containsKey(nextNode)) {
            putNode(nextNode);
        }
        graphLinkedHashMap.get(sourceNode).put(nextNode, value);
    }

    /**
     * Из графа возвращает по имени узла все связанные узлы вместе с весами в виде LinkedNodes
     *
     * @param nodeName исходный узел
     * @return linkedNodes в классе которого указаны все связанные узлы и веса.
     */
    public LinkedNodes getLinkedNodes(String nodeName) {
        LinkedNodes linkedNodes = new LinkedNodes();

        linkedNodes.addLinks(graphLinkedHashMap.get(nodeName));

//        Iterator iterator = linkedNodesHashMap.keySet().iterator();
//        //noinspection WhileLoopReplaceableByForEach
//        while (iterator.hasNext()) {
//            //noinspection unchecked
//            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
//            linkedNodes.addLink(entry.getKey(), entry.getValue());
//        }


        return linkedNodes;
    }

    public Iterator getIterator() {
        return graphLinkedHashMap.keySet().iterator();
    }
}
