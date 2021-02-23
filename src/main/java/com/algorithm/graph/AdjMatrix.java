package com.algorithm.graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: jiangjiabin
 * @date: Create in 21:25 2021/1/17
 * @description: 简单图: 没有自环、平行边
 * 邻接矩阵表示图
 * 建图：O(E)
 * 查看两点是否相邻：O(1)
 * 查看点的所有邻边：O(V)
 * 瓶颈：
 * 空间复杂度：O(V^2)
 * 求一个点的相邻节点O(V)
 * -----
 * V是顶点个数
 * E是边的条数
 */
public class AdjMatrix {

    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrix(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            V = scanner.nextInt();
            if (V < 0) throw new IllegalArgumentException("V must be non-negative");
            adj = new int[V][V];
            E = scanner.nextInt();
            if (E < 0) throw new IllegalArgumentException("E must be non-negative");
            for (int i = 0; i < E; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                if (a == b) throw new IllegalArgumentException("self loop is detected");
                if (adj[a][b] == 1) {
                    throw new IllegalArgumentException("parallel edges is detected");
                }

                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("E:\\SoftWare\\IDEA\\ideaProjects\\algorithm\\src\\main\\resources\\g.txt");
        System.out.println(adjMatrix);
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
     * 是否相连
     *
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return adj[v][w] == 1;
    }

    /**
     * 返回相邻的顶点
     *
     * @param v
     * @return
     */
    public List<Integer> adj(int v) {
        validateVertex(v);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) result.add(i);
        }
        return result;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                sb.append(String.format("%d ", adj[i][j]));
            sb.append('\n');
        }
        return sb.toString();
    }

}
