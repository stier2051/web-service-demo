package kz.mun.soap.webservicedemo.soap.service;

import kz.mun.courses.DeleteCourseDetailsResponse;
import kz.mun.courses.GetAllCourseDetailsResponse;
import kz.mun.courses.GetCourseDetailsResponse;

public interface CourseDetailsService {
    GetCourseDetailsResponse findById(int id);
    GetAllCourseDetailsResponse findAll();
    DeleteCourseDetailsResponse deleteById(int id);
}
