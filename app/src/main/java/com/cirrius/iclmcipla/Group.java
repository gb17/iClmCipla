package com.cirrius.iclmcipla;

import java.util.ArrayList;

public class Group {

    private String Name;
    private String Name1;
    private ArrayList<Child> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name) {
        this.Name1 = name;
    }

    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }

}