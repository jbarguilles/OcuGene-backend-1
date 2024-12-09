package com.ocugene.service;

import com.ocugene.entity.User;
import com.ocugene.entity.nonFormEntities.VerificationCode;
import com.ocugene.entity.requests.AddUserRequest;
import com.ocugene.repository.UserRepository;
import com.ocugene.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    VerificationCodeRepository verificationCodeRepository;

    @Autowired
    private EmailService emailService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(AddUserRequest addUserRequest){

        return userRepository.save(addUserRequest.mapToUser());
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void forgotPassword(String email) {

        User user = new User();
        VerificationCode verificationCode = new VerificationCode();

        if(userRepository.findByEmail(email).isPresent()){
            user = userRepository.findByEmail(email).get();
            verificationCode = createVerificationCode(user);
            emailService.sendVerificationEmail(verificationCode);

            //add verification code to the table
            verificationCodeRepository.save(verificationCode);
        }

        else{
            //throw user with specified email not found error
            System.out.println("User does not exist!");
        }
    }

    private VerificationCode createVerificationCode(User user) {
        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setCode(generateVerificationCode());
        verificationCode.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
        verificationCode.setOcugeneUser(user);
        user.getVerificationCodes().add(verificationCode);
        return verificationCode;
    }

    public String generateVerificationCode() {

        //8-digit verification code
        Random random = new Random();
        int randomNumber = random.nextInt(100000000);
        String code = Integer.toString(randomNumber);

        while(code.length() < 8){
            code = "0" + code;
        }

        return code;
    }


}
