package vehicles;

import exceptions.CustomException;
import utils.InputUtil;

import java.util.HashMap;
import java.util.Map;

public class SportsVehicle extends Vehicle {
    private Boolean turbo;

    @Override
    protected Map<Integer, String> getDefinedEngineTypes() {
        Map<Integer, String> engineTypes = new HashMap<>();
        engineTypes.put(1, "oil");
        return engineTypes;
    }

    public Boolean getTurbo() {
        return this.turbo;
    }

    public void setTurbo(Integer choice) throws CustomException {
        if(choice != 1 && choice != 2) {
            throw new CustomException("Wrong input");
        }
        this.turbo = choice == 1;
    }

    public void initialize() {
        System.out.println("Enter details for sports vehicle");
        super.initialize();
        System.out.println("Has turbo?\n1. Yes\n2. No");
        InputUtil.assignValueToField(() -> {
            int choice = InputUtil.takeMenuOptionInput(2);
            this.setTurbo(choice);
        });
    }

    public void show() {
        System.out.println("Vehicle type: Sports");
        super.show();
        if(this.getTurbo()) {
            System.out.println("Has turbo: Yes");
        }
        else {
            System.out.println("Has turbo: No");
        }
    }
}
