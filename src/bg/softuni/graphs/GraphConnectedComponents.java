package bg.softuni.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class GraphConnectedComponents {

    static class Node implements Comparable<Node> {

        public final int nodeName;
        public final ArrayList<Integer> adjacend;
        public ArrayList<Node> cNodes;

        public Node(int name, ArrayList<Integer> adjacend) {
            this.nodeName = name;
            this.adjacend = adjacend;
            cNodes = new ArrayList<>();
        }

        @Override
        public String toString() {
            String result = nameMap[nodeName] + " --> ";
            for (int name : adjacend) {
                result += nameMap[name] + " ";
            }
            return result;
        }

        @Override
        public boolean equals(Object obj) {

            Node n = (Node) obj;
            return nodeName == n.nodeName;
        }

        @Override
        public int compareTo(Node o) {

            return nodeName > o.nodeName ? -1 : 1;
        }

    }

    static class Graff {

        private ArrayList<Node> graffNodes;

        public Graff(ArrayList<Node> graffNode) {

            this.setGraffNodes(graffNode);
        }

        public ArrayList<Node> getGraffNodes() {
            return graffNodes;
        }

        public void setGraffNodes(ArrayList<Node> graffNodes) {
            this.graffNodes = graffNodes;
        }

    }

    private static String[] nameMap = { "Ruse", "Sofia", "Pleven", "Varna", "Burgas", "Stara Zagora", "Plovdiv" };
    private static Graff g = createGraf();
    private static boolean[] visited = new boolean[g.getGraffNodes().size()];

    public static void main(String[] args) {



        FindGraphConnectedComponents(g); // Standard foreech
        System.out.println("\n");
        Node n = g.getGraffNodes().get(0);

        for (int i = 0; i < visited.length; i++) { // set arr-false
            visited[i] = false;
        }

        // for (int i = 0; i < visited.length; i++) {
        // FindComponentsDFS(g.getGraffNodes().get(i));
        // }

        FindComponentsBFS(n);
    }

    private static Queue<Node> q = new LinkedList<Node>();

    private static void FindComponentsBFS(Node n) {

        q.add(n);
        visited[n.nodeName] = true;
        while(!q.isEmpty()){

            Node node = q.poll();
            System.out.println(node.toString());

            for (int i : node.adjacend) {
                Node child = g.getGraffNodes().get(i);
                if (!visited[child.nodeName]) {
                    visited[child.nodeName] = true;
                    q.add(child);
                }
            }
        }

    }

    @SuppressWarnings("unused")
    private static void FindComponentsDFS(Node n) {

        if (!visited[n.nodeName]) {
            visited[n.nodeName] = true;
            for (int i : n.adjacend) {
                Node node = g.getGraffNodes().get(i);
                if (!visited[node.nodeName]) {
                    FindComponentsDFS(node);
                }
            }
            System.out.println(n.toString());
        }

    }


    private static void FindGraphConnectedComponents(Graff g) {

        for (Node node : g.getGraffNodes()) {
            System.out.println(node.toString());
        }

    }

    private static Graff createGraf() {

        ArrayList<Integer> ruseAdj = new ArrayList<>();
        ruseAdj.add(3);
        ruseAdj.add(6);
        Node ruse = new Node(0, ruseAdj);

        ArrayList<Integer> sofiaAdj = new ArrayList<>();
        sofiaAdj.add(2);
        sofiaAdj.add(3);
        sofiaAdj.add(4);
        sofiaAdj.add(5);
        sofiaAdj.add(6);
        Node sofia = new Node(1, sofiaAdj);

        ArrayList<Integer> plevenAdj = new ArrayList<>();
        plevenAdj.add(4);
        Node pleven = new Node(2, plevenAdj);

        ArrayList<Integer> varnaAdj = new ArrayList<>();
        varnaAdj.add(0);
        varnaAdj.add(1);
        varnaAdj.add(5);
        Node varna = new Node(3, varnaAdj);

        ArrayList<Integer> burgasAdj = new ArrayList<>();
        burgasAdj.add(1);
        burgasAdj.add(6);
        Node burgas = new Node(4, burgasAdj);

        ArrayList<Integer> stZagoraAdj = new ArrayList<>();
        stZagoraAdj.add(1);
        stZagoraAdj.add(3);
        Node stZagora = new Node(5, stZagoraAdj);

        ArrayList<Integer> plovdivAdj = new ArrayList<>();
        plovdivAdj.add(0);
        plovdivAdj.add(1);
        plovdivAdj.add(4);
        Node plovdiv = new Node(6, plovdivAdj);

        ArrayList<Node> graffSet = new ArrayList<>();
        graffSet.add(ruse);
        graffSet.add(sofia);
        graffSet.add(pleven);
        graffSet.add(varna);
        graffSet.add(burgas);
        graffSet.add(stZagora);
        graffSet.add(plovdiv);

        return new Graff(graffSet);
    }

}
