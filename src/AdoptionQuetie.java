import java.util.ArrayList;

/**
 * Stores the animals in the adoption system.
 */
public class AdoptionQuetie
{
    private ArrayList<Animal> animals;

    /**
     * Creates an empty adoption system.
     */
    public AdoptionQuetie()
    {
        animals = new ArrayList<Animal>();
    }


    /**
     * Adds an animal to the system.
     */
    public void addAnimal(Animal animal)
    {
        if (animal == null)
        {
            throw new IllegalArgumentException("Animal cannot be null");
        }

        animals.add(animal);
    }


    /**
     * Finds an animal by name.
     */
    public Animal findAnimal(String name)
    {
        if (name == null)
        {
            return null;
        }

        for (Animal animal : animals)
        {
            if (animal.getName().equalsIgnoreCase(name))
            {
                return animal;
            }
        }

        return null;
    }


    /**
     * Adds an adopter to an animal's queue. Returns false if the animal does
     * not exist.
     */
    public boolean joinQueue(String animalName, Adopter adopter)
    {
        Animal animal = findAnimal(animalName);

        if (animal == null)
        {
            return false;
        }

        animal.getQueue().enqueue(adopter);
        return true;
    }


    /**
     * Returns the list of animals.
     */
    public ArrayList<Animal> getAnimals()
    {
        return animals;
    }
}
