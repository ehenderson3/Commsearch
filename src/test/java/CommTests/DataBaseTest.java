package CommTests;


import CommPageObjects.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Created by ehend on 2/25/2017.
 */
public class DataBaseTest extends BaseTest{
    private PathDetailAntennaPage pathDetailAnt;
    private QuickAddPage quickAdd;
    private PathSummaryPage pathSummary;
    private CreateNewPathPage createPath;
    private PathDetailPage pathDetail;
    private RadioPage pathDetailRadio;
    private DataBasePage database;


    @Before
    public void Setup() {
        pathDetailAnt = new PathDetailAntennaPage(driver);
        quickAdd = new QuickAddPage(driver);
        pathSummary = new PathSummaryPage(driver);
        createPath = new CreateNewPathPage(driver);
        pathDetail = new PathDetailPage(driver);
        pathDetailRadio = new RadioPage(driver);
        database = new DataBasePage(driver);

    }
        Random rndNum = new Random();
        int randomNumber = rndNum.nextInt(100000);



    @Rule
    public RetryTest.Retry retry = new RetryTest.Retry(1);

    /**
     COM-589
     (UI AUTO) Create routes to connect home page with Antenna DB Management View. COM-527
     Open the Lego project
     Click "Database Management"
     Click "Antenna Database"


     */
    @Test
    public void antDataBase_theAntennaDatabasePageShouldOpen_whenNavigatingToAntDataBase() {
        database.accessAntennaDataBase();
    }

    /**
     COM-657
     Manufacturer search Enter a manufacturer name in the
     "Manufacturer" search field
     1. Click "Search"
     2. All of the antennas from that manufacturer are
     displayed. None of the displayed antennas are from
     other manufacturers.
     */
    @Test
    public void antDataBase_AllAntennasFromThatCompanyAreDisplayed_whenInputValidCompanyNameAndSearch () {
        database.accessAntennaDataBase();
        database.antennaDataBaseSearch("","Commscope","","","");
        database.antennaDataSearchResult1(0,"02306A","Commscope","Commscope Family","P8F-9 LF","","880 - 950");
        database.antennaDataSearchResult2(0,"20.3","3.2","2.44 / 8.01","n/a","n/a","n/a");
        database.companyRowVal("Commscope");
    }


    /**COM-657
     * Model Family search Continuing:
     Make note of the model families of the
     displayed antennas.
     Pick one, preferably one that has its first three characters in
     common with another model family.

     Clear the "Manufacturer" field
     Enter the model family you picked.
     Click "Search"

     A list of model families with those first three digits is
     displayed.

     All of the antennas from that model family are
     displayed. None of the displayed antennas are from
     other model families.
     */
    @Test
    public void antDataBase_AllAntennasFromThatCompanyFamilyAreDisplayed_whenInputValidCompanyFamilyAndSearch1 () {
        database.accessAntennaDataBase();
        database.antennaDataBaseSearch("","","Com","","");
        database.antennaDataSearchResult1(0,"02306A","Commscope","Commscope Family","P8F-9 LF","","880 - 950");
        database.antennaDataSearchResult2(0,"20.3","3.2","2.44 / 8.01","n/a","n/a","n/a");
        database.companyFamilyRowVal("Commscope Family");
    }

    @Test
    public void antDataBase_AllAntennasFromThatCompanyFamilyAreDisplayed_whenInputValidCompanyFamilyAndSearch2 () {
        database.accessAntennaDataBase();
        database.antennaDataBaseSearch("","","Val","","");
        database.antennaDataSearchResult1(0,"77100A","Commscope","ValuLine High Performance Low Profile","VHLPX2-11 LF","","10500 - 11700");
        database.antennaDataSearchResult2(0,"34.4","3.4","0.61 / 2.00","n/a","n/a","n/a");
        database.companyFamilyRowVal("ValuLine High Performance Low Profile");
    }

