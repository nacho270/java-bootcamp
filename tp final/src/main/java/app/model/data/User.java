package app.model.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	private String usr;
	@NotNull
	private String pwd;

	public User() {
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "usr: " + usr + " / pwd: " + pwd;
	}

	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		if (user.getUsr().equals(this.usr) && user.getPwd().equals(this.pwd)) {
			return true;
		}
		return false;

	}
}
