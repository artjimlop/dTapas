package business;

import java.util.List;

import domain.IActivity;
import domain.IRepresentationActivity;

public interface IBusinessActivity {

	List<IActivity> getAllActivitiesByUserLogin(String userLogin);

	IRepresentationActivity getRepresentationActivity(
			IActivity activity);

}