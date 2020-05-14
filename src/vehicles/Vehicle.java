package vehicles;

import exceptions.CustomException;
import utils.InputUtil;
import java.util.Map;

public abstract class Vehicle {

    private String modelNumber;
    private String engineType;
    private Integer horsePower;
    private Integer tireSize;

    private final Map<Integer, String> engineTypes;

    public Vehicle() {
        this.engineTypes = this.getDefinedEngineTypes();
    }

    public String getModelNumber() {
        return this.modelNumber;
    }

    public void setModelNumber(String modelNumber) throws CustomException {
        if(modelNumber.isEmpty()) {
            throw new CustomException("Wrong input");
        }
        this.modelNumber = modelNumber;
    }

    public String getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer typeNumber) throws CustomException {
        String type = this.engineTypes.get(typeNumber);
        if(type == null) {
            throw new CustomException("Wrong input");
        }
        this.engineType = type;
    }

    public Integer getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(Integer horsePower) throws CustomException {
        if(horsePower <= 0) {
            throw new CustomException("Horse power can not be 0 or negative");
        }
        this.horsePower = horsePower;
    }

    public Integer getTireSize() {
        return this.tireSize;
    }

    public void setTireSize(Integer tireSize) throws CustomException {
        if(tireSize <= 0) {
            throw new CustomException("Tier size can not be 0 or negative");
        }
        this.tireSize = tireSize;
    }

    public Map<Integer, String> getEngineTypes() {
        return this.engineTypes;
    }

    protected abstract Map<Integer, String> getDefinedEngineTypes();

    public void initialize() {
        System.out.print("Enter model number: ");
        InputUtil.assignValueToField(() -> {
            String modelNumber = InputUtil.takeStringInput();
            this.setModelNumber(modelNumber);
        });

        if(this.engineTypes.size() > 1) {
            System.out.println("Enter engine type");
            for (Map.Entry<Integer, String> entry : this.getEngineTypes().entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
            InputUtil.assignValueToField(() -> {
                int choice = InputUtil.takeIntegerInput();
                this.setEngineType(choice);
            });
        }
        else {
            this.engineType = this.engineTypes.get(1);
        }

        System.out.print("Set hours power (hp): ");
        InputUtil.assignValueToField(() -> {
            int horsePower = InputUtil.takeIntegerInput();
            this.setHorsePower(horsePower);
        });

        System.out.print("Set tire size (inches): ");
        InputUtil.assignValueToField(() -> {
            int tireSize = InputUtil.takeIntegerInput();
            this.setTireSize(tireSize);
        });
    }

    public void show() {
        System.out.println("Model number: " + this.getModelNumber());
        System.out.println("Engine type: " + this.getEngineType());
        System.out.println("Horse power: " + this.getHorsePower() + " hp");
        System.out.println("Tire size: " + this.getTireSize() + "inch's");
    }
}
