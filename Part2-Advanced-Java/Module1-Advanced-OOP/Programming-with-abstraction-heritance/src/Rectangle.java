import java.util.Stack;

public class Rectangle extends Shape {
    private float width;
    private float height;
    private String color;

    @Override
    public float calculateArea() {
        float area = this.width * this.height;
        return area;
    }
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with width=" + this.width + " height=" + this.height);
    }

    @Override
    public void lineColor() {
        System.out.println("Drawing Rectangle: " + color + " color");
    }

    @Override
    public float calculatePerimeter() {
        float perimeter = (float) this.width + this.width + this.height + this.height;
        return perimeter;
    }

    Rectangle(float w, float h, String color) {
        this.width = w;
        this.height = h;
        this.color = "Red";
    }


}
