package tn.esprit.PI.persistance;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



/**
 * Entity implementation class for Entity: SimpleUser
 * 
 */
@Entity
@DiscriminatorValue(value = "simple")
public class SimpleUser extends User implements Serializable
{

	private static final long serialVersionUID = 1L;


	public SimpleUser()
	{
		super();
	}

	@Override
	public String getType()
	{
		return "Simple";
	}

}
