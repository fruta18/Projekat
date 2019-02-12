package com.itkpreobuka.diary.controllers.util;

import com.fasterxml.jackson.annotation.JsonView;
import com.itkpreobuka.diary.security.Views;


public class RestError {
	

		@JsonView(Views.Public.class)
		private int code;
		@JsonView(Views.Public.class)
		private String message;

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public RestError(int code, String message) {
			super();
			this.code = code;
			this.message = message;
		}

		public RestError() {
			super();
		}

		

		
	}

