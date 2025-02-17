public class Tiger extends Animal implements Walk {

    @Override
    public void eatingCompleted() {
        System.out.println("I have eaten meat");
    }

    @Override
    public void eatingFood() {
        super.eatingFood();
        System.out.println("I am eating delicious chicken");
    }

    private int numberOfStripes = 25;
    public int getNumberOfStripes() {
        return numberOfStripes;
    }
    public void setNumberOfStripes(int numberOfStripes) {
        this.numberOfStripes = numberOfStripes;
    }

    private int speed = 30;
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private String levelOfRoar = "High";
    public String getLevelOfRoar() {
        return levelOfRoar;
    }
    public void setLevelOfRoar(String levelOfRoar) {
        this.levelOfRoar = levelOfRoar;
    }

    public Tiger() {
        super("Tiger");
    }

    @Override
    public void walking() {
        System.out.println("I am walking at the speed " + speed +" mph");
    }
}


