import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class OrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> orderItems = new ArrayList<>();
        List<Integer> orderQuantities = new ArrayList<>();
        List<Double> orderPrices = new ArrayList<>();

        System.out.println("Welcome to Lidl Supermarket! Ready to take your order?");
        System.out.println("Enter (Y)es or (N)o:");
        String input = scanner.nextLine().trim().toUpperCase();

        while (!input.equals("Y") && !input.equals("N")) {
            System.out.println("Invalid input. Please enter (Y)es or (N)o:");
            input = scanner.nextLine().trim().toUpperCase();
        }

        while (input.equals("Y")) {
            System.out.println("Choose a menu category from the following:");
            System.out.println("╔==========================================╗");
            System.out.println("║            Lidl Supermarket Menu         ║");
            System.out.println("║                  Category                ║");
            System.out.println("╠==========================================╣");
            System.out.println("║ 1. Canned Goods          6. Snacks       ║");
            System.out.println("║ 2. Frozen Foods          7. Fruits       ║");
            System.out.println("║ 3. Fresh Produce         8. Vegetables   ║");
            System.out.println("║ 4. Beverages             9. Dairy        ║");
            System.out.println("║ 5. Deli                  10. Health Care ║");
            System.out.println("╚==========================================╝");

            int categoryChoice = 0;
            boolean validInput = false;

            System.out.println("Enter the number of your choice:");

            while (!validInput) {
                try {
                    categoryChoice = scanner.nextInt();
                    if (categoryChoice >= 1 && categoryChoice <= 10) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid category choice. Please enter a number between 1 and 10:");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 10:");
                    scanner.next();
                }
            }

            switch (categoryChoice) {
                case 1:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Baked beans", "Soup", "Canned Tomatoes", "Hot Dogs", "Dog Food"},
                                        new double[]{248.00, 112.00, 187.00, 102.00, 70.00},
                                        "Canned Goods");
                    break;
                case 2:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Frozen Pizza", "Ice Cream", "Frozen Vegetables", "Frozen Fries", "Frozen Chicken"},
                                        new double[]{349.00, 199.00, 129.00, 99.00, 299.00},
                                        "Frozen Foods");
                    break;
                case 3:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Apples", "Bananas", "Oranges", "Grapes", "Strawberries"},
                                        new double[]{79.00, 69.00, 89.00, 129.00, 149.00},
                                        "Fresh Produce");
                    break;
                case 4:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Soda", "Juice", "Water", "Energy Drink", "Milk"},
                                        new double[]{59.00, 69.00, 29.00, 99.00, 89.00},
                                        "Beverages");
                    break;
                case 5:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Ham", "Cheese", "Turkey", "Salami", "Roast Beef"},
                                        new double[]{299.00, 249.00, 349.00, 279.00, 399.00},
                                        "Deli");
                    break;
                case 6:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Chips", "Popcorn", "Nuts", "Crackers", "Cookies"},
                                        new double[]{49.00, 69.00, 129.00, 59.00, 79.00},
                                        "Snacks");
                    break;
                case 7:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Apples", "Bananas", "Grapes", "Mangoes", "Pineapple"},
                                        new double[]{79.00, 69.00, 129.00, 89.00, 99.00},
                                        "Fruits");
                    break;
                case 8:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Carrots", "Broccoli", "Spinach", "Cucumbers", "Lettuce"},
                                        new double[]{49.00, 59.00, 39.00, 35.00, 45.00},
                                        "Vegetables");
                    break;
                case 9:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Milk", "Cheese", "Yogurt", "Butter", "Cream"},
                                        new double[]{89.00, 149.00, 69.00, 79.00, 59.00},
                                        "Dairy");
                    break;
                case 10:
                    handleCategoryOrder(scanner, orderItems, orderQuantities, orderPrices,
                                        new String[]{"Vitamins", "Pain Relievers", "Bandages", "Cough Syrup", "Antiseptic"},
                                        new double[]{249.00, 149.00, 79.00, 129.00, 89.00},
                                        "Health Care");
                    break;
            }

            System.out.println("Want to order more? (Y/N)");
            input = scanner.next().trim().toUpperCase();

            while (!input.equals("Y") && !input.equals("N")) {
                System.out.println("Invalid input. Please enter (Y)es or (N)o:");
                input = scanner.next().trim().toUpperCase();
            }
        }

        if (!orderItems.isEmpty()) {
            printReceipt(orderItems, orderQuantities, orderPrices, scanner);
        } else {
            System.out.println("Thank you! Have a great day!");
        }
    }

    public static void handleCategoryOrder(Scanner scanner, List<String> orderItems, List<Integer> orderQuantities,
                                            List<Double> orderPrices, String[] items, double[] prices, String category) {
        printMenu(items, prices, category);

        int itemChoice = 0;
        boolean validItemChoice = false;

        while (!validItemChoice) {
            System.out.println("Enter the number of your choice:");
            try {
                itemChoice = scanner.nextInt();
                if (itemChoice >= 1 && itemChoice <= items.length) {
                    validItemChoice = true;
                } else {
                    System.out.println("Invalid item choice. Please enter a number between 1 and " + items.length + ":");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and " + items.length + ":");
                scanner.next();
            }
        }

        int quantity = 0;
        boolean validQuantity = false;

        while (!validQuantity) {
            System.out.println("How many units would you like to purchase?");
            try {
                quantity = scanner.nextInt();
                if (quantity > 0) {
                    validQuantity = true;
                } else {
                    System.out.println("Invalid quantity. Please enter a positive number:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive number:");
                scanner.next();
            }
        }

        orderItems.add(items[itemChoice - 1]);
        orderQuantities.add(quantity);
        orderPrices.add(prices[itemChoice - 1]);

        System.out.println("You have added " + quantity + " unit(s) of " + items[itemChoice - 1] + " to your order.");
    }

    public static void printMenu(String[] items, double[] prices, String category) {
        int boxWidth = 40;
        int padding = (boxWidth - category.length()) / 2;
        String centeredTitle = String.format("%" + padding + "s%s%" + padding + "s", "", category, "");

        if (centeredTitle.length() > boxWidth) {
            centeredTitle = category.substring(0, boxWidth - 2);
        }

        System.out.println("╔" + "=".repeat(boxWidth) + "╗");
        System.out.println("║" + centeredTitle + "║");
        System.out.println("╠" + "=".repeat(boxWidth) + "╣");

        for (int i = 0; i < items.length; i++) {
            String itemLine = String.format("%d. %-25s P%.2f", (i + 1), items[i], prices[i]);
            System.out.println("║ " + itemLine + " ".repeat(boxWidth - itemLine.length() - 3) + "║");
        }

        System.out.println("╚" + "=".repeat(boxWidth) + "╝");
    }

    public static void printReceipt(List<String> orderItems, List<Integer> orderQuantities, List<Double> orderPrices, Scanner scanner) {
        int boxWidth = 40;
        double total = 0.0;

        System.out.println("\n╔" + "=".repeat(boxWidth) + "╗");
        String title = "Lidl Supermarket\nReceipt";
        String[] titleLines = title.split("\n");
        for (String line : titleLines) {
            int padding = (boxWidth - line.length()) / 2;
            String centeredTitle = String.format("%" + padding + "s%s%" + padding + "s", "", line, "");
            System.out.println("║" + centeredTitle + "║");
        }
        System.out.println("╠" + "=".repeat(boxWidth) + "╣");

        for (int i = 0; i < orderItems.size(); i++) {
            double itemTotal = orderQuantities.get(i) * orderPrices.get(i);
            total += itemTotal;
            String itemLine = String.format("%d x %-20s P%.2f", orderQuantities.get(i), orderItems.get(i), itemTotal);
            System.out.println("║ " + itemLine + " ".repeat(boxWidth - itemLine.length() - 3) + "║");
        }

        System.out.println("╠" + "=".repeat(boxWidth) + "╣");

        String totalLine = String.format("Total: P%.2f", total);
        System.out.println("║ " + totalLine + " ".repeat(boxWidth - totalLine.length() - 3) + "║");

        double payment = 0.0;
        boolean validPayment = false;

        while (!validPayment) {
            System.out.print("Add payment: P");
            try {
                payment = scanner.nextDouble();
                if (payment >= total) {
                    validPayment = true;
                } else {
                    System.out.println("Insufficient payment. Please enter an amount greater than or equal to P" + total);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount:");
                scanner.next();
            }
        }

        double change = payment - total;
        System.out.println("\n╔" + "=".repeat(boxWidth) + "╗");
        System.out.println(titleLines[0 != titleLines.length ? 0 : titleLines.length - 1] != null ?
            "║" + String.format("%" + (boxWidth - titleLines[0].length()) / 2 + "s%s%" + (boxWidth - titleLines[0].length()) / 2 + "s", "", titleLines[0], "") + "║" : "");
        System.out.println("╠" + "=".repeat(boxWidth) + "╣");

        for (int i = 0; i < orderItems.size(); i++) {
            double itemTotal = orderQuantities.get(i) * orderPrices.get(i);
            String itemLine = String.format("%d x %-20s P%.2f", orderQuantities.get(i), orderItems.get(i), itemTotal);
            System.out.println("║ " + itemLine + " ".repeat(boxWidth - itemLine.length() - 3) + "║");
        }

        System.out.println("╠" + "=".repeat(boxWidth) + "╣");

        String totalLineFinal = String.format("Total: P%.2f", total);
        String paymentLine = String.format("Payment: P%.2f", payment);
        String changeLine = String.format("Change: P%.2f", change);

        System.out.println("║ " + totalLineFinal + " ".repeat(boxWidth - totalLineFinal.length() - 3) + "║");
        System.out.println("║ " + paymentLine + " ".repeat(boxWidth - paymentLine.length() - 3) + "║");
        System.out.println("║ " + changeLine + " ".repeat(boxWidth - changeLine.length() - 3) + "║");
        System.out.println("╚" + "=".repeat(boxWidth) + "╝");

        System.out.println("\nThank you for shopping at Lidl Supermarket! Have a great day!");
    }
}
