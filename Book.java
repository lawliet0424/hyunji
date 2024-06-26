<<<<<<< HEAD
import java.util.ArrayList;

public class Book {
	
	// book 클래스
	private String id;
	private String title;
	private String author;
	private int year;
		
	public Book(String id, String title, String author, int year) {
		this.id = id;
		this.title= title;
		this.author = author;
		this.year = year;
	}
		
	public String GetId() {
		return id;
	}
		
	public String GetBookInfo() {
		String info = String.format("Book{id: %s, 제목: %s, 저자: %s, 출판년도: %d}도서", id, title, author, year);
		return info;
	}
	
	// bookmanager 클래스
	private static ArrayList<Book> books = new ArrayList<>();
	
	public static Boolean AddBook(Book newBook) {
		// 추가하려는 도서 id가 이미 존재하는 id인지 확인
		for (int i = 0; i < books.size(); i++) {
		    Book book = books.get(i);
		    if(book.GetId() == newBook.GetId()) {
		    	// 이미 있는 id이면, 경고문 보내기
		    	String alertinfo = String.format("해당 ID(%s)는 이미 존재합니다.\n", newBook.GetId());
		    	System.out.println(alertinfo);
		    	return false;
		    }
		}
		
		//기존에 없던 id이면 books에 추가하고, 추가했다는 안내문 보내기
		books.add(newBook);
		String addinfo = newBook.GetBookInfo() + "가 추가되었습니다.\n";
		System.out.println(addinfo);
		return true;
	}
	
	public static Boolean SearchBook(String id) {
		// 찾고자하는 도서 id로 books 검색
		for (int i = 0; i < books.size(); i++) {
		    Book book = books.get(i);
		    if(book.GetId() == id) {
		    	// 도서가 존재하는 경우
		    	// 도서 정보 출력
		    	System.out.println(book.GetBookInfo() + "\n");
		    	return true;
		    }
		}
		
		//도서가 존재하지 않는 경우
		System.out.println("검색된 도서가 없습니다.\n");
		return false;
	}
	
	public static Boolean RemoveBook(String id) {
		// 지우고자 하는 도서 id를 바탕으로 books 검색
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if(book.GetId() == id) {
				String addinfo = book.GetBookInfo() + "를 삭제하였습니다.\n";
				System.out.println(addinfo);
				books.remove(book);
				return true;
			}
		}
		
		//도서가 존재하지 않는 경우
		String alertinfo = String.format("해당 ID(%s)의 도서를 찾을 수 없습니다.\n", id);
    	System.out.println(alertinfo);
    	return false;
	}
}
=======

import java.util.ArrayList;
import java.util.List;

public class Book {
  private int id;
  private String title;
  private String author;
  private int publicationYear;
  private static List<Book> bookCollection = new ArrayList<>();

  public Book(int id, String title, String author, int publicationYear) {
      this.id = id;
      this.title = title;
      this.author = author;
      this.publicationYear = publicationYear;
  }

  public int getId() {
      return id;
  }

  public String getTitle() {
      return title;
  }

  public String getAuthor() {
      return author;
  }

  public int getPublicationYear() {
      return publicationYear;
  }

  public static boolean addBook(Book book) {
      for (Book b : bookCollection) {
      	// 추가 
      	if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
      		System.out.println("책제목이 null이면 추가할 수 없습다.");
              return false;
          }
      	
          if (b.getId() == book.getId()) {
              System.out.println("해당 ID(" + book.getId() + ")는 이미 존재합니다.");
              return false;
          }
      }
      bookCollection.add(book);
      System.out.println(book + "도서가 추가되었습니다.");
      return true;
  }

  public static boolean removeBook(int id) {
      for (Book b : bookCollection) {
          if (b.getId() == id) {
              bookCollection.remove(b);
              System.out.println(b + "도서를 삭제하였습니다.");
              return true;
          }
      }
      System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
      return false;
  }

  public static Book searchBook(String title) {
  	
      for (Book b : bookCollection) {        	
          if (b.getTitle() == title) {
              System.out.println("검색 결과:\n" + b);
              return b;
          }
          
          // 추가 
      	if (b.getTitle() == null || b.getTitle().isEmpty()) {
              throw new IllegalArgumentException("책제목이 null이면 검색할 수 없습니다.");
          }
      }
      System.out.println("검색된 도서가 없습니다.");
      return null;
  }

  public static void clearBookCollection() {
      bookCollection.clear();
  }

  @Override
  public String toString() {
      return "Book{id: '" + id + "', 제목: '" + title + "', 저자: '" + author + "', 출판년도: " + publicationYear + "}";
  }
}
>>>>>>> branch 'Hyunji' of https://github.com/youna3515/SW.git
