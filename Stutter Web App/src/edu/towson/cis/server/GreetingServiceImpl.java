package edu.towson.cis.server;

import edu.towson.cis.client.GreetingService;
import edu.towson.cis.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.StringTokenizer;
import java.io.*;
import java.util.regex.*;
// TODO: Auto-generated Javadoc
/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	/* (non-Javadoc)
	 * @see edu.towson.cis.client.GreetingService#greetServer(java.lang.String)
	 */
	@SuppressWarnings("null")
	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		String temp = null;
		String stringReturn = " ";
		//String[] combo = null;
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 10 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
        String line;
    	String[]result = null;
    	String[]combo = {"","",""};
    	String last = null;
        result=input.split("\n");
        int  count=1;
        for (int i=0; i<result.length; i++){
    	   
    	    String stringTemp;
			combo = compare(result[i], last);
            last =  combo[1];
			temp =  combo[2] + "  " + combo[0] ;
			stringTemp = "the repeat word in line" + Integer.toString(count) + ":" + temp + "<br>";
		    stringReturn = stringReturn + stringTemp;
			count++;
		}	
      return stringReturn ;
       
	    }

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
	
	/**
	 * Compare.
	 *
	 * @param line the line
	 * @param last the last
	 * @return the string[]
	 */
	public static String[] compare(String line, String last) {
		int i = 0;
		int a2 = 0;
		String temp = " ";
		String[] result2;
		String thirdValue = "";
		StringTokenizer token = new StringTokenizer(line, "() ,.!-+=;:?&{}\\");// split
																				// string
																				// tokener
																				// by
																				// different
																				// symbol
		result2 = new String[token.countTokens()];

		int total = token.countTokens();
		while (token.hasMoreTokens()) // use loop to cauculate the same word!
		{
			result2[i++] = token.nextToken();

		}

		if (result2[0].equals(last)){// check the last word and first word for
									// next line
			System.out.println(result2[0] + " " + last);
			thirdValue = last;
		}
		for (int a1 = 0; a1 <= total - 1; a1++) {
			for (a2 = a1 + 1; a2 <= total - 1; a2++) {
				if (result2[a1].equals(result2[a2])) {
					System.out.println(result2[a2] + " " + result2[a1]);// print
					temp = temp+" "+result2[a2];
				}

			}

		}

		last = result2[total - 1];
		//return last;// pass the string value to readfile function
		
		String []returnString = {temp, last, thirdValue};
		return returnString;
	}



}

