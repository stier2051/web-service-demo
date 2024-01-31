package kz.mun.soap.webservicedemo.soap;

import kz.mun.courses.CourseDetails;
import kz.mun.courses.GetCourseDetailsRequest;
import kz.mun.courses.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {

    //method
    //input - GetCourseDetailsRequest
    //output - GetCourseDetailsResponse
    @PayloadRoot(namespace = "http://mun.kz/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        GetCourseDetailsResponse response = new GetCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Microservices Course");
        courseDetails.setDescription("Wonderful course");
        response.setCourseDetails(courseDetails);
        return response;
    }
}
