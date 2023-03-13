import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        BusinessContact contact2 = new BusinessContact("Tre", "trebenballin@gmail.com", "614-678-6101");
        ContactBook contactBook = new ContactBook();
        Contacts contact1 = new Contacts("John Doe", "johndoe@gmail.com") {
            @Override
            public String aString() {
                return null;
            }
        };
        contactBook.addContact(contact1);
        contactBook.addContact(contact2);
        contactBook.displayContacts();
    }
}




abstract class Contacts{
    private String name;
    private String mail;

    public Contacts(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String mail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public abstract String aString();

    public void display(){
        System.out.println("Person's name is: " + this.name);
        System.out.println("Person's Email is: " + this.mail);
    }
}
class BusinessContact extends Contacts{
    private String number;

    public BusinessContact(String name, String mail, String number) {
        super(name, mail);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String aString() {
        return "BusinessContact{" +
                "number='" + number + '\'' +
                '}';
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Person's Phone Number is: " + this.number);
    }
}

class ContactBook {
    private ArrayList<Contacts> contactsList;

    public ContactBook() {
        contactsList = new ArrayList<>();
    }

    public void addContact(Contacts contact) {
        contactsList.add(contact);
    }

    public void displayContacts() {
        for (Contacts contact : contactsList) {
            contact.display();
        }
    }
}