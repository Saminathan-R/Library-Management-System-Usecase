package com.Library.WebApp.Repository;
import com.Library.WebApp.Model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    

}