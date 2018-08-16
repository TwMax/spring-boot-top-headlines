package com.example.topheadlines.mappers;

import com.example.topheadlines.dto.AllSourcesDTO;
import com.example.topheadlines.model.AllSources;

public class AllSourcesMapper {
    public static AllSourcesDTO map(AllSources allSources){
        AllSourcesDTO allSourcesDTO = new AllSourcesDTO();
        allSourcesDTO.setSources(ParameterMapper.map(allSources.getSources()));
        return allSourcesDTO;
    }
}
