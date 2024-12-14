package org.sid.appbackser.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "roles")
    private List<Groupe> groupes;
    @OneToMany(mappedBy = "role")
    private List<Account>accounts;
    private RoleTypes roleTypes;

}
