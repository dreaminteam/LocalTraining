package by.training.java.grodno.az.data.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.dao.mapper.UserMapper;
import by.training.java.grodno.az.data.model.User;

@Repository
public class UserDaoImpl extends GenericDao<User> implements UserDao {

	
}
