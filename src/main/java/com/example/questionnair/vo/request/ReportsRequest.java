package com.example.questionnair.vo.request;

import java.util.List;

import com.example.questionnair.entity.Reports;

public class ReportsRequest {

	private List<Reports> reportList;

	public List<Reports> getReportList() {
		return reportList;
	}

	public void setReportList(List<Reports> reportList) {
		this.reportList = reportList;
	}
}
