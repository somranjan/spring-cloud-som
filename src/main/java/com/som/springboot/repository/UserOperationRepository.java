package com.som.springboot.repository;

import java.util.List;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.som.springboot.model.User;

@Repository
public class UserOperationRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	CachingConnectionFactory cachingConnectionFactory;

	public void save(User user) {
		mongoTemplate.save(user);
	}

	public List<User> findAllUsers() {
		List<User> users = mongoTemplate.findAll(User.class);
		return users;
	}

	public User findById(long id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").in(id));
		List<User> find = mongoTemplate.find(query, User.class);
		User user = find.get(0);
	   return user;
	}
	
	public String saveUser(User user) {
		try {
		mongoTemplate.save(user);
		return "Saved Successfully";
		} catch (Exception e) {
			return "Failed";
		}
	}
	
}
