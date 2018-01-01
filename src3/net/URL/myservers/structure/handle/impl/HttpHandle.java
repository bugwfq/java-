package net.URL.myservers.structure.handle.impl;

import net.URL.myservers.structure.communication.Request;
import net.URL.myservers.structure.communication.Response;
import net.URL.myservers.structure.handle.Handle;

public class HttpHandle implements Handle{

	@Override
	public void alternating(Request request, Response response) {
		String url = request.getUrl();
		response.response(url);
	}
	
}
