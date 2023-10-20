package seminars.fourth.book;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//Задание 2.

//        У вас есть класс BookService, который использует интерфейс BookRepository для получения
//        информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService,
//        используя Mockito  для создания мок-объекта BookRepository.


class BookServiceTest {
    @Test
    void getTitleTest(){
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);
        Book book1 = new Book("1", "Book1","autor1");
        when(mockBookRepository.findById("1")).thenReturn(book1);
        verify(mockBookRepository).findById("1");
        assertEquals("Book1",mockBookRepository.findById("1").getTitle());
    }
    @Test
    void getAuthorTest(){
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);
        Book book1 = new Book("1", "Book1","autor1");
        when(mockBookRepository.findById("1")).thenReturn(book1);
        assertEquals("autor1",bookService.findBookById("1").getAuthor());
    }
    @Test
    void findAllBooksTest(){
        List<Book> testbooks = new ArrayList<>();
        testbooks.add(new Book("1", "Book1","autor1"));
        testbooks.add(new Book("2", "Book2","autor2"));
        BookRepository mockBookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(mockBookRepository);

        when(mockBookRepository.findAll()).thenReturn(testbooks);
        assertEquals(testbooks,bookService.findAllBooks());
    }

}

//    Book book1 = bookService.findBookById("1");
//        System.out.println("Найдена книга: " + book1.getTitle() + " by " + book1.getAuthor());
//
//                List<Book> allBooks = bookService.findAllBooks();
//        System.out.println("Все книги:");
//        for (Book book : allBooks) {
//        System.out.println("- " + book.getTitle() + " от " + book.getAuthor());