package com.std.cation.payload;

import com.std.cation.model.enumeration.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
public class StudentPayload {

    @NotBlank(message = "Full name may not be blank")
    @Size(max = 200)
    private String fullName;

    @NotNull(message = "Date of birth may not be null")
    private LocalDateTime dateOfBirth;

    @NotNull(message = "Address may not be null")
    @Size(max = 200)
    private String address;

    @NotNull(message = "Gender may not be null. It is neither North America nor Europe.")
    private Gender gender;

    @NotNull(message = "Group id may not be null")
    private Long groupId;
}
