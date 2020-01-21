package com.login.webapp.service;

import com.login.webapp.domain.LoginUser;
import com.login.webapp.exception.DuplicateEmailException;
import com.login.webapp.mapper.UserToUserModel;
import com.login.webapp.model.UserModel;
import com.login.webapp.repository.LoginUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoggedUserServiceImpl implements LoggedUserService {

    //UserRepository to retrieve data
    @Autowired
    private LoginUserRepository userRepo;

    //mapper to map DB data to Model data
    @Autowired
    private UserToUserModel mapper;

    //BCrypt encoder for password encryption
    @Autowired
    private PasswordEncoder encoder;

    //SEARCH

    //using Repository that extends JPA to find User By Email
    //then map it to Model

    @Override
    public UserModel findByEmail(String email){

        //needs some exception handling here if exists etc
        Optional<LoginUser> loginUser = userRepo.findByEmail(email);
        return mapper.mapToUserModel(loginUser.get());
    }

    //UPDATE

    //update user data according to UserModel data
    @Override
    public LoginUser updateUser(UserModel userModel) {

        //assign email to variable
        String updatedEmail = userModel.getEmail();

        //find User using Repository
        //will not throw exception on duplicate mail because it will be a readonly field
        LoginUser loginUser = userRepo.findByEmail(updatedEmail).get();

        //assign variables to updatedUser
        loginUser.setEmail(updatedEmail);
        loginUser.setCompany(userModel.getCompany());
        loginUser.setFirstName(userModel.getFirstName());
        loginUser.setLastName(userModel.getLastName());
        loginUser.setPhoneNumber(userModel.getPhoneNumber());
        loginUser.setRole(userModel.getRole());

        //ONLY ENCRYPT PASSWORD IF USER CHANGED IT
        //otherwise it will encrypt the encrypted password (unwanted behaviour)
        if (!(loginUser.getPassword().equals(userModel.getPassword()))) {

            loginUser.setPassword(encoder.encode(userModel.getPassword()));

        } else {

            loginUser.setPassword(userModel.getPassword());

        }

        return userRepo.save(loginUser);
    }

    //CREATE
    //creates user

    @Override
    public LoginUser createUser(UserModel userModel) throws DuplicateEmailException{

        //assign mail to variable
        String email = userModel.getEmail();

        //find User using Repository
        Optional<LoginUser> optionalLoginUser = userRepo.findByEmail(email);

        //throws exception if duplicate mail is find in DB
        if (!optionalLoginUser.isEmpty())
            throw new DuplicateEmailException(email);

        //assign variables
        LoginUser loginUser = new LoginUser();
        loginUser.setEmail(email);
        loginUser.setFirstName(userModel.getFirstName());
        loginUser.setLastName(userModel.getLastName());
        loginUser.setCompany(userModel.getCompany());
        loginUser.setPhoneNumber(userModel.getPhoneNumber());
        loginUser.setRole(userModel.getRole());


        //encrypt password before create
        loginUser.setPassword(encoder.encode(userModel.getPassword()));
        return userRepo.save(loginUser);
    }

}
