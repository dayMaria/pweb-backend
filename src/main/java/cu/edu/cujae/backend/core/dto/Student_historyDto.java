package cu.edu.cujae.backend.core.dto;


public class Student_historyDto {

    protected Integer id_student_history;
    protected Integer id_group;
    protected Integer num_list;
    protected Integer id_course;

    protected GroupsDto groupsDto;
    protected CourseDto courseDto;

    public Student_historyDto() {
        super();

    }


    public Student_historyDto(Integer id_student_history, Integer id_group, Integer num_list, Integer id_course, GroupsDto groupsDto, CourseDto courseDto) {

        super();
        this.id_student_history = id_student_history;
        this.id_group = id_group;
        this.num_list = num_list;
        this.id_course = id_course;
        this.groupsDto = groupsDto;
        this.courseDto = courseDto;
    }


    public Student_historyDto(Student_historyDto student_historyDto) {
        super();
        this.id_student_history = student_historyDto.getId_student_history();
        this.id_group = student_historyDto.getId_group();
        this.num_list = student_historyDto.getNum_list();
        this.id_course = student_historyDto.getId_course();
    }


    public Integer getId_student_history() {
        return id_student_history;
    }


    public Integer getId_group() {
        return id_group;
    }


    public Integer getNum_list() {
        return num_list;
    }


    public Integer getId_course() {
        return id_course;
    }


    public void setId_student_history(Integer id_student_history) {
        this.id_student_history = id_student_history;
    }


    public void setId_group(Integer id_group) {
        this.id_group = id_group;
    }


    public void setNum_list(Integer num_list) {
        this.num_list = num_list;
    }


    public void setId_course(Integer id_course) {
        this.id_course = id_course;
    }


    public String toString() {
        return id_student_history.toString();

    }


}
