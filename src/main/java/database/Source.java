package database;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "sources")
    List<User> users;

    @ManyToMany
    @JoinTable(
            name = "sources_attached_skills",
            joinColumns = {@JoinColumn(name = "source_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    List<Skill> skills;

    public Source(String name) {
        this.name = name;
    }

    public Source(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
