package com.bookstore.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.net.entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books,Integer>{

}
