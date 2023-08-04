package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Journey {
    private String journeyId;
    private JourneyState journeyState = JourneyState.CREATD;
    private List<JourneyStage> journeyStageList;
    private JourneyStage activeStage;
}
