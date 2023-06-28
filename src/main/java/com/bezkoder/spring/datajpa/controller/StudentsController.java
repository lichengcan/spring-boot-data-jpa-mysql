package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.Students;
import com.bezkoder.spring.datajpa.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: lichengcan
 * @date: 2023-06-27 17:05
 * @description
 **/
@RestController
@RequestMapping("/stu")
public class StudentsController {

    private static final String[] FIRST_NAMES = {"Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Taylor", "Miller", "Wilson"};
    private static final String[] GENDERS = {"Male", "Female"};

    @Autowired
    StudentsRepository studentsRepository;

    @PostMapping("/students")
    public void student() {
        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Students students = new Students();
            students.setAge(generateRandomAge());
            students.setName(generateRandomName());
            students.setGender(generateRandomPhoneNumber());
            students.setGrade(generateRandomAge());
            studentsList.add(students);
        }
        studentsRepository.saveAllAndFlush(studentsList);
    }

    private static String generateRandomName() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    private static String generateRandomGender() {
        Random random = new Random();
        return GENDERS[random.nextInt(GENDERS.length)];
    }

    private static int generateRandomAge() {
        Random random = new Random();
        return random.nextInt(60) + 18; // Generate age between 18 and 77
    }

    private static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();

        // Generate area code
        phoneNumber.append(String.format("%03d", random.nextInt(1000)));
        phoneNumber.append("-");

        // Generate phone number prefix
        phoneNumber.append(String.format("%03d", random.nextInt(1000)));
        phoneNumber.append("-");

        // Generate phone number line
        phoneNumber.append(String.format("%04d", random.nextInt(10000)));

        return phoneNumber.toString();
    }

}
