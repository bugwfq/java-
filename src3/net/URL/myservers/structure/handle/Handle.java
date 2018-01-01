package net.URL.myservers.structure.handle;

import net.URL.myservers.structure.communication.Request;
import net.URL.myservers.structure.communication.Response;

public interface Handle {
	void alternating(Request request,Response response);
}
