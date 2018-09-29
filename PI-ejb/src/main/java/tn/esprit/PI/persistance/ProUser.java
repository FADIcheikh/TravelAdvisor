package tn.esprit.PI.persistance;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



/**
 * Entity implementation class for Entity: ProUser
 */
@Entity
@DiscriminatorValue(value = "pro")
public class ProUser extends User implements Serializable
{

	private static final long serialVersionUID = 1L;


	public ProUser()
	{
		super();
	}

	@Override
	public String getType()
	{
		return "Pro";
	}

}
