
import java.util.*;
import java.lang.String;


public class Main {


    public static void main(String[] args) {
        // write your code here
        boolean flag = true;

        // we can refer to AddressBook directly because its implementations are static
        AddressBook.addEntry(
                new Entry("Andy",
                        "Charles",
                        "555-555-5555",
                        "andy.charles@test.com"));
        AddressBook.addEntry(new Entry("Perry",
                "Mason",
                "555-555-5555",
                "perry.mason@gmail.com"));
        AddressBook.addEntry(new Entry("Katie",
                "Holmes",
                "555-555-5555",
                "kateholmes@email.com"));
        AddressBook.addEntry(new Entry("Hobbs",
                "Horne",
                "555-555-5555",
                "hobbshorne@catsrule.com"));
        //  game loop to hold user in game until exit is choosen
        do {

            int op;
            Scanner ch = new Scanner(System.in);

            System.out.println("1.Add an Entry");
            System.out.println("2.Remove an Entry");
            System.out.println("3.Search for a specific entry");
            System.out.println("4.Print the contents of the address book");
            System.out.println("5.Delete the contents of the address book");
            System.out.println("6.Quit the program");

            System.out.println("What do you want to do in the Address Book: ");
            System.out.println("->");

            op = ch.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Enter the firstName:");
                    String firstName = ch.next();
                    System.out.println("Enter the lastName:");
                    String lastName = ch.next();
                    System.out.println("Enter a phoneNumber :");
                    var phoneNumber = ch.next();
                    System.out.println("Enter an email Address:");
                    String emailAddress = ch.next();
                    AddressBook.addEntry(new Entry(firstName, lastName, phoneNumber, emailAddress));
                    break;

                case 2:
                    System.out.println("Enter the email id of the entry you want to remove");
                    String emailId = ch.next();
                    AddressBook.removeEntry(emailId);
                    break;

                case 3:
                    System.out.println("""
                       Choose how you want to remove the entry\s
                        'F' - FirstName\s
                        'L'- LastName\s
                        'P'- Phone Number\s
                        'E' - EmailAddress\s
                        ...
                         """);
                    char selector = ch.next().charAt(0);
                    System.out.println("Input here, please: \n");
                    String searchQuery = ch.next();

                    Entry found = AddressBook.searchEntry(selector,
                            searchQuery);
                    if (found != null) {
                        System.out.println("WooHoo, An Entry is found for you : " +found);
                    }
                    break;

                case 4:
                    AddressBook.printEntryList();
                    break;

                case 5:
                    AddressBook.deleteList();
                    break;

                case 6:
                    System.out.println("Quit!");
                    flag = false;
                    ch.close();
                    break;
                default:
                    System.out.println("Input Invalid, Please select from the list below ");
                    break;
            }
        } while(flag);

    }


}





