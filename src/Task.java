
public class Task {
	protected String name = "Sean";
	protected String date = "12/1/2020";
	protected String finished = "Not Finished";
	protected String description = "Get a job";

	public Task(String name, String date, String finished, String description) {
		this.name = name;
		this.date = date;
		this.finished = finished;
		this.description = description;
	}

	public Task(String name, String date, String description) {
		super();
		this.name = name;
		this.date = date;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Task() {
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
