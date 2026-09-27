package com.engine.calculator.repositorys;

import com.engine.calculator.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

//Anotação redundante mas deixarei por razões semânticas
@Repository
public interface UserRepository extends JpaRepository<User,UUID> {


}
