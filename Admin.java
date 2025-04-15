import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends person {
    


    public void main_menu() {
        while (true) {
            Scanner input = new Scanner(System.in);
            int choice;
            System.out.println("1. Add Slots");
            System.out.println("2. Delete an Entity");
            System.out.println("3. Display All Available Slots for All Spots");
            System.out.println("4. Display All Owners' Data");
            System.out.println("5. Display All Spots Data");
            System.out.println("6. Calculate and Display Total Money from Normal Spot Reservations");
            System.out.println("7. Calculate and Display Total Money from Bike Spot Reservations");
            System.out.println("8. Calculate and Display Total Money from Large Spot Reservations");
            System.out.println("9. Update Any Data of Any Entity");
            System.out.println("10. Logout");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:
                    add_slot();
                    break;
                case 2:
                    Delete_entity();
                    break;
                case 3:
                    Display_Available_slots();
                    break;
                case 4:
                    Display_all_owner_data();
                    break;
                case 5:
                    Dipslay_spots();
                    break;
                case 6:
                    Display_normal_spot_total_amount();
                    break;
                case 7:
                    Display_bike_spot_total_amount();
                    break;
                case 8:
                    Display_large_spot_total_amount();
                    break;
                case 9:
                    update_data();
                    break;
                case 10:
                    System.out.println("logging out....");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 10.");
                    break;
            }
        }
    }

    public void add_slot() {
        Scanner scanner = new Scanner(System.in);
        String ans1 = new String();
        slots slot = new slots();
        int ans2;
        int ans3;
        try {
            System.out.println("Which spot kind do you want to add slots to: ( bike | normal | large )");
            ans1 = scanner.next();
            System.out.println("Which spot id do you want to add slots to: 200 | 201 | 202");
            ans2 = scanner.nextInt();
            System.out.println("How many slots you want to add");
            ans3 = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            return;
        }
        if (ans1.toLowerCase().equals("bike")) {
            if (ans2 == bike.getSpot_id()) {
                for (int i = 0; i < ans3; i++) {
                    bike.addslots();
                    bike.setAvailable_slots(bike.getAvailable_slots() + 1);
                    bike.setSlot(bike.getSlot() + 1);
                }
            } else {
                System.out.println("Invalid id");
                return;
            }
        } else if (ans1.toLowerCase().equals("normal")) {
            if (ans2 == car.getSpot_id()) {
                for (int i = 0; i < ans3; i++) {

                    car.addslots();
                    car.setAvailable_slots(car.getAvailable_slots() + 1);
                    car.setSlot(car.getSlot() + 1);

                }
            } else {
                System.out.println("Invalid id");
                return;
            }
        } else if (ans1.toLowerCase().equals("large")) {
            if (ans2 == fourByFour.getSpot_id()) {
                for (int i = 0; i < ans3; i++) {

                    fourByFour.addslots();
                    fourByFour.setAvailable_slots(fourByFour.getAvailable_slots() + 1);
                    fourByFour.setSlot(fourByFour.getSlot() + 1);

                }
            } else {
                System.out.println("Invalid id");
                return;
            }
        } else {
            System.out.println("Invalid type");
        }
    }

    public void Delete_entity() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int choice2;
        int index = 0;
        String choice3;
        int choice4;
        System.out.println("Select the entity you want to delete");
        System.out.println("1.User");
        System.out.println("2.Vehicle");
        System.out.println("3.Reservation");
        System.out.println("4.Available slot");
        System.out.println("5.Return to main menu");
        Exceptions e = new Exceptions();
        choice = e.check_range(1, 5);
        if (choice == -1) {
            System.out.println("Invalid choice");
            return;
        }
        switch (choice) {
            case 1:
                System.out.println("Enter the id of the user you want to delete");
                try {
                    choice2 = scanner.nextInt();
                } catch (InputMismatchException l) {
                    System.out.println("Invalid input.");
                    return;
                }
                index = main.users.indexOf(new user(" ", " ", " ", 0, 0, " ", " ", choice2));
                if (index == -1) {
                    System.out.println("Id not found");
                    return;
                }
                System.out.println("Owner Name: " + main.users.get(index).getName());
                System.out.println("Owner ID: " + main.users.get(index).getId());
                System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
                for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
                    System.out.println("Vehicles: ");
                    System.out.print(j+1 + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
                    if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                        System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                        System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                        System.out.print(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
                    }

                }
                System.out.println(" ");
                System.out.println("Are you sure you want to delete this user? Y/N");
                try {
                    choice3 = scanner.next();
                } catch (InputMismatchException l) {
                    System.out.println("Invalid input.");
                    return;
                }
                switch (choice3) {
                    case "Y":
                    case "y":
                        main.users.remove(index);
                        System.out.println("User deleted successfully");
                        break;
                    case "N":
                    case "n":
                        System.out.println("No changes had done");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 2:
                System.out.println("Enter the id of the user you want to delete his vehicle");
                try {
                    choice2 = scanner.nextInt();
                } catch (InputMismatchException l) {
                    System.out.println("Invalid input.");
                    return;
                }
                index = main.users.indexOf(new user(" ", " ", " ", 0, 0, " ", " ", choice2));
                if (index == -1) {
                    System.out.println("Id not found");
                    return;
                }
                System.out.println("Owner Name: " + main.users.get(index).getName());
                System.out.println("Owner ID: " + main.users.get(index).getId());
                System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
                choice4 = main.users.get(index).selectVehicle();
                System.out.println(" ");
                System.out.println("Are you sure you want to delete this vehicle? Y/N");
                try {
                    choice3 = scanner.next();
                } catch (InputMismatchException l) {
                    System.out.println("Invalid input.");
                    return;
                }
                switch (choice3) {
                    case "Y":
                    case "y":
                        if (main.users.get(index).vehicle.get(choice4).There_is_reservation) {
                            main.users.get(index).vehicle.get(choice4).ConfirmCancelation();
                        }
                        main.users.get(index).vehicle.remove(choice4);
                        System.out.println("vehicle deleted successfully");
                        break;
                    case "N":
                    case "n":
                        System.out.println("No changes had done");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 3:
                System.out.println("Enter the id of the user you want to delete his resrvation");
                try {
                    choice2 = scanner.nextInt();
                } catch (InputMismatchException l) {
                    System.out.println("Invalid input.");
                    return;
                }
                index = main.users.indexOf(new user(" ", " ", " ", 0, 0, " ", " ", choice2));
                if (index == -1) {
                    System.out.println("Id not found");
                    return;
                }
                System.out.println("Owner Name: " + main.users.get(index).getName());
                System.out.println("Owner ID: " + main.users.get(index).getId());
                System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
                System.out.println("Here is the reserved vehicles");
                choice4 = main.users.get(index).selectReservedVehicle();
                System.out.println(" ");
                System.out.println("Are you sure you want to delete this reservation? Y/N");
                try {
                    choice3 = scanner.next();
                } catch (InputMismatchException l) {
                    System.out.println("Invalid input.");
                    return;
                }
                switch (choice3) {
                    case "Y":
                    case "y":
                        main.users.get(index).vehicle.get(choice4).ConfirmCancelation();
                        System.out.println("reservation deleted successfully");
                        break;
                    case "N":
                    case "n":
                        System.out.println("No changes had done");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 4:
                System.out.println("Select the type of the spot you want to delete it's slots");
                System.out.println("1.Bike spot");
                System.out.println("2.Normal spot");
                System.out.println("3.Large spot");
                try {
                    choice2 = scanner.nextInt();
                } catch (InputMismatchException l) {
                    System.out.println("Invalid input.");
                    return;
                }
                switch (choice2) {
                    case 1:
                        System.out.println("Here is the number of available slots");
                        bike.getAvailable_slots();
                        System.out.println("Enter the number of slots you want to delete");
                        try {
                            choice4 = scanner.nextInt();
                        } catch (InputMismatchException l) {
                            System.out.println("Invalid input.");
                            return;
                        }
                        if (choice4 > bike.getAvailable_slots()) {
                            System.out.println("The number of slots you want to delete is not available");
                        } else {
                            for (int i = 0; i < choice4; i++) {
                                bike.removeslots();
                            }
                            System.out.println("Slots removed successfully");
                        }
                        break;
                    case 2:
                        System.out.println("Here is the number of available slots");
                        car.getAvailable_slots();
                        System.out.println("Enter the number of slots you want to delete");
                        try {
                            choice4 = scanner.nextInt();
                        } catch (InputMismatchException l) {
                            System.out.println("Invalid input.");
                            return;
                        }
                        if (choice4 > car.getAvailable_slots()) {
                            System.out.println("Can't delete a reserved spot");
                        } else {
                            for (int i = 0; i < choice4; i++) {
                                car.removeslots();
                            }
                            System.out.println("Slots removed successfully");
                        }
                        break;
                    case 3:
                        System.out.println("Here is the number of available slots");
                        fourByFour.getAvailable_slots();
                        System.out.println("Enter the number of slots you want to delete");
                        try {
                            choice4 = scanner.nextInt();
                        } catch (InputMismatchException l) {
                            System.out.println("Invalid input.");
                            return;
                        }
                        if (choice4 > fourByFour.getAvailable_slots()) {
                            System.out.println("Can't delete a reserved spot");
                        } else {
                            for (int i = 0; i < choice4; i++) {
                                fourByFour.removeslots();
                            }
                            System.out.println("Slots removed successfully");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
                break;
            case 5:
                return;
        }
    }

    public void Display_Available_slots() {
        System.out.println("Spot Type: " + car.getSpot_type());
        System.out.println("Spot ID: " + car.getSpot_id());
        System.out.println("Number of available slots: " + car.getAvailable_slots());
        for (int i = 0; i < car.slotsArray.size(); i++) {
            System.out.println("Slot Date: " + car.slotsArray.get(i).getDate());
            System.out.println("Slot Time: " + car.slotsArray.get(i).getTime());
        }
        System.out.println("Spot Type: " + bike.getSpot_type());
        System.out.println("Spot ID: " + bike.getSpot_id());
        System.out.println("Number of available slots: " + bike.getAvailable_slots());
        for (int i = 0; i < bike.slotsArray.size(); i++) {
            System.out.println("Slot Date: " + bike.slotsArray.get(i).getDate());
            System.out.println("Slot Time: " + bike.slotsArray.get(i).getTime());
        }
        System.out.println("Spot Type: " + fourByFour.getSpot_type());
        System.out.println("Spot ID: " + fourByFour.getSpot_id());
        System.out.println("Number of available slots: " + fourByFour.getAvailable_slots());
        for (int i = 0; i < fourByFour.slotsArray.size(); i++) {
            System.out.println("Slot Date: " + fourByFour.slotsArray.get(i).getDate());
            System.out.println("Slot Time: " + fourByFour.slotsArray.get(i).getTime());

        }
    }

    public void Display_all_owner_data() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the user you want to show");
        int choice1;
        try {
            choice1 = scanner.nextInt();
        } catch (InputMismatchException l) {
            System.out.println("Invalid input.");
            return;
        }
        int index = main.users.indexOf(new user(" ", " ", " ", 0, 0, " ", " ", choice1));
        if (index == -1) {
            System.out.println("Id not found");
            return;
        }
        System.out.println("Owner Name: " + main.users.get(index).getName());
        System.out.println("Owner ID: " + main.users.get(index).getId());
        System.out.println("Owner Age: " + main.users.get(index).getAge());
        System.out.println("Owner Address: " + main.users.get(index).getAddress());
        System.out.println("Owner Email: " + main.users.get(index).getE_mail());
        System.out.println("Owner Phone number: " + main.users.get(index).getPhone_number());
        System.out.println("Owner Gender: " + main.users.get(index).getGender());
        System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
        for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
            System.out.println("Vehicles: ");
            System.out.print(j + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
            if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                System.out.println(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
            }

        }

    }

    public void Dipslay_spots() {
        for (int i = 0; i < bike.slotsArray.size(); i++) {
            System.out.println("Spot ID: " + bike.getSpot_id());
            System.out.println("Spot Type: " + bike.getSpot_type());
            System.out.print("Date: " + bike.slotsArray.get(i).getDate());
            if (bike.slotsArray.get(i).getDate() > 0) {
                System.out.println("/12/2024");
            } else {
                System.out.println(" ");
            }
            System.out.println("time: " + bike.slotsArray.get(i).getTime());
            System.out.println("fees: " + bike.slotsArray.get(i).getFees());
        }
        for (int i = 0; i < car.slotsArray.size(); i++) {
            System.out.println("Spot ID: " + car.getSpot_id());
            System.out.println("Spot Type: " + car.getSpot_type());
            System.out.print("Date: " + car.slotsArray.get(i).getDate());
            if (car.slotsArray.get(i).getDate() > 0) {
                System.out.println("/12/2024");
            } else {
                System.out.println(" ");
            }
            System.out.println("time: " + car.slotsArray.get(i).getTime());
            System.out.println("fees: " + car.slotsArray.get(i).getFees());
        }
        for (int i = 0; i < fourByFour.slotsArray.size(); i++) {
            System.out.println("Spot ID: " + fourByFour.getSpot_id());
            System.out.println("Spot Type: " + fourByFour.getSpot_type());
            System.out.print("Date: " + fourByFour.slotsArray.get(i).getDate());
            if (fourByFour.slotsArray.get(i).getDate() > 0) {
                System.out.println("/12/2024");
            } else {
                System.out.println(" ");
            }
            System.out.println("time: " + fourByFour.slotsArray.get(i).getTime());
            System.out.println("fees: " + fourByFour.slotsArray.get(i).getFees());
        }
    }

    public void Display_normal_spot_total_amount() {
        int fees = 0;
        for (int i = 0; i < car.getAvailable_slots(); i++) {
            fees += car.slotsArray.get(i).getFees();
        }
        System.out.println("Normal Spot fees: " + fees);
    }

    void Display_bike_spot_total_amount() {
        int fees = 0;
        for (int i = 0; i < bike.getAvailable_slots(); i++) {
            fees += bike.slotsArray.get(i).getFees();
        }
        System.out.println("bike Spot fees: " + fees);
    }

    public void Display_large_spot_total_amount() {
        int fees = 0;
        for (int i = 0; i < fourByFour.getAvailable_slots(); i++) {
            fees += fourByFour.slotsArray.get(i).getFees();
        }
        System.out.println("Large Spot fees: " + fees);
    }

    public void update_data() {
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id of the user you want to update");
        int choice1;
        int choice9;
        try {
            choice1 = input.nextInt();
        } catch (InputMismatchException l) {
            System.out.println("Invalid input.");
            return;
        }
        int index = main.users.indexOf(new user(" ", " ", " ", 0, 0, " ", " ", choice1));
        if (index == -1) {
            System.out.println("Id not found");
            return;
        }
        System.out.println("Owner Name: " + main.users.get(index).getName());
        System.out.println("Owner ID: " + main.users.get(index).getId());
        System.out.println("Owner Total Fees: " + main.users.get(index).getFees());
        System.out.println(" ");
        System.out.println("Enter the number ");
        System.out.println("1.update Vehicle");
        System.out.println("2.Return to main menu");
        Exceptions e = new Exceptions();
        choice9 = e.check_range(1, 2);
        if (choice9 == -1) {
            System.out.println("Invalid choice");
            return;
        }
        int choice2;
        switch (choice9) {
            case 1:
                System.out.println("1.update the name of the vehicle");
                System.out.println("2.update the liscenes number");
                System.out.println("3.update the reservation");
                System.out.println("4.cancel the reservation");
                int choice3 = e.check_range(1, 4);
                if (choice3 == -1) {
                    System.out.println("Invalid choice");
                    return;
                }
                switch (choice3) {
                    case 1:
                        for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
                            System.out.println("Vehicles: ");
                            System.out.print(j + 1 + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
                            if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                                System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                                System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                                System.out.print(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
                            }

                        }
                        System.out.println(" ");
                        System.out.println("Enter the number of vehicle you want to update");
                        choice2 = e.check_range(1, main.users.get(index).vehicle.size());
                        if (choice2 == -1) {
                            return;
                        }
                        System.out.println("Enter the new vehicle name");
                        String s;
                        try {
                            s = scanner.next();
                        } catch (InputMismatchException l) {
                            System.out.println("Invalid input.");
                            return;
                        }
                        main.users.get(index).vehicle.get(choice2 - 1).setName(s);
                        break;
                    case 2:
                        for (int j = 0; j < main.users.get(index).vehicle.size(); j++) {
                            System.out.println("Vehicles: ");
                            System.out.print(j + 1 + ". " + main.users.get(index).vehicle.get(j).getName() + " (License: " + main.users.get(index).vehicle.get(j).getLicenes_number());
                            if (main.users.get(index).vehicle.get(j).There_is_reservation) {
                                System.out.print(" Reservation date: " + main.users.get(index).vehicle.get(j).getReservationdate() + "/12/2024");
                                System.out.print(" Reservation time: " + main.users.get(index).vehicle.get(j).getReservationtime() + ":00");
                                System.out.print(" Reservation hours " + main.users.get(index).vehicle.get(j).getHours());
                            }

                        }
                        System.out.println("Enter the number of vehicle you want to update");
                        choice2 = e.check_range(1, main.users.get(index).vehicle.size());
                        if (choice2 == -1) {
                            System.out.println("Invalid choice");
                            return;
                        }
                        System.out.println("Enter the new number");
                        String L;
                        try {
                            L = scanner.next();
                        } catch (InputMismatchException l) {
                            System.out.println("Invalid input.");
                            return;
                        }
                        main.users.get(index).vehicle.get(choice2 - 1).setName(L);
                        break;
                    case 3:
                        main.users.get(index).updatereservation();
                        break;
                    case 4:
                        main.users.get(index).CancelReservation();
                        break;
                }

                break;
            case 2:
                return;
        }

    }

}
