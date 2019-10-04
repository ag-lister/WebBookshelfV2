import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {
	
		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a book title: ");
			String bookTitle = in.nextLine();
			System.out.print("Enter an author: ");
			String bookAuthor = in.nextLine();
			System.out.print("Enter a genre: ");
			String bookGenre = in.nextLine();
			ListItem toAdd = new ListItem(bookTitle, bookAuthor, bookGenre);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the book title to delete: ");
			String bookTitle = in.nextLine();
			System.out.print("Enter the author to delete: ");
			String bookAuthor = in.nextLine();
			System.out.print("Enter a genre to delete: ");
			String bookGenre = in.nextLine();
			
			ListItem toDelete = new ListItem(bookTitle, bookAuthor, bookGenre);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by book title");
			System.out.println("2 : Search by author");
			System.out.println("3 : Search by genre");
			int searchBy = in.nextInt();
			in.nextLine();
			
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the book title: ");
				String bookTitle = in.nextLine();
				foundItems = lih.searchForItemByTitle(bookTitle);
				
			} else if (searchBy ==2) {
				System.out.print("Enter the author: ");
				String bookAuthor = in.nextLine();
				foundItems = lih.searchForItemByAuthor(bookAuthor);
				
			} else {
				System.out.print("Enter the genre: ");
				String bookGenre = in.nextLine();
				foundItems = lih.searchForItemByGenre(bookGenre);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println("ID: " + l.getId());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getTitle() + " by " + toEdit.getAuthor() + " Genre: " + toEdit.getGenre());
				System.out.println("1 : Update Title");
				System.out.println("2 : Update Author");
				System.out.println("3 : Update Genre");
				System.out.println("4 : Cancel Update");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New title: ");
					String newTitle = in.nextLine();
					toEdit.setTitle(newTitle);
				} else if (update == 2) {
					System.out.print("New author: ");
					String newAuthor = in.nextLine();
					toEdit.setAuthor(newAuthor);
				} else if (update == 3){
					System.out.print("New Genre: ");
					String newGenre = in.nextLine();
					toEdit.setGenre(newGenre);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- Edit Cancelled ----");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to your Bookshelf! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
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
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem : allItems) {
				System.out.println(singleItem.returnBookDetails());
			}
			

		}

	}