package com.solution.exception;

public class SolutionException extends Exception {

  public SolutionException(String errorCode, String response) {
		super();
		this.errorCode = errorCode;
		this.response = response;
	}

private static final long serialVersionUID = 1L;

  private String errorCode;

  private String response;

    public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getResponse() {
    return response;
  }

  public void setResponseCode(String response) {
    this.response = response;
  }

  @Override
  public String toString() {
    return "Exception [errorCode=" + errorCode + ", responseCode="
        + response + "]";
  }

}
