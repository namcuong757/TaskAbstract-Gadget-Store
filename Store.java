package CoreJava6;

import java.util.Scanner;

public abstract class Store {
    public int counter = 0;
    public int total_bill = 0;
    public String bill = "====================\nGood Buy Shop\n"
            + "Sl.no\tDescription\t\tYear\tQty\tPrice\tTotal Price\n";

    Store() {
    }

    public void update(Store a) {
        a.counter++;
    }

    public abstract String sale(Store a);

    public String bill_generator(String sub_bill) {
        bill += sub_bill;
        return bill;
    }

    public void intro(Store a, Laptop lap, Phone phone, TV tv) {
        int cont = 0;
        int giftCard = 0;
        int remaining = 0;
        System.out.println("Good Buy Shop");
        System.out.println("====================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello...What is your name?");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! How are you today?");
        System.out.println("Are you ready to check out?");
        do {
            int cont0 = 0;

            do {
                String bill = null;
                System.out.println("Select an item you want to check out");
                System.out.println("1. Laptop\n2. Phone\n3. TV");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        bill = bill_generator(lap.sale(a));
                        break;
                    case 2:
                        bill = bill_generator(phone.sale(a));
                        break;
                    case 3:
                        bill = bill_generator(tv.sale(a));
                        break;
                    default:
                        System.out.println("Item does not exist");
                }
                System.out.println("Want to buy more? 0. Yes 1. No");
                cont0 = scanner.nextInt();
                if (cont0 < 0 || cont0 > 1) {
                    System.out.println("Invalid choice. Terminate");
                    break;
                }
            } while (cont0 != 1);

            if (bill != null) {
                System.out.println(bill);
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Your total amount is \t\t" + total_bill);
                System.out.println("--------------------------------------------------------------------");
            }

            System.out.print("If you have any gift card, please enter: ");
            giftCard = scanner.nextInt();
            giftCard += remaining;
            if (giftCard != 0) {
                if (giftCard >= total_bill) {
                    remaining = giftCard - total_bill;
                    total_bill = 0;
                } else if (giftCard < total_bill) {
                    total_bill -= giftCard;
                    remaining = 0;
                }

                System.out.println(bill);
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Gift Card Amount: \t\t" + giftCard);
                System.out.println("Gift Card Remaining: \t\t" + remaining);
                System.out.println("Your total amount is \t\t" + total_bill);
                System.out.println("--------------------------------------------------------------------");
            }

            System.out.println("Want to buy more? 0. Yes 1. No");
            cont = scanner.nextInt();

            if (cont < 0 || cont > 1) {
                System.out.println("Invalid choice. Terminate");
                break;
            }
        } while (cont != 1);
    }
}
