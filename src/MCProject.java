import java.util.Scanner;
import java.text.DecimalFormat;

public class MCProject {

	static DecimalFormat money = new DecimalFormat("$0.00");

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean shop = false;

		do {
			shop = shop(shop, kb);
			if (shop == true) {
				double changeDue = validPurchase(kb);
				makeChange(changeDue);
			}
		} while (shop == true);

	}

	public static boolean shop(boolean shop, Scanner kb) {
		System.out.println("Would you like to shop? (Yes/No)");
		String startShop = kb.next();
		if (startShop.equalsIgnoreCase("yes")) {
			shop = true;
		} else {
			System.out.println("Smell ya later!");
			shop = false;
		}
		return shop;
	}

	public static double validPurchase(Scanner kb) {
		System.out.print("Hi there, how much is that item you have?: ");
		double price = kb.nextDouble();
		System.out.println("Ok, great " + (money.format(price)));

		System.out.print("How much do you plan on paying?: ");
		double cashPaid = kb.nextDouble();
		double balance = (cashPaid - price);
		System.out.println("Change due: ");
		System.out.println(money.format(balance));

		if (balance == 0.0) {
			System.out.println("Great, have a nice day!");
		} else if (balance < 0.0) {
			System.out.println("Sorry but you are short some cash :(");
			System.out.println("What you have cost money, so cough up!\n");
		} else if (balance > 0.0) {
			System.out.println("Ok I owe you some change.");
		}
		return balance;

	}

	public static void makeChange(double changeDue) {
		int newChangeDue = (int) (Math.round(changeDue * 100));

		double[] denomination = { 2000, 1000, 500, 100, 25, 10, 5, 1 };
		String[] bills = { "Twenites", "Tens", "Fives", "Ones", "Quarters", "Dimes", "Nickels", "Pennies" };
		String[] bill = { "Twenty", "Ten", "Five", "One", "Quarter", "Dime", "Nickel", "Penny" };

		for (int i = 0; i < denomination.length; i++) {
			int makingChange = 0;
			makingChange = (int) (newChangeDue / denomination[i]);
			newChangeDue = newChangeDue - (int) (makingChange * denomination[i]);
			if (makingChange > 1) {
				System.out.println(makingChange + " " + bills[i]);
			} else if (makingChange == 1) {
				System.out.println(makingChange + " " + bill[i]);
			}
		}
	}
}
