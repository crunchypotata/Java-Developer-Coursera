public class Circle extends Shape{
    private float radius;
    private String color;


    @Override
    public float calculateArea() {
        float area = (float)Math.PI *this.radius*this.radius;
        return area;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius=" + this.radius);
    }

    @Override
    public void lineColor() {
        System.out.println("Drawing Circle: " + color + " color");
    }

    @Override
    public float calculatePerimeter() {
        float perimeter = 2*(float)Math.PI*this.radius;
        return perimeter;
    }

    Circle(float r, String color) {
        this.radius = r;
        this.color = "Blue";
    }
}

