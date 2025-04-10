package com.dunkin.app.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dunkin.app.entity.Qna;
import com.dunkin.app.service.QnaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna/api/")
@CrossOrigin(origins="*")

public class QnaRestController {
	private final QnaService qnaService;
	
	@GetMapping("/list")
	public List<Qna> getAll() {
		return qnaService.getAllQnas();
	}
	
	@GetMapping("/detail/{no}")
	public Qna getOne(@PathVariable Long no) {
		return qnaService.findByNo(no);
	}
	
	@PostMapping("/new")
	public Qna insert(@RequestBody Qna qna) {
		return qnaService.save(qna);
	}
	
	@PutMapping("/update/{no}")
	public Qna update(@PathVariable("no") Long no, @RequestBody Qna qna) {
		qna.setNo(no);
		return qnaService.save(qna);
	}
	
	@DeleteMapping("/delte/{no}")
	public void delete(@PathVariable("no") Long no) {
		qnaService.delete(no);
	}
	
}