    /**COM-657
     * Model search with
     left and right feed.
     Continuing:
     Make note of the model names of the
     displayed antennas. Pick one that has
     left and right feeds.
     Clear all search fields.
     Enter the model name
     Click "Search"
     Select "Left Feed" and search again
     Select "Right Feed" and search again
     4. All versions of that model (left and right feed) appear
     in the search results.
     5. Only the left feed version of that antenna is
     returned.
     6. Only the right feed version of that antenna is
     returned.
     */

    @Test
    public void antDataBase_AllAntModelOfTypeAreDisplayed_whenInputValidAntModelAnyAndSearch () {
        database.accessAntennaDataBase();
        database.antennaDataBaseSearch("","","","P8F","");
        database.antennaDataSearchResult1(0,"02306A","Commscope","Commscope Family","P8F-9 LF","","880 - 950");
        database.antennaDataSearchResult2(0,"20.3","3.2","2.44 / 8.01","n/a","n/a","n/a");
        database.companyFamilyRowVal("Commscope Family");
    }

    @Test
    public void antDataBase_AllAntModelOfTypeAreDisplayed_whenInputValidAntModelLFAndSearch () {
        database.accessAntennaDataBase();
        database.antennaDataBaseSearch("","","","P8F","");
        database.selectLF();
        database.antennaDataSearchResult1(0,"02306A","Commscope","Commscope Family","P8F-9 LF","","880 - 950");
        database.antennaDataSearchResult2(0,"20.3","3.2","2.44 / 8.01","n/a","n/a","n/a");
        database.companyFamilyRowVal("Commscope Family");
    }

    /**COM-657
     * Frequency search Continuing:
     Make note of the frequency range of the
     antenna you searched for.
     Clear all search fields.
     Enter the manufacturer name (in order
     to limit results) in the Manufacturer field
     Enter a frequency in the middle of the
     frequency range
     Click "Search"
     Enter a frequency at the high bound of
     the frequency range, and click "Search"
     Enter a frequency at the low bound of
     the frequency range, and click "Search"
     5. The selected radio (along with others from the same
     manufacturer) appears in the search results. None of
     the returned radios cover a range that does not include
     that frequency.
     6. The selected radio (along with others from the same
     manufacturer) appears in the search results. None of
     the returned radios cover a range that does not include
     that frequency.
     7. The selected radio (along with others from the same
     manufacturer) appears in the search results. None of
     the returned radios
     */

    @Test
    public void antDataBase_AllAntsWithGivenFrequencyAreDisplayed_whenInputValidLowFrequencyAndSearch () {
        database.accessAntennaDataBase();
        database.antennaDataBaseSearch("","Commscope","","","950");
        database.selectLF();
        database.antennaDataSearchResult1(0,"02306A","Commscope","Commscope Family","P8F-9 LF","","880 - 950");
        database.antennaDataSearchResult2(0,"20.3","3.2","2.44 / 8.01","n/a","n/a","n/a");
        database.companyFamilyRowVal("Commscope Family");
    }

    @Test
    public void antDataBase_AllAntsWithGivenFrequencyAreDisplayed_whenInputValidHighFrequencyAndSearch () {
        database.accessAntennaDataBase();
        database.antennaDataBaseSearch("","Commscope","","","880");
        database.selectLF();
        database.antennaDataSearchResult1(0,"02306A","Commscope","Commscope Family","P8F-9 LF","","880 - 950");
        database.antennaDataSearchResult2(0,"20.3","3.2","2.44 / 8.01","n/a","n/a","n/a");
        database.companyFreqRowVal(880,950);
    }

    /**COM-657
     * Advanced Search
     * 1. Click "Advanced Search"
     * 2. The search bar expands to display the following
     additional fields:
     Status
     Gain (dBi)
     Application
     Diameter
     RPE
     Classification
     3dB BW
     FCC Compliance
     */

    @Test
    public void antDataBaseAdvancedSearch_NewAdvancedSearchFieldsWillDisplay_whenAdvancedSearchIsSelected () {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("Active","","Point-to-Point","","","All","","Compliant (no category)");

    }

