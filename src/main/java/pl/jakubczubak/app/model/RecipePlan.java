package pl.jakubczubak.app.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class RecipePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mealName;
    private int sequence;
    @ManyToMany
    private List<Recipe> recipe;
    @ManyToMany
    private List<Plan> plan;
    @OneToOne
    private Day day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }

    public List<Plan> getPlan() {
        return plan;
    }

    public void setPlan(List<Plan> plan) {
        this.plan = plan;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
