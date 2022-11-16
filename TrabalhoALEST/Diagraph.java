import java.util.ArrayList;

/**
 * Diagraph
 */
public class Diagraph {
    public static int soma = 0;
    public ArrayList<Node> nodos;

    public Diagraph(){
        nodos = new ArrayList<Node>();
    }


    public class Node{
        public String sabor;
        public ArrayList<Node> filhos; 

        public Node(String sabor){
            this.sabor = sabor;
            filhos = new ArrayList<>();
        }
    }

    public Node procuraSaborExistente(String saborInput){
        for(Node nodo : nodos){
            if(nodo.sabor.equals(saborInput)){
                return nodo;
            }
        }
        return null;
    }

    public Node criaNode(String sabor){
        Node nodo = new Node(sabor);
        nodos.add(nodo);
        return nodo;
    }

    public void adicionaFilho(Node nodoPai, Node nodoFilho){
        nodoPai.filhos.add(nodoFilho);
    }

    public boolean testePaternidadeRatinho(Node nodoPai, Node possivelFilho){
        for(Node nodo : nodoPai.filhos){
            if(nodo.equals(possivelFilho)){
                return true;
            }
        }
        
        return false;
    }
    public int getCombinacoesDoisSabores(){
        int combinacoesDoisSabores = 0;
        for(Node n : nodos){
            combinacoesDoisSabores += n.filhos.size();
        }
        return combinacoesDoisSabores;
    }

    public int getCombinacoesTresSabores(){
        int combinacoesTresSabores = 0;
        for(Node nodoPai: nodos){
            ArrayList<Node> filhosNodo = nodoPai.filhos;
            for(Node nodoFilho : filhosNodo){
                combinacoesTresSabores += nodoFilho.filhos.size();
            }
        }

        return combinacoesTresSabores;
    }

    public void adicionaSubFilhos(){
        for(Node nodoPai : nodos){
            ArrayList<Diagraph.Node> filhosNodo = (ArrayList<Diagraph.Node>) nodoPai.filhos.clone();  
            for(Node nodoFilho : filhosNodo){  
                checaFilhosRecursivo(nodoPai , nodoFilho);

            }
        }
    }

    private void checaFilhosRecursivo(Node nodoPai, Node nodoFilho) {
        if(!testePaternidadeRatinho(nodoPai, nodoFilho)){ 
            nodoPai.filhos.add(nodoFilho);
        }
        for(Node nodoNeto : nodoFilho.filhos){
          
            checaFilhosRecursivo(nodoPai, nodoNeto);
        }
        return;
    }
}