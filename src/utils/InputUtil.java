package utils;

import application.VehicleOption;
import exceptions.CustomException;
import vehicles.Vehicle;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InputUtil {

    public static double takeInput(Boolean returnInt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try{
                double input = returnInt ? scanner.nextInt() : scanner.nextDouble();
                return input;
            }
            catch (InputMismatchException ex) {
                try {
                    throw new CustomException("Wrong input type");
                }
                catch (CustomException ex2) {
                    System.out.println(ex2.getMessage());
                    scanner.nextLine();
                }
            }
        }
    }

    public static double takeDoubleInput() {
        return takeInput(false);
    }

    public static int takeIntegerInput() {
        return (int) takeInput(true);
    }

    public static String takeStringInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static Object getObjectByInputForVehicleType(Map<Integer, VehicleOption<? extends Vehicle>> map) {
        while (true) {
            try {
                int input = takeIntegerInput();
                Object object = map.get(input);
                if(object == null) {
                    throw new CustomException("Wrong input");
                }
                return object;
            }
            catch (CustomException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static int takeMenuOptionInput(int optionLimit) {
        while (true) {
            try{
                int input = takeIntegerInput();
                if(input < 1 || input > optionLimit) {
                    throw new CustomException("Wrong input");
                }
                return input;
            }
            catch (CustomException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void assignValueToField(FieldTask fieldTask) {
        while (true) {
            try {
                fieldTask.execute();
                break;
            }
            catch (CustomException ex) {
                ex.getMessage();
            }
        }
    }
}
