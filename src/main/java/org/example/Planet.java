package org.example;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planet")
public class Planet {
    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketsFrom = new ArrayList<>();

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketsTo = new ArrayList<>();


    @Id
    @Column(name = "id", nullable = false, unique = true, length = 10)
    @Pattern(regexp = "^[A-Z0-9]+$", message = "ID повинен складатися виключно з латинських букв у верхньому регістрі та цифр.")
    private String id;

    @Column(name = "name", nullable = false, length = 500)
    private String name;

    public Planet() {
    }

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


