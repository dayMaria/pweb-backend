package cu.edu.cujae.backend.core.dto;


public class Student_repeatingDto {

	protected Integer id_student_repeating;
	protected Integer id_subject;
	protected Integer id_student;

	protected SubjectDto subjectDto;
	protected StudentDto studentDto;


	public Student_repeatingDto() {
		super();

	}


	public Student_repeatingDto(Integer id_student_repeating, Integer id_subject, Integer id_student, SubjectDto subjectDto, StudentDto studentDto) {

		super();
		this.id_student_repeating = id_student_repeating;
		this.id_subject = id_subject;
		this.id_student = id_student;
		this.subjectDto = subjectDto;
		this.studentDto = studentDto;
	}


	public Student_repeatingDto(Student_repeatingDto student_repeatingDto) {
		super();
		this.id_student_repeating = student_repeatingDto.getId_student_repeating();
		this.id_subject = student_repeatingDto.getId_subject();
		this.id_student = student_repeatingDto.getId_student();
	}


	public Integer getId_student_repeating() {
		return id_student_repeating;
	}


	public Integer getId_subject() {
		return id_subject;
	}


	public Integer getId_student() {
		return id_student;
	}


	public void setId_student_repeating(Integer id_student_repeating) {
		this.id_student_repeating = id_student_repeating;
	}


	public void setId_subject(Integer id_subject) {
		this.id_subject = id_subject;
	}


	public void setId_student(Integer id_student) {
		this.id_student = id_student;
	}


	public String toString() {
		return id_student_repeating.toString();

	}


}
