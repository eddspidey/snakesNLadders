package com.deserve.test.snakesnladders;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Jump {
    private Map<Integer, Integer> ladderMap;
}
