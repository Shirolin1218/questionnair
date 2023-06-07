package com.example.questionnair.service.ifs;

import java.util.List;

import com.example.questionnair.entity.Options;
import com.example.questionnair.entity.Questions;
import com.example.questionnair.vo.request.OptionsRequest;
import com.example.questionnair.vo.response.OptionsResponse;

public interface OptionsService {
	public OptionsResponse newOption(OptionsRequest req);

	public OptionsResponse updateOption(OptionsRequest req);

	public OptionsResponse delOption(OptionsRequest req);

	public List<Options> findByQuestion(Questions question);
}
