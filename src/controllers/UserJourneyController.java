package controllers;

import model.Journey;
import model.JourneyStage;
import storage.JourneyStorage;

import java.util.List;

public class UserJourneyController {
    JourneyStorage journeyStorage = JourneyStorage.getInstance();

    public JourneyStage getCurrentStage(String userId, String journeyId) {
        List<Journey> journeyList = journeyStorage.getAllJourneyForAUser(userId);
        Journey journey = journeyStorage.getJourney(journeyId);
        if(journeyList.contains(journey)) {
            return journey.getActiveStage();
        }
        return null;
    }

    public boolean isOnboarded(String userId, String journeyId) {
        List<String> userIds = journeyStorage.getUserAssociatedWithAJourney(journeyId);
        return userIds.contains(userId);
    }

    public boolean associateUserAndJourney(String userId, String journeyId) {
        journeyStorage.addUserToJourney(userId, journeyId);
        return true;
    }
}
