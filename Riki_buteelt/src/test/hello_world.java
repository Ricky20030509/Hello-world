package test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hello_world {

    // Function to add a car to the stop (enqueue)
    public static void addCar(Queue<String> queue, String car) {
        queue.offer(car);
        System.out.println(car + " has arrived at the stop.");
    }

    // Function to remove a car from the stop (dequeue)
    public static void removeCar(Queue<String> queue) {
        if (!queue.isEmpty()) {
            String removedCar = queue.poll();
            System.out.println(removedCar + " has left the stop.");
        } else {
            System.out.println("No cars at the stop.");
        }
    }

    // Function to check the next car at the stop (peek)
    public static void checkNextCar(Queue<String> queue) {
        if (!queue.isEmpty()) {
            String nextCar = queue.peek();
            System.out.println("Next car at the stop: " + nextCar);
        } else {
            System.out.println("No cars at the stop.");
        }
    }

    // Function to get the number of cars at the stop
    public static int getNumberOfCars(Queue<String> queue) {
        return queue.size();
    }

    // Function to check if the stop is empty
    public static boolean isEmpty(Queue<String> queue) {
        return queue.isEmpty();
    }

    // Function to clear all cars from the stop
    public static void clearStop(Queue<String> queue) {
        queue.clear();
        System.out.println("All cars have left the stop.");
    }

    public static void main(String[] args) {
        Queue<String> carStop = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nCar Stop Menu:");
            System.out.println("1. Add a car");
            System.out.println("2. Remove a car");
            System.out.println("3. Check the next car");
            System.out.println("4. Get the number of cars");
            System.out.println("5. Check if the stop is empty");
            System.out.println("6. Clear all cars from the stop");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the car to add: ");
                    String carToAdd = scanner.nextLine();
                    addCar(carStop, carToAdd);
                    break;
                case 2:
                    removeCar(carStop);
                    break;
                case 3:
                    checkNextCar(carStop);
                    break;
                case 4:
                    System.out.println("Number of cars at the stop: " + getNumberOfCars(carStop));
                    break;
                case 5:
                    System.out.println("Is the stop empty? " + isEmpty(carStop));
                    break;
                case 6:
                    clearStop(carStop);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
