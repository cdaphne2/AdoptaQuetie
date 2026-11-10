
import java.util.Scanner;

/**
 * Displays information and gets user input.
 *
 * @author Ujay Bhuva
 * @version 11.10.2026
 */
public class AdoptionView
{
    private Scanner scanner;

    public AdoptionView()
    {
        scanner = new Scanner(System.in);
    }


    public void displayMessage(String message)
    {
        System.out.println(message);
    }


    public void displayAnimal(Animal animal)
    {
        System.out.println("Name: " + animal.getName());
        System.out.println("Age: " + animal.getAge());
        System.out.println("Gender: " + animal.getGender());
        System.out.println("Breed: " + animal.getBreed());
        System.out.println("Description: "
            + animal.getDescription());
        System.out.println("Waiting: "
            + animal.getQueue().getSize());
        System.out.println();
    }


    public void displayMenu()
    {
        System.out.println("1. View Animals");
        System.out.println("2. Join Queue");
        System.out.println("3. View Queue Size");
        System.out.println("4. Finish Meeting");
        System.out.println("5. Exit");
    }


    public String getInput()
    {
        return scanner.nextLine();
    }
}
