package com.dunkin.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dunkin.app.entity.Sample;
import com.dunkin.app.repository.SampleRepository;

@Service
public class SampleService {
	//SampleRepository sampleRepository; //필드주입
	
	private final SampleRepository sampleRepository; //생성자주입

	public SampleService(SampleRepository sampleRepository) {
		this.sampleRepository=sampleRepository;
	}
	//서비스기술
	//목록조회(getAllSamples())
	//select * from sample; => .findAll()
	public List<Sample> getAllSamples() {
		return sampleRepository.findAll();
	}
	
	//샘플1건조회(no 조회) => getSampleById(Long no)
	//select * from sample where no=1; => .findById()
	public Optional<Sample> getSampleById(Long no) {
		return sampleRepository.findById(no); //Sample sample=new Sample();
	}
	
	//샘플저장(sample 객체로 전달받아 저장) => saveSample(Sample, sample)
	//insert into sample values (default, "김기태"); => .save(sample)
	public Sample saveSample(Sample sample) {
		return sampleRepository.save(sample);
	}
	
	//샘플삭제(no 삭제) => deleteSample(Long no)
	//delete from sample where no=1; => .deleteById(no);
	public void deleteSample(Long no) {
		sampleRepository.deleteById(no);
	}
	public Sample getSampleByNo(Long no) { //RestApiController
		return sampleRepository.findById(no).orElse(null);
	}
	
	//샘플수정
	//update sample set name="" where no=1 => .save(sample)
	public Sample updateSample(Sample sample) {
		return sampleRepository.save(sample);
	}
}
