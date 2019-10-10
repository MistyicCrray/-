package com.nursery_school.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nursery_school.manager.mapper.PayStandardMapper;
import com.nursery_school.manager.model.PayStandard;
import com.nursery_school.manager.tools.DocConverter;
import com.nursery_school.manager.tools.FileUtil;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class PayStandardService {

	@Autowired
	private PayStandardMapper payStandardMapper;

	@Value("${uploadFilePath}")
	private String filePath;

	public void add(PayStandard payStandard, MultipartFile file) {
		payStandard.setId(UUIDUtils.get16UUID());
		if (file != null) {
			payStandard.setFile((String) FileUtil.uploadImage(file).get("filePath"));
			System.out.println(filePath + payStandard.getFile());
			DocConverter dct = new DocConverter(filePath + payStandard.getFile());
			dct.conver();
		}
		// 以分为单位要乘100
		payStandard.setBoardAges(payStandard.getBoardAges() * 100);
		payStandard.setBookMoney(payStandard.getBookMoney() * 100);
		payStandard.setQuarterage(payStandard.getQuarterage() * 100);
		payStandard.setSchooling(payStandard.getSchooling() * 100);
		payStandardMapper.insert(payStandard);
	}

	public void delete(String id) {
		payStandardMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map, MultipartFile file) {
		if (file != null) {
			map.put("file", (String) FileUtil.uploadImage(file).get("filePath"));
			System.out.println(filePath + map.get("file").toString());
			DocConverter dct = new DocConverter(filePath + map.get("file").toString());
			dct.conver();
		}
		payStandardMapper.updateProvider(map);
	}

	public List<PayStandard> selectProvider(Map<String, Object> map) {
		return payStandardMapper.selectProvider(map);
	}

	public PayStandard findById(String id) {
		return payStandardMapper.selectByPrimaryKey(id);
	}
}
