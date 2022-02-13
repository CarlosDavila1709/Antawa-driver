package store.antawa.customer.user.application;

import java.util.List;

import store.antawa.shared.domain.bus.query.Response;

public final class UsersResponse implements Response {

	private final List<UserResponse> users;
	
	public UsersResponse(List<UserResponse> users) {
		this.users = users;
	}
	
	public List<UserResponse> users(){
		return users;
	}
}
