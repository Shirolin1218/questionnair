package com.example.questionnair.service.ifs;

import com.example.questionnair.vo.request.OptionsRequest;
import com.example.questionnair.vo.response.OptionResponse;

public interface OptionsService {
	public OptionResponse newOption(OptionsRequest req);
}
