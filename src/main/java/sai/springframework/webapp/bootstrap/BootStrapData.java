package sai.springframework.webapp.bootstrap;
import sai.springframework.webapp.domain.Author;
import sai.springframework.webapp.domain.Book;
import sai.springframework.webapp.domain.Publisher;
import sai.springframework.webapp.repositories.AuthorRepository;
import sai.springframework.webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sai.springframework.webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository,BookRepository bookRepository ,PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository=publisherRepository;
    }
    @Override
    public void run(String... args) throws Exception{
        System.out.println("Started in Bootstrap");
        Publisher publisher=new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("ST perterburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);
        Author eric =new Author( "Eric","Evans");
        Book ddd =new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);
        Author rod=new Author("Rod","Johnson");
        Book noEJB=new Book("J2EE development without EJB","3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books"+bookRepository.count());
        System.out.println("Publisher Number of Books"+publisher.getBooks().size());
    }
}
