package application;

import vehicles.Vehicle;

public class VehicleOption<T extends Vehicle> {
    private final Class<T> cls;
    private final String name;

    public VehicleOption(Class<T> cls, String name) {
        this.cls = cls;
        this.name = name;
    }

    public Class<T> getCls() {
        return cls;
    }

    public String getName() {
        return name;
    }

    public Vehicle getInstanceByClass() {
        try {
            return  cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }
}
