package com.amigoscode.bbexample.api.provider;

import com.amigoscode.bbexample.domain.provider.PageProvider;
import com.amigoscode.bbexample.domain.provider.Provider;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PageProviderDtoMapper {

    @Mapping(target = "providers", qualifiedByName = "toProviderDtoList")
    PageProviderDto toPageDto(PageProvider domain);

    @Named("toProviderDtoList")
    @IterableMapping(qualifiedByName = "providerToProviderDto")
    List<ProviderDto> toListDto(List<Provider> providers);

    @Named("providerToProviderDto")
    ProviderDto toDto(Provider domain);
}