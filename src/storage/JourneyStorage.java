package storage;

import model.Journey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JourneyStorage {
    private static JourneyStorage journeyStorageSingletonInstance = null;

    private final Map<String, Journey> journeyMap;
    private final Map<String, List<Journey>> userToJourneyMap;
    private final Map<String, List<String>> journeyToUsers;

    // Here we will be creating private constructor
    // restricted to this class itself
    private JourneyStorage()
    {
        this.journeyMap = new HashMap<String, Journey>();
        this.userToJourneyMap = new HashMap<String, List<Journey>>();
        this.journeyToUsers = new HashMap<String, List<String>>();
    }

    public static synchronized JourneyStorage getInstance()
    {
        if (journeyStorageSingletonInstance == null)
            journeyStorageSingletonInstance = new JourneyStorage();
        return journeyStorageSingletonInstance;
    }

    public void addJourney(Journey journey) {
        journeyMap.put(journey.getJourneyId(), journey);
    }

    public Journey getJourney(String journeyId) {
        return journeyMap.get(journeyId);
    }

    public void addUserToJourney(String userId, String journeyId) {
        //Adding Journey to a user index
        if(null != userToJourneyMap.get(userId)) {
            List<Journey> journeyList = userToJourneyMap.get(userId);
            journeyList.add(journeyMap.get(journeyId));
            userToJourneyMap.put(userId, journeyList);
        }else{
            userToJourneyMap.put(userId, Arrays.asList(journeyMap.get(journeyId)));
        }

        //Adding user ids to a journey id
        //reverse index
        if(null != journeyToUsers.get(journeyId)) {
            List<String> userList = journeyToUsers.get(journeyId);
            userList.add(userId);
            journeyToUsers.put(journeyId, userList);
        } else {
            journeyToUsers.put(journeyId,Arrays.asList(userId));
        }
    }

    public List<String> getUserAssociatedWithAJourney(String journeyId) {
        return journeyToUsers.get(journeyId);
    }

    public List<Journey> getAllJourneyForAUser(String userId) {
        return userToJourneyMap.get(userId);
    }
}
