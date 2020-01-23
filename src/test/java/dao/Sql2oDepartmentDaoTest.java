package dao;

import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;


import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private Connection conn;
    private Sql2oDepartmentDao departmentDao;





    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/companyapi_test";
        Sql2o sql2o = new Sql2o(connectionString, "elmonche", "Access");
       departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        conn.close();
        departmentDao.clearAll();
    }

    @Test
    public void add_DepartmentSuccess() {
        Department testDepartment = setUpDepartment();
        departmentDao.add(testDepartment);
        assertEquals(1, departmentDao.findAllDepartments().size());
    }

    @Test
    public void findAllDepartments() {
        Department testDepartment = setUpDepartment();
        Department testDepartment1 = setUpDepartment();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartment1);
        assertEquals(2, departmentDao.findAllDepartments().size());



    }

    @Test
    public void findDepartmentById(int id) {
        Department testDepartment = setUpDepartment();
        departmentDao.add(testDepartment);
        assertEquals(testDepartment.getId(),departmentDao.findDepartmentById(id));



    }

    @Test
    public void deleteById(int id) {

    }

    @Test
    public void clearAll() {
        Department testDepartment = setUpDepartment();
        Department testDepartment1 = setUpDepartment();
        departmentDao.add(testDepartment);
        departmentDao.add(testDepartment1);
        assertEquals(2, departmentDao.findAllDepartments().size());
        departmentDao.clearAll();
        assertEquals(0, departmentDao.findAllDepartments().size());

    }



    //helper


    public Department setUpDepartment(){
        Department department = new Department("finance","deals with money");
        return department;

    }


}