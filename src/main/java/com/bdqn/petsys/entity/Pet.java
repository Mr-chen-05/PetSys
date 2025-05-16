package com.bdqn.petsys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.bdqn.petsys.enums.PetBreedInfoEnum;
import com.bdqn.petsys.enums.PetSexInfoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName pet
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("pet")
public class Pet extends Model<Pet> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer petid;

    private String petname;

    private Integer petbreed;

    private Integer petsex;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    private String description;

    // 获取宠物的种类名称
    public String getPetBreedName() {
    	return PetBreedInfoEnum.getName(petbreed);
    }
    // 获取宠物的性别名称
    public String getPetSexName() {
    	return PetSexInfoEnum.getName(petsex);
    }
}