package com.example.tags;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class MyIteratorTag extends TagSupport {
	private String[] movies;
	private int movieCounter;
	
	// this setter is for old Java Bean to use for tag attribute(required):
	public void setMovieCounter(int movieCounter){
		this.movieCounter = movieCounter;
	}
	
	public int doStartTag()throws JspException{
		movies = new String[]{"SpiderMan", "Saved!", "Amelie"};
		return EVAL_BODY_INCLUDE; // in invoke tag body!! default is SKIP_BODY
	}
	
	public int doEndTag()throws JspException{
		return EVAL_PAGE; // this saying go execute rest page , same if you dont provide this method is default 
	}
	
	public int doAfterBody()throws JspException{
		
		if(movieCounter < movies.length){
			pageContext.setAttribute("movie", movies[movieCounter]);
			movieCounter++;
			return EVAL_BODY_AGAIN; // this go to tag body again!
		}else{
		return SKIP_BODY; // end of body itteration!
		}
	}
}
