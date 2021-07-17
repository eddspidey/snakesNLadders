package com.deserve.test.snakesnladders.properties;

import java.util.Map;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class LadderProperties {
    @Value("${num-of-ladders}")
    private int numOfLadders;

    @Value("#{${ladder-positions}}")
    private Map<Integer, Integer> ladderPositions;
}
