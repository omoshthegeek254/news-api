import static spark.Spark.*;
import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Spark;

import java.util.List;

public class App {

    public static void main(String[] args) {
        Sql2oUserDao userDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://localhost:5432/companyapi";//INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "omoshthegeek", "access");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        userDao = new Sql2oUserDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();


//users

        post("/user/new", "application/json",(request, response) -> {
            User user = gson.fromJson(request.body(), User.class);
            userDao.add(user);
            response.status(201);
            response.type("application/json");
            return gson.toJson(user);
        });

//list all users
        get("/users", "application/json", (request, response) -> {
            response.type("application/json");
            //int departmentID = Integer.parseInt(request.params("de"));
            return gson.toJson(userDao.getAll());

        });
//list users in a department

        get("/departmentusers/:departmentid", "application/json", (request, response) -> {
            response.type("application/json");
            int departmentId = Integer.parseInt(request.params("departmentid"));
            response.type("application/json");
            return gson.toJson(userDao.findAllUserByDepartmentId(departmentId));
        });

         //departments

        post("/department/new", "application/json",(request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });


        get("/departments", "application/json", (request, response) -> {
            response.type("application/json");

            return gson.toJson(departmentDao.findAllDepartments());

        });

        //find department by id
        get("/department/:departmentid", "application/json", (request, response) -> {
            response.type("application/json");
            int departmentId = Integer.parseInt(request.params("departmentid"));
            response.type("application/json");
            return gson.toJson(departmentDao.findDepartmentById(departmentId));
        });





        //news
//post news
        post("/news/new", "application/json",(request, response) -> {
            News news= gson.fromJson(request.body(), News.class);
            newsDao.add(news);
            response.status(201);
            response.type("application/json");
            return gson.toJson(news);
        });

//get all news
        get("/news", "application/json", (request, response) -> {
            response.type("application/json");

            return gson.toJson(newsDao.findAllNews());

        });



        //get news by department id
        get("/departmentnews/:departmentid", "application/json", (request, response) -> {
            response.type("application/json");
            int departmentId = Integer.parseInt(request.params("departmentid"));
            response.type("application/json");
            return gson.toJson(newsDao.findAllNewsByDepartmentId(departmentId));
        });




    }
}