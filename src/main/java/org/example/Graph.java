package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Graph is represented as nodes paired with their adjacent nodes.
 */
public class Graph {
    private Map<Node, List<Node>> adjNodes;

    Graph() {
        this.adjNodes = new HashMap<Node, List<Node>>();
    }

    void addNode(String label) {
        adjNodes.putIfAbsent(new Node(label), new ArrayList<>());
    }

    void addEdge(String label1, String label2) {
        Node v1 = new Node(label1);
        Node v2 = new Node(label2);
        adjNodes.get(v1).add(v2);
        adjNodes.get(v2).add(v1);
    }

    List<Node> getAdjNodes(String label) {
        return adjNodes.get(new Node(label));
    }

    /**
     * The method checks if there is a path with more than n nodes involved. The initial root node is counted in also.
     * The method is recursive, and it returns if we found a path with enough nodes.
     * @param graph the graph the method works with.
     * @param root the initial node where the path starts.
     * @param nodesNeeded we need more nodes than this number
     * @param nodesFound the number of nodes we found in our path yet
     * @param visitedNodeLabels the labels of nodes which we already touched with our path.
     * @return true if there is a path with more than nodesNeeded, false if there is no such path.
     */
    public static boolean isThereAWayWithAtLeastNNodes(Graph graph, String root, int nodesNeeded, int nodesFound, List<String> visitedNodeLabels){
        if(nodesFound > nodesNeeded){
            return true;
        }
        ArrayList<String> visitedNodeLabelsArrayList = new ArrayList<>(visitedNodeLabels);
        visitedNodeLabelsArrayList.add(root);
        List<Node> rootAdjacents = graph.getAdjNodes(root);
        for(Node neighbor : rootAdjacents){
            if(visitedNodeLabelsArrayList.contains(neighbor.label)){
                continue;
            }
            nodesFound++;
            return isThereAWayWithAtLeastNNodes(graph, neighbor.label, nodesNeeded, nodesFound, visitedNodeLabelsArrayList);
        }
        return false;
    }

    class Node {
        String label;
        Node(String label) {
            this.label = label;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
}