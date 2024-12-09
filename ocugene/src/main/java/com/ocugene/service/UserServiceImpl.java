package com.ocugene.service;

import com.ocugene.entity.User;
import com.ocugene.entity.nonFormEntities.VerificationCode;
import com.ocugene.entity.requests.AddUserRequest;
import com.ocugene.repository.UserRepository;
import com.ocugene.repository.VerificationCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

            //create the verif code
            verificationCode = createVerificationCode(user);

            //send to the user's email
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

        String usercode = generateVerificationCode();

        //checks the db if the generated code is unique or not
        // While the generated user code is not unique, keep generating new codes
        while (verificationCodeRepository.findByCode(usercode).isPresent()) {
            // Re-assign new value for user code
            usercode = generateVerificationCode();
        }

        // Once the code is unique, set it on the verificationCode object
        verificationCode.setCode(usercode);
        verificationCode.setCreatedTimestamp(LocalDateTime.now());
        verificationCode.setOcugeneUser(user);
        verificationCode.setIsValid(true);

        user.getVerificationCodes().add(verificationCode);
        return verificationCode;
    }

    private String generateVerificationCode() {

        //8-digit verification code
        Random random = new Random();
        int randomNumber = random.nextInt(100000000);
        String code = Integer.toString(randomNumber);

        while(code.length() < 8){
            code = "0" + code;
        }

        return code;
    }

    @Override
    public int verifyUserUsingCode(String code) {

        //check if the verification code exists in th table
        if(verificationCodeRepository.findByCode(code).isPresent()){

            // Fetch the code from the table or repository
            VerificationCode verificationCode = verificationCodeRepository.findByCode(code).get();

            //check if the code is still valid
            if(verificationCode.getIsValid()){

                //scenario: code is valid but 15 minutes has already passed

                //Get the user that owns the code
                User codeOwner = verificationCode.getOcugeneUser();

                // Get the created timestamp (which is now LocalDateTime)
                LocalDateTime createdTimestamp = verificationCode.getCreatedTimestamp();

                // Get the current time
                LocalDateTime currentTimestamp = LocalDateTime.now();

                // Calculate the duration between the two times
                Duration duration = Duration.between(createdTimestamp, currentTimestamp);

                // Get the difference in minutes
                long minutesDifference = duration.toMinutes();

                if (minutesDifference > 15) {
                    // The code has expired (more than 15 minutes passed)
                    // Handle expired verification code
                    System.out.println("The verification code has expired.");

                    //set isValid tag to false
                    verificationCode.setIsValid(false);

                    //make sure it is saved in the verification codes table
                    verificationCodeRepository.save(verificationCode);

                    //since code is expired, new code should be generated

                    //generate new code
                    verificationCode = createVerificationCode(codeOwner);

                    //send to the user's email
                    emailService.sendVerificationEmail(verificationCode);

                    //add verification code to the table
                    verificationCodeRepository.save(verificationCode);

                } else {
                    // The code is still valid (within 15 minutes)
                    // Handle valid verification code
                    return codeOwner.getUserId();
                }



            }
        }

        else {
            // Return an error -> no such code exists
            System.out.println("No such code exists!");
        }

        return -1;
    }


}
