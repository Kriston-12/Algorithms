package OrderedListAndDisjointedSet;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {

    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public class UnionFindSet<V> {

        public HashMap<V, Element<V>> elementMap; // V是value，Element<V> 是V对应的圈

        public HashMap<Element<V>, Element<V>> fatherMap; // 第二个element是第一个的父

        public HashMap<Element<V>, Integer> sizeMap; // Integer 表示每个集合代表元素value的大小

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public Element<V> findHead(Element<V> element) {
            Stack<Element<V>> stack = new Stack<>();
            while (fatherMap.get(element) != element) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return (findHead(elementMap.get(a)) == findHead(elementMap.get(b)));
            }
            return false;
        }

        public void Union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> af = findHead(elementMap.get(a));
                Element<V> bf = findHead(elementMap.get(b));
                if (af != bf) {
                    Element<V> big = sizeMap.get(af) >= sizeMap.get(bf) ? af : bf;
                    Element<V> small = af == big ? bf : af;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                    sizeMap.remove(small);
                }
            }
        }
    }

}
