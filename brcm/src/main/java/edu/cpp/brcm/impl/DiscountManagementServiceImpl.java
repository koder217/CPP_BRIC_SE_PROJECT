package edu.cpp.brcm.impl;

import edu.cpp.brcm.common.Mapper;
import edu.cpp.brcm.dtos.DiscountschemeDto;
import edu.cpp.brcm.entities.Discountscheme;
import edu.cpp.brcm.repositories.DiscountSchemeRepository;
import edu.cpp.brcm.services.DiscountManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

public class DiscountManagementServiceImpl implements DiscountManagementService {
    @Autowired
    private DiscountSchemeRepository discountSchemeRepository;

    @Override
    public DiscountschemeDto createDiscountScheme(DiscountschemeDto discountschemeDto) {
        Discountscheme d = Mapper.toEntity(discountschemeDto);
        d = discountSchemeRepository.save(d);
        return Mapper.toDTO(d);
    }

    @Override
    public List<DiscountschemeDto> getAllDiscountSchemes() {
        return discountSchemeRepository.findAll().stream().map(Mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteDiscountScheme(int id) {
        discountSchemeRepository.deleteById(id);
    }

    @Override
    public void updateDiscountScheme(DiscountschemeDto discountschemeDto) {
        Discountscheme d = discountSchemeRepository.findById(discountschemeDto.getId()).orElseThrow(()->new ResourceAccessException("No discount scheme found for id:"+discountschemeDto.getId()));
        d.setPricediscount(discountschemeDto.getPricediscount());
        d.setPercentdiscount(discountschemeDto.getPercentdiscount());
        d.setStartdate(discountschemeDto.getStartdate());
        d.setEnddate(discountschemeDto.getEnddate());
        d.setCustomertype(discountschemeDto.getCustomertype());
        discountSchemeRepository.save(d);
    }
}
