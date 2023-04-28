package com.service;

import com.user.*;
public class Main {

	public static void main(String[] args) {
		User u = new User();
		u.getBox();
		u.viewBox();
		UserHandler user = new UserHandler();
		user.run();
	}

}
