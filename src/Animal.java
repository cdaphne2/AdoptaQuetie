/**
 * Represents an animal available for adoption.
 */
public class Animal
{
    private String name;
    private int age;
    private String gender;
    private String breed;
    private String description;
    private AdoptionQueue queue;

    /**
     * Creates an animal with an empty waiting queue.
     */
    public Animal(
        String name,
        int age,
        String gender,
        String breed,
        String description)
    {
        if (name == null || name.trim().isEmpty() || gender == null
            || gender.trim().isEmpty() || breed == null
            || breed.trim().isEmpty() || description == null
            || description.trim().isEmpty() || age < 0)
        {
            throw new IllegalArgumentException("Invalid animal information");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.description = description;
        queue = new AdoptionQueue();
    }


    public String getName()
    {
        return name;
    }


    public int getAge()
    {
        return age;
    }


    public String getGender()
    {
        return gender;
    }


    public String getBreed()
    {
        return breed;
    }


    public String getDescription()
    {
        return description;
    }


    public AdoptionQueue getQueue()
    {
        return queue;
    }
}
