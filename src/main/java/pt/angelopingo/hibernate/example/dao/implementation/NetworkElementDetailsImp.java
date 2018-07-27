package pt.angelopingo.hibernate.example.dao.implementation;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pt.angelopingo.hibernate.example.dao.NetworkElementDetails;
import pt.angelopingo.hibernate.example.model.NetworkElement;

@Repository
public class NetworkElementDetailsImp implements NetworkElementDetails {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public NetworkElement getUsername(String id) {
        return sessionFactory.getCurrentSession().get(NetworkElement.class, id);
    }
}
