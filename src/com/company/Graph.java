package com.company;

import java.util.HashMap;

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
 * "key-NodeName4"-[   ]
 * ]
 * <p>
 * методы:
 * мне нужно по имени узла смочь получить все узлы к которым
 * идет направленное ребро графа, а также их вес
 * <p>
 * вес ребра графа
 * имя узла ребра
 * <p>
 * наполнить можно методами
 * после выполнения конструктора поле должно быть уже не-null
 * в поле преедаем имя узла и узлы с которыми он связана
 * надо ли проверять существуют ли связанные узлы?
 * Если связаный узел не существует то создать его
 * Если существует то ничего с ним не делать
 */
public class Graph {
    //            имя узла | имя связанного узла|вес ребра
    private HashMap<String, HashMap<String, Integer>> graphHashMap;

    // CONSTRUCTOR
    public Graph(HashMap<String, HashMap<String, Integer>> graphHashMap) {
        this.graphHashMap = graphHashMap;
    }

    public Graph() {
        this(new HashMap<String, HashMap<String, Integer>>());
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
        graphHashMap.put(nodeName, connectedNodes);
    }


    public HashMap<String, Integer> getRelatedNodes(String nodeName) {
        return graphHashMap.get(nodeName);
    }
}
