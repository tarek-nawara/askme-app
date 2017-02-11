package edu.askme.dao.domain;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import edu.askme.dao.entities.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	public List<User> findByUsername(String username);
}
