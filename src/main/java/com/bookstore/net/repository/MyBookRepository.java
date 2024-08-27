package com.bookstore.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.net.entity.MyBooks;
@Repository
public interface MyBookRepository extends JpaRepository<MyBooks,Integer> {

}
