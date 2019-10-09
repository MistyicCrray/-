package com.nursery_school.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ReplyMapper;
import com.nursery_school.manager.model.Reply;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class ReplyService {

	@Autowired
	private ReplyMapper replyMapper;

	public void add(Reply reply) {
		reply.setId(UUIDUtils.get16UUID());
		reply.setCreateDate(new Date());
		replyMapper.insert(reply);
	}

	public void delete(String id) {
		replyMapper.deleteByPrimaryKey(id);
	}
//
//	public void update(Map<String, Object> map) {
//		replyMapper.updateProvider(map);
//	}

	public List<Reply> findByDyna(Map<String, Object> map) {
		return replyMapper.findByDyna(map);
	}

	public Reply findById(String id) {
		return replyMapper.selectByPrimaryKey(id);
	}
}
