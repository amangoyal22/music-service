package com.example.trial.mapper;

import com.example.trial.bos.RestaurantBo;
import com.example.trial.bos.UserBo;
import com.example.trial.dtos.request.OwnerLoginRequestDto;
import com.example.trial.dtos.request.UserSignInRequestDto;
import com.example.trial.dtos.request.UserSignUpRequestDto;
import org.mapstruct.Mapper;

/**
 * The interface Dto to bo mapper.
 */
@Mapper(componentModel = "spring")
public interface DtoToBoMapper {

    /**
     * Gets user dto to bo.
     *
     * @param userSignUpRequestDto the user sign up dto
     * @return the user dto to bo
     */
    UserBo getUserSignUpDtoToBo(UserSignUpRequestDto userSignUpRequestDto);

    /**
     * Gets user sign in dto to bo.
     *
     * @param userSignInRequestDto the user sign in request dto
     * @return the user sign in dto to bo
     */
    UserBo getUserSignInDtoToBo(UserSignInRequestDto userSignInRequestDto);

}
