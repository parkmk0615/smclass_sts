package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceimpl implements MemberService {
	@Autowired MemberMapper memberMapper;

	@Override
	public ArrayList<MemberDto> member() {
		ArrayList<MemberDto> mlist = memberMapper.selectAll();
		return mlist;
	}
	
}
