package com.company.library.repository;

import com.company.library.entity.BookHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookHistoryRepository extends JpaRepository<BookHistory, Long> {
}
