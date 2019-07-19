package com.example.trial.entity;


import com.example.trial.models.RestaurantDetailsForUserModel;
import com.example.trial.models.RestaurantModel;

import javax.persistence.*;

@SqlResultSetMapping(name = "restaurantInfo",
        classes = {
                @ConstructorResult(
                        targetClass = RestaurantDetailsForUserModel.class,
                        columns = {
                                @ColumnResult(name = "uid", type = String.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "location", type = String.class),
                                @ColumnResult(name = "owner", type = String.class),
                                @ColumnResult(name = "logo", type = String.class)
                        })
        })
@NamedNativeQuery(name = "RestaurantEntity.findRestaurantDetails",
        query = "select  rd.restaurant_uid as uid, rd.restaurant_name as name, "
                + " rd.restaurant_location as location, "
                + " o.name as owner, rd.restaurant_logo as logo "
                + " FROM restaurant_details rd,owner_details o"
                + " where rd.owner_uid = o.owner_uid and rd.status = 1 and o.status = 1",
        resultSetMapping = "restaurantInfo")
@Entity
@Table(name = "restaurant_details")
public class RestaurantEntity extends RestaurantModel {
}
