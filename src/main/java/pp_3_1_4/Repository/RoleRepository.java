package pp_3_1_4.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp_3_1_4.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
