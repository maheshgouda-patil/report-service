package com.solution.bo;

public class ResponseBo {

  private Object response;

  public Object getResponse() {
		return response;
	}


	public void setResponse(Object response) {
		this.response = response;
	}
 
  @Override
  public String toString() {
    return "ResponseBo message=" + response + "]";
  }




}
