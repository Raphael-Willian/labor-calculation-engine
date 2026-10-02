package com.engine.calculator.services;

import com.engine.calculator.dtos.requests.CreateUserRequest;
import com.engine.calculator.models.User;
import com.engine.calculator.repositorys.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    //@Autowired posteriormente...
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passswordEncoder;
    }

    //Métodos criados apenas para implementação do controller. Porém, serão reformulados.
    public User create(CreateUserRequest request) {

        User user = new User();

        user.setNameUser(request.getName());
        user.setEmailUser(request.getEmail());
        user.setRoleUser(request.getRole());
        user.setTenant(request.getTenant());
        user.setPasswordUser(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);

    }

    public List<User> read() {

        return userRepository.findAll();

    }

    public void update(UUID idUser, User userRequest) {

        //Aqui temos duas visitas ao banco de dados. A abordagem pode mudar no futuro para melhorar esse ponto.
        User userExist = userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("Usuário com ID: " + idUser
         + " não foi encontrado."));

        userExist.setNameUser(userRequest.getNameUser());
        userExist.setEmailUser(userRequest.getEmailUser());
        userExist.setPasswordUser(userRequest.getPasswordUser());
        userExist.setRoleUser(userRequest.getRoleUser());
        userExist.setTenant(userRequest.getTenant());

        userRepository.save(userExist);

    }

    public void delete(UUID idUser) {

        userRepository.deleteById(idUser);

    }

}
