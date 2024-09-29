import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Input first the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Input first the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 -  num2;
        double product = num1 * num2;

        System.out.println("Sum of 2 numbers: " + sum);
        System.out.println("Difference of 2 numbers: " + difference);
        System.out.println("Product of 2 numbers: " + product);

        if(num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient of 2 numbers: " + quotient);
        } else {
            System.out.println("Cannot divided by zero!");
        }

        System.exit(0);
    }
}

