package pt.angelopingo.hibernate.example.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pt.angelopingo.hibernate.example.dao.NetworkElementDetails;
import pt.angelopingo.hibernate.example.service.NetworkElementService;


public class NetworkElementServiceImp implements NetworkElementService {

    @Autowired
    private NetworkElementDetails networkElementDetails;

    @Transactional(readOnly = true)
    @Override
    public String getUsername(String id) {
        return networkElementDetails.getUsername(id).getUsername();
    }
}
