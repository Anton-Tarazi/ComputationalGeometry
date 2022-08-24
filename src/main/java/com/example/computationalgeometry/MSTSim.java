package com.example.computationalgeometry;

import javafx.animation.KeyFrame;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Comparator;

public class MSTSim extends PointsSimulation{

    public ArrayList<Edge> edges;
    public ArrayList<Edge> spanningTree;
    public Group lines;


    public MSTSim(Scene home, Stage stage) {
        super(home, stage, "Prim's Algorithm", "Kruskal's Algorithm");
        lines = new Group();
        graphics.getChildren().add(lines);

        edges = new ArrayList<>();
        spanningTree = new ArrayList<>();
    }

    public void updateTimeline1() {
        Duration timePoint = Duration.ZERO;
        Duration pause = Duration.seconds(0.1);
        for (Edge edge: spanningTree) {
            System.out.println("adding edge");
            timePoint = timePoint.add(pause);
            KeyFrame keyFrame = new KeyFrame(timePoint, e ->
                    lines.getChildren().add(edge.getShape()));

            timeline.getKeyFrames().add(keyFrame);
        }
    }

    public void updateTimeline2() {
        updateTimeline1();
    }

    private void createEdges() {
        markUnexplored();
        int n = points.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(points.get(i), points.get(j)));
            }
        }
    }

    public void markUnexplored() {
        for (Point p: points) {
            p.setExplored(false);
        }
    }

    public void prim() {
        Point start = points.get(0);
        start.setExplored(true);

        while (true) {
            Edge minEdge = null;
            for (Edge edge: edges) {
                if ((minEdge == null || edge.getLength() < minEdge.getLength()) &&
                        edge.onePointExplored()) {
                    minEdge = edge;
                }
            }
            if (minEdge == null) break;

            minEdge.markExplored();
            spanningTree.add(minEdge);
        }
    }

    public void kruskal() {
        edges.sort(Comparator.comparingDouble(Edge::getLength));

        int[] unionFind = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            unionFind[i] = i;
        }

        for (Edge edge: edges) {
            if (find(edge.getP1().getId(), unionFind) != find(edge.getP2().getId(), unionFind)) {
                spanningTree.add(edge);
                union(edge.getP1().getId(), edge.getP2().getId(), unionFind);
            }
        }
    }

    private int find(int p, int[] uf) {
        if (uf[p] == p) {
            return p;
        } else {
            return find(uf[p], uf);
        }
    }

    private void union(int p1, int p2, int[] uf) {
        int parent1 = find(p1, uf);
        int parent2 = find(p2, uf);
        uf[parent1] = parent2;
    }

    public void reset() {
        super.reset();
        edges.clear();
        spanningTree.clear();
        lines.getChildren().clear();
    }

    public void run1() {
        reset();
        createEdges();
        prim();
    }

    public void run2() {
        reset();
        createEdges();
        kruskal();
    }
}
