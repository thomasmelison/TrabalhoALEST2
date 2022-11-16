import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    


    public static void main(String[] args) throws IOException{
        


        Scanner scanner = new Scanner(new File("casocohen60.txt"));
        Diagraph diagraph = new Diagraph();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(!line.contains("->")){
                break;
            }
            String[] sabores = line.split("->");
            sabores[0] = sabores[0].replaceAll(" ", "");
            sabores[1] = sabores[1].replaceAll(" ", "");

            Diagraph.Node nodoPai = diagraph.procuraSaborExistente(sabores[0]);
            //System.out.println(nodoPai.sabor);
            if(nodoPai == null){
                // cria nodo
                nodoPai = diagraph.criaNode(sabores[0]);
            }

            Diagraph.Node nodoFilho = diagraph.procuraSaborExistente(sabores[1]);
            if(nodoFilho == null){
                // cria nodo
                nodoFilho = diagraph.criaNode(sabores[1]);
            }

            // cria ligação
            diagraph.adicionaFilho(nodoPai, nodoFilho);
        }
        diagraph.adicionaSubFilhos();
        int numeroEsperadoDuasBolas = scanner.nextInt();
        int numeroEsperadoTresBolas = scanner.nextInt();
        System.out.println("Resposta encontrada para 2 bolas:  " + diagraph.getCombinacoesDoisSabores());
        System.out.println("Esperado:  " + numeroEsperadoDuasBolas);
        System.out.println("Resposta encontrada para 3 bolas:  " + diagraph.getCombinacoesTresSabores());
        System.out.println("Esperado:  " + numeroEsperadoTresBolas);
        /* 
        for(Diagraph.Node nodo : diagraph.nodos){
            System.out.println("Nodo pai: " + nodo.sabor);
            System.out.print("Filhos : ");
            for(Diagraph.Node nodofilho : nodo.filhos){
                System.out.print(nodofilho.sabor + " ");
            }
            System.out.println();
            System.out.println();
        } */

        

    }
}
