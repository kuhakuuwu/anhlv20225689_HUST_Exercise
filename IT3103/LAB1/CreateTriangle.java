import java.util.Scanner;
 
public class CreateTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        System.out.println("Input the height of the triangle: ");
        int n = input.nextInt();    
        int i;
        for(i = 0; i < n; i++){
            for(int j = 0; j <  n - i - 1; j++){
                System.out.print(" ");                
            }
            for(int j = 0; j < 2*i + 1; j++){
                System.out.print("*");                            
            }        
            System.out.println();              
        }
        input.close();                
    }
}
 
