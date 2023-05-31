package com.example.questionnair.service.ifs;

import com.example.questionnair.vo.request.QuestionnairesRequest;
import com.example.questionnair.vo.response.QuestionnairesResponse;

public interface QuestionnairesService {
	
	public QuestionnairesResponse newQuestionnaire(QuestionnairesRequest req);
	
}
