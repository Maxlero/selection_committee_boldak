package by.grsu.boldak.model;

/**
 * AdminSubmit form Model for `/admin` page
 */
public class AdminSubmit {
	private String type;
	private String email;

	@Override
	public String toString() {
		return "AdminSubmit{" +
				"type='" + type + '\'' +
				", email='" + email + '\'' +
				'}';
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
