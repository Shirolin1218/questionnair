package com.example.questionnair.service.ifs;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.vo.request.QuestionnairesRequest;
import com.example.questionnair.vo.response.QuestionnairesResponse;

public interface QuestionnairesService {

	public QuestionnairesResponse newQuestionnaire(QuestionnairesRequest req);

	public QuestionnairesResponse updateQuestionnaire(QuestionnairesRequest req);

	public QuestionnairesResponse getHowManyData();

	public List<Questionnaires> findQuestionnairesPage(Pageable pageable);

	public QuestionnairesResponse findByTitle(String title);

	public QuestionnairesResponse searchQuestionnaires(QuestionnairesRequest req);

}
