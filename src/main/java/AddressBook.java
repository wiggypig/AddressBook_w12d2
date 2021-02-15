
import java.util.*;

public class AddressBook {

    // this class is pretty much just a utility class
    // as such all of the properties are static

    private static List<Entry> entryList = new ArrayList<>();


    //Adds an entry to the list
    public static void addEntry(Entry entry) {
        int length = entryList.size();
        //entryList.add(entry);//
        // for loop, essentially
        // this returns true if my email is not unique
        var isNotUnique = entryList.stream()
                .anyMatch(e -> e.getEmailAddress().equals(entry.getEmailAddress()));

        if (isNotUnique) {
            System.out.print("Email ID must be unique, try again!\n");
        }  else {
            entryList.add(entry);
            System.out.println(entry);
            System.out.print("Woohoo, your entry was added! Taking you to the Main Menu...\n");
        }
    }

    //Delete an entry
    public static void removeEntry(String emailID) {

        boolean ans;
        if ( ans = entryList.removeIf(entry -> entry.getEmailAddress().equals(emailID))) {
            System.out.println("Contact with " +emailID + " is going to be deleted");
            System.out.println("The Address Book Modified: \n" +entryList + "\n");

        }

        else{
            ans = false;
            System.out.println("Please enter a valid email ID");
        }
    }



    //Search for an entry either using FirstName or LastName or PhoneNumber or emailAddress
    public static Entry searchEntry(char queryType, String query) {
        switch(queryType) {
            case 'F' -> {
                return entryList.stream()
                        .filter(entry -> entry.getFirstName().contains(query))
                        .findAny()
                        .orElseThrow();
            }
            case 'L' -> {
                return entryList.stream()
                        .filter(entry -> entry.getLastName().contains(query))
                        .findAny()
                        .orElseThrow();
            }
            case 'P' -> {
                return entryList.stream()
                        .filter(entry -> entry.getPhoneNumber().contains(query))
                        .findAny()
                        .orElseThrow();
            }
            case 'E' -> {
                return entryList.stream()
                        .filter(entry -> entry.getEmailAddress().contains(query))
                        .findAny()
                        .orElseThrow();
            }
            default -> new Entry("", "", "", "");
        }
        return new Entry("", "", " ", "");
    }

    //Printing all the contacts in the address book
    public static void printEntryList() {
        if (entryList.isEmpty()) {
            System.out.println("Address Book is empty");
        } else {
            System.out.println("Printing the contacts in Address Book \n" + entryList + "\n");
        }
    }


    //Deleting all the contacts from the address book
    public static void deleteList() {
        entryList.clear();
        System.out.println("All contacts in the address book are deleted!");
    }
}

