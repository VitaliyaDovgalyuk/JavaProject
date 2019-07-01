package com.cheese.cheese;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GifService {
	@Autowired
	private GifRepository gifRepository;
	
	public List<Gif> listAll(){
		return gifRepository.findAll();
	}
	public void save(Gif gif) {
		gifRepository.save(gif);
	}
	public Gif get(Long id){
		return gifRepository.findById(id).get();
		}
	public void delete(Long id) {
		gifRepository.deleteById(id);
	}
	
	public void deleteAll() {
		gifRepository.deleteAll();
	}
}
