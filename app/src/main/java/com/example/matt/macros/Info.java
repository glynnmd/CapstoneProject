package com.example.matt.macros;

/**
 * Created by Matt on 3/21/18.
 */

public class Info {
    private long foodcarbs;
    private long foodfats;
    private long foodproteins;
    private String name;


    public long getFoodcarbs() {
        return foodcarbs;
    }

    public void setFoodcarbs(long foodcarbs) {
        this.foodcarbs = foodcarbs;
    }

    public long getFoodfats() {
        return foodfats;
    }

    public void setFoodfats(long foodfats) {
        this.foodfats = foodfats;
    }

    public long getFoodproteins() {
        return foodproteins;
    }

    public void setFoodproteins(long foodproteins) {
        this.foodproteins = foodproteins;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Info()
    {
        foodcarbs = 0;
        foodfats = 0;
        foodproteins = 0;
        name = "";

    }

    public Info(String s, long c, long f, long p)
    {
        foodcarbs = c;
        foodfats = f;
        foodproteins = p;
        name = s;

    }

    public String toString()
    {
        return "" + name + " ..." + foodcarbs + "   " + foodfats;
    }




}
