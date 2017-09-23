package CommTests;


import CommPageObjects.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by ehend on 2/25/2017.
 */
public class ModelFamilyAdditionAntennaDBTest extends BaseTest{
	
	private DataBasePage database;
	private BasePage basePage;




	@Before
	public void Setup() {
		
		database = new DataBasePage(driver);
		basePage = new BasePage(driver);


	}
	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);



	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/*
	 * LEGO-704 or COM-709: UI  Add Model Family addition workflow UI in Antenna Details
	 */
	@Test
	public void addModelFamily_AntennaDatabase_ModelFamilyNameValidation() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.openModelFamily();
		database.createNewAntennaModelFamily_validateSave(randomNumber, "The Model Family name you have entered already exists.");
		String existingFamilyRow1 =database.getAnExistingSaveModelFamily();
		database.validateExistingModelFamily(existingFamilyRow1, "The Model Family name you have entered already exists.");
	}


}

