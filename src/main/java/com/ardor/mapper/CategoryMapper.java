package com.ardor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ardor.model.CategoryDTO;

@Mapper
public interface CategoryMapper {

	
	// 카테고리 (DB)등록
	public boolean insertCategoryInfoToDB(CategoryDTO categoryDTO);
		
	// 카테고리 전체 목록 조회
	public List<CategoryDTO> getAllCategoryFromDB(CategoryDTO categoryDTO);
	
	// 카테고리 정보조회(카테고리 코드로)
	public CategoryDTO getCategoryInfoByCatCode(String catCode);
	
	// 카테고리 수정(카테고리 코드로)
	public boolean updateCategoryByCatCode(CategoryDTO categoryDTO);
	
	// 카테고리 삭제(카테고리 코드로)
	public boolean deleteCategoryByCatCode(String catCode);
	
	
	
}
