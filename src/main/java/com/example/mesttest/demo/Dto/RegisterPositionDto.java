package com.example.mesttest.demo.Dto;

import com.example.mesttest.demo.Domain.defaultStructure.RegisterPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterPositionDto {

    private String position;
    @Builder
    public RegisterPositionDto(String position)
    {
        this.position=position;
    }

    public RegisterPosition toEntity()
    {
        return RegisterPosition.builder().position(position).build();
    }
}
