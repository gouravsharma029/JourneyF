package controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import model.Journey;
import model.JourneyState;
import storage.JourneyStorage;

@RequiredArgsConstructor
@AllArgsConstructor
public class JourneyController {
    JourneyStorage journeyStorage = JourneyStorage.getInstance();

    public Journey validateAndcreateJourney(Journey journey) {
        //Validation goes here
        journeyStorage.addJourney(journey);
        return journeyStorage.getJourney(journey.getJourneyId());
    }

    public boolean updateJourneyState(String journeyId, JourneyState journeyState) {
        //Any validation related to state goes here.
        Journey journey = journeyStorage.getJourney(journeyId);
        journey.setJourneyState(journeyState);
        journeyStorage.addJourney(journey);
        return true;
    }

    public Journey getJourney(String journeyId) {
        return journeyStorage.getJourney(journeyId);
    }

}
