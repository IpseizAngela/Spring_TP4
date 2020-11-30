package com.masteril.book;

import com.masteril.book.model.Book;
import com.masteril.book.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookApplication {

	private static final Logger log = LoggerFactory.getLogger(BookApplication.class);

	@Bean
	public CommandLineRunner lineRunner(BookRepository repository) {
		return (args) -> {
//			log.info("---------------- log de tous les livres ----------------");
//			for (Book b : repository.findAll()) {
//				log.info(b.toString());
//			}
//
//			log.info("---------------- log du livre 1 ----------------");
//			Book b = repository.findById(1);
//			log.info(b.toString());
//
//			repository.findByAuthor("Richard Castle").forEach(book -> {
//				log.info(book.toString());
//			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class);
	}

}
