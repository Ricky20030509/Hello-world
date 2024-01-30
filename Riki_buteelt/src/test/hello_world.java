package test;

import java.util.Scanner;

public class hello_world {
    private static final double PI = 3.14;
    private final double radius;

    public hello_world(double radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        return 2 * PI * radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------");
        System.out.println("CircleCalc v1.0");
        System.out.println();
        System.out.println("Calculates and prints information for a user-supplied radius");
        System.out.println("------------------------------------------------------------");
        System.out.print("Enter the circle's radius: ");
        
        Scanner in = new Scanner(System.in);
        hello_world c = new hello_world(in.nextDouble());

        // Compute and print the circumference and area of the circle
        double circumference = c.getCircumference();
        double area = c.getArea();

        System.out.println("Circumference: " + circumference);
        System.out.println("Area: " + area);
    }
}
