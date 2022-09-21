package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner, will tell Spring to find instance of this type, and run them.
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    // Bring this constructor into Spring Context and do Dependency injection for an instance of our Repositories.
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /**
         * Using Sping Data JPA, this allows us to save our data using hibernate into H2 in memory databse
         */
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "1754635636");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        Publisher jack = new Publisher("123 Main Street", "Moncton", "New Brunswick", "E1A 0A1");

        publisherRepository.save(jack);

        System.out.printf("Started in Bootstrap\n");
        System.out.printf("Number of books in H2 Database: {%d}\n", bookRepository.count());
        System.out.printf("Number of publishers in H2 Database: {%d}\n", publisherRepository.count());
    }
}
