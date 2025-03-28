import java.io.Serializable;

/**
 * TODO 1.c: Implement serializable interface for class Dolphin
 */
public class Dolphin extends Animal implements Swim, Serializable {

    // property for color of dolphin
    String color;

    // property for speed of dolphin
    int swimmingSpeed;

    public Dolphin() {
        super("Dolphin");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public void eatingFood() {
        System.out.println("Dolphin: I am eating delicious fish.");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Dolphin: I have eaten fish.");
    }

    @Override
    public void swimming() {
        System.out.println("Dolphin: I am swimming at the speed " + swimmingSpeed);
    }

    @Override
    public String toString() {
        return "Dolphin{" +
                "color='" + color + '\'' +
                ", swimmingSpeed=" + swimmingSpeed +
                '}';
    }
}
