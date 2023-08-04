import model.Journey;
import model.JourneyStage;
import model.JourneyState;
import service.JourneyService;
import service.JourneyServiceImpl;
import service.UserJourneyService;
import service.UserJourneyServiceImpl;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        JourneyService journeyService = new JourneyServiceImpl();
        UserJourneyService userJourneyService = new UserJourneyServiceImpl();

        Journey journey = Journey.builder()
                .journeyId("temp2")
                .journeyState(JourneyState.CREATD)
                .activeStage(JourneyStage.builder().stageName("FIRST").build())
                .journeyStageList(Arrays.asList(JourneyStage.builder().stageName("First").build())).build();

        System.out.println("1 " + journeyService.createJourney(journey));
        System.out.println("2 " + journeyService.updateState(journey.getJourneyId(), JourneyState.EXPIRED));

        System.out.println("3 " + userJourneyService.associateUserAndJourney("1", journey.getJourneyId()));
        System.out.println("4 " + userJourneyService.isOnboarded("1", journey.getJourneyId()));
        System.out.println("5 " + userJourneyService.getCurrentStage("1", journey.getJourneyId()));

    }
}