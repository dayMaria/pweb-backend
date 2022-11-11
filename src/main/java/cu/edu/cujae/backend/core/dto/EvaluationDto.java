package cu.edu.cujae.backend.core.dto;


import java.sql.Date;

public class EvaluationDto {

	protected Integer id_evaluation;
	protected Integer evaluation;
	protected Integer id_subject;
	protected Integer id_student_history;
	protected Date date;


	public EvaluationDto() {
		super();

	}


	public EvaluationDto(Integer id_evaluation, Integer evaluation, Integer id_subject, Integer id_student_history, Date date) {

		super();
		this.id_evaluation = id_evaluation;
		this.evaluation = evaluation;
		this.id_subject = id_subject;
		this.id_student_history = id_student_history;
		this.date = date;
	}


	public EvaluationDto(EvaluationDto evaluationDto) {
		super();
		this.id_evaluation = evaluationDto.getId_evaluation();
		this.evaluation = evaluationDto.getEvaluation();
		this.id_subject = evaluationDto.getId_subject();
		this.id_student_history = evaluationDto.getId_student_history();
		this.date = evaluationDto.getDate();
	}


	public Integer getId_evaluation() {
		return id_evaluation;
	}


	public Integer getEvaluation() {
		return evaluation;
	}


	public Integer getId_subject() {
		return id_subject;
	}


	public Integer getId_student_history() {
		return id_student_history;
	}


	public java.sql.Date getDate() {
		return date;
	}


	public void setId_evaluation(Integer id_evaluation) {
		this.id_evaluation = id_evaluation;
	}


	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}


	public void setId_subject(Integer id_subject) {
		this.id_subject = id_subject;
	}


	public void setId_student_history(Integer id_student_history) {
		this.id_student_history = id_student_history;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String toString() {
		return id_evaluation.toString();

	}


}
