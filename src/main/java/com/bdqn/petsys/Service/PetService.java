package com.bdqn.petsys.Service;

import com.bdqn.petsys.entity.Pet;
import com.bdqn.petsys.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetMapper petMapper;

    //查询全部和根据品种查询
    public List<Pet> selectAllAndBreed(Integer petbreed) {
        return petMapper.selectByBreedAndAll(petbreed);
    }
    //添加宠物
    public Integer insertSelective(Pet pet){
        Integer count = petMapper.selectByName(pet.getPetname());
        if(count>0){
            return -1;
        }else {
            petMapper.insertSelective(pet);
            return pet.getPetid();
        }
    }
    //根据宠物昵称确认唯一性
    public Integer selectByName(String petname) {
        return petMapper.selectByName(petname);
    }

    public Integer deleteById(Integer petid) {
        return petMapper.deleteById(petid);
    }
}
