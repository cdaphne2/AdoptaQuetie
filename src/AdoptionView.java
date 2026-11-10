import java.util.Scanner;

/**
 * Displays adoption information and reads user input.
 *
 * @author Ujay Bhuva
 * @version 11.10.2026
 */
public class AdoptionView
{
    private Scanner scanner;

    /**
     * Creates the view.
     */
    public AdoptionView()
    {
        scanner = new Scanner(System.in);
    }


    /**
     * Displays a message.
     *
     * @param message
     *            the message to display
     */
    public void displayMessage(String message)
    {
        System.out.println(message);
    }


    /**
     * Displays information about one animal.
     *
     * @param animal
     *            the animal to display
     */
    public void displayAnimal(Animal animal)
    {
        System.out.println("-------------------------");
        System.out.println("Name: " + animal.getName());
        System.out.println("Age: " + animal.getAge());
        System.out.println("Gender: " + animal.getGender());
        System.out.println("Breed: " + animal.getBreed());
        System.out.println("Description: " + animal.getDescription());
        System.out.println("People waiting: " + animal.getQueue().getSize());
        System.out.println("-------------------------");
        System.out.println();
    }


    /**
     * Displays the main menu.
     */
    public void displayMenu()
    {
        System.out.println();
        System.out.println("===== ADOPT A QUETIE =====");
        System.out.println("1. View Available Animals");
        System.out.println("2. Join an Animal's Queue");
        System.out.println("3. View Queue Size");
        System.out.println("4. See Who's Next");
        System.out.println("5. Finish Meeting");
        System.out.println("6. Skip Absent Adopter");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }


    /**
     * Reads input from the user.
     *
     * @return the user's input
     */
    public String getInput()
    {
        return scanner.nextLine();
    }
}
