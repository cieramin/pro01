package com.dunkin.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dunkin.app.entity.Sample;
import com.dunkin.app.service.SampleService;

//Restful API
@RestController
@RequestMapping("/api")
public class RestApiController {
	private final SampleService sampleService;
	
	public RestApiController(SampleService sampleService) {
		this.sampleService=sampleService;
		//서비스 생성자 주입
	}
	//샘플목록
	@GetMapping("/list")   //localhost:8801/api/list
	public ResponseEntity<List<Sample>> getAllSamples() {
		List<Sample> samples=sampleService.getAllSamples();
		return ResponseEntity.ok(samples);
	}
	//샘플상세보기
	@GetMapping("/detail/{no}") //localhost:8801/api/detail/1
	public ResponseEntity<Sample> getSample(@PathVariable("no") Long no) {
		Sample sample=sampleService.getSampleByNo(no);
		return ResponseEntity.ok(sample);
	}
	//샘플추가
	@PostMapping("/save")
	public ResponseEntity<Sample> saveSample(@RequestBody Sample sample) {
		return ResponseEntity.ok(sampleService.saveSample(sample));
	}
	//샘플수정
	@PutMapping("/edit/{no}") //localhost:8801/api/edit/1
	public ResponseEntity<Sample> updateSample(@PathVariable("no") Long no, @RequestBody Sample sample) {
		sample.setNo(no);
		return ResponseEntity.ok(sampleService.updateSample(sample));
	}
	
	//샘플삭제
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<Void> deleteSample(@PathVariable("no") Long no) {
		sampleService.deleteSample(no);
		return ResponseEntity.noContent().build();
	}
} 
