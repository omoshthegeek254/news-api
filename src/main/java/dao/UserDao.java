package dao;

import daoExceptions.DaoException;
import models.User;

import java.util.List;

public interface UserDao {

   //create
    void add(User user);


    //read
    List<User> getAll();
    List<User> findAllUserByDepartmentId(int departmentid);


    //update


    //delete
    void deleteById(int id);






}
