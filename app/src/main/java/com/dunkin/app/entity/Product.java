package com.dunkin.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
	
	@Column(nullable=false, length=100)
	private String cate;
	
	@Column(nullable=false, length=200)
	private String pname;
	
	@Column(columnDefinition="TEXT")
	private String comment;
	
	@Builder.Default
	private int price1=1000; //입고가격
	
	@Builder.Default
	private int price2=1300; //출고가격
	
	@Builder.Default
	private int amount=1; //상품현재 잔존수량
	
	@Builder.Default
	private String img1="/images/noimg.jpg"; //상품 메인 이미지(800X600)
	
	@Builder.Default
	private String img2="/images/noimg.jpg"; //상품 보조 이미지(X)
	
	@Builder.Default
	private LocalDateTime resdate=LocalDateTime.now();
	
}
