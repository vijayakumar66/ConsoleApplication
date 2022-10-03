package view;

import java.util.Scanner;

class ResgisterAndLogin {
	static Scanner scanner = new Scanner(System.in);

	public static void startPage() {
		AlreadyUser alreadyUser = new AlreadyUser();
		AddNewUser addNewUser = new AddNewUser();
		System.out.println("\t YesBank Online");
		System.out.println("\t***************");
		System.out.println("\t1.Already User");
		System.out.println("\t2.New User");
		System.out.println("Enter the option ");
		int input = scanner.nextInt();
		while (!scanner.hasNextInt()) {
			System.out.println("Invalid Key.Enter again :");
			scanner.nextLine();
		}
		if (input > 0 && input < 3) {
			switch (input)

			{
			case 1:
				alreadyUser.alreadyUser();
				startPage();
				break;
			case 2:
				addNewUser.newUser();
				startPage();
				break;
			}
		} else {
			System.out.println("!Invalid Key");
			startPage();
		}

	}

	public static void main(String[] args) {
		startPage();
	}

}
