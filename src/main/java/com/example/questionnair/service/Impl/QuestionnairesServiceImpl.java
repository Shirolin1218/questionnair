package com.example.questionnair.service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnair.constants.RtnCode;
import com.example.questionnair.entity.Questionnaires;
import com.example.questionnair.repository.QuestionnairesDao;
import com.example.questionnair.service.ifs.QuestionnairesService;
import com.example.questionnair.vo.request.QuestionnairesRequest;
import com.example.questionnair.vo.response.QuestionnairesResponse;

@Service
public class QuestionnairesServiceImpl implements QuestionnairesService {

	@Autowired
	private QuestionnairesDao questionnaireDao;

	@Override
	public QuestionnairesResponse newQuestionnaire(QuestionnairesRequest req) {
		if (req == null) {
			return new QuestionnairesResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}

		Questionnaires reqQuestionnaire = req.getQuestionnaire();

		if (!StringUtils.hasText(reqQuestionnaire.getTitle())) {
			return new QuestionnairesResponse(RtnCode.CANNOT_EMPTY.getCode(), RtnCode.CANNOT_EMPTY.getMessage());
		}

		Questionnaires reqTitle = questionnaireDao.findByTitle(reqQuestionnaire.getTitle());

		if (reqTitle != null) {
			return new QuestionnairesResponse(RtnCode.REPEAT_TITLE.getCode(), RtnCode.REPEAT_TITLE.getMessage());
		}

		if (reqQuestionnaire.getStartDate() == null || reqQuestionnaire.getEndDate() == null
				|| reqQuestionnaire.getStartDate().isAfter(reqQuestionnaire.getEndDate())) {
			return new QuestionnairesResponse(RtnCode.BAD_VALUE.getCode(), RtnCode.BAD_VALUE.getMessage());
		}

		reqQuestionnaire.setActive(//
				LocalDate.now().isEqual(reqQuestionnaire.getStartDate())//
						|| LocalDate.now().isAfter(reqQuestionnaire.getStartDate())//
								&& LocalDate.now().isBefore(reqQuestionnaire.getEndDate()));

		questionnaireDao.save(reqQuestionnaire);
		Questionnaires resData = questionnaireDao.findByTitle(reqQuestionnaire.getTitle());
		return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), resData);
	}

	@Override
	public QuestionnairesResponse updateQuestionnaire(QuestionnairesRequest req) {
		if (req == null) {
			return new QuestionnairesResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}

		Questionnaires reqQuestionnaire = req.getQuestionnaire();

		if (!StringUtils.hasText(reqQuestionnaire.getTitle())) {
			return new QuestionnairesResponse(RtnCode.CANNOT_EMPTY.getCode(), RtnCode.CANNOT_EMPTY.getMessage());
		}

		Optional<Questionnaires> opDbQuestionnaire = questionnaireDao.findById(reqQuestionnaire.getQuestionnaireId());
		if (!opDbQuestionnaire.isPresent()) {
			return new QuestionnairesResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		Questionnaires dbQuestionnaire = opDbQuestionnaire.get();
		boolean isUpdate = false;
		if (!dbQuestionnaire.getDescription().equals(reqQuestionnaire.getDescription())) {
			isUpdate = true;
		}
		if (!dbQuestionnaire.getStartDate().isEqual(reqQuestionnaire.getStartDate())) {
			isUpdate = true;
		}
		if (!dbQuestionnaire.getEndDate().isEqual(reqQuestionnaire.getEndDate())) {
			isUpdate = true;
		}
		reqQuestionnaire.setActive(//
				LocalDate.now().isEqual(reqQuestionnaire.getStartDate())//
						|| LocalDate.now().isAfter(reqQuestionnaire.getStartDate())//
								&& LocalDate.now().isBefore(reqQuestionnaire.getEndDate()));
		if (!isUpdate) {
			return new QuestionnairesResponse(RtnCode.NO_DATA_UPDATED.getCode(), RtnCode.NO_DATA_UPDATED.getMessage());
		}
		questionnaireDao.save(reqQuestionnaire);
		return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
				reqQuestionnaire);
	}

	@Override
	public List<Questionnaires> findQuestionnairesPage(Pageable pageable) {
		Page<Questionnaires> questionnairesPage = questionnaireDao.findAll(pageable);
		List<Questionnaires> questionnairesList = questionnairesPage.getContent();
		return questionnairesList;
	}

	@Override
	public QuestionnairesResponse getHowManyData() {// 取得總資料數量並回傳第一頁的資料
		Page<Questionnaires> questionnairesPage = questionnaireDao
				.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "questionnaireId")));
		return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
				questionnairesPage.getContent(), (int) questionnairesPage.getTotalElements());
	}

	@Override
	public QuestionnairesResponse findByTitle(String title) {
		Questionnaires questionnaire = questionnaireDao.findByTitle(title);
		if (questionnaire == null) {
			return new QuestionnairesResponse(RtnCode.NOT_FOUND.getCode(), RtnCode.NOT_FOUND.getMessage());
		}
		return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), questionnaire);
	}

	@Override
	public QuestionnairesResponse searchQuestionnaires(QuestionnairesRequest req) {
		if (req == null || req.getQuestionnaire() == null) {
			return new QuestionnairesResponse(RtnCode.BAD_REQUEST.getCode(), RtnCode.BAD_REQUEST.getMessage());
		}
		String reqTitle = req.getQuestionnaire().getTitle();
		LocalDate reqStartTime = req.getQuestionnaire().getStartDate();
		LocalDate reqEndTime = req.getQuestionnaire().getEndDate();
		Pageable pageRequest = PageRequest.of(req.getPage(), 10, Sort.by(Sort.Direction.DESC, "questionnaireId"));
		Page<Questionnaires> questionnairesPage;
		
		if (!StringUtils.hasText(reqTitle)//
				&& (reqStartTime == null || !StringUtils.hasText(reqStartTime.toString()))//
				&& (reqEndTime == null || !StringUtils.hasText(reqEndTime.toString()))) {//

			questionnairesPage = questionnaireDao.findAll(pageRequest);

			return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
					questionnairesPage.getContent(), (int) questionnairesPage.getTotalElements());
		}

		if (StringUtils.hasText(reqTitle) //
				&& (reqStartTime == null || !StringUtils.hasText(reqStartTime.toString()))//
				&& (reqEndTime == null || !StringUtils.hasText(reqEndTime.toString()))) {//

			questionnairesPage = questionnaireDao.findBytitleContaining(reqTitle, pageRequest);

			return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
					questionnairesPage.getContent(), (int) questionnairesPage.getTotalElements());
		}

		if (StringUtils.hasText(reqTitle) //
				&& (reqStartTime != null)//
				&& (reqEndTime == null || !StringUtils.hasText(reqEndTime.toString()))) {//

			questionnairesPage = questionnaireDao.findBytitleContainingAndStartDateGreaterThanEqual(reqTitle,
					reqStartTime, pageRequest);

			return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
					questionnairesPage.getContent(), (int) questionnairesPage.getTotalElements());
		}

		if (StringUtils.hasText(reqTitle) //
				&& (reqStartTime == null || !StringUtils.hasText(reqEndTime.toString()))//
				&& (reqEndTime != null)) {//

			questionnairesPage = questionnaireDao.findBytitleContainingAndEndDateLessThanEqual(reqTitle, reqEndTime,
					pageRequest);

			return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
					questionnairesPage.getContent(), (int) questionnairesPage.getTotalElements());
		}

		questionnairesPage = questionnaireDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(//
				reqTitle, reqStartTime, reqEndTime, pageRequest);

		return new QuestionnairesResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
				questionnairesPage.getContent(), (int) questionnairesPage.getTotalElements());
	}

}
