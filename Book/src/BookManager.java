import java.util.ArrayList;
import java.util.List;

public class BookManager {
	public List<Book> bookList = new ArrayList<>();

    public Book AddBook(int id, String title, String author, int date) {
        Book newBook = new Book(id, title, author, date);
        bookList.add(newBook);
        return newBook;
    }

    public void RemoveBook(int id) {
    	int idx = 0;
    	
    	for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                idx = i;
                break;
            }
        }
    	bookList.remove(idx);
    }

    public Book SearchBook(int id) {
    	int idx = 0;
    	
    	for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                idx = i;
                break;
            }
        }
		return bookList.get(idx);
    }
}
