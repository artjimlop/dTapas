package test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import business.BusinessBeer;
import business.BusinessEstablishmentScore;
import dao.IBeerDAO;
import dao.IEstablishmentScoreDAO;
import dao.JDBCBeerDAO;
import dao.JDBCEstablishmentScoreDAO;
import domain.Beer;
import domain.EstablishmentScore;
import domain.IEstablishmentScore;
import static org.mockito.Mockito.when;
@RunWith(PowerMockRunner.class)
@PrepareForTest(JDBCBeerDAO.class)
public class BusinessBeerTest {

	private BusinessBeer businessBeer;
	
	private List<Beer> beers;
	private IBeerDAO beerDAO;
	
	@Before
	public void setUp(){
		beerDAO = mock(JDBCBeerDAO.class);
		businessBeer = mock(BusinessBeer.class);
		Beer mockBeer;
		beers = new ArrayList<>();
		
		for(int i = 0; i<5;i++){
			//System.out.println("entra en bucle");
			mockBeer = mock(Beer.class);
			//System.out.println(mockScore.getEstablishmentScoreOID());
			beers.add(mockBeer);
		}
		
		when(businessBeer.getAllBeers()).thenReturn(beers);
		//System.out.println(establishmentScores.size());
		//verify(businessEstablishmentScore,times(1)).getAllScores();
	}
	
	@Test
	public void insertWhole(){
		String productName = "name";
		Double price = new Double(5);
		String userCreatorOID = "7";
		String establishmentOID = "8";
		String productOID = "9";
		String size = "22";
		String label ="LEGEND";
		String color = "NIGGA";
		String temperature = "TEMP";
		String beerOID = "1488";
		System.out.println(businessBeer.getAllBeers().size());
		businessBeer.insertBeer(productName, price, userCreatorOID, establishmentOID, productOID, size, label, color, temperature);
		System.out.println(businessBeer.getAllBeers().size());
		Beer beer = new Beer(productName, price, userCreatorOID, establishmentOID, productOID, size, label, color, temperature, beerOID);
		beers.add(beer);
		System.out.println(beers.size());
		System.out.println(businessBeer.getAllBeers().size());
		
		System.out.println(businessBeer.getBeerByOID(beerOID).getBeerOID());
	}
}
