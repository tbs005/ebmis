package com.cqu.edu.ebmis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.repository.ReportRepository;
import com.cqu.edu.ebmis.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	@Resource private ReportRepository reportRepository;
	public List<Map<String, Object>> getOriginData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getOriginData(map);
	}
	public int getOriginDataCount() {
		// TODO Auto-generated method stub
		return reportRepository.getOriginDataCount();
	}
	public List<Map<String, Object>> getCQLocalStore(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getCQLocalStore(map);
	}
	public int getCQLocalStoreCount() {
		// TODO Auto-generated method stub
		return reportRepository.getCQLocalStoreCount();
	}
	public List<Map<String, Object>> AliClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.AliClassifyData(map);
	}
	public int AliClassifyCount() {
		// TODO Auto-generated method stub
		return reportRepository.AliClassifyCount();
	}
	public List<Map<String, Object>> TmMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.TmMonthProductData(map);
	}
	public List<Map<String, Object>> TbMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.TbMonthProductData(map);
	}
	public List<Map<String, Object>> allProductNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.allProductNumData(map);
	}
	public int allProductNumCount() {
		// TODO Auto-generated method stub
		return reportRepository.allProductNumCount();
	}
	public List<Map<String, Object>> CQFarmProductNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductNumData(map);
	}
	public int CQFarmProductNumCount() {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductNumCount();
	}
	public List<Map<String, Object>> PlatformStoreNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.PlatformStoreNumData(map);
	}
	public int PlatformStoreNumCount() {
		// TODO Auto-generated method stub
		return reportRepository.PlatformStoreNumCount();
	}
	public List<Map<String, Object>> ClassifySystemData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.ClassifySystemData(map);
	}
	public int ClassifySystemCount() {
		// TODO Auto-generated method stub
		return reportRepository.ClassifySystemCount();
	}
	public List<Map<String, Object>> OneClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.OneClassifyData(map);
	}
	public int OneClassifyCount() {
		// TODO Auto-generated method stub
		return reportRepository.OneClassifyCount();
	}
	public List<Map<String, Object>> FreshClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.FreshClassifyData(map);
	}
	public int FreshClassifyCount() {
		// TODO Auto-generated method stub
		return reportRepository.FreshClassifyCount();
	}
	public List<Map<String, Object>> NoFreshClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.NoFreshClassifyData(map);
	}
	public int NoFreshClassifyCount() {
		// TODO Auto-generated method stub
		return reportRepository.NoFreshClassifyCount();
	}
	public List<Map<String, Object>> CQFarmProductEveryMarketData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryMarketData(map);
	}
	public int CQFarmProductEveryMarketCount() {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryMarketCount();
	}
	public List<Map<String, Object>> CQFarmProductEveryStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryStoreData(map);
	}
	public int CQFarmProductEveryStoreCount() {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryStoreCount();
	}
	public List<Map<String, Object>> MarketCQFarmProductStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.MarketCQFarmProductStoreData(map);
	}
	public int MarketCQFarmProductStoreCount() {
		// TODO Auto-generated method stub
		return reportRepository.MarketCQFarmProductStoreCount();
	}
	public List<Map<String, Object>> CQEveryCityStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQEveryCityStoreData(map);
	}
	public int CQEveryCityStoreCount() {
		// TODO Auto-generated method stub
		return reportRepository.CQEveryCityStoreCount();
	}

}
