package com.example.validation.model;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@NotBlank(message = "Name may not be empty")
	@Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters long")
	private String name;
	
	@Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
	private int age;
	
	@NotBlank(message = "Email may not be empty")
	@Email(message = "Email should be valid")
	private String email;
	
	//@Pattern(regexp="(^$|[0-9]{10})", message = "phoneNumber should be number")
	private Number phoneNumber;
	
	@AssertTrue
    private boolean working;
	
	@Past(message = "DOB needs to be in past!")
	@JsonFormat(pattern = "MM/dd/yy")
	private Date dateOfBirth;
	
	//few more annotations like .. 
	
	//@Positive and @PositiveOrZero apply to numeric values and validate that they are strictly positive, or positive including 0.
	//@Negative and @NegativeOrZero apply to numeric values and validate that they are strictly negative, or negative including 0.
	//@Past and @PastOrPresent validate that a date value is in the past or the past including the present; can be applied to date types including those added in Java 8.
	//@Future and @FutureOrPresent validate that a date value is in the future, or in the future including the present.
	
}
