package pl.jakubczubak.app.model;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class RecipePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, message = "Pole musi zawierać min 3 znaki")
    private String mealName;
    @NotNull
    @Min(value = 0, message = "Wprowadzona wartość musi być liczbą")
    private int sequence;
    @NotNull(message = "Wybierz przepis")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Recipe> recipe;
    @NotNull(message = "Wybierz plan")
    @ManyToMany
    private List<Plan> plan;
    @NotNull(message = "Wybierz dzień tygodnia")
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
