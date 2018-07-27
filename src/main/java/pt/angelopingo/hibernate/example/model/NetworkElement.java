package pt.angelopingo.hibernate.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "NETWORK_ELEMENTS")
public class NetworkElement {

    @Id
    @NonNull
    @Column(name = "USERNAME",
            unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "networkelement")
    private Set<String> counters = new HashSet<>();

}
