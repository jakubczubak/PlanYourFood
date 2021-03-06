package pl.jakubczubak.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 100, message = "Pole musi zawierać min 3 max 100 znaków")
    private String name;
    @NotNull
    @Size(min = 3, max = 300, message = "Pole musi zawierać min 3 max 100 znaków")
    private String ingredients;
    @NotNull
    @Size(min = 3, max = 300, message = "Pole musi zawierać min 3 max 100 znaków")
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;

    private int preparationTime;
    @NotNull
    @Size(min = 3, max = 300, message = "Pole musi zawierać min 3 max 100 znaków")
    private String methodOfPreparing;
    @ManyToMany(mappedBy = "recipe",
            cascade = CascadeType.REMOVE)
    private List<RecipePlan> recipePlan;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getMethodOfPreparing() {
        return methodOfPreparing;
    }

    public void setMethodOfPreparing(String methodOfPreparing) {
        this.methodOfPreparing = methodOfPreparing;
    }

    public List<RecipePlan> getRecipePlan() {
        return recipePlan;
    }

    public void setRecipePlan(List<RecipePlan> recipePlan) {
        this.recipePlan = recipePlan;
    }
}
