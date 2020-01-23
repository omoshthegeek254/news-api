package dao;

import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News news);
    //void addToRestaurant(Foodtype foodtype, Restaurant restaurant);
    //void addFoodtypeToRestaurant(Foodtype foodtype, Restaurant restaurant);

    //read
    List<News> findAllNews();
   // List<News> findAllNewsByUserId();
    List<News> findAllNewsByDepartmentId(int departmentid);

    //void getAllByDepartment(Foodtype foodtype, Restaurant restaurant);
    // List<Restaurant> getAllRestaurantsForAFoodtype(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
//    void clearAll();
}
