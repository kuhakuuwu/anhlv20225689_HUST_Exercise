import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose the type of equation to solve:");
            System.out.println("(Input a number)");
            System.out.println("1. First-degree equation with one variable (ax + b = 0).");
            System.out.println("2. System of first-degree equations with two variables (a1x + b1y = c1 | a2x + b2y = c2).");
            System.out.println("3. Second-degree equation with one variable (ax^2 + bx + c = 0).");
            System.out.println("4. Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    solveLinearEquation(input);
                    break;
                case 2:
                    solveLinearSystem(input);
                    break;
                case 3:
                    solveQuadraticEquation(input);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 4);

        input.close();
    }

    public static void solveLinearEquation (Scanner input) {
        System.out.println("Solving Linear Equation: ");
        System.out.println("ax + b = 0");

        System.out.println("Input a: ");
        double a = input.nextDouble();
        System.out.println("Input b: ");
        double b = input.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many roots!" + "\n");
            } else System.out.println("The equation have no solution!" + "\n");
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x + "\n");
        }

    }

    public static void solveLinearSystem (Scanner input) {
        System.out.println("Solving system of linear equations: ");
        System.out.println("a1x + b1y = c1");
        System.out.println("a2x + b2y = c2");

        System.out.print("Input a1: ");
        double a1 = input.nextDouble();
        System.out.print("Input b1: ");
        double b1 = input.nextDouble();
        System.out.print("Input c1: ");
        double c1 = input.nextDouble();

        System.out.print("Input a2: ");
        double a2 = input.nextDouble();
        System.out.print("Input b2: ");
        double b2 = input.nextDouble();
        System.out.print("Input c2: ");
        double c2 = input.nextDouble();

        double D = a1*b2 - a2*b1;
        double Dx = c1*b2 - c2*b1;
        double Dy = a1*c2 - a2*c1;

        if (D == 0) {
            if (Dx == Dy) {
                System.out.println("The system has infinitely many roots!" + "\n");
            } else if (Dx != 0 || Dy != 0) {
                System.out.println("The system have no solution!" + "\n");
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            System.out.println("The solution is: x = " + x + " y = " + y + "\n");
        }

    }

    public static void solveQuadraticEquation (Scanner input) {
        System.out.println("Solving Quadratic Equation: ");
        System.out.println("ax^2 + bx + c = 0");

        System.out.print("Input a: ");
        double a = input.nextDouble();
        System.out.print("Input b: ");
        double b = input.nextDouble();
        System.out.print("Input c: ");
        double c = input.nextDouble();

        if (a == 0) {
            System.out.println("This is not a quadratic equation! It's a linear equation! Do you want to?");
            System.out.println("(Input a number)");
            System.out.println("1. Input again?");
            System.out.println("2. Go to Solve Linear Equation?");
            System.out.println("3. Return?");
            int cmd = input.nextInt();
            switch (cmd) {
                case 1: 
                    solveQuadraticEquation(input);
                    return;
                case 2: 
                    solveLinearEquation(input);
                    return;
                case 3: return;
                default: 
                    System.out.println("Invalid option! Return!"+ "\n");
                    return;
            }

        }

        double delta = b*b - 4*a*c;

        if (delta < 0){
            System.out.println("The equation has no real solution!" + "\n");
        } else if (delta == 0) {
            double x = -b / 2*a;
            System.out.println("The equation has one real root: x = " + x + "\n");
        } else {
            double x1 = (-b + Math.sqrt(delta)) / 2*a;
            double x2 = (-b - Math.sqrt(delta)) / 2*a;
            System.out.println("The equation has two real roots: x1 = " + x1 + " and x2 = " + x2 + "\n");
        }


    }
    
}
