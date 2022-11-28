package cu.edu.cujae.backend.core.dto;


public class StudentDto {

	protected Integer student_ci;
	protected String student_name;
	protected String first_surname;
	protected String second_surname;
	protected String sex;
	protected Integer id_town;
	protected Integer id_student;
	protected Integer id_student_history;
	protected TownDto townDto;
	protected StudentDto studentDto;
	protected Student_historyDto student_historyDto;


	public StudentDto() {
		super();

	}


	public StudentDto(Integer student_ci, String student_name, String first_surname, String second_surname, String sex, Integer id_town, Integer id_student, Integer id_student_history, TownDto townDto, StudentDto studentDto, Student_historyDto student_historyDto) {

		super();
		this.student_ci = student_ci;
		this.student_name = student_name;
		this.first_surname = first_surname;
		this.second_surname = second_surname;
		this.sex = sex;
		this.id_town = id_town;
		this.id_student = id_student;
		this.id_student_history = id_student_history;
		this.townDto = townDto;
		this.studentDto = studentDto;
		this.student_historyDto = student_historyDto;
	}


	public StudentDto(StudentDto studentDto) {
		super();
		this.student_ci = studentDto.getStudent_ci();
		this.student_name = studentDto.getStudent_name();
		this.first_surname = studentDto.getFirst_surname();
		this.second_surname = studentDto.getSecond_surname();
		this.sex = studentDto.getSex();
		this.id_town = studentDto.getId_town();
		this.id_student = studentDto.getId_student();
		this.id_student_history = studentDto.getId_student_history();
	}


	public Integer getStudent_ci() {
		return student_ci;
	}


	public String getStudent_name() {
		return student_name;
	}


	public String getFirst_surname() {
		return first_surname;
	}


	public String getSecond_surname() {
		return second_surname;
	}


	public String getSex() {
		return sex;
	}


	public Integer getId_town() {
		return id_town;
	}


	public Integer getId_student() {
		return id_student;
	}


	public Integer getId_student_history() {
		return id_student_history;
	}


	public void setStudent_ci(Integer student_ci) {
		this.student_ci = student_ci;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public void setFirst_surname(String first_surname) {
		this.first_surname = first_surname;
	}


	public void setSecond_surname(String second_surname) {
		this.second_surname = second_surname;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public void setId_town(Integer id_town) {
		this.id_town = id_town;
	}


	public void setId_student(Integer id_student) {
		this.id_student = id_student;
	}


	public void setId_student_history(Integer id_student_history) {
		this.id_student_history = id_student_history;
	}


	public String toString() {
		return student_ci.toString();

	}

}
