package kz.mun.soap.webservicedemo.soap.service;

import kz.mun.courses.*;
import kz.mun.soap.webservicedemo.soap.bean.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CourseDetailsServiceImpl implements CourseDetailsService {

    private static List<Course> courses = new ArrayList<>();

    static {
        Course course1 = new Course(1, "Spring", "10 Steps");
        courses.add(course1);

        Course course2 = new Course(2, "Spring MVC", "10 Examples");
        courses.add(course2);

        Course course3 = new Course(3, "Spring Boot", "6K Students");
        courses.add(course3);

        Course course4 = new Course(4, "Maven", "Most popular maven course");
        courses.add(course4);
    }

    @Override
    public GetCourseDetailsResponse findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return mapCourseDetails(course);
            }
        }
        return null;
    }

    @Override
    public GetAllCourseDetailsResponse findAll() {
        return mapAllCourseDetails(courses);
    }
    @Override
    public DeleteCourseDetailsResponse deleteById(int id) {
        Iterator<Course> iterator = courses.iterator();
        DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId() == id) {
                iterator.remove();
                response.setStatus(Status.SUCCESS);
                return response;
            }
        }
        response.setStatus(Status.FAILURE);
        return response;
    }

    private GetCourseDetailsResponse mapCourseDetails(Course course) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        response.setCourseDetails(mapCourse(course));
        return response;
    }

    private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        courses.forEach(x -> {
            response.getCourseDetails().add(mapCourse(x));
        });
        return response;
    }

    private CourseDetails mapCourse(Course course) {
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(course.getId());
        courseDetails.setName(course.getName());
        courseDetails.setDescription(course.getDescription());
        return courseDetails;
    }
}
