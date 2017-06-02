package jamiesmyth.contactstask;

/**
 * Created by user on 01/06/2017.
 */
public class DataModel {

    String imageURL;
    String firstName;
    String secondName;
    String age;
    String gender;
    String notes;

    public DataModel(String imageURL, String firstName, String secondName, String age, String gender, String notes)
    {
        this.imageURL = imageURL;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.notes = notes;
    }

    // Returns Image URL
    public String getImageURL()
    {
        return imageURL;
    }

    //Returns First Name
    public String getFirstName()
    {
        return firstName;
    }

    // Returns Second Name
    public String getSecondName()
    {
        return secondName;
    }

    // Returns Age
    public String getAge()
    {
        return age;
    }

    // Returns Gender
    public String getGender()
    {
        return gender;
    }

    // Returns Notes
    public String getNotes()
    {
        return notes;
    }
}
