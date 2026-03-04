package syntactic_analysis;

import java.util.LinkedList;
import java.util.List;

public class ParseTree {
    private Node root;
    private List<Node> childrens;
    
    public ParseTree(Node root, List<Node> childrens){
        this.root = root;
        this.childrens = new LinkedList<>();
    }
}
