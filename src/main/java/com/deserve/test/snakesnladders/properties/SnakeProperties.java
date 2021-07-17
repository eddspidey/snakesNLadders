package com.deserve.test.snakesnladders.properties;

import java.util.Map;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SnakeProperties {

    @Value("${num-of-snakes}")
    private int numOfSnakes;

    @Value("#{${snake-positions}}")
    private Map<Integer, Integer> snakePositions;
}
