package contacts;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");

            String input = scanner.nextLine();

            switch (input) {
                case ("add"):
                    contactBook.add(scanner); //done
                    break;
                case ("list"):
                    contactBook.list(scanner);
                    break;
                case ("search"):
                    contactBook.search(scanner);
                    break;
                case ("count"):
                    contactBook.count();
                    break;
                case ("exit"):
                    return;
            }
            System.out.println();

        }

    }


}