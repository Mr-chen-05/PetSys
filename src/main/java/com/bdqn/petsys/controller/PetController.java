package com.bdqn.petsys.controller;

import com.bdqn.petsys.Service.PetService;
import com.bdqn.petsys.entity.Pet;
import com.bdqn.petsys.util.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    // 查询所有
    // 根据品种查询
    @GetMapping("/findAllAndByBreed")
    @ResponseBody
    public AjaxResult findAllAndByBreed(@RequestParam(required = false) String petbreed) {
        List<Pet> petList;
        if (StringUtils.isBlank(petbreed)){
            petList = petService.selectAllAndBreed(null);
        }else {
            petList = petService.selectAllAndBreed(Integer.parseInt(petbreed));
        }

        if (!CollectionUtils.isEmpty(petList)) {
            return AjaxResult.success("查询成功！", petList);
        }else {
            return AjaxResult.error("查询失败");
        }
    }

    @GetMapping("/{petname}")
    @ResponseBody
    public AjaxResult findByName(@PathVariable("petname") String petname) {
        Integer count = petService.selectByName(petname);
        if (count != null) {
            return AjaxResult.success("昵称已存在", count);
        } else {
            return AjaxResult.error("昵称不存在");
        }
    }

    @PostMapping("/addPet")
    @ResponseBody
    public AjaxResult addPet(@ModelAttribute Pet pet) {
        Integer count = petService.insertSelective(pet);
        if (count == null) {
            return AjaxResult.error("添加失败");
        }
        if (count != -1){
            return AjaxResult.success("添加成功!", count);
        }else {
            return AjaxResult.error("昵称已存在!");
        }
    }

    // 方法二
    // @PostMapping("/addPet")
    // @ResponseBody
    // public AjaxResult addPet(@RequestParam String petname,@RequestParam Integer petbreed,@RequestParam Integer petsex,@RequestParam String birthday, String description) {
    //    //   // 如果需要LocalDateTime，可以转换为当天的开始时间
    //     //     LocalDateTime birthDateTime = birthDate.atStartOfDay();
    //    Pet pet =  Pet.builder().petname(petname).petbreed(petbreed).petsex(petsex).birthday(LocalDate.parse(birthday).atStartOfDay()).description(description).build();
    //     Integer count = petService.insertSelective(pet);
    //     if (count != null) {
    //         return AjaxResult.success("添加成功!", count);
    //     } else {
    //         return AjaxResult.error("添加失败");
    //     }
    // }

    @DeleteMapping("/{petid}")
    @ResponseBody
    public AjaxResult deletePet(@PathVariable Integer petid) {
        Integer count = petService.deleteById(petid);
        if (count != null) {
            return AjaxResult.success("删除成功!", count);
        } else {
            return AjaxResult.error("删除失败");
        }
    }




}
