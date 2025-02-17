public class Dolphin extends Animal implements Swim{
    @Override
    public void eatingCompleted() {
        System.out.println("I have eaten fish");
    }

    @Override
    public void eatingFood() {
        super.eatingFood();
        System.out.println("I am eating delicious fish");
    }

    private int swimmingSpeed = 70;
    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }
    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    private String color = "Gray";
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Dolphin () {
        super("Dolphin");
    }

    @Override
    public void swimming() {
        System.out.println("I am swimming at the speed " + swimmingSpeed + " nautical miles per hour");
    }
}
