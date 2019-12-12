package pl.akotus.myHomePage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akotus.myHomePage.model.Role;
import pl.akotus.myHomePage.repository.RoleRepository;

import java.util.List;

@Service("roleService")
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAllWithAdmin() {
        return (List<Role>) roleRepository.findAll();
    }

    public List<Role> getAll() {
        return (List<Role>) roleRepository.findAll();
    }

    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }
}
