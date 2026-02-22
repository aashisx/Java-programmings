public class temperatureconversion {
    public static void main(String[] args) {
        int temp = 27;

        double tempDouble = temp;
        System.out.println("Temperature as double: " + tempDouble);


        float tempFloat = (float)(temp + 0.75);
        System.out.println("Temperature as float after adding 0.75: " + tempFloat);
    }
}
