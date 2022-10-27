import java.util.List;
import java.util.Scanner;

import controller.DishListHelper;
import model.DishList;


public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static DishListHelper dlh = new DishListHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter country: ");
			String country = in.nextLine();
			System.out.print("Enter dish name: ");
			String dishName = in.nextLine();
			System.out.print("Enter dish description: ");
			String dishDescription = in.nextLine();
			DishList toAdd = new DishList(country, dishName,dishDescription);
			dlh.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the country to delete: ");
			String country = in.nextLine();
			System.out.print("Enter the dish name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the dish description to delete: ");
			String description = in.nextLine();
			DishList toDelete = new DishList(country, name, description);
			dlh.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Country");
			System.out.println("2 : Search by Dish Name");
			System.out.println("3 : Search by Dish Description");
			int searchBy = in.nextInt();
			in.nextLine();
			List<DishList> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the country name: ");
				String countryName = in.nextLine();
				foundItems = dlh.searchForItemByCountry(countryName);
				} 
			else if (searchBy == 2 ){
				System.out.print("Enter the dish name: ");
				String dishName = in.nextLine();
				foundItems = dlh.searchForItemByName(dishName);
				
			}
			else {
				System.out.print("Enter the dish description: ");
				String dishDescription = in.nextLine();
				foundItems = dlh.searchForItemByName(dishDescription);
				}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (DishList l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				DishList toEdit = dlh.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getDishName() +"("+toEdit.getDishDescription()+") "+ " from " + toEdit.getCountry());
				System.out.println("1 : Update Country");
				System.out.println("2 : Update Dish Name");
				System.out.println("3 : Update Dish Description");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Country: ");
					String newCountry = in.nextLine();
					toEdit.setCountry(newCountry);
				}else if (update == 2) {
					System.out.print("New Dish Name: ");
					String newDishName = in.nextLine();
					toEdit.setDishName(newDishName);
				} else if (update == 3) {
					System.out.print("New Dish Description: ");
					String newDishDescription= in.nextLine();
					toEdit.setDishDescription(newDishDescription);
				}

				dlh.updateItem(toEdit);
				}
				
				else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("**********Dish list!**********");
			while (goAgain) {
				System.out.println("*  Select a dish:");
				System.out.println("*  1 -- Add a dish");
				System.out.println("*  2 -- Edit a dish");
				System.out.println("*  3 -- Delete a dish");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					//lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<DishList> allItems = dlh.showAllItems();
			for(DishList singleItem: allItems){
				System.out.println(singleItem.returnDishDetails());
			}
		}
			

}

	