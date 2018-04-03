package by.grsu.boldak.DataTransferObject;

import by.grsu.boldak.constraint.FieldMatch;

import javax.validation.constraints.*;

@FieldMatch.List({
		@FieldMatch(first = "password", second = "confirmPassword", message = "Пароли не совпадают"),
})
public class UserRegistrationDto {

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String password;

	private int faculty;

	@Min(0)
	@Max(100)
	private int mark1;

	@Min(0)
	@Max(100)
	private int mark2;

	@Min(0)
	@Max(100)
	private int mark3;

	@Min(0)
	@Max(100)
	private int certificate;

	@NotEmpty
	private String confirmPassword;

	@Email
	@NotEmpty
	private String email;

	@AssertTrue
	private Boolean terms;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getTerms() {
		return terms;
	}

	public void setTerms(Boolean terms) {
		this.terms = terms;
	}

	public int getFaculty() {
		return faculty;
	}

	public void setFaculty(Integer faculty) {
		this.faculty = faculty;
	}

	public int getMark1() {
		return mark1;
	}

	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}

	public int getMark2() {
		return mark2;
	}

	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}

	public int getMark3() {
		return mark3;
	}

	public void setMark3(int mark3) {
		this.mark3 = mark3;
	}

	public int getCertificate() {
		return certificate;
	}

	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}
}
