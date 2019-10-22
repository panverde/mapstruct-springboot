package com.joaquin.mapper;

import com.joaquin.dto.FlattenUserDTO;
import com.joaquin.dto.UserDTO;
import com.joaquin.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    List<UserDTO> mapToUsers(List<UserEntity> userEntityList);

    @Mappings({
            @Mapping(target = "location",source = "address.location")
    })
    FlattenUserDTO mapToFlattenUser(UserEntity userEntity);

}
