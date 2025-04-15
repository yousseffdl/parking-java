
import java.util.InputMismatchException;
import java.util.Scanner;


public class Exceptions {

    public int check_range(int lower, int upper){
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
                choice = scanner.nextInt();
                if (choice < lower || choice > upper) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid choice. Please try again.");
                return -1;
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                return -1;
            }
        return choice;
    }
        
    
}
