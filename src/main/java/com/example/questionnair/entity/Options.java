package com.example.questionnair.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_id")
	private Long optionId;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Questions question;
	@Column(name = "option_name")
	private String optionName;
	@Column(name = "count")
	private int count;

	// 其他欄位及相對應的getter和setter方法
}
