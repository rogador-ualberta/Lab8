package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        //Test if city is in list
        City oldCity = new City("Windsor", "Ontario");
        list.addCity(oldCity);
        assertTrue(list.hasCity(oldCity));
        //Test if city is not in list
        City newCity = new City("Calgary", "Alberta");
        assertFalse(list.hasCity(newCity));
    }

    @Test
    public void testDelete(){
        list = MockCityList();
        int listSize = list.getCount();
        City city = new City("Windsor", "Ontario");

        list.addCity(city);
        assertEquals(list.getCount(),listSize + 1);
        assertTrue(list.hasCity(city));

        list.delete(city);
        assertEquals(list.getCount(), listSize);
        assertFalse(list.hasCity(city));
    }

    @Test
    void testCountCities(){
        list = MockCityList();
        int listSize = list.getCount();
        assertEquals(list.countCities(), listSize);
    }
}
