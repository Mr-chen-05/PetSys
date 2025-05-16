package com.bdqn.petsys.controller;

import com.bdqn.petsys.enums.PetBreedInfoEnum;
import com.bdqn.petsys.enums.PetSexInfoEnum;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class PetSysBreedAndSexController {
    public List<HashMap<String, Object>> getPetBreedInfoList() {
        List<HashMap<String, Object>> petBreedInfoList = new ArrayList<>();
        for (PetBreedInfoEnum petBreedInfoEnum : PetBreedInfoEnum.values()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("value", petBreedInfoEnum.getValue());
            map.put("name", petBreedInfoEnum.name());
            petBreedInfoList.add(map);
        }
        return petBreedInfoList;
    }
    @GetMapping("/BreedInfo")
    public String PetSysBreedInfo(HttpSession session) {
        session.setAttribute("petBreedInfoList", getPetBreedInfoList());
        return "index";
    }
    @GetMapping("/BreedAndSexInfo")
    public String PetSysSexInfo(HttpSession session){
        List<HashMap<String, Object>> petSexInfoList = new ArrayList<>();
        for (PetSexInfoEnum petSexInfoEnum : PetSexInfoEnum.values()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("value", petSexInfoEnum.getValue());
            map.put("name", petSexInfoEnum.name());
            petSexInfoList.add(map);
        }
        session.setAttribute("petSexInfoList", petSexInfoList);
        session.setAttribute("petBreedInfoList", getPetBreedInfoList());
        return "updatePage";
    }

}
