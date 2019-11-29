package org.bag.model.primitives;

public class BooleanModel {
    private boolean[] booleans;

    private boolean value;
    
    public boolean[] getBooleans() {
        return booleans;
    }

    public void setBooleans(boolean[] booleans) {
        this.booleans = booleans;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
