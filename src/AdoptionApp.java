
import java.util.ArrayList;

/**
 * Starts the Adopt a Quetie application.
 */
public class AdoptionApp
{
    public static void main(String[] args)
    {
        // Create the list of available animals.
        ArrayList<Animal> animals = new ArrayList<Animal>();

        // Animal 1
        animals.add(
            new Animal(
                "Buddy",
                3,
                "Male",
                "Golden Retriever",
                "Friendly dog who loves walks and playing fetch."));

        // Animal 2
        animals.add(
            new Animal(
                "Luna",
                2,
                "Female",
                "Siamese Cat",
                "Sweet and playful cat who loves attention."));

        // Animal 3
        animals.add(
            new Animal(
                "Max",
                1,
                "Male",
                "Beagle",
                "Energetic puppy who loves running and playing."));

        // Animal 4
        animals.add(
            new Animal(
                "Bella",
                4,
                "Female",
                "Labrador Retriever",
                "Calm and gentle dog who is great with families."));

        // Animal 5
        animals.add(
            new Animal(
                "Milo",
                2,
                "Male",
                "Tabby Cat",
                "Curious and friendly cat who loves exploring."));

        // Animal 6
        animals.add(
            new Animal(
                "Daisy",
                1,
                "Female",
                "Ragdoll Cat",
                "Affectionate kitten who loves cuddling and naps."));

        // Create the controller and start the menu.
        AdoptionController controller = new AdoptionController(animals);

        controller.start();
    }
}
