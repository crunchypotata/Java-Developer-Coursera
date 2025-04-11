import java.util.LinkedList;

public class Recipe {
    public static void main(String[] args) {
        LinkedList<String> recipeSteps = new LinkedList<>();

        recipeSteps.add("Milk");
        recipeSteps.add("Bread");
        recipeSteps.add("Eggs");
        recipeSteps.add("Butter");
        recipeSteps.add("Tomatoes");
        System.out.println(recipeSteps);

        recipeSteps.set(1, "Whole wheat bread”");
        System.out.println(recipeSteps);

        recipeSteps.remove(3);
        recipeSteps.add("Cheese");
        System.out.println("Final Grocery List: " + recipeSteps);

    }
}
