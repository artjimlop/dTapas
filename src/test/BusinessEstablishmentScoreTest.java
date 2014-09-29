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
import business.BusinessEstablishmentScore;
import dao.IEstablishmentScoreDAO;
import dao.JDBCEstablishmentScoreDAO;
import domain.EstablishmentScore;
import domain.IEstablishmentScore;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(JDBCEstablishmentScoreDAO.class)
public class BusinessEstablishmentScoreTest {
	
	private BusinessEstablishmentScore businessEstablishmentScore;
	private List<EstablishmentScore> establishmentScores;
	private IEstablishmentScoreDAO establishmentScoreDAO;
	private static Integer LIST_LENGTH = 5;
	/*
	@Test
	 public void testLegacyCode(){
		 IEstablishmentScoreDAO myClass = new JDBCEstablishmentScoreDAO();
		
		 // Le indicamos lo que debe devolver en este test en concreto
		 IEstablishmentScoreDAO mockLegacyCode = mock(JDBCEstablishmentScoreDAO.class);
		
		 //Instanciamos y comprobamos el mensaje devuelto
		 System.out.println(myClass.toString());
		 verify(mockLegacyCode, times(1)).getClass();
	 }
	*/
	@Before
	public void setUp(){
		establishmentScoreDAO = mock(JDBCEstablishmentScoreDAO.class);
		businessEstablishmentScore = mock(BusinessEstablishmentScore.class);
		EstablishmentScore mockScore;
		establishmentScores = new ArrayList<>();
		
		for(int i = 0; i<5;i++){
			//System.out.println("entra en bucle");
			mockScore = mock(EstablishmentScore.class);
			//System.out.println(mockScore.getEstablishmentScoreOID());
			establishmentScores.add(mockScore);
		}
		
		when(businessEstablishmentScore.getAllScores()).thenReturn(establishmentScores);
		//System.out.println(establishmentScores.size());
		//verify(businessEstablishmentScore,times(1)).getAllScores();
	}
	
	@Test
	public void getAllScores(){
		Integer sizeMethod = businessEstablishmentScore.getAllScores().size();
		Integer sizeList = establishmentScores.size();
		sizeMethod.equals(LIST_LENGTH);
		sizeList.equals(sizeMethod);
		//System.out.println(sizeMethod);
	}
	
	@Test
	public void getScoresByUser(){
		String userOID = null;
		Integer resultSize = businessEstablishmentScore.getScoresByUser(userOID).size();
		Integer resultMustBe = 5;
		resultSize.equals(resultMustBe);
		//System.out.println(resultSize);
	}
	
	//SIN MOCK:
	
	@Test
	public void insertEstablishmentScore(){
		
		Double mediumScore = new Double(5);
		Double qualityScore = new Double(5);
		Double serviceScore = new Double(5); 
		Double cleaningScore = new Double(5);
		Double sizeScore = new Double(5);
		Double locationScore = new Double(5);
		Double priceScore = new Double(5);
		String userOID = "17";
		String establishmentOID = "77";
		Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
		businessEstablishmentScore.insertEstablishmentScore(mediumScore, qualityScore, serviceScore, cleaningScore, sizeScore, locationScore, priceScore, date, userOID, establishmentOID);
		//Prueba para la lista del BO:
		EstablishmentScore score = new EstablishmentScore(mediumScore, qualityScore, serviceScore, cleaningScore, sizeScore, locationScore, priceScore, date, userOID, establishmentOID);
		
		System.out.println(establishmentScores.size());
		establishmentScores.add(score);
		System.out.println(establishmentScores.size());
		
		//COMPROBAMOS VALORES:
		Integer usersExpected = businessEstablishmentScore.getScoresByUser(userOID).size();
		Integer estOIDExpected = businessEstablishmentScore.getScoresByEstablishment(establishmentOID).size();
		Integer dateExpected = businessEstablishmentScore.getScoresByCreationDate(date).size();
		
		System.out.println("TAMAÑO: "+establishmentScores.size());
		
		System.out.println(businessEstablishmentScore.getAllScores().size());
		
		for(EstablishmentScore score2 : businessEstablishmentScore.getAllScores()){
			System.out.println("USER: "+score2.getUserOID());
			if(score2.getUserOID()==userOID){
				System.out.println("EXISTE EL userOID__"+score2.getUserOID());}
		
		}
			
		
		List<EstablishmentScore> list = new ArrayList<>();
		list = businessEstablishmentScore.getScoresByEstablishment(establishmentOID);
		
		for(EstablishmentScore score3: list){
			System.out.println("TARGET: "+score3.getEstablishmentOID());
		}
		
		usersExpected.equals(1);
		estOIDExpected.equals(1);
		dateExpected.equals(1);
		
		assertEquals(list.size(),1);
	}
	
}
