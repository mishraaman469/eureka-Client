package com.mindtree.school.exception;

public class NullCheckException extends RuntimeException{
	
		private String message;

		public NullCheckException(String message) {
			super(message);
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
}
