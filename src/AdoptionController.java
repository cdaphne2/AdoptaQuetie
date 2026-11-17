
import java.util.ArrayList;

/**
 * Controls the adoption application.
 *
 * @author Ujay Bhuva
 * @version 11.10.2026
 */
public class AdoptionController
{
    private ArrayList<Animal> animals;
    private AdoptionView view;

    public AdoptionController(ArrayList<Animal> animals)
    {
        this.animals = animals;
        view = new AdoptionView();
    }


    public void displayAnimals()
    {
        if (animals.isEmpty())
        {
            view.displayMessage("No animals available.");
            return;
        }

        for (Animal animal : animals)
        {
            view.displayAnimal(animal);
        }
    }


    public Animal selectAnimal(String name)
    {
        if (name == null)
        {
            return null;
        }

        for (Animal animal : animals)
        {
            if (animal.getName().equalsIgnoreCase(name.trim()))
            {
                return animal;
            }
        }

        return null;
    }


    public void joinQueue(String animalName, String firstName, String lastName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        if (firstName == null || lastName == null || firstName.trim().isEmpty()
            || lastName.trim().isEmpty())
        {
            view.displayMessage("Invalid name.");
            return;
        }

        Adopter adopter = new Adopter(firstName.trim(), lastName.trim());

        AdoptionQueue queue = animal.getQueue();
        AdoptionQueue temp = new AdoptionQueue();
        boolean duplicate = false;

        while (!queue.isEmpty())
        {
            Adopter current = queue.dequeue();

            if (current.equals(adopter))
            {
                duplicate = true;
            }

            temp.enqueue(current);
        }

        while (!temp.isEmpty())
        {
            queue.enqueue(temp.dequeue());
        }

        if (duplicate)
        {
            view.displayMessage("Already in queue.");
            return;
        }

        queue.enqueue(adopter);
        view.displayMessage("Successfully joined queue!");
    }


    public void showQueueSize(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        view.displayMessage("People waiting: " + animal.getQueue().getSize());
    }


    public void showNextAdopter(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        Adopter next = animal.getQueue().peek();

        if (next == null)
        {
            view.displayMessage("Nobody is waiting.");
        }
        else
        {
            view.displayMessage(
                "Next up: " + next.getFirstName() + " " + next.getLastName());
        }
    }


    public void finishMeeting(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        Adopter adopter = animal.getQueue().dequeue();

        if (adopter == null)
        {
            view.displayMessage("Queue is empty.");
        }
        else
        {
            view.displayMessage(
                "Meeting finished for " + adopter.getFirstName() + " "
                    + adopter.getLastName() + ".");
        }
    }


    public void skipAdopter(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        Adopter skipped = animal.getQueue().dequeue();

        if (skipped == null)
        {
            view.displayMessage("Queue is empty.");
        }
        else
        {
            view.displayMessage(
                "Skipped: " + skipped.getFirstName() + " "
                    + skipped.getLastName());
        }
    }


    /**
     * Shows an adopter's estimated waiting time.
     */
    public void showEstimatedWaitTime(
        String animalName,
        String firstName,
        String lastName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        if (firstName == null || lastName == null || firstName.trim().isEmpty()
            || lastName.trim().isEmpty())
        {
            view.displayMessage("Invalid name.");
            return;
        }

        Adopter adopter = new Adopter(firstName.trim(), lastName.trim());

        int minutes = animal.getQueue().getEstimatedWaitTime(adopter);

        if (minutes == -1)
        {
            view.displayMessage("Adopter not found in this queue.");
        }
        else
        {
            view.displayEstimatedWaitTime(minutes);
        }
    }


    public void start()
    {
        boolean running = true;

        while (running)
        {
            view.displayMenu();
            String choice = view.getInput();

            switch (choice)
            {
                case "1":
                    displayAnimals();
                    break;

                case "2":
                    view.displayMessage("Animal name:");
                    String animal = view.getInput();

                    view.displayMessage("First name:");
                    String first = view.getInput();

                    view.displayMessage("Last name:");
                    String last = view.getInput();

                    joinQueue(animal, first, last);
                    break;

                case "3":
                    view.displayMessage("Animal name:");
                    showQueueSize(view.getInput());
                    break;

                case "4":
                    view.displayMessage("Animal name:");
                    showNextAdopter(view.getInput());
                    break;

                case "5":
                    view.displayMessage("Animal name:");
                    finishMeeting(view.getInput());
                    break;

                case "6":
                    view.displayMessage("Animal name:");
                    skipAdopter(view.getInput());
                    break;

                case "7":
                    view.displayMessage("Animal name:");
                    String waitAnimal = view.getInput();

                    view.displayMessage("First name:");
                    String waitFirst = view.getInput();

                    view.displayMessage("Last name:");
                    String waitLast = view.getInput();

                    showEstimatedWaitTime(waitAnimal, waitFirst, waitLast);
                    break;

                case "8":
                    running = false;
                    view.displayMessage("Goodbye!");
                    break;

                default:
                    view.displayMessage("Invalid choice.");
                    break;
            }
        }
    }
}
