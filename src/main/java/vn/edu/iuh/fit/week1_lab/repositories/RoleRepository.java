package vn.edu.iuh.fit.week1_lab.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week1_lab.entities.Role;

public class RoleRepository {
    private Role role;
    private EntityManager entityManager;

    public RoleRepository(){
        this.entityManager = entityManager;
    }


}
