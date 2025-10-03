package inventory.demo.controller;

import inventory.demo.dto.BookCreateDTO;
import inventory.demo.dto.BookUpdateDTO;
import inventory.demo.entity.Book;
import inventory.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Book invoice = bookService.getBookById(id);

        return ResponseEntity.ok(invoice);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookCreateDTO createDTO) {
        Book response = bookService.createBook(createDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookUpdateDTO updateDto) {
        Book response = bookService.updateBook(id, updateDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
