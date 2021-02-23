package com.algorithm.graph;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: jiangjiabin
 * @date: Create in 23:47 2021/1/17
 * @description:
 * 邻接表实现图（链表）
 * 空间复杂度：O(V+E)
 * 时间复杂度：
 * 建图O(V*E)
 * 查看两点是否相邻：O(degree(v))
 * 求一个点的所有临边：O(degree(v))
 * 瓶颈：建图和查看两节点是否相邻
 */
public class AdjList {

    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public AdjList(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative");
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
            E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-negative");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                if (a == b) throw new IllegalArgumentException("self loop is detected");
                if (adj[a].contains(b)) {
                    throw new IllegalArgumentException("parallel edges is detected");
                }

                adj[a].add(b);
                adj[b].add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AdjList adjList = new AdjList("E:\\SoftWare\\IDEA\\ideaProjects\\algorithm\\src\\main\\resources\\g.txt");
        System.out.println(adjList);
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + "is invalid");
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 两个顶点是否相连
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v].contains(w);
    }

    /**
     * 返回相邻的顶点
     *
     * @param v
     * @return
     */
    public List<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * 返回一个顶点的度（邻边的条数）
     * @param v
     * @return
     */
    public int degree(int v) {
        return adj(v).size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int v = 0; v < V; v ++){
            sb.append(String.format("%d : ", v));
            for(int w : adj[v])
                sb.append(String.format("%d ", w));
            sb.append('\n');
        }
        return sb.toString();
    }
}
