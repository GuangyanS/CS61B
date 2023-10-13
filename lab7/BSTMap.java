import java.util.Set;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private Node root;
    private int size = 0;
    public void clear() {
        root = null;
        size = 0;
    }
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }
    private boolean containsKey(Node T, K key) {
        if (T == null)
            return false;
        int cmp = key.compareTo(T.key);
        if (cmp == 0) {
            return true;
        }
        else if (cmp < 0){
            return containsKey(T.left, key);
        }
        else {
            return containsKey(T.right, key);
        }
    }
    public V get(K key) {
        return get(root, key);
    }
    private V get(Node T, K key) {
        if (T == null)
            return null;
        int cmp = key.compareTo(T.key);
        if (key.equals(T.key)) {
            return T.value;
        }
        else if (cmp < 0){
            return get(T.left, key);
        }
        else {
            return get(T.right, key);
        }
    }

    public int size() {
        return size;
    }
    public void put(K key, V value) {
        root = put(root, key, value);
        size += 1;
    }
    private Node put(Node T, K key, V value) {
        if (T == null)
            return new Node(key, value);
        int cmp = key.compareTo(T.key);
        if (cmp < 0) {
            T.left = put(T.left, key, value);
        } else if (cmp > 0) {
            T.right = put(T.right, key, value);
        } else {
            T.value = value;
        }
        return T;
    }
    public V remove(K key) {
        return null;
    }
    public V remove(K key, V value) {
        return null;
    }
    public Set<K> keySet() {
        return null;
    }
    public Iterator<K> iterator() {
        return null;
    }
    public void printInOrder() {
        printInOrder(root);
    }
    private void printInOrder(Node T) {
        if (T == null) {
            return;
        }
        printInOrder(T.left);
        System.out.println(T.key.toString() + " -> " + T.value.toString());
        printInOrder(T.right);
    }
    private class Node {
        public final K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }
}
