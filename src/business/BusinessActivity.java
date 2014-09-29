package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.CompareActivityDate;
import domain.IActivity;
import domain.IComment;
import domain.IEstablishment;
import domain.IEstablishmentComment;
import domain.IEstablishmentScore;
import domain.IProduct;
import domain.IProductComment;
import domain.IProductScore;
import domain.IRepresentationActivity;
import domain.ITapaRoute;
import domain.ITapaRouteComment;
import domain.IUser;
import domain.IUserComment;
import domain.RepresentationActivity;


/**
 * 
 * @author David Alanis
 *
 */


public class BusinessActivity implements IBusinessActivity {
	
	private IBusinessProductComment businessProductComment;
	private IBusinessEstablishmentComment businessEstablishmentComment;
	private IBusinessUserComment businessUserComment;
	private IBusinessProductScore businessProductScore;
	private IBusinessEstablishmentScore businessEstablishmentScore;
	private IBusinessFollower businessFollower;
	private IBusinessProduct businessProduct; 
	private IBusinessEstablishment businessEstablishment;
	private IBusinessTapaRoute businessTapaRoute;
	
	
	public BusinessActivity(){
		
		this.businessEstablishmentComment = new BusinessEstablishmentComment();
		this.businessProductComment = new BusinessProductComment();
		this.businessUserComment = new BusinessUserComment();
		this.businessProductScore = new BusinessProductScore();
		this.businessEstablishmentScore = new BusinessEstablishmentScore();
		this.businessFollower= new BusinessFollower();
		this.businessProduct = new BusinessProduct();
		this.businessEstablishment = new BusinessEstablishment();
		this.businessTapaRoute = new BusinessTapaRoute();
	}
	
	/* (non-Javadoc)
	 * @see business.IBusinessActivity#getAllActivitiesByUserLogin(java.lang.String)
	 */
	@Override
	public List<IActivity> getAllActivitiesByUserLogin(String userLogin){
		
		List<IActivity> activities = new ArrayList<>();
		Set<IComment> myComments = new HashSet<>();
		
		//Cargamos mis comentarios --> UserComment EstablishmentComment & ProductComment
		List<IUserComment> myUserComments = new ArrayList<>();
		myUserComments = this.businessUserComment.getAllUserCommentsFromUserLogin(userLogin);
		myComments.addAll(myUserComments);
		
		List<IUserComment> destinationUserCommentI = new ArrayList<>();
		destinationUserCommentI = this.businessUserComment.getAllUserCommentsOverUserLogin(userLogin);
		myComments.addAll(destinationUserCommentI);
		
		List<IEstablishmentComment> myEstablishmentComments = new ArrayList<>();
		myEstablishmentComments = this.businessEstablishmentComment.getAllEstablishmentCommentByLogin(userLogin);
		myComments.addAll(myEstablishmentComments);
		
		List<IProductComment> myProductComments= new ArrayList<>();
		myProductComments = this.businessProductComment.getAllProductCommentsByLogin(userLogin);
		myComments.addAll(myProductComments);
		
		activities.addAll(myComments);
		//-------------------------------------------------------------------
		
		//Cargamos mis ProductScore y EstablishmentScore
		List<IProductScore> myProductsScore = new ArrayList<>();
		myProductsScore = this.businessProductScore.getScoresByUser(userLogin);
		
		List<IEstablishmentScore> myEstablishmentsScore = new ArrayList<>();
		myEstablishmentsScore = this.businessEstablishmentScore.getScoresByUser(userLogin);
		
		activities.addAll(myEstablishmentsScore);
		activities.addAll(myProductsScore);
		
		//-------------------------------------------------------------------
		
		List<IUser> users = this.businessFollower.getMyFollowed(userLogin);
		
		
		
		
		//Cargamos todo sobre las personas a las que sigues
		for(IUser user : users){
			List<IComment> comments = new ArrayList<>();
			List<IUserComment> userComments = new ArrayList<>();
			List<IEstablishmentComment> establishmentComments = new ArrayList<>();
			List<IProductComment> productComments = new ArrayList<>();
			List<IProductScore> productsScore = new ArrayList<>();
			List<IEstablishmentScore> establishmentsScore = new ArrayList<>();
			
			userComments = this.businessUserComment.getAllUserCommentsFromUserLogin(user.getLogin());
			userComments.removeAll(destinationUserCommentI);
			comments.addAll(userComments);
			
			productComments = this.businessProductComment.getAllProductCommentsByLogin(user.getLogin());
			comments.addAll(productComments);
			
			establishmentComments = this.businessEstablishmentComment.getAllEstablishmentCommentByLogin(user.getLogin());
			comments.addAll(establishmentComments);
			
			establishmentsScore = this.businessEstablishmentScore.getScoresByUser(user.getLogin());
			productsScore = this.businessProductScore.getScoresByUser(user.getLogin());
			
			activities.addAll(establishmentsScore);
			activities.addAll(productsScore);
			activities.addAll(comments);
		}
		
		Comparator<IActivity> comparator = new CompareActivityDate();
		Collections.sort(activities, comparator);
		Collections.reverse(activities);
		
		return activities;
		
	}
	
	
	//Este sera el metodo que usaremos para pasar la inforamcion a representar en la capa de presentacion
	
	/* (non-Javadoc)
	 * @see business.IBusinessActivity#getRepresentationActivity(domain.IActivity)
	 */
	@Override
	public IRepresentationActivity getRepresentationActivity(IActivity activity){
		
		IRepresentationActivity representationActivity = null;
		
		if(activity instanceof IUserComment){
			representationActivity = new RepresentationActivity((IUserComment)activity);
		}
		else if(activity instanceof IProductComment){
			
			IProduct product = this.businessProduct.getProductByID(((IProductComment)activity).getProductID());
			representationActivity = new RepresentationActivity((IProductComment)activity, product.getProductName());
		}
		else if(activity instanceof IEstablishmentComment){
			
			IEstablishment establishment = this.businessEstablishment.getEstablishmentByID(((IEstablishmentComment)activity).getEstablishmentID());
			representationActivity = new RepresentationActivity((IEstablishmentComment)activity, establishment.getNameEstablishment());
		}
		else if(activity instanceof ITapaRouteComment){
			
			ITapaRoute tapaRoute = this.businessTapaRoute.getTapaRouteByID(((ITapaRouteComment)activity).getTapaRouteID());
			representationActivity = new RepresentationActivity((ITapaRouteComment)activity, tapaRoute.getName());
		}
		else if(activity instanceof IProductScore){
			
			IProduct product = this.businessProduct.getProductByID(((IProductScore)activity).getProductID());
			representationActivity = new RepresentationActivity((IProductScore)activity, product.getProductName());
		}
		else if(activity instanceof IEstablishmentScore){
			
			IEstablishment establishment = this.businessEstablishment.getEstablishmentByID(((IEstablishmentScore)activity).getEstablishmentID());
			representationActivity = new RepresentationActivity((IEstablishmentScore)activity, establishment.getNameEstablishment());
		}
		
		return representationActivity;
	}
	
	
}
	
