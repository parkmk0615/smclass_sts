package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.EventDto;

@Mapper
public interface EventMapper {

	ArrayList<EventDto> selectAll();

	EventDto selectone(int eno);

}
