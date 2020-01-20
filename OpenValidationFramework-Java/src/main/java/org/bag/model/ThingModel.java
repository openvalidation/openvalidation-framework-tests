package org.bag.model;

import java.util.ArrayList;
import java.util.List;

public class ThingModel {

    private List<Thing> things = new ArrayList<>();

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }
}
