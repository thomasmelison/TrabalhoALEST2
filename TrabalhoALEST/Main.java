import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    


    public static void main(String[] args) throws IOException , FileNotFoundException{
        System.out.println("Programa da sorveteria maluca do meu primo:");
        System.out.println();
        for(int i = 10; i <= 60; i = i + 10){
            System.out.println("Teste para " + i + " sabores");
            rodaPrograma("TrabalhoALEST/casoDeTeste/casocohen" + i + ".txt");
            System.out.println();
        }
    }
    public static void rodaPrograma(String fileName) throws IOException , FileNotFoundException{
        Scanner scanner = new Scanner(new File(fileName));
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

        long inicioExecucaoAdicionaSub = System.currentTimeMillis();
        diagraph.adicionaSubFilhos();
        long finalExecucaoAdicionaSub = System.currentTimeMillis();
        System.out.println("Tempo para adicionar subFilhos: " + (finalExecucaoAdicionaSub - inicioExecucaoAdicionaSub) + " milisegundos.");

        int numeroEsperadoDuasBolas = scanner.nextInt();
        int numeroEsperadoTresBolas = scanner.nextInt();

        long inicio2bolas = System.currentTimeMillis();
        System.out.println("Resposta encontrada para 2 bolas:  " + diagraph.getCombinacoesDoisSabores());
        long final2bolas = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (final2bolas - inicio2bolas) + " milisegundos.");

        System.out.println("Esperado:  " + numeroEsperadoDuasBolas);

        long inicio3bolas = System.currentTimeMillis();
        System.out.println("Resposta encontrada para 3 bolas:  " + diagraph.getCombinacoesTresSabores());
        long final3bolas = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (final3bolas - inicio3bolas) + " milisegundos.");

        System.out.println("Esperado:  " + numeroEsperadoTresBolas);
    }
}
