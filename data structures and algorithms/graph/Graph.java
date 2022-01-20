package com.company;

public class Graph {
    private Vertex[] vertexList;
    private int[][] adjMat;
    private boolean directed;
    private int nVerts;
    private int n;

    public Graph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        vertexList = new Vertex[n];
        adjMat = new int[n][n];
        nVerts = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        if (!directed) {
            adjMat[end][start] = 1;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].visited) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {
        vertexList[0].visited = true;
        Stack stack = new Stack(n);
        displayVertex(0);
        stack.push(0);

        while(!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].visited = true;
                stack.push(v);
            }
            displayVertex(v);
        }
        unVisitVertexes();
    }

    public void bfs() throws Exception {
        vertexList[0].visited = true;
        Queue queue = new Queue(n);
        displayVertex(0);
        queue.inQueue(0);
        int v2;

        while(!queue.isEmpty()) {
            int v = queue.deQueue();
            while((v2 = getAdjUnvisitedVertex(v)) != -1) {
                vertexList[v2].visited = true;
                queue.inQueue(v2);
                displayVertex(v2);
            }
        }
        unVisitVertexes();
    }

    public void unVisitVertexes() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].visited = false;
        }
    }

    public void floyd() {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (adjMat[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (adjMat[k][i] == 1) {
                            adjMat[k][j] = 1;
                        }
                    }
                }
            }
        }
        showAdjMat();
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void showAdjMat() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
