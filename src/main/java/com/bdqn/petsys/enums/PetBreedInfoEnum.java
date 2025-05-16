package com.bdqn.petsys.enums;

import java.util.HashMap;

public enum PetBreedInfoEnum {

    狗(1),猫(2),鸟(3),兔(4);

    private Integer value;

    static private final HashMap<Integer,String> hashMap = new HashMap<>();

    static {//类加载之后只执行一次
        for (PetBreedInfoEnum obj : PetBreedInfoEnum.values()){
                hashMap.put(obj.getValue(), obj.name());
        }

    }

    PetBreedInfoEnum(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }

    static public String getName(Integer value){
        return hashMap.getOrDefault(value,"");
    }

}
