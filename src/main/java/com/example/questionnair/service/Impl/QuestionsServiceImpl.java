package com.example.questionnair.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.questionnair.constants.RtnCode;
import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.entity.Questions;
import com.example.questionnair.repository.QuestionnairesDao;
import com.example.questionnair.repository.QuestionsDao;
import com.example.questionnair.service.ifs.QuestionsService;
import com.example.questionnair.vo.request.QuestionsRequest;
import com.example.questionnair.vo.response.QuestionsResponse;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	@Autowired
	private QuestionsDao questionsDao;
	@Autowired
	private QuestionnairesDao questionnairesDao;

	@Override
	public QuestionsResponse newQuestion(QuestionsRequest req) {
		if (req == null) {
			return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		List<Questions> reqQuestionList = req.getQuestionList();
		if (CollectionUtils.isEmpty(reqQuestionList)) {
			return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		List<Questions> newQuestionList = new ArrayList<>();
		for (Questions reqQuestion : reqQuestionList) {
			if (reqQuestion.getQuestionnaire() == null || //
					!StringUtils.hasText(reqQuestion.getTitle()) || //
					!StringUtils.hasText(reqQuestion.getType())) {
				return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
			}
			Optional<Questionnaires> opQuestionnaire = questionnairesDao
					.findById(reqQuestion.getQuestionnaire().getQuestionnaireId());
			if (opQuestionnaire.isEmpty()) {
				return new QuestionsResponse(RtnCode.CANNOT_FIND_QUESTIONNAIRE.getCode(),
						RtnCode.CANNOT_FIND_QUESTIONNAIRE.getMessage());
			}

			reqQuestion.setQuestionnaire(opQuestionnaire.get());
			List<Questions> dbQuestionList = questionsDao.findByQuestionnaire(opQuestionnaire.get());
			for (Questions dbQuestion : dbQuestionList) {
				if (dbQuestion.getTitle().equals(reqQuestion.getTitle())
						&& dbQuestion.getQuestionId() != reqQuestion.getQuestionId()) {
					return new QuestionsResponse(RtnCode.REPEAT_TITLE.getCode(), RtnCode.REPEAT_TITLE.getMessage());
				}
			}
			newQuestionList.add(reqQuestion);
		}
		if (CollectionUtils.isEmpty(newQuestionList)) {
			return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		questionsDao.saveAll(newQuestionList);
		return new QuestionsResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public QuestionsResponse updateQuestion(QuestionsRequest req) {
		return null;
	}

	@Override
	public QuestionsResponse delQuestion(QuestionsRequest req) {
		if (req == null) {
			return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		List<Questions> delQuestionList = req.getQuestionList();
		if (CollectionUtils.isEmpty(delQuestionList)) {
			return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}

		for (Questions delQuestion : delQuestionList) {
			if (delQuestion.getQuestionnaire() == null || !StringUtils.hasText(delQuestion.getTitle())) {
				return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
			}
			Questions dbQuestion = questionsDao.findByTitleAndQuestionnaireId(//
					delQuestion.getTitle(), //
					delQuestion.getQuestionnaire().getQuestionnaireId());
			if (dbQuestion == null) {
				return new QuestionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
			}
		}
		questionsDao.deleteAll(delQuestionList);
		return new QuestionsResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public List<Questions> findByQuestionnaire(Questionnaires questionnaire) {
		return questionsDao.findByQuestionnaire(questionnaire);
	}

}
