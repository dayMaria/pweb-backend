package cu.edu.cujae.backend.core.dto;


public class GroupsDto {

	protected Integer id_group;
	protected String group_name;
	protected Integer id_year;


	public GroupsDto() {
		super();

	}


	public GroupsDto(Integer id_group, String group_name, Integer id_year) {

		super();
		this.id_group = id_group;
		this.group_name = group_name;
		this.id_year = id_year;
	}


	public GroupsDto(GroupsDto groupsDto) {
		super();
		this.id_group = groupsDto.getId_group();
		this.group_name = groupsDto.getGroup_name();
		this.id_year = groupsDto.getId_year();
	}


	public Integer getId_group() {
		return id_group;
	}


	public String getGroup_name() {
		return group_name;
	}


	public Integer getId_year() {
		return id_year;
	}


	public void setId_group(Integer id_group) {
		this.id_group = id_group;
	}


	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}


	public void setId_year(Integer id_year) {
		this.id_year = id_year;
	}


	public String toString() {
		return id_group.toString();

	}


}
