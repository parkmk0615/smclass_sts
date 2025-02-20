package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceimpl implements MemberService {
	@Autowired MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		MemberDto memberDto = memberMapper.selectLogin(mdto);
		return memberDto;
	}

}
