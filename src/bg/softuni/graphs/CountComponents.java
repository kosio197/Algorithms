package bg.softuni.graphs;

import java.util.ArrayList;

public class CountComponents {

    static class Node {

        private int name;
        private ArrayList<Node> edge;

        public Node(int Name) {

            this.name = Name;
            this.edge = new ArrayList<>();
        }

        public int getName() {
            return name;
        }

        public void setName(int name) {
            this.name = name;
        }

        public ArrayList<Node> getEdge() {
            return edge;
        }

        public void setEdge(ArrayList<Node> edge) {
            this.edge = edge;
        }
    }

    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    static char map[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'O', 'P', 'Q', 'K', 'J', 'M', 'N', 'L', 'I' };
    static boolean[] visited = new boolean[map.length];
    static int counterConnectedComponents = 0;

    public static void main(String[] args) {

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        ArrayList<Node> graf = new ArrayList<Node>();

        Node A = new Node(0);
        A.edge.add(new Node(3));
        A.edge.add(new Node(5));
        graf.add(A);

        Node D = new Node(3);
        D.edge.add(new Node(0));
        D.edge.add(new Node(5));
        graf.add(D);

        Node F = new Node(5);
        F.edge.add(new Node(0));
        F.edge.add(new Node(3));
        graf.add(F);

        Node G = new Node(6);
        G.edge.add(new Node(2));
        graf.add(G);
        Node C = new Node(2);
        C.edge.add(new Node(6));
        graf.add(C);

        graf.add(new Node(8));// O
        graf.add(new Node(7));// H

        Node K = new Node(11);
        Node J = new Node(12);
        Node M = new Node(13);
        Node N = new Node(14);
        Node L = new Node(15);
        Node I = new Node(16);

        K.edge.add(J);
        K.edge.add(N);
        graf.add(K);

        J.edge.add(K);
        J.edge.add(M);
        J.edge.add(N);
        graf.add(J);

        M.edge.add(J);
        M.edge.add(N);
        M.edge.add(L);
        M.edge.add(I);
        graf.add(M);


        L.edge.add(M);
        L.edge.add(N);
        graf.add(L);


        N.edge.add(K);
        N.edge.add(J);
        N.edge.add(M);
        N.edge.add(L);
        graf.add(N);

        I.edge.add(M);
        graf.add(I);

        Node Q = new Node(10);
        Q.edge.add(new Node(1));
        Q.edge.add(new Node(4));
        Q.edge.add(new Node(9));
        graf.add(Q);

        Node P = new Node(9);
        P.edge.add(new Node(1));
        P.edge.add(new Node(4));
        P.edge.add(new Node(10));
        graf.add(P);

        Node E = new Node(4);
        E.edge.add(new Node(9));
        E.edge.add(new Node(10));
        graf.add(E);

        Node B = new Node(1);
        B.edge.add(new Node(10));
        B.edge.add(new Node(9));
        graf.add(B);

        printGrafComponents(graf);
    }

    private static void printGrafComponents(ArrayList<Node> graf) {

        for (Node node : graf) {
            if (!visited[node.name]) {
                dfs(node);
                System.out.println();
                counterConnectedComponents++;
            }
        }
        System.out.println("Connected Components " + counterConnectedComponents);
    }

    private static void dfs(Node node) {

        if (!visited[node.name]) {

            visited[node.name] = true;
            System.out.print(map[node.name] + " ");
            for (Node n : node.edge) {
                dfs(n);
            }
        }
    }
}
