 package cu.edu.cujae.backend.core.dto;

 public class SubjectDto{

protected Integer id_subject;
protected String subject;
protected Integer id_semester;


public SubjectDto(){
	super();

}


public SubjectDto(Integer id_subject,String subject,Integer id_semester) {

	super();
	this.id_subject=id_subject;
	this.subject=subject;
	this.id_semester=id_semester;
}


public SubjectDto(SubjectDto subjectDto){
	super();
	this.id_subject=subjectDto.getId_subject();
	this.subject=subjectDto.getSubject();
	this.id_semester=subjectDto.getId_semester();
}


public Integer getId_subject() {
	return id_subject;
}


public String getSubject() {
	return subject;
}


public Integer getId_semester() {
	return id_semester;
}


public void setId_subject( Integer id_subject) {
	this.id_subject=id_subject;
}


public void setSubject( String subject) {
	this.subject=subject;
}


public void setId_semester( Integer id_semester) {
	this.id_semester=id_semester;
}


public String toString(){
	return id_subject.toString();

}

}
