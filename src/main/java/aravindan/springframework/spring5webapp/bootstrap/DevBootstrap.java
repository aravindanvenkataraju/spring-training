package aravindan.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import aravindan.springframework.spring5webapp.model.Author;
import aravindan.springframework.spring5webapp.model.Book;
import aravindan.springframework.spring5webapp.model.Publisher;
import aravindan.springframework.spring5webapp.model.repositories.AuthorRepository;
import aravindan.springframework.spring5webapp.model.repositories.BookRepository;
import aravindan.springframework.spring5webapp.model.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		//Eric
		Author eric = new Author("Eric", "Evans");
		Publisher harperCollins = new Publisher("Harper Collins", "New York");
		Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(harperCollins);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("Worx", "California");
		Book noEJB = new Book("J2EE Development without EJB", "10001", worx);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(worx);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
}
