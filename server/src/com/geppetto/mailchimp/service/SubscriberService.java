package com.geppetto.mailchimp.service;

import java.util.ArrayList;
import java.util.List;

import com.geppetto.mailchimp.dto.Subscriber;

/**
 * @author Suresh Palanisamy<br>
 *         <p>
 *         Date Created: 28-July-2015
 *         </p>
 *
 */

public interface SubscriberService {

	public ArrayList<Subscriber> findAllSubscribers() throws Exception;

	public Subscriber findSubscriber(long subscriberSno) throws Exception;

	public List<Subscriber> createSubscribers(List<Subscriber> subscribers) throws Exception;

	public Subscriber updateSubscriber(Subscriber subscriber) throws Exception;

	public boolean deleteSubscriber(long subscriberSno) throws Exception;
}