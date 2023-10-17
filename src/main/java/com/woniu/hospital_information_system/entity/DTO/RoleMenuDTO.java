package com.woniu.hospital_information_system.entity.DTO;

import com.woniu.hospital_information_system.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuDTO {

    private Role role;
    private Integer[] menuIds;


}