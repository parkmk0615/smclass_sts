package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StuDto {
	private int stuno;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
}
