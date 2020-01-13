package pl.jakubczubak.app.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @ManyToMany(mappedBy = "plan",
    cascade = CascadeType.REMOVE)
    private List<RecipePlan> recipePlans;


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

    public List<RecipePlan> getRecipePlans() {
        return recipePlans;
    }

    public void setRecipePlans(List<RecipePlan> recipePlans) {
        this.recipePlans = recipePlans;
    }
}
