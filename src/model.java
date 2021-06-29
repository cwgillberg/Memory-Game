import java.util.*;

public class model {

    private double sqOheight, height, weight, bmi;

    public model(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double calculate() {
        sqOheight = Math.pow(height, 2);

        bmi = weight / sqOheight;

        return bmi;

    }
}
