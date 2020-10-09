import java.util.Arrays;
import java.util.stream.Collectors;

class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        String authorsList = "["+Arrays.stream(authors).collect(Collectors.joining(","))+"]";
        return String.format("title=%s,yearOfPublishing=%d,authors=%s", title, yearOfPublishing,
                authorsList);
    }
}

/*public class Main {
    public static void main(String[] args) {
        Book book = new Book("Java 8 & 9 in Action",
                2017, new String[]{"Maria Fusco", "Alan Mycroft"});
        System.out.println(book.toString());
    }
}*/