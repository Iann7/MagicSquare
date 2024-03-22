import java.util.ArrayList;
public class mainClass{
    //TODO PODAR TREES
    static int n=3;
    static int magicNumber= (n*n*n +n)/2;
    static ArrayList<Integer> possInt;
    public static void main(String[] args) {
        possInt=new ArrayList<>();
        for(int i=1;i<=n*n;i++){
            possInt.add(i);
        }
        FindNSquares(0, 0, n, possInt, new Integer[n][n]);
    }

    public static void FindNSquares(int i,int j,int n,ArrayList<Integer> possInt,Integer[][] matrix){
        if(i==n-1 && j==n-1){
            Integer[][] copyMatrix = CopyMatrix(matrix);
            ArrayList<Integer> copyPossInt = (ArrayList<Integer>) possInt.clone();
            int nextI = 0;
            int nextJ = 0;
            fillingMagicSquare(i, j, 0, 0, n, copyPossInt, copyMatrix);
        } else if(i!=n-1 && j==n-1){
            System.out.println(possInt.size());
            Integer[][] copyMatrix =  CopyMatrix(matrix);
            ArrayList<Integer> copyPossInt = (ArrayList<Integer>) possInt.clone();
            int nextI = i+1;
            int nextJ = 0;
            fillingMagicSquare(i, j, nextI, nextJ, n, copyPossInt, copyMatrix);
        }else{
            Integer[][] copyMatrix =  CopyMatrix(matrix);
            System.out.println("a");
            int nextI = i;
            int nextJ = j+1;
            fillingMagicSquare(i, j, nextI, nextJ, n, possInt, copyMatrix);
        }
    }

    public static void fillingMagicSquare(int i,int j,int nextI,int nextJ,int n,ArrayList<Integer> possInt,Integer[][] matrix){
        for (Integer iInteger : possInt) {

            matrix[i][j] = iInteger;
            if((i!=n-1 || j!=n-1)){
            ArrayList<Integer> copyPossInt = (ArrayList<Integer>) possInt.clone();
            copyPossInt.remove(iInteger);
            FindNSquares(nextI, nextJ, n, copyPossInt, matrix);
            } else if(i==n-1 && j==n-1){
                if(IsMagicSquare(matrix)) PrintMagicSquare(matrix);
            } else continue;
        }
    }


    public static boolean IsPartialMagicSquare(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != null)
                    sum += matrix[i][j];
            }
            if (sum > magicNumber)
                return false;
        }
        
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != null)
                    sum += matrix[i][j];
            }
            if (sum > magicNumber)
                return false;
            
        }

        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != null)
                sumDiagonal1 += matrix[i][i];
            if ((sumDiagonal1 > magicNumber))
            return false;


            if (matrix[i][matrix.length - 1 - i] != null)
                sumDiagonal2 += matrix[i][matrix.length - 1 - i];

            if(sumDiagonal2 > magicNumber){
                return false;
            }

        }
        
        return true;
    }

    public static boolean IsMagicSquare(Integer[][] matrix) {
        int sum=0;
        for (Integer[] row : matrix) {
            for (Integer cell : row) {
                sum+=cell;
                if (cell == null)
                    return false;
            }
        }
        return sum==magicNumber*n;
    }

    public static void PrintMagicSquare(Integer[][] matrix){
        System.out.println("Magic Square:");
        for (Integer[] row : matrix) {
            for (Integer cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Integer[][] CopyMatrix(Integer[][] matrix){
        Integer[][] matrixCopy = new Integer[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        return matrixCopy;
    }
}