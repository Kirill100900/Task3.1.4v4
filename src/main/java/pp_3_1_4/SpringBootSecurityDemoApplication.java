package pp_3_1_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import pp_3_1_4.Repository.RoleRepository;
import pp_3_1_4.Repository.UserRepository;
import pp_3_1_4.model.Role;
import pp_3_1_4.model.User;

import java.util.HashSet;

@SpringBootApplication
public class SpringBootSecurityDemoApplication implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SpringBootSecurityDemoApplication(RoleRepository roleRepository,
                                             UserRepository userRepository,
                                             PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Role admin = new Role(1L,"ROLE_ADMIN");
        Role user = new Role(2L,"ROLE_USER");
        roleRepository.save(admin);
        roleRepository.save(user);


        userRepository.save(new User(1L,"admin",passwordEncoder.encode("admin"),"admin",
                "admin@mail.com",new HashSet<Role>() {{
            add(admin);
        }}));

        userRepository.save(new User(2L,"user",passwordEncoder.encode("user"),"user","cdcd",new HashSet<Role>() {{
            add(user);
        }}));


    }
}
