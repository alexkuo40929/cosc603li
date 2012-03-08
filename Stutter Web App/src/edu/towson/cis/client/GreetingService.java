/*
 * 
 */
package edu.towson.cis.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

// TODO: Auto-generated Javadoc
/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	/**
	 * Greet server.
	 *
	 * @param name the name
	 * @return the string
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	String greetServer(String name) throws IllegalArgumentException;
}
