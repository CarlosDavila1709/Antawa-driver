package store.antawa.backoffice.user.domain;

import java.util.Objects;

public class User {

	private final UserUid uid;
	private final UserName names;
	private final UserLastName lastName;
	private final UserEmail email;
	private final UserPassword password;
	
	public User(
			UserUid uid,
			UserName names,
			UserLastName lastName,
			UserEmail email,
			UserPassword password) {
		
    	this.uid 				 = uid;
    	this.names 				 = names;
    	this.lastName 			 = lastName;
    	this.email 				 = email;
    	this.password 			 = password;

	}

	
	public User() {
    	this.uid 				 = null;
    	this.names 				 = null;
    	this.lastName 			 = null;
    	this.email 				 = null;
    	this.password 			 = null;
	}
	
	public static User create(
			UserUid uid,
			UserName names,
			UserLastName lastName,
			UserEmail email,
			UserPassword password)
			{
		
		User user = new User(uid, names, lastName, email,  password);
		
		return user;
	}
	public UserUid uid() {
		return uid;
	}
	public UserName names() {
		return names;
	}
	public UserLastName lastName() {
		return lastName;
	}
	public UserEmail email() {
		return email;
	}
	public UserPassword password() {
		return password;
	}
    public boolean passwordMatches(UserPassword password) {
        return this.password.equals(password);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User driver = (User) o;
        return uid.equals(driver.uid) &&
               email.equals(driver.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash( uid,
        		 names,
        		 lastName,
        		 email,
        		 password);
    }
}
