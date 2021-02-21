package com.std.cation.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor
public class GroupPayload {

    @NotBlank(message = "Group name may not be blank")
    @Size(max = 200, message = "Max allowed length of group name is 200")
    private String groupName;

    @Min(value = 1990, message = "Start year should be greater than 1990")
    @Max(value = 2021, message = "End year should be less than 2021")
    private int startYear;

    @NotBlank(message = "Faculty may not be blank")
    private String faculty;
}
