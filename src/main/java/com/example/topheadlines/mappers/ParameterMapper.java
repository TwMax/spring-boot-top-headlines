package com.example.topheadlines.mappers;

import com.example.topheadlines.dto.ParameterDTO;
import com.example.topheadlines.model.Parameter;

import java.util.ArrayList;

public class ParameterMapper {

    private static ParameterDTO map(Parameter parameter){
        ParameterDTO parameterDTO = new ParameterDTO();
        parameterDTO.setCategory(parameter.getCategory());
        parameterDTO.setCountry(parameter.getCountry());
        return parameterDTO;
    }

    public static ArrayList<ParameterDTO> map(ArrayList<Parameter> parameters){
        ArrayList<ParameterDTO> parametersDTO = new ArrayList<>();
        for(Parameter parameter : parameters){
            parametersDTO.add(map(parameter));
        }
        return parametersDTO;
    }
}
