import java.io.Serializable;

/**
 * TODO 1.b: Implement serializable interface for class Penguin
 */
public class Penguin extends Animal implements Walk, Swim, Serializable {

    boolean isSwimming;
    int walkSpeed;
    int swimSpeed;

    public boolean isSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean swimming) {
        isSwimming = swimming;
    }

    public int getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    public Penguin() {
        super("Penguin");
    }

    @Override
    public void eatingFood() {
        System.out.println("Penguin: I am eating delicious fish.");
    }

    @Override
    public void eatingCompleted() {
        System.out.println("Penguin: I have eaten fish.");
    }

    @Override
    public void swimming() {
        System.out.println("Penguin: I am swimming at the speed " + swimSpeed + " nautical miles per hour");
    }

    @Override
    public void walking() {
        System.out.println("Penguin: I am walking at the speed " + walkSpeed + " mph");
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "isSwimming=" + isSwimming +
                ", walkSpeed=" + walkSpeed +
                ", swimSpeed=" + swimSpeed +
                '}';
    }
}