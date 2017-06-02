package jamiesmyth.contactstask;

/**
 * Helper class that enables access to all the contact data for the test.
 */
public class ContactsStore {

    private static ContactsStore contactStore;
    private Contact[] contacts;

    public ContactsStore() {
        initialiseContacts();
    }

    /**
     * Creates and returns the singleton ContactStore.
     *
     * @return
     */
    public static ContactsStore getStore() {
        if (contactStore == null) {
            contactStore = new ContactsStore();
        }

        return contactStore;
    }

    /**
     * @return Returns all the contacts stored in the contact store.
     */
    public Contact[] getContacts() {
        return contacts;
    }

    /**
     * Initialise all the contact data in the store.
     */
    private void initialiseContacts() {
        contacts = new Contact[] {
                new Contact(
                        "Steve",
                        "Jobs",
                        "Male",
                        "Co-founder, Chairman and CEO, Apple Inc., CEO, Pixar, Co-founder and CEO, NeXT Inc.",
                        "http://upload.wikimedia.org/wikipedia/commons/b/b9/Steve_Jobs_Headshot_2010-CROP.jpg",
                        56),

                new Contact(
                        "Daniel",
                        "Goleman",
                        "Male",
                        "Author, psychologist, and science journalist.",
                        "http://www.pbs.org/moyers/journal/05152009/images/profile_pic2.jpg",
                        65),

                new Contact(
                        "Anthony",
                        "Robbins",
                        "Male",
                        "American self-help author and motivational speaker",
                        "http://upload.wikimedia.org/wikipedia/commons/5/5e/Tony_Robbins.jpg",
                        51),

                new Contact(
                        "Steve",
                        "Wozniak",
                        "Male",
                        "American computer engineer and programmer who founded Apple Computer, Co. (now Apple Inc.) with Steve Jobs and Ronald Wayne.",
                        "http://upload.wikimedia.org/wikipedia/commons/f/f6/Steve_Wozniak.jpg",
                        61), };
    }

    public static class Contact {
        private String firstName;
        private String lastName;
        private String sex;
        private String notes;
        private String imageUrl;
        private int age;

        public Contact(String firstName, String lastName, String sex,
                       String notes, String imageUrl, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.notes = notes;
            this.imageUrl = imageUrl;
            this.age = age;
        }

        /**
         * @return Returns the first name of the contact.
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * @return Returns the last name of the contact.
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * @return Returns the sex of the contact.
         */
        public String getSex() {
            return sex;
        }

        /**
         * @return Returns the notes of the contact.
         */
        public String getNotes() {
            return notes;
        }

        /**
         * @return Returns the url that points to the image of the contact.
         */
        public String getImageUrl() {
            return imageUrl;
        }

        /**
         * @return Returns the age of the contact.
         */
        public int getAge() {
            return age;
        }
    }
}