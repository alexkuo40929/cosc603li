/*
 * 
 */
package edu.towson.cis.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

// TODO: Auto-generated Javadoc
/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	
	/**
	 * Greet server.
	 *
	 * @param input the input
	 * @param callback the callback
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
