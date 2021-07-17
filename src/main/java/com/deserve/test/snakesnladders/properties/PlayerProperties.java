package com.deserve.test.snakesnladders.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PlayerProperties {

    @Value("${player-chance}")
    private int playerChances;

    @Value("${num-of-player}")
    private int numOfPlayer;
}
