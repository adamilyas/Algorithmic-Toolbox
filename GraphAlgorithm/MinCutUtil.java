import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MinCutUtil {

    private HashSet<String> verticeSet = new HashSet<>();

    private List<Edge> edgeList = new ArrayList<>();

    @Override
    public String toString(){
        String repr = "";
        for (Edge edge : edgeList){
            repr = repr.concat(String.format("(%s)  ", edge.toString()));
        }
        return repr;
    }

    public void addEdge(String i, String j){
        edgeList.add(new Edge(i,j));
    }

    public void addEdge(int i, int j){
        String source = String.valueOf(i), destination = String.valueOf(j);
        edgeList.add(new Edge(source, destination));

        verticeSet.add(source);
        verticeSet.add(destination);
    }

    private Random random = new Random();

    private Edge getRandomEdge(){
        return edgeList.get(random.nextInt(edgeList.size()));
    }

    public void merge(Edge edgeToMerge){
        String sourceToMerge = edgeToMerge.getSource();
        String destinationToMerge = edgeToMerge.getDestination();

        edgeList.remove(edgeToMerge);
        verticeSet.remove(sourceToMerge);
        verticeSet.remove(destinationToMerge);

        String merged = String.format("%s+%s", sourceToMerge, destinationToMerge);
        verticeSet.add(merged);

        int i = 0;
        while (i < edgeList.size()){
            Edge currentEdge = edgeList.get(i);
            if (currentEdge.getSource().equals(sourceToMerge) || currentEdge.getSource().equals(destinationToMerge)){
                currentEdge.setSource(merged);
            }
            if (currentEdge.getDestination().equals(sourceToMerge) || currentEdge.getDestination().equals(destinationToMerge)){
                currentEdge.setDestination(merged);
            }

            if (currentEdge.isLoop()){
                edgeList.remove(currentEdge);
            } else {
                i++;
            }
        }
    }

    public int getMinCut(){

        Edge edgeToMerge = null;
        while (verticeSet.size() > 2){
            edgeToMerge = getRandomEdge();

            System.out.println("Merging on edge: " + edgeToMerge);

            merge(edgeToMerge);
            System.out.println(toString() + " Vertices: " + verticeSet);

            if (edgeList.size() == 0){
                return -1;
            }
        }
        return edgeList.size();
    }

    public static void main(String[] args){

        MinCutUtil g = new MinCutUtil();
        g.addEdge(1,2);
        g.addEdge(1,3); 
        g.addEdge(1,4);     
        g.addEdge(2,4);     
        g.addEdge(3,4);     

        System.out.println(g);
        System.out.println(g.getMinCut());
    }

}

class Edge {

    private String source;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private String destination;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Edge (String source, String destination){
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String toString(){
        return String.format("%s -> %s", source, destination);
    }

    public boolean isLoop(){
        return source.equals(destination);
    }

}