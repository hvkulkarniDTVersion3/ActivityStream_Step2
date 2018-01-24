package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

/*
 * This class is implementing the MessageDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */

@Repository
public class MessageDAOImpl implements MessageDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory. 
	 */
	@Autowired
	SessionFactory SessionFactory;
	/*
	 * retrieve all existing messages sorted by posted Date in descending order(showing latest
	 * message first)
	 */
	@Override
	@Transactional
	public List<Message> getMessages() {
		try{
			Session session=SessionFactory.getCurrentSession();
			Query query=session.createQuery("from Message order by postedDate desc");
			List <Message> messageList=(List <Message>)query.getResultList();
			return messageList;
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				return null;
			}

	}


	/*
	 * Save the message in the database in message table 
	 */
	@Override
	@Transactional
	public boolean sendMessage(Message message) {
		try{
			Session session=SessionFactory.getCurrentSession();
			session.save(message);
			return true;
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				return false;
			}
	}
	
	/*
	 * Remove the message from the database in message table 
	 */

	@Override
	public boolean removeMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}
}