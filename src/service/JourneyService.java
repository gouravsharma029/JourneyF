package service;

import model.Journey;
import model.JourneyState;

public interface JourneyService {
    public Journey createJourney(Journey journey);
    public boolean updateState(String journeyId, JourneyState journeyState);

    public Journey getJourney(String journeyId);
}
