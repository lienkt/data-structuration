package fr.epita.etl;

/**
 * The Item State
 * @author LienKT
 */

public class ItemState {
	private String email;
	private String state;
	
	public ItemState() {
	}

	public ItemState(String email, String state) {
		this.email = email;
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ItemState [email=" + email + ", state=" + state + "]";
	}
}
