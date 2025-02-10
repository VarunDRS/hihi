package com.junits.junits.Repository;

import com.junits.junits.Entity.NotebookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteBookRepository extends JpaRepository<NotebookEntity, Integer> {
      public NotebookEntity findById(int id);
}
