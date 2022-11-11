package cu.edu.cujae.backend.core.dto;


import java.sql.Date;

public class CourseDto {

    protected Integer id_course;
    protected String course;
    protected Date begin_date;
    protected Date end_date;


    public CourseDto() {
        super();

    }


    public CourseDto(Integer id_course, String course, Date begin_date, Date end_date) {

        super();
        this.id_course = id_course;
        this.course = course;
        this.begin_date = begin_date;
        this.end_date = end_date;
    }


    public CourseDto(CourseDto courseDto) {
        super();
        this.id_course = courseDto.getId_course();
        this.course = courseDto.getCourse();
        this.begin_date = courseDto.getBegin_date();
        this.end_date = courseDto.getEnd_date();
    }


    public Integer getId_course() {
        return id_course;
    }
    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public java.sql.Date getBegin_date() {
        return begin_date;
    }
    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String toString() {
        return id_course.toString();

    }

}
