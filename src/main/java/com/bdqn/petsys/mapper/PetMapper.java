package com.bdqn.petsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bdqn.petsys.entity.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author luo20
* @description 针对表【pet】的数据库操作Mapper
* @createDate 2025-05-06 19:32:40
* @Entity com.bdqn.petsys.entity.Pet
*/
// @Mapper
public interface PetMapper extends BaseMapper<Pet> {

    int deleteByPrimaryKey(Long id);
    //添加
    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

    //根据品种查询或者查询全部
    List<Pet> selectByBreedAndAll(Integer petbreed);

    //根据宠物昵称确认唯一性
    @Select("select * from pet where petname=#{petname}")
    Integer selectByName(String petname);


}
