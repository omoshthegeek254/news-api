package dao;

import daoExceptions.DaoException;
import models.Department;

import java.util.List;

public interface DepartmentDao {

    //create
    void add(Department department) ;

    //read
   List<Department> findAllDepartments();
 List<Department> findDepartmentById(int id);
     //List<Department> getAllRestaurantsForAFoodtype(int id);

    //update
    //omit for now

    //delete
   void deleteById(int id);
 void clearAll();
}
