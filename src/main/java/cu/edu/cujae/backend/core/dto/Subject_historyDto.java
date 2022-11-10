package cu.edu.cujae.backend.core.dto;


public class Subject_historyDto {

	protected Integer id_subject_history;
	protected String subject_history_type;
	protected Integer id_course;


	public Subject_historyDto() {
		super();

	}


	public Subject_historyDto(Integer id_subject_history, String subject_history_type, Integer id_course) {

		super();
		this.id_subject_history = id_subject_history;
		this.subject_history_type = subject_history_type;
		this.id_course = id_course;
	}


	public Subject_historyDto(Subject_historyDto subject_historyDto) {
		super();
		this.id_subject_history = subject_historyDto.getId_subject_history();
		this.subject_history_type = subject_historyDto.getSubject_history_type();
		this.id_course = subject_historyDto.getId_course();
	}


	public Integer getId_subject_history() {
		return id_subject_history;
	}


	public String getSubject_history_type() {
		return subject_history_type;
	}


	public Integer getId_course() {
		return id_course;
	}


	public void setId_subject_history(Integer id_subject_history) {
		this.id_subject_history = id_subject_history;
	}


	public void setSubject_history_type(String subject_history_type) {
		this.subject_history_type = subject_history_type;
	}


	public void setId_course(Integer id_course) {
		this.id_course = id_course;
	}


	public String toString() {
		return id_subject_history.toString();

	}


}
