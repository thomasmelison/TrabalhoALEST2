import java.util.ArrayList;

/**
 * Diagraph
 */
public class Diagraph {

    public Node[] nodos;


    class Node{
        private String sabor;
        private ArrayList<Node> filhos; 

        public Node(String sabor){
            this.sabor = sabor;
            filhos = new ArrayList<>();
        }
    }
}