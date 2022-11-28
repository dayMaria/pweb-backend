package cu.edu.cujae.backend.core.dto;

public class SemesterDto {

	protected Integer id_semester;
	protected String semester;
	protected Integer id_year;
	protected Integer id_course;



	public SemesterDto() {
		super();

	}


	public SemesterDto(Integer id_semester, String semester, Integer id_year, Integer id_course) {

		super();
		this.id_semester = id_semester;
		this.semester = semester;
		this.id_year = id_year;
		this.id_course = id_course;
	}


	public SemesterDto(SemesterDto semesterDto) {
		super();
		this.id_semester = semesterDto.getId_semester();
		this.semester = semesterDto.getSemester();
		this.id_year = semesterDto.getId_year();
		this.id_course = semesterDto.getId_course();
	}


	public Integer getId_semester() {
		return id_semester;
	}


	public String getSemester() {
		return semester;
	}


	public Integer getId_year() {
		return id_year;
	}


	public Integer getId_course() {
		return id_course;
	}


	public void setId_semester(Integer id_semester) {
		this.id_semester = id_semester;
	}


	public void setSemester(String semester) {
		this.semester = semester;
	}


	public void setId_year(Integer id_year) {
		this.id_year = id_year;
	}


	public void setId_course(Integer id_course) {
		this.id_course = id_course;
	}

	public String toString() {
		return id_semester.toString();

	}


}