    /**COM-657
     * Search by Status Run a search that will have a wide
     variety of results. A company with a
     large number of entries in the DB
     (Comsearch) or a commonly used
     frequency should give good results.
     Make a general note of the "Status"
     fields of the available antennas. Sorting
     by Status might help (Ideally, all three
     statuses will be represented.)
     Select "Active" status and search
     Select "Obsolete" status and search
     Select "Invalid" status and search
     3. All "Active" antennas are displayed.
     4. All "Obsolete" antennas are displayed.
     5. All "Invalid" antennas are displayed.
     */

    @Test
    public void antDataBaseAdvancedSearch_ActiveStatusWillBeReturnd_whenASearchByActive() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("Active","","Point-to-Point","","","All","","Select Compliance");
        database.antennaDataActiveStatusResult();
    }

    @Test
    public void antDataBaseAdvancedSearch_ObsoleteStatusWillBeReturnd_whenASearchByObsolete() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("Obsolete","","Point-to-Point","","","All","","Select Compliance");
        database.antennaDataObsoleteStatusResult();
    }

    @Test
    public void antDataBaseAdvancedSearch_InvalidStatusWillBeReturnd_whenASearchByInvalid() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("Invalid","","Point-to-Point","","","All","","Select Compliance");
        database.antennaDataInvalidStatusResult();
    }

    /**COM-657
     * Search by
     Classification
     Run the previous search again. Make
     note of the Classifications of the
     antennas available. (Ideally, all nine
     classifications will be represented, but
     that's not likely.)
     1. Select each of the available
     classifications, one by one, and search
     for them.
     2. Go into Swagger and verify that the same antennas
     are returned there.
     */

    @Test
    public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByBillboard() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","All","","","Billboard","","Select Compliance");
        database.clickAndVal("1");
    }

    @Test
    public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByCylindricalParabola() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","All","","","Cylindrical Parabola","","Select Compliance");
        database.clickAndVal("4");
    }

    @Test
    public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByHornParabolic() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","All","","","Horn Parabolic","","Select Compliance");
        database.clickAndVal("8");
    }

    /**COM-657
     * Search by RPE
     (Radio Pattern
     Envelope)
     Run the previous search again. Make
     note of the RPE field for the antennas
     available.
     1. Pick one of the available RPE's and
     search for it.
     2. The search results are the antennas that match that
     RPE.
     */

    @Test
    public void antDataBaseAdvancedSearch_RBEWillBeReturnd_whenASearchByRBE() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","All","","7297","All","","Select Compliance");
        database.RPEVal("7297");
        database.antennaDataBaseRPESearchResult("7297", 0);
    }

    /**COM-657
     * Search by Gain Run the previous search again. Make
     note of the gain values for the antennas
     available.
     Pick one of the available gain values and
     search for it.
     1. Enter a range of gain values (such as
     30:40)
     2. The search results are the antennas that have that
     gain value.
     */

    //TODO can't enter ranges
    @Test
    public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByGain1() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","24.9","All","","","All","","Select Compliance");
        database.antennaDataBaseGainSearchResult("24.9", 0);
    }

    @Test
    public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByGain2() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","20","All","","","All","","Select Compliance");
        database.antennaDataBaseGainSearchResult("20", 0);
    }

    @Test
    public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByGain3() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","34.4","All","","","All","","Select Compliance");
        database.antennaDataBaseGainSearchResult("34.4", 0);
    }


    /**COM-657
     * Search by
     Application and FCC
     Compliance
     Run the previous search again. Make
     note of the Compliance values for the
     antennas available.
     Pick one of the available Compliance
     values and search for it.
     Change "Application" to "ES Earth
     Station"
     Change "FCC Compliance" to "Select
     Compliance"
     Search
     Make note of the Compliance values for
     the antennas available.
     Pick one of the available Compliance
     values and search for it.
     2. The search results are the antennas that have that
     Compliance value.
     5. Earth Station antennas are returned in the search.
     7. The search results are the antennas that have that
     Compliance value.
     */

    @Test
    public void antDataBaseAdvancedSearch_AntWillBeReturnd_whenASearchByFCCCompliance1() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","Point-to-Point","","","All","","Category A");
        database.antennaDataBaseComplianceSearchResult("Category A", 0);
    }

    /**COM-657
     * Search by Diameter Change "Application" to "MW PtP
     Microwave PointtoPoint" and run the
     previous search again. Make note of the
     Diameter values for the antennas
     available.
     1. Pick one of the available Diameter
     values and search for it.
     2. The search results are the antennas that have that
     Diameter value.
     */
    @Test
    public void antDataBaseAdvancedSearch_AntWillBeReturnd_whenASearchByDiameter() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","Point-to-Point","8.01","","All","","Select Compliance");
        database.antennaDataBaseDiameterSearchResult("2.44 / 8.01", 0);
        database.clearDiameter();
        database.advanceSearch("All","","All","8.00","","All","","Select Compliance");
        database.antennaDataBaseDiameterSearchResult("2.44 / 8.01", 0);
        database.clearDiameter();
        database.advanceSearch("All","","All","2","","All","","Select Compliance");
        database.antennaDataBaseDiameterSearchResult("0.61 / 2.00", 0);
    }

    /**COM-653
     * Antenna Export
     COM-579
     Navigate to Antenna Database
     Run a search (see above test cases for
     possible search criteria)
     Sort the results
     Click "Export"
     Open the resulting file
     5. Data in the downloaded file matches the data on the
     screen.
     */

    @Test
    public void antDataBaseAdvancedSearch_AntWillCreateCSVFile_whenAExportIsSelected() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","Point-to-Point","8.01","","All","","Select Compliance");
        database.export();

        //TODO tool limitation can't validate excel
    }

    /**
     * COM-582 Viewing Antenna Information
     Open the Lego project
     Click "Database Management"
     Click "Antenna Database"
     Search for any antenna code (Make a
     note of this antenna code for future test)
     Click on the antenna code from the
     search results to view the antenna info.
     Click "X" to close the antenna
     information window
     5. The antenna information appears with the following
     details/sections for that particular antenna code:
     Basic Information
     Technical Information
     Regulatory Information
     Earth station Information
     Pattern Information
     Comments & Attachments
     6. The window closes and will go back to search results
     page.
     */

    @Test
    public void antDataBaseAdvancedSearch_antDetailSameAsOnAntDB_whenAAntCodeIsSelected() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","All","","","Horn Parabolic","","Select Compliance");
        database.clickAndVal("8");
        database.antDbBasicInfoVal("02306A","Commscope","Commscope Family","P8F-9","8","","1","1");
        database.antDbTechInfoVal("880", "950","20.3","8.01","3.2","20");
        database.antDbRegInfoVal("1", "");
        database.antDbEarthStationVal("", "");
    }

    /**COM-655
     * Form can populate from any selected antenna DB search result. Simply just click on the result to see its details.

     Validation is in place for all present inputs.

     Status Icon changes with status change.

     Diameter value changes on unit change with logic in place to ensure values don't diminish on conversion.

     Form footer buttons dynamically  change if the antenna exists or not.
     */

    @Test
    public void antDataBaseAdvancedSearch_StatusIconChangesWithStatushange_whenStatusIsChanged() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.advanceSearch("All","","All","","","Horn Parabolic","","Select Compliance");
        database.clickAndVal("8");
        database.antDbBasicInfoVal("02306A","Commscope","Commscope Family","P8F-9","8","","1","1");
        database.antDbTechInfoVal("880", "950","20.3","8.01","3.2","20");
        database.antDbRegInfoVal("1", "");
        database.antDbEarthStationVal("", "");
        database.antDbBasicInfoChangeStatus("Invalid");
        database.changeStatusred();
        database.antDbBasicInfoChangeStatus("Obsolete");
        database.changeStatusYellow();
        database.antDbBasicInfoChangeStatus("Active");
        database.changeStatusGreen();
        database.changeDiameterMeter();
        database.checkDiameterMeter("2.44");
        database.changeDiameterFeet();
        database.checkDiameterMeter("8.01");


    }

    /**
     * Creating Antenna Continuing..
     Click "Create" button on the antenna
     database search window.
     Click "Save" button
     Click "X" to close the window and go
     back to search results page.
     Click "Create" button again.
     Antenna database window appears for creating
     new antenna.
     The system should show error message or
     highlight all mandatory fields
     Antenna code
     Manufacturer
     Model
     Classification
     */
    @Test
    public void antDataBaseCreateAnt_antRequiredFieldsNotSatisfied_whenSaveIsSelected() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.saveCreatedAntenna();
        database.createAntCompanyError();
        database.createAntAntModelError();
        database.createAntClassificationError();
        database.createAntStatusError();
        database.createAntLoFreqError();
        database.createAntHiFreqError();
        database.createAntMainbeamGainError();
        database.createAnt3DBeamwidthError();
        database.createAntApplicationError();
    }

    /**
     * Creating AntennaField
     validation
     Basic Information
     Continuing..
     Antenna code field:


     Enter 6 characters
     Clear antenna code and enter a code
     with special characters
     Clear antenna code and enter antenna
     code with only numbers
     Antenna code should be restricted to 8
     characters for 70-90 antennas

     code."

     System accept the value without any errors
     The system should allow antenna code with special
     characters.
     The system should show validation error on blur,
     At least one letter should be present in Antenna
     code
     *
     * Enter an antenna code that already exists in the database.
     * It should check for uniqueness on blur. If the
       antenna code is not unique, validation error
       message should appear
       Error text: "Code is required to be unique. Please
       enter a unique
     */
    @Test
    public void antDataBaseCreateAnt_EnterAntennaCodeThatAlreadyExists_whenUniqueError() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbBasicInfoEntry("02306A","","","","Billboard","","Dual","Active");

        database.antDbBlur();
        database.errorText("Antenna Code is not unique.");
    }

    /**
     * Enter an antenna code more than 6 characters
     * The system should show an error message, entry field length should be restricted to 6 characters
     */

    @Test
    public void antDataBaseCreateAnt_EnterAntennaCodeThatsMoreThan6_when6CharError() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbBasicInfoEntry("02306AWAW","","","","Billboard","","Dual","Active");
        database.antDbBlur();
        database.errorText("6 characters max.");
    }

    /**
     * Clear antenna code and enter antenna
     code with only numbers
     The system should show validation error on blur,
     At least one letter should be present in Antenna
     code
     */
    @Ignore //TODO not in place yet
    public void antDataBaseCreateAnt_EnterAntennaCodeWithAllNumbers_ErroroneLetterShouldBePresentInAntennacode() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbBasicInfoEntry("456655","","","","Billboard","","Dual","Active");
        database.antDbBlurTech();
        database.errorText("At least one letter should be present in Antennacode");
    }

    /**
     * COM-655
     * Antenna Details Form - UI and Validation
     This does not include the pattern section nor comments.

     The auto-suggest functionality for Manufacturer, Antenna Model Family and Antenna Model are not in place as their respective APIs are not yet ready. The Model Family modal    will also not be present in this work.
     Because the above auto-suggest inputs will not be functional, new antennas will not be able to be saved. This is because of how the auto-suggest will associate selected values with their respective ids. (eg. Antenna Family Id 3, not 'Commscope Family'.

     Form can populate from any selected antenna DB search result. Simply just click on the result to see its details.
     Valid URLs are be: `/#/database-management/antenna/{ANTENNA_SPEC_ID}` or `/#/database-management/antenna/new-antenna`
     Invalid paths gracefully default to a 'new-antenna' form.
     Antenna Codes on new antenna forms are not auto-generated. This requires an API to generate a new, unique antenna code. Antenna Code does however validate if it is a unique value.

     Validation is in place for all present inputs.
     Associated Antenna Lookup is set up. Associated Antenna input validates that antenna code exists on blur.
     Status Icon changes with status change.
     Diameter value changes on unit change with logic in place to ensure values don't diminish on conversion.
     Form footer buttons dynamically  change if the antenna exists or not.

     * Manufacturer field:
     Put the cursor on this field
     As user types, filter down the list in a
     scrollable window
     Support wildcard characters
     Show a list of all possible manufacturers
     (scrollable)
     Require user to choose a manufacturer from the
     list, auto suggest works
     Continuing..
     Model family field:
     Put the cursor on this field
     As user types, filter down the list in a
     scrollable window
     Support wildcard characters
     Click "+" icon to add a new model family
     <incomplete - visit later>
     Show a list of all possible model families
     (scrollable)
     Require user to choose a model family from the
     list; not editable
     Continuing..
     Model field:
     Enter more than 30 characters
     Enter 30 characters
     This should be an editable field.
     Entry field length should be restricted to 30
     characters
     System accepts without any errors
     Continuing..
     Classification dropdown field should have the
     following options
     Billboard
     Cassegrain Parabolic
     Corner Reflector
     Cylindrical Parabola
     Dipole
     Grid Parabolic
     Gaussian Lens
     Horn Parabolic
     Offset Feed Parabola
     Omnidirectional
     Panel
     Prime Focus Parabola
     Prime Focus Torus
     Sector
     Solid Parabolic
     Yagi
     Continuing..
     Feed Direction  field:
     The user should be able to select options: LF - Left
     Feed, RF - Right Feed and "None". (None should be the
     default)
     Continuing..
     Associated Antenna Code field:
     Type in an antenna code.
     Clear Associated Antenna Code field and
     click the lookup icon
     The antenna code should exist in the database
     else system will throw an error message.
     User should be able to find antennas and the
     antennas are not restricted by band
     Continuing..
     Polarized field should be a dropdown,
     withe the following options.
     D - Dual
     S - Single
     C - Circular
     None
     Click "Save"
     Click cancel or discard
     The default should be null
     Validate that a polarization is entered and give
     user a warning: "You have not set a polarization for
     this antenna. Are you sure you want to proceed?"
     Continuing..
     Polarization Restriction field should be a
     dropdown with the following options:
     V - Vertical
     H - Horizontal
     "None"
     It should default to "None".
     Continuing..
     Status dropdown field should have the
     following options:
     Active
     Obsolete
     */

    @Test//TODO Creating antenna is not ready yet
    public void antDataBaseCreateAnt_CreateAntenna_recordIsCreated() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbBasicInfoEntry("656541","Commscope","Commscope Family","P8F-9","Horn Parabolic","YYYYYY","Dual","Active");
        database.antDbTechInfoEntry("880","950","20.3","8.01","3.2","20");
        database.antDbEarthStationEntry("","");
        database.antDbRegInfoEntry("Point-to-Point","Category A");
    }

    /**
     Information section -
     Field validation
     Low frequency (MHz) field:
     Enter alphabets
     Enter special characters
     Enter negative numbers
     Enter numeric value, less than or equal
     to high frequency
     Enter numeric value greater than high
     frequency.
     System should throw an error message
     System should throw an error message
     System should throw an error message
     System should allow user to save the value.
     Validation fails give user an error and do not allow
     them to save the antenna record
     High frequency (MHz) field:
     Enter alphabets
     Enter special characters
     Enter negative numbers
     Enter numeric value, greater than or
     equal to low frequency
     Enter numeric value less than low
     frequency.
     System should throw an error message
     System should throw an error message
     System should throw an error message
     System should allow user to save the value.
     Validation fails give user an error and do not allow
     them to save the antenna record
     Gain (dBi) field:
     Enter negative number 
     Enter alphabets
     Enter positive number
     System should throw an error message
     System should throw an error message
     System accepts the value.
     3dB Beamwidth (deg) field:
     Enter negative number 
     Enter alphabets
     Enter positive number
     System should throw an error message
     System should throw an error m

     Front-to- Back Ratio (dB) field:
     Enter negative number 
     Enter alphabets
     Enter positive number
     System should throw an error message
     System should throw an erro

     */
    @Test
    public void antDataBaseCreateAnt_CreateAntennaTechInfoFieldValidationAlpha_MustBeNumericalValue() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbTechInfoEntry("AAA","AAA","AAA","AAA","AAA","AAA");
        database.antDbBlurTech();
        database.errorTechInfoText("Must be numerical value.","Must be numerical value.","Must be numerical value.","Must be numerical value.","Must be numerical value.","Must be numerical value.");

    }

    @Test
    public void antDataBaseCreateAnt_CreateAntennaTechInfoFieldValidationSpecial_MustBeNumericalValue() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbTechInfoEntry("!@#","!@#","!@#","!@#","!@#","!@#");
        database.antDbBlurTech();
        database.errorTechInfoText("Must be numerical value.","Must be numerical value.","Must be numerical value.","Must be numerical value.","Must be numerical value.","Must be numerical value.");
    }

    @Test
    public void antDataBaseCreateAnt_CreateAntennaTechInfoFieldValidationNegativeNum_MustBeNumericalValue() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbTechInfoEntry("-22","-22","-22","-22","-22","-22");
        database.antDbBlurTech();
        database.errorTechInfoText("Must be a positive value.","Must be a positive value.","Must be a positive value.","Must be a positive value.","Must be a positive value.","Must be a positive value.");
    }

    /**
     * Regulatory
     Information - Field
     validation
     Application dropdown field should have
     the following options:
     Point-to-Point
     Earth Station
     Other
     2. It should default to "Point-to-Point"
     If "Point-to-Point" option is selected for
     Application, FCC Compliance field should
     have the following options:
     Category A
     Category B
     Category B1
     Category B2
     Compliant (no category)
     Noncompliant
     Unknown
     Default to Category A
     If "Earth Station" option is selected for
     Application, FCC Compliance field should
     have the following options:
     Compliant
     R, Restricted
     S, Super Restricted
     U, Useable but Questionable
     Noncompliant
     Unknown
      Default to Compliant
     If "Other" option is selected for
     Application, FCC Compliance field should
     have the following o
     */

    @Test
    public void antDataBaseCreateAnt_CreateAntennaRegulatoryInformationt_FieldValidationDefaul() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbRegInfoEntry("Point-to-Point","Category A");
        database.antDbBlur();
        database.antDbRegInfoEntry("Point-to-Point","Category B");
        database.antDbBlur();
        database.antDbRegInfoEntry("Point-to-Point","Category B1");
        database.antDbBlur();
        database.antDbRegInfoEntry("Point-to-Point","Category B2");
        database.antDbBlur();
        database.antDbRegInfoEntry("Earth Station","S, Super Restricted");
        database.antDbBlur();
        database.antDbRegInfoEntry("Earth Station","U, Useable but Questionable");
        database.antDbBlur();
        database.antDbRegInfoEntry("Earth Station","R, Restricted");

        database.antDbRegInfoVal("2","8");
    }

    /**
     * Manufacturer auto-suggest
     COM-632
     Continuing:
     1. Enter the first three digits of the manufacturer in the "Manufacturer" field
     2. Pick a manufacturer
     1. A dropdown appears with all of the manufacturers that start with those three characters
     2. The field is populated with that maunfacturer
     */
    @Test
    public void antDataBaseCreateAnt_EnterTheFirstThreeDigitsOfTheManufacturer_ADropdownAppearsWithAllOfTheManufacturersThatStart() {
        database.accessAntennaDataBase();
        database.openAdvancedSearch();
        database.createAnt();
        database.antDbBasicInfoEntry("656541","Com","Commscope Family","P8F-9","Horn Parabolic","YYYYYY","Dual","Active");

    }


}


