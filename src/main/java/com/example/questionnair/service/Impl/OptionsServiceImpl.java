package com.example.questionnair.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.questionnair.constants.RtnCode;
import com.example.questionnair.entity.Options;
import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.entity.Questions;
import com.example.questionnair.repository.OptionsDao;
import com.example.questionnair.repository.QuestionnairesDao;
import com.example.questionnair.repository.QuestionsDao;
import com.example.questionnair.service.ifs.OptionsService;
import com.example.questionnair.vo.request.OptionsRequest;
import com.example.questionnair.vo.response.OptionsResponse;

@Service
public class OptionsServiceImpl implements OptionsService {
	@Autowired
	private QuestionsDao questionsDao;
	@Autowired
	private QuestionnairesDao questionnairesDao;
	@Autowired
	private OptionsDao optionsDao;

	@Override
	public OptionsResponse newOption(OptionsRequest req) {
		if (req == null) {
			return new OptionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		List<Options> reqOptionList = req.getOptionList();
		if (CollectionUtils.isEmpty(reqOptionList)) {
			return new OptionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		List<Options> newOptionList = new ArrayList<>();
		for (Options option : reqOptionList) {
			Questionnaires reqQuestionnaire = questionnairesDao.findByTitle(option.getQuestionnaire().getTitle());
			if (reqQuestionnaire == null) {
				return new OptionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
			}
			Questions reqQuestion = questionsDao.findByTitleAndQuestionnaireId(option.getQuestion().getTitle(),
					reqQuestionnaire.getQuestionnaireId());
			if (reqQuestion == null) {
				return new OptionsResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
			}
			option.setQuestionnaire(reqQuestionnaire);
			option.setQuestion(reqQuestion);
			newOptionList.add(option);
		}
		optionsDao.saveAll(newOptionList);
		return new OptionsResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());

	}

	@Override
	public OptionsResponse updateOption(OptionsRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OptionsResponse delOption(OptionsRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Options> findByQuestion(Questions question) {
		Questions dbQuestion = questionsDao.findByTitleAndQuestionnaireId(question.getTitle(),
				question.getQuestionnaire().getQuestionnaireId());
		return optionsDao.findByQuestion(dbQuestion);
	}

}
