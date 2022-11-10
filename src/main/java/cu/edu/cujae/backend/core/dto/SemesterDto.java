 package cu.edu.cujae.backend.core.dto;

 public class SemesterDto{

protected Integer id_semester;
protected String semester;
protected Integer hour;
protected Integer id_year;
protected Integer id_subject_history;


public SemesterDto(){
	super();

}


public SemesterDto(Integer id_semester,String semester,Integer hour,Integer id_year,Integer id_subject_history) {

	super();
	this.id_semester=id_semester;
	this.semester=semester;
	this.hour=hour;
	this.id_year=id_year;
	this.id_subject_history=id_subject_history;
}


public SemesterDto(SemesterDto semesterDto){
	super();
	this.id_semester=semesterDto.getId_semester();
	this.semester=semesterDto.getSemester();
	this.hour=semesterDto.getHour();
	this.id_year=semesterDto.getId_year();
	this.id_subject_history=semesterDto.getId_subject_history();
}


public Integer getId_semester() {
	return id_semester;
}


public String getSemester() {
	return semester;
}


public Integer getHour() {
	return hour;
}


public Integer getId_year() {
	return id_year;
}


public Integer getId_subject_history() {
	return id_subject_history;
}


public void setId_semester( Integer id_semester) {
	this.id_semester=id_semester;
}


public void setSemester( String semester) {
	this.semester=semester;
}


public void setHour( Integer hour) {
	this.hour=hour;
}


public void setId_year( Integer id_year) {
	this.id_year=id_year;
}


public void setId_subject_history( Integer id_subject_history) {
	this.id_subject_history=id_subject_history;
}


public String toString(){
	return id_semester.toString();

}


}
