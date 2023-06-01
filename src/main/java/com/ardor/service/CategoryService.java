package com.ardor.service;

import java.util.List;

import com.ardor.model.CategoryDTO;

public interface CategoryService {
	
	//카테고리 등록
	public boolean registerCategory(CategoryDTO categoryDTO);

	// 카테고리 전체 목록 조회
	public List<CategoryDTO> getAllCategoryList();
	
	// 카테고리 1개 정보 조회
	 public CategoryDTO getCategoryInfo(String catCode);
	
	// 카테고리 수정(byCatCode)
	public boolean updateCategory(CategoryDTO categoryDTO);
	
	// 카테고리 삭제(byCatCode)
	public boolean deleteCategory(String catCode);
}
