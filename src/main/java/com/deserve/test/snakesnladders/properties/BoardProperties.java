package com.deserve.test.snakesnladders.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BoardProperties {

    @Value("${board-size}")
    private int boardSize;
}
