public class Penguin extends Animal implements Walk, Swim {


    private boolean isSwimming = true;
    public boolean isSwimming() {
        return isSwimming;
    }
    public void setSwimming(boolean swimming) {
        isSwimming = swimming;
    }


    private int walkSpeed = 5;
    public int getWalkSpeed() {
        return walkSpeed;
    }
    public void setWalkSpeed(int walkSpeed) {
        this.walkSpeed = walkSpeed;
    }


    private int swimSpeed = 15;
    public int getSwimSpeed() {
        return swimSpeed;
    }
    public void setSwimSpeed(int swimSpeed) {
        this.swimSpeed = swimSpeed;
    }

    @Override
    public void walking() {

    }

    @Override
    public void swimming() {

    }
    @Override
    public void eatingCompleted() {
        System.out.println("I have eaten small fish");
    }

    @Override
    public void eatingFood() {
        if (isSwimming) {
            System.out.println("I am eating delicious fish");
        } else {
            System.out.println("I am not eating right now");
        }
    }

    public Penguin() {
        super("Penguin");
    }

    public void movement() {
        if (isSwimming) {
            System.out.println("Penguin: I am swimming at the speed " + swimSpeed);
        } else {
            System.out.println("Penguin: I am walking at the speed " + walkSpeed);
        }
    }

}
