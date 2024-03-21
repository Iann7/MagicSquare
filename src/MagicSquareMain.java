import java.io.Console;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class MagicSquareMain {
    //USO LINKED LIST PARA ASEGURAR QUE CADA VEZ HAY MENOS OPCIONES PARA ELEGIR, PODRIA USAR OTRA ESTRUCTURA
    // "size" lo podría sacar como parametro
    // tengo que vetar todas las matrices que no cumplen con el numero magico
    static int n=3;
    static int magicNumber= (n*n*n + n*n)/2;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0;i<=n*n;i++) {
            linkedList.add(i);
        }
        magicSquare(0,0,n,
        linkedList,new int[n][n]);
    }
    //i=filas
    //j=columnas
    private static void magicSquare(int i,int j,int size,
    LinkedList<Integer> numerosFrescos,int[][] matriz){
        if(j==size-1 && i==size-1){
            PrintMagicSquare(matriz);
            return;
        }
        if(j==size-1 && i!=size-1){
            for (int numeroFresco : numerosFrescos) {
                matriz[i][j] = numeroFresco;
                LinkedList<Integer> paramFresco = (LinkedList) numerosFrescos.clone();
                paramFresco.removeFirst();
                magicSquare(i+1, 1,size,paramFresco,cloneMatrix(matriz));
            }
        }
        else{
            for (int numeroFresco : numerosFrescos) {
                matriz[i][j] = numeroFresco;
                if(IsExceeding(matriz))continue;
                LinkedList<Integer> paramFresco = (LinkedList) numerosFrescos.clone();
                paramFresco.removeFirst();
                magicSquare(i, j+1,size,paramFresco,cloneMatrix(matriz));
            }
        }
    }

    private static int[][] cloneMatrix(int[][] original) {
        int[][] clone = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            clone[i] = original[i].clone();
        }
        return clone;
    }

    private static void PrintMagicSquare(int[][] matriz){
        System.out.println("-------------");
        for (int[] filas : matriz) {
            for (int numero : filas) {
                System.out.print("-" + numero +"-");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    private static boolean IsExceeding(int[][] matriz){
        //TODO
        return false;
    }
}
