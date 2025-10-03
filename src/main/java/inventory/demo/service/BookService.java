package inventory.demo.service;

import inventory.demo.dto.BookCreateDTO;
import inventory.demo.dto.BookUpdateDTO;
import inventory.demo.entity.Book;
import inventory.demo.exception.ResourceNotFoundException;
import inventory.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookId));
    }

    public Book createBook(BookCreateDTO createDTO) {
        Book book = new Book();

        book.setTitle(createDTO.getTitle());
        book.setAuthor(createDTO.getAuthor());
        book.setIsbn(createDTO.getIsbn());
        book.setPublicationYear(createDTO.getPublicationYear());
        book.setPrice(createDTO.getPrice());

        return bookRepository.save(book);
    }

    public Book updateBook(Long bookId, BookUpdateDTO updateDTO) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookId));

        book.setTitle(updateDTO.getTitle());
        book.setAuthor(updateDTO.getAuthor());
        book.setIsbn(updateDTO.getIsbn());
        book.setPublicationYear(updateDTO.getPublicationYear());
        book.setPrice(updateDTO.getPrice());

        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookId));

        bookRepository.delete(book);
    }
}
