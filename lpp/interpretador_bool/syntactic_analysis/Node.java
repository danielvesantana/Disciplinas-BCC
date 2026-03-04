package syntactic_analysis;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private Node parent;
    private List<Node> childrens;
    private String token;
    
    public Node(Node parent, String token){
        this.parent = parent;
        this.childrens = new LinkedList<>();
        this.token = token;
    }
}
