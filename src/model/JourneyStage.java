package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class JourneyStage {

    @NonNull
    private String stageName;
}
