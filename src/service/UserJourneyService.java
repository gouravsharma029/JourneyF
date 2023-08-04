package service;

import model.JourneyStage;

public interface UserJourneyService {
    public JourneyStage getCurrentStage(String userId, String journeyId);
    public boolean isOnboarded(String userId, String journeyId);

    public boolean associateUserAndJourney(String userId, String journeyId);
}
