/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;
import com.cqu.edu.ebmis.repository.ProductBaseInfoRepository;
import com.cqu.edu.ebmis.repository.ThreeClassificationRepository;
import com.cqu.edu.ebmis.service.ProductBaseInfoService;
import com.cqu.edu.ebmis.service.ThreeClassificationService;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 产品基本信息服务实现
 * 
 * @author mxl
 * @version $ ProductBaseInfoServiceImpl.java v1.0, 2017年5月5日 下午11:30:09 mxl Exp
 *          $
 */
@Service
public class ThreeClassificationServiceImpl implements ThreeClassificationService {
	
	@Autowired
	private ThreeClassificationRepository	threeClassificationRepository;

	public List<ThreeClassificationDo> findLevel0() {
		// TODO Auto-generated method stub
		return threeClassificationRepository.findLevel0();
	}

	public List<ThreeClassificationDo> findLevel1(String LevelName) {
		// TODO Auto-generated method stub
		return threeClassificationRepository.findLevel1(LevelName);
	}

	public List<ThreeClassificationDo> findLevel2(ThreeClassificationDo threeClassificationDo) {
		// TODO Auto-generated method stub
		return threeClassificationRepository.findLevel2(threeClassificationDo);
	}

	public List<ThreeClassificationDo> findLevel3(ThreeClassificationDo threeClassificationDo) {
		// TODO Auto-generated method stub
		return threeClassificationRepository.findLevel3(threeClassificationDo);
	}

	public List<ThreeClassificationDo> allPlatform() {
		// TODO Auto-generated method stub
		return threeClassificationRepository.allPlatform();
	}
	
}
