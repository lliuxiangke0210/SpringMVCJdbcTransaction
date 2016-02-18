package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.User;

public interface UserDAO {

	public User findUser(int userId);

	public void insertUser(User User);

	public List<User> listUser();

	public void delete(int userId);

	public void Update(User User);

}