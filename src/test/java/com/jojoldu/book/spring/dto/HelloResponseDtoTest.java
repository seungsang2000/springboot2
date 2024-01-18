package com.jojoldu.book.spring.dto;

import com.jojoldu.book.spring.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void shouldReturnNameAndAmount(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
