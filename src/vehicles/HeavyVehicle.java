package vehicles;

import exceptions.CustomException;
import utils.InputUtil;
import java.util.HashMap;
import java.util.Map;

public class HeavyVehicle extends Vehicle {
    private Double weight;

    @Override
    protected Map<Integer, String> getDefinedEngineTypes() {
        Map<Integer, String> engineTypes = new HashMap<>();
        engineTypes.put(1, "diesel");
        return engineTypes;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) throws CustomException {
        if(weight <= 0) {
            throw new CustomException("Horse power can not be 0 or negative");
        }
        this.weight = weight;
    }

    public void initialize() {
        System.out.println("Enter details for heavy vehicle");
        super.initialize();

        System.out.print("Set weight: ");
        InputUtil.assignValueToField(() -> {
            double weight = InputUtil.takeDoubleInput();
            this.setWeight(weight);
        });
    }

    public void show() {
        System.out.println("Vehicle type: Heavy");
        super.show();
        System.out.println("Weight: " + this.getWeight());
    }
}
