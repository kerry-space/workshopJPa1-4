package se.lexicon.workshopjpa14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.workshopjpa14.dao.AppUserDao;
import se.lexicon.workshopjpa14.dao.BookDao;
import se.lexicon.workshopjpa14.dao.BookLoanDao;
import se.lexicon.workshopjpa14.dao.DetailsDao;
import se.lexicon.workshopjpa14.entity.AppUser;
import se.lexicon.workshopjpa14.entity.Book;
import se.lexicon.workshopjpa14.entity.BookLoan;
import se.lexicon.workshopjpa14.entity.Details;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserDao appUserDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    BookLoanDao bookLoanDao;

    @Autowired
    DetailsDao detailsDao;



    @Override
    public void run(String... args) throws Exception {
        Details details = new Details("kerry@gmail.com","kerry", LocalDate.parse("1995-10-30"));
        detailsDao.create(details);

        AppUser appUser = new AppUser("kerry","lovelove", LocalDate.now(),details);
        AppUser createdAppUser = appUserDao.create(appUser);

        Book book = new Book("bb-100","think and grow rich",15);
        bookDao.create(book);



    }




}
