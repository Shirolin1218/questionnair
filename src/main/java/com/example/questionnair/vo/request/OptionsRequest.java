package com.example.questionnair.vo.request;

import java.util.List;

import com.example.questionnair.entity.Options;

public class OptionsRequest {

	private List<Options> optionList;

	public List<Options> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<Options> optionList) {
		this.optionList = optionList;
	}
}
