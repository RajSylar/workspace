package com.ip.sylar.disjointset;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    Map<Integer, Node> map = new HashMap<>();

    class Node {
        private int data;

        private Node parent;

        private int rank;

    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
    }

    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    public void union(int data1, int data2) {
        Node parent1 = findSet(map.get(data1));
        Node parent2 = findSet(map.get(data2));

        if (parent1.data == parent2.data) {
            return;
        } else {
            if (parent1.rank > parent2.rank) {
                parent2.parent = parent1;
            } else if (parent1.rank < parent2.rank) {
                parent1.parent = parent2;
            } else {
                parent1.rank = parent1.rank + 1;
                parent2.parent = parent1;
            }
        }
    }

    public Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node)
            return parent;

        node.parent = findSet(node.parent);
        return node.parent;
    }

    public int findSet(int data) {
        return findSet(map.get(data)).data;
    }
}
