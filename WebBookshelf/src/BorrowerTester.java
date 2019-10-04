import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.BorrowerHelper;
import controller.ListDetailsHelper;
import model.Borrower;
import model.ListDetails;
import model.ListItem;

public class BorrowerTester {

	public static void main(String[] args) {
		Borrower susan = new Borrower("Susan");
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListItem book1 = new ListItem("Book1", "Andy", "Biography");
		ListItem book2 = new ListItem("Book2", "Andy", "Autobiography");
		
		List<ListItem> susansBooks = new ArrayList<ListItem>();
		susansBooks.add(book1);
		susansBooks.add(book2);
		
		ListDetails susansList = new ListDetails(LocalDate.now(), susan);
		susansList.setListOfBooks(susansBooks);
		ldh.insertNewListDetails(susansList);
		
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			System.out.println(a.toString());
		}
	}

}