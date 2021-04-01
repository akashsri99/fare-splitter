package com.example.testing.users.service;

import com.example.testing.users.dto.UserDTO;
import com.example.testing.users.entity.UserEntity;
import com.example.testing.users.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers(){
        ArrayList<UserDTO> userDTOs = new ArrayList<>();
        List<UserEntity> users =  userRepository.findAll();
       System.out.println(users);
//       BeanUtils.copyProperties(users, userDTOs);

        for(int i=0; i<users.size(); i++){
            UserDTO tmpuser = new UserDTO();
            System.out.println(users.get(i));
            BeanUtils.copyProperties(users.get(i) , tmpuser );
            userDTOs.add(tmpuser);
        }
       return userDTOs;
    }

    public UserDTO createUser(UserDTO user){
        UserEntity userEntity = new UserEntity();
        UserDTO response =  new UserDTO();
        BeanUtils.copyProperties(user, userEntity);
        System.out.println(user);
        userRepository.save(userEntity);
        UserEntity createdUser = userRepository.findByName(user.getName());
        BeanUtils.copyProperties(createdUser, response);
        return  response;
    }


    public Optional<UserEntity> getUserById(String id){
        return userRepository.findById(id);
    }


    public  void addBalance(String id, Double balance){
        Optional<UserEntity> user = getUserById(id);
        UserEntity userData = new UserEntity();
        if(user.isPresent()){
            userData = user.get();
        }
        Double amountToBeTaken = userData.getAmountToBeTaken() + balance;
        userData.setAmountToBeTaken(amountToBeTaken);
        userRepository.save(userData);

    }

    public  void deductBalance(String id, Double balance){
        Optional<UserEntity> user = getUserById(id);
        UserEntity userData = new UserEntity();
        if(user.isPresent()){
            userData = user.get();
        }
        Double amountToBeGiven = userData.getAmountToBeGiven() + balance;
        userData.setAmountToBeGiven(amountToBeGiven);
        userRepository.save(userData);
    }
}
