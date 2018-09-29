package tn.esprit.PI.PI.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import tn.esprit.PI.PI.services.*;
import tn.esprit.PI.persistance.Challenge;

@ManagedBean
public class StatBean {

	@EJB
	NoteServiceEJBLocal ns; 
	@EJB
	ChallengeServiceEJBLocal cs;
	
	
private BarChartModel barModel;
	
	@PostConstruct
	public void init() {
		createBarModels();
	}
	public BarChartModel getBarModel() {
		return barModel;
	}
	
	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		ChartSeries stats = new ChartSeries();
		stats.setLabel("Number of Rates");
		List<Challenge> ltp = cs.listChallenge();
		for (Challenge s : ltp) {
			long number = ns.NbrParticipantChallenge(s);
		    stats.set(s.getName(), number);
		}
		model.addSeries(stats);
		return model;
		
	}
	private void createBarModels() {
		createBarModel();
	}
	private void createBarModel() {
		barModel = initBarModel();
		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");
		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Challenges");
		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("number of participants");
		yAxis.setMin(0);
		yAxis.setMax(15);
	}
	
}
