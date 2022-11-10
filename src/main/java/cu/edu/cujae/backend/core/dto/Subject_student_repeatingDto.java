package cu.edu.cujae.backend.core.dto;

public class Subject_student_repeatingDto {

    protected Integer tid_subject;
    protected Integer id_student_repeating;


    public Subject_student_repeatingDto() {
        super();

    }


    public Subject_student_repeatingDto(Integer tid_subject, Integer id_student_repeating) {

        super();
        this.tid_subject = tid_subject;
        this.id_student_repeating = id_student_repeating;
    }


    public Subject_student_repeatingDto(Subject_student_repeatingDto subject_student_repeatingDto) {
        super();
        this.tid_subject = subject_student_repeatingDto.getTid_subject();
        this.id_student_repeating = subject_student_repeatingDto.getId_student_repeating();
    }


    public Integer getTid_subject() {
        return tid_subject;
    }


    public Integer getId_student_repeating() {
        return id_student_repeating;
    }


    public void setTid_subject(Integer tid_subject) {
        this.tid_subject = tid_subject;
    }


    public void setId_student_repeating(Integer id_student_repeating) {
        this.id_student_repeating = id_student_repeating;
    }


    public String toString() {
        return tid_subject.toString();

    }

}
