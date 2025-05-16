package com.bdqn.petsys;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bdqn.petsys.entity.Pet;
import com.bdqn.petsys.mapper.PetMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TestPet {

    @Autowired
    private PetMapper petMapper;

    @Test
     void testPet(){
        System.out.println(petMapper.selectByPrimaryKey(1L));
    }
    @Test
    void TestAdd(){
        // Pet pet = new Pet();
        // pet.setPetname("小花");
        // pet.setPetbreed(1);
        // pet.setPetsex(1);
        // pet.setBirthday(LocalDateTime.now());
        // pet.setDescription("小花");

        Pet builder = Pet.builder().petname("红兔").petbreed(4).petsex(2).birthday(LocalDateTime.now()).description("兔子").build();
        int insert = petMapper.insert(builder);
        System.out.println(insert);
    }
    @Test
    void TestInsertSelective(){
        Pet builder = Pet.builder().petname("狸花猫").petbreed(2).petsex(1).birthday(LocalDateTime.now()).description("").build();
        int insertSelective = petMapper.insertSelective(builder);
        System.out.println(builder.getPetid());
    }

    @Test
    void selectByBreedAndAll(){
        List<Pet> petList = petMapper.selectByBreedAndAll(null);
        petList.forEach(System.out::println);
    }
    @Test
    void selectByQueryWrapper(){
        Pet pet = new Pet();
        // 查询猫（petBreed=2）且生日在2020年之后的宠物
        LambdaQueryWrapper<Pet> lambdaWrapper = new LambdaQueryWrapper<>();
        lambdaWrapper.eq(Pet::getPetbreed, 2)  // 品种=猫
                .ge(Pet::getBirthday, LocalDateTime.of(2020, 1, 1, 0, 0)) // 生日≥2020-01-01
                .orderByDesc(Pet::getBirthday); // 按生日倒序

        List<Pet> cats = pet.selectList(lambdaWrapper);
        cats.forEach(System.out::println);
    }
    /**
     * git测试
     */


}
