import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Add contacts to phonebook");
        AddNewContact("Ivanov", "4444333322221111");
        AddNewContact("Ivanov", "1234567890");
        AddNewContact("Smirnov", "222333344445555");
        ShowEntryContact("Ivanov");
        ShowEntryContact("Petrov");
        ShowEntryContact("Smirnov");
        System.out.println("Removing contacts from phonebook");
        RemoveContact("Ivanov", "4444333322221111");
        RemoveContact("Smirnov", "222333344445555");
        ShowEntryContact("Ivanov");
        ShowEntryContact("Petrov");
        ShowEntryContact("Smirnov");
    }

    public static Map<String, LinkedList<String>> PhoneBook = new HashMap<>();

    public static void AddNewContact(String name, String phoneNumber) {
        if (PhoneBook.containsKey(name)) {
            PhoneBook.get(name).add(phoneNumber);
        } else {
            LinkedList<String> numbers = new LinkedList<String>();
            numbers.add(phoneNumber);
            PhoneBook.put(name, numbers);
        }
    }

    public static LinkedList<String> SearchPhoneNumbers(String name) {
        if (!PhoneBook.containsKey(name)) return null;
        return PhoneBook.get(name);
    }

    public static void ShowEntryContact(String name) {
        LinkedList<String> phoneNumbers = SearchPhoneNumbers(name);
        if (phoneNumbers == null) {
            System.out.printf("%s is not in the PhoneBook.\n", name);
        } else if (phoneNumbers.size() == 0) {
            System.out.printf("%s has no phone numbers.\n", name);
        } else {
            System.out.printf("%s has phones: %s\n", name, String.join(", ", phoneNumbers));;
        }
    }

    public static void RemoveContact(String name, String phoneNumber) {
        if (PhoneBook.containsKey(name)) {
            PhoneBook.get(name).remove(phoneNumber);
        }
    }
}