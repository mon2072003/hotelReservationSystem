
package hotelreservationsystem;

abstract class MealPlan implements Cloneable {
    private String planName;

    public MealPlan(String planName) {
        this.planName = planName;
    }

    public String getPlanName() {
        return planName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public abstract void describe();
}

class BreakfastOnly extends MealPlan {
    public BreakfastOnly() {
        super("Breakfast Only");
    }

    @Override
    public void describe() {
        System.out.println("Meal Plan: Breakfast Only");
    }
}

class FullBoard extends MealPlan {
    public FullBoard() {
        super("Full Board");
    }

    @Override
    public void describe() {
        System.out.println("Meal Plan: Full Board (Breakfast, Lunch, Dinner)");
    }
}

class MealPlanFactory {
    public static MealPlan getClonedPlan(MealPlan mealPlan) {
        try {
            return (MealPlan) mealPlan.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}



