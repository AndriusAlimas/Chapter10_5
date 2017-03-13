package com.example.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class MyCorrectIteratorTag extends TagSupport{

	private String[] movies;
	private int movieCounter;
	
	// this setter is for old Java Bean to use for tag attribute(required):
		public void setMovieCounter(int movieCounter){
			this.movieCounter = movieCounter;
		}
		
	public int doStartTag()throws JspException{
		movies = new String[]{"SpiderMan", "Saved!", "Amelie"};
		// we must first save attribute before letting go to tag body!!!:
		pageContext.setAttribute("movie", movies[movieCounter]);
		movieCounter++; // increament by one if you dont want to see same result twice
		return EVAL_BODY_INCLUDE; // remeber EVAL_BODY + INCLUDE in doStart!!
	}
	
	public int doAfterBody()throws JspException{
		
		if(movieCounter < movies.length){
		   pageContext.setAttribute("movie", movies[movieCounter]);
		   movieCounter++;
		   return EVAL_BODY_AGAIN; // EVAL_BODY + AGAIN only in doAfterBody()!!!
		}else{
		return SKIP_BODY; // we done with body!
		}
	}
	
	public int doEndTag()throws JspException{
		return EVAL_PAGE; // if you dont want SKIP_PAGE go futher to do page job with EVAL_PAGE!
	}
	
}
