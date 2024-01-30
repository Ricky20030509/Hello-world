package test;

import java.util.Scanner;
import java.util.Stack;

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

public class hello_world {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Circle> circleStack = new Stack<>();

        System.out.println("Enter the number of circles:");
        int numCircles = scanner.nextInt();

        for (int i = 0; i < numCircles; i++) {
            System.out.print("Enter the radius of circle " + (i + 1) + ": ");
            double radius = scanner.nextDouble();
            circleStack.push(new Circle(radius));
        }

        System.out.println("\nCalculating areas of circles using stack:");
        while (!circleStack.isEmpty()) {
            Circle circle = circleStack.pop();
            double area = circle.getArea();
            System.out.println("Area of circle with radius " + circle.getRadius() + ": " + area);
            System.out.println("UUrchlult ");

        }
    }
}
