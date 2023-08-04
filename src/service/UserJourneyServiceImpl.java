package service;

import controllers.UserJourneyController;
import model.JourneyStage;

public class UserJourneyServiceImpl implements UserJourneyService{
    UserJourneyController userJourneyController = new UserJourneyController();
    public JourneyStage getCurrentStage(String userId, String journeyId) {
        return userJourneyController.getCurrentStage(userId, journeyId);
    }
    public boolean isOnboarded(String userId, String journeyId) {
        return userJourneyController.isOnboarded(userId, journeyId);
    }

    public boolean associateUserAndJourney(String userId, String journeyId) {
        return userJourneyController.associateUserAndJourney(userId, journeyId);
    }
}
