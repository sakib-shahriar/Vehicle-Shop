package vehicles;

import java.util.HashMap;
import java.util.Map;

public class NormalVehicle extends Vehicle {
    @Override
    protected Map<Integer, String> getDefinedEngineTypes() {
        HashMap<Integer, String> engineTypes = new HashMap<>();
        engineTypes.put(1, "oil");
        engineTypes.put(2, "gas");
        engineTypes.put(3, "diesel");
        return engineTypes;
    }

    public void initialize() {
        System.out.println("Enter details for normal vehicle");
        super.initialize();
    }

    public void show() {
        System.out.println("Vehicle type: Normal");
        super.show();
    }
}
