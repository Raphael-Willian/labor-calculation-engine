package com.engine.calculator.services;

import com.engine.calculator.models.User;
import com.engine.calculator.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    //@Autowired posteriormente...
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Métodos criados apenas para implementação do controller. Porém, serão reformulados.
    public User create(User userRequest) {

        return userRepository.save(userRequest);

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
