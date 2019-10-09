package com.nursery_school.manager.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nursery_school.manager.mapper.CleaningInfoMapper;
import com.nursery_school.manager.model.CleaningInfo;
import com.nursery_school.manager.tools.FileUtil;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class CleaningInfoService {

	@Autowired
	private CleaningInfoMapper cleaningInfoMapper;

	public void add(Map<String, Object> map, MultipartFile img) throws ParseException {
		CleaningInfo cleaningInfo = new CleaningInfo();
		cleaningInfo.setId(UUIDUtils.get16UUID());
		if (img != null) {
			cleaningInfo.setImg((String) FileUtil.uploadImage(img).get("filePath"));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cleaningInfo.setCleanEndTime(sdf.parse(map.get("cleanEndTime").toString()));
		cleaningInfo.setCleaningId((String) map.get("cleaningId"));
		cleaningInfo.setCleanStartTime(sdf.parse(map.get("cleanStartTime").toString()));
		cleaningInfo.setStaffId((String) map.get("staffId"));
		cleaningInfoMapper.insert(cleaningInfo);
	}

	public void delete(String id) {
		cleaningInfoMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map, MultipartFile img) {
		if (img != null) {
			map.put("img", (String) FileUtil.uploadImage(img).get("filePath"));
		}
		cleaningInfoMapper.updateProvider(map);
	}

	public List<CleaningInfo> findByDyna(Map<String, Object> map) {
		return cleaningInfoMapper.findByDyna(map);
	}
}
