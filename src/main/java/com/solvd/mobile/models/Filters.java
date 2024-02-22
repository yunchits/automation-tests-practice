package com.solvd.mobile.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Filters {
    CLASS("classBased"),
    WHITEBOARD("whiteboardBased"),
    FIFTEEN_MIN("fifteenMinutes"),
    THIRTY_MIN("thirtyMinutes"),
    FORTY_FIVE_MIN("fortyFiveMinutes"),
    NONE("none"),
    BASIC("basic"),
    FULL("full"),
    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced"),
    LOW("low"),
    MODERATE("moderate"),
    HIGH("high"),
    STRENGTH("strength"),
    ENDURANCE("endurance"),
    MOBILITY("mobility");

    private final String id;
}
