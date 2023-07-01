package com.amigoscode.bbexample.external.storage.provider;

import com.amigoscode.bbexample.domain.provider.Provider;
import com.amigoscode.bbexample.domain.user.User;
import com.amigoscode.bbexample.external.storage.user.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProviderEntityMapper {

    ProviderEntity toEntity(Provider domain);

    Provider toDomain(ProviderEntity entity);

}
