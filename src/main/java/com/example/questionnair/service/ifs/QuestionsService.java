package com.example.questionnair.service.ifs;

import com.example.questionnair.vo.request.QuestionsRequest;
import com.example.questionnair.vo.response.QuestionsResponse;

public interface QuestionsService {
	
	public QuestionsResponse newQuestion(QuestionsRequest req);

}
