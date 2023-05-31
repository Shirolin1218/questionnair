package com.example.questionnair.service.ifs;

import com.example.questionnair.vo.request.ReportersRequest;
import com.example.questionnair.vo.response.ReportersResponse;

public interface ReportersService {
	public ReportersResponse newReporter(ReportersRequest req);
}
