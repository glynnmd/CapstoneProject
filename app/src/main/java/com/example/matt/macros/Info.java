package com.example.matt.macros;

/**
 * Created by Matt on 3/21/18.
 */

public class Info {
    private String carbs = "";
    private String fats = "";
    private String proteins = "";

    public Info()
    {
         carbs = "";
        fats = "";
        proteins = "";
    }

    public String getcarbs(){
        return carbs;
    }

    public String getfats(){
        return fats;
    }

    public String getproteins(){
        return proteins;
    }

    public void setcarbs(String carbs){
        this.carbs = carbs;
    }

    public void setfats(String fats)
    {
        this.fats = fats;
    }

    public void setproteins(String proteins){
        this.proteins = proteins;
    }
}
