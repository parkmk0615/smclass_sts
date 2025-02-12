package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface CustomerMapper {

	ArrayList<BoardDto> selectAll();

	BoardDto selectOne(int bno);

	int selectAll(String category, String searchW);

	ArrayList<BoardDto> notice(int startrow, int endrow, String category, String searchW);

}	
