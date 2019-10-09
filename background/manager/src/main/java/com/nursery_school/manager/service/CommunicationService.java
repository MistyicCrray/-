package com.nursery_school.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.CommunicationMapper;
import com.nursery_school.manager.model.Communication;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class CommunicationService {

	@Autowired
	private CommunicationMapper communicationMapper;

	public void add(Communication communication) {
		communication.setId(UUIDUtils.get16UUID());
		communication.setCreateDate(new Date());
		communicationMapper.insert(communication);
	}

	public void delete(String id) {
		communicationMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map) {
		communicationMapper.updateProvider(map);
	}

	public List<Communication> findByDyna(Map<String, Object> map) {
		return communicationMapper.findByDyna(map);
	}

	public Communication findById(String id) {
		return communicationMapper.selectByPrimaryKey(id);
	}
}
