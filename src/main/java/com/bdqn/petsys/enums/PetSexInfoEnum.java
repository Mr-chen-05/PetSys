package com.bdqn.petsys.enums;

import java.util.HashMap;

public enum PetSexInfoEnum {

    雄(1),雌(2);

    private Integer value;

    static private final HashMap<Integer,String> hashMap = new HashMap<>();

    static {//类加载之后只执行一次
        for (PetSexInfoEnum obj : PetSexInfoEnum.values()){
                hashMap.put(obj.getValue(), obj.name());
        }

    }

    PetSexInfoEnum(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }

    static public String getName(Integer value){
        return hashMap.getOrDefault(value,"");
    }

}
