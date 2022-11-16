package cu.edu.cujae.backend.core.dto;

public class Subject_student_repeatingDto {

    protected Integer id_subject;
    protected Integer id_student_repeating;


    public Subject_student_repeatingDto() {
        super();

    }


    public Subject_student_repeatingDto(Integer id_subject, Integer id_student_repeating) {

        super();
        this.id_subject = id_subject;
        this.id_student_repeating = id_student_repeating;
    }


    public Subject_student_repeatingDto(Subject_student_repeatingDto subject_student_repeatingDto) {
        super();
        this.id_subject = subject_student_repeatingDto.getId_subject();
        this.id_student_repeating = subject_student_repeatingDto.getId_student_repeating();
    }


    public Integer getId_subject() {
        return id_subject;
    }


    public Integer getId_student_repeating() {
        return id_student_repeating;
    }


    public void setId_subject(Integer id_subject) {
        this.id_subject = id_subject;
    }


    public void setId_student_repeating(Integer id_student_repeating) {
        this.id_student_repeating = id_student_repeating;
    }


    public String toString() {
        return id_subject.toString();

    }

}
