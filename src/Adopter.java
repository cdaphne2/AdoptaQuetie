
/**
 * Represents a person waiting to meet an animal.
 *
 * @author Daphne
 * @version 11.07.2026
 */

public class Adopter
{
    private String firstName;
    private String lastName;

    /**
     * Creates an adopter with a first and last name.
     *
     * @param firstName
     *            the adopter's first name
     * @param lastName
     *            the adopter's last name
     */
    public Adopter(String firstName, String lastName)
    {
        if (firstName == null || firstName.trim().isEmpty() || lastName == null
            || lastName.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                "First and last name cannot be empty.");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }


    /**
     * Returns the adopter's first name.
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }


    /**
     * Returns the adopter's last name.
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }


    /**
     * Compares two adopters by their first and last names.
     *
     * @param other
     *            the object to compare
     * @return true if both names match
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }

        if (!(other instanceof Adopter))
        {
            return false;
        }

        Adopter otherAdopter = (Adopter)other;

        return firstName.equals(otherAdopter.getFirstName())
            && lastName.equals(otherAdopter.getLastName());
    }


    /**
     * Returns a hash code based on the adopter's names.
     *
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        return 31 * firstName.hashCode() + lastName.hashCode();
    }
}
