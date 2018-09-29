package tn.esprit.PI.persistance;


import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



/**
 * Entity implementation class for Entity: Administrator
 */
@Entity
@DiscriminatorValue(value = "admin")
public class Administrator extends User implements Serializable
{

	private static final long serialVersionUID = 1L;


	public Administrator()
	{
		super();
	}

	@Override
	public String getType()
	{
		return "Admin";
	}

}
