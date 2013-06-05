package producerfields.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ToDo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date timeCreated;
	protected String taskText;
	
	public ToDo() {}

	public ToDo(Long id, Date timeCreated, String taskText) {
		this.id = id;
		this.timeCreated = timeCreated;
		this.taskText = taskText;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((taskText == null) ? 0 : taskText.hashCode());
		result = prime * result
				+ ((timeCreated == null) ? 0 : timeCreated.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDo other = (ToDo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (taskText == null) {
			if (other.taskText != null)
				return false;
		} else if (!taskText.equals(other.taskText))
			return false;
		if (timeCreated == null) {
			if (other.timeCreated != null)
				return false;
		} else if (!timeCreated.equals(other.timeCreated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", timeCreated=" + timeCreated
				+ ", taskText=" + taskText + "]";
	}
}
