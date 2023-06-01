package com.ardor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardor.mapper.CategoryMapper;
import com.ardor.model.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService{

@Autowired CategoryMapper categoryMapper;


	//카테고리 등록
	@Override
	public boolean registerCategory(CategoryDTO categoryDTO) {
		return categoryMapper.insertCategoryInfoToDB(categoryDTO);
	}

	// 카테고리 전체 목록 조회
	@Override
		public List<CategoryDTO> getAllCategoryList() {
			return categoryMapper.getAllCategoryFromDB();
		}

	
	// 카테고리 1개 정보 조회(byCatCode)
	@Override
		public CategoryDTO getCategoryInfo(String catCode) {
			return categoryMapper.getCategoryInfoByCatCode(catCode);
		}
	
	// 카테고리 수정(byCatNo)
	@Override
		public boolean updateCategory(CategoryDTO categoryDTO) {
			return categoryMapper.updateCategoryByCatCode(categoryDTO);
		}
	
	// 카테고리 삭제(byCatCode)
	@Override
		public boolean deleteCategory(String catCode) {
			return categoryMapper.deleteCategoryByCatCode(catCode);
		}
	
}
