package edu.askme.dao.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.askme.dao.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
