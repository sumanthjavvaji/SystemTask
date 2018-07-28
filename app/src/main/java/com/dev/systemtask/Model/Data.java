package com.dev.systemtask.Model;

import java.util.ArrayList;

/**
 * Created by Sumanth on 7/28/2018.
 */

public class Data {

    public Feed feed = new Feed();




    public class Feed{

        public ArrayList<Entrylist> entry = new ArrayList<>();
    }

    public class Entrylist{

        public Title title = new Title();

    }

    public class Title{
        public String label;
    }
}
