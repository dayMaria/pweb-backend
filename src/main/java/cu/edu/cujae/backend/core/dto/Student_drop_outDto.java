package cu.edu.cujae.backend.core.dto;


public class Student_drop_outDto {

	protected Integer id_student;
	protected Integer id_drop_out_cause;
	protected Integer id_student_drop_out;


	public Student_drop_outDto() {
		super();

	}


	public Student_drop_outDto(Integer id_student, Integer id_drop_out_cause, Integer id_student_drop_out) {

		super();
		this.id_student = id_student;
		this.id_drop_out_cause = id_drop_out_cause;
		this.id_student_drop_out = id_student_drop_out;
	}


	public Student_drop_outDto(Student_drop_outDto student_drop_outDto) {
		super();
		this.id_student = student_drop_outDto.getId_student();
		this.id_drop_out_cause = student_drop_outDto.getId_drop_out_cause();
		this.id_student_drop_out = student_drop_outDto.getId_student_drop_out();
	}


	public Integer getId_student() {
		return id_student;
	}


	public Integer getId_drop_out_cause() {
		return id_drop_out_cause;
	}


	public Integer getId_student_drop_out() {
		return id_student_drop_out;
	}


	public void setId_student(Integer id_student) {
		this.id_student = id_student;
	}


	public void setId_drop_out_cause(Integer id_drop_out_cause) {
		this.id_drop_out_cause = id_drop_out_cause;
	}


	public void setId_student_drop_out(Integer id_student_drop_out) {
		this.id_student_drop_out = id_student_drop_out;
	}


	public String toString() {
		return id_student.toString();

	}

}
