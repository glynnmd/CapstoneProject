package com.example.matt.macros;

/**
 * Created by Matt on 3/21/18.
 */

public class Info {
    private long adjustedcarbs = 0;
    private long adjustedfats = 0;
    private long adjustedproteins = 0;


    public long getAdjustedcarbs() {
        return adjustedcarbs;
    }

    public void setAdjustedcarbs(long adjustedcarbs) {
        this.adjustedcarbs = adjustedcarbs;
    }

    public long getAdjustedfats() {
        return adjustedfats;
    }

    public void setAdjustedfats(long adjustedfats) {
        this.adjustedfats = adjustedfats;
    }

    public long getAdjustedproteins() {
        return adjustedproteins;
    }

    public void setAdjustedproteins(long adjustedproteins) {
        this.adjustedproteins = adjustedproteins;
    }

    public Info()
    {
        adjustedcarbs = 0;
        adjustedfats = 0;
        adjustedproteins = 0;

    }




}
