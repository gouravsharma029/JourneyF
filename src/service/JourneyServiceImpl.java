package service;

import controllers.JourneyController;
import model.Journey;
import model.JourneyState;

public class JourneyServiceImpl implements JourneyService{

    JourneyController journeyController = new JourneyController();
    public Journey createJourney(Journey journey) {
        return journeyController.validateAndcreateJourney(journey);
    }
    public boolean updateState(String journeyId, JourneyState journeyState) {
        return journeyController.updateJourneyState(journeyId, journeyState);
    }

    public Journey getJourney(String journeyId) {
        return journeyController.getJourney(journeyId);
    }
}
