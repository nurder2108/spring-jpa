package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Course;
import com.pluralsight.conference.model.Registration;
import com.pluralsight.conference.repository.CourseRepository;
import com.pluralsight.conference.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private CourseRepository courseRepository;


    @Override
    @Transactional
    public Registration addRegistration(Registration registration) {
        registration = registrationRepository.save(registration);

        Course course = new Course();
        course.setName("Intro");
        course.setDescription("Every attendee must comple the intro.");
        course.setRegistration(registration);

        courseRepository.save(course);

        return registration;
    }

}