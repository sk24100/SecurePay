package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.secure.qa.util.CustomFileFilter;
import com.secure.qa.util.TestUtil;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.reducers.ReducingMethod;

@CucumberOptions(
		features={"src/main/resources/FeatureFiles/"},
		glue= {"steps"},
		tags={"@contactus"},
		plugin={"json:src/test/resources/Report/Automated_Test_Execution.json"})

public class TestRunner extends AbstractTestNGCucumberTests {
	
	    @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	    
	    
	    @BeforeSuite
	    public void setUpSuit() {
	    	deletePreviousReports();
	    }
	    
	    @AfterSuite
	    public void generateReport() {
	    	try {
				String sInputFilePaths = TestUtil.REPORTS_FOLDER;
				String sTrackName = "Unilever Digital Platform";
				File reportOutputDirectory = new File(TestUtil.CUCUMBER_HTML_REPORTS_FOLDER + "Report-"
						+ TestUtil.getExecutionTimeStamp());
				List<String> jsonFiles = new ArrayList<String>();
				File reportInputFolder = new File(sInputFilePaths);
				File[] filesInput = reportInputFolder.listFiles(new CustomFileFilter(new String[] { "json" }));
				List<File> listInputFiles = Arrays.asList(filesInput);
				for (File inputFile : listInputFiles) {
					jsonFiles.add(sInputFilePaths + inputFile.getName());
				}
				Configuration configuration = new Configuration(reportOutputDirectory, sTrackName);
				configuration.setBuildNumber(new Date().toString());
				configuration.addReducingMethod(ReducingMethod.MERGE_FEATURES_BY_ID);
				ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
				reportBuilder.generateReports();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Exception in generating final report");
			}
	    }
	    
	    
		public void deletePreviousReports() {
			File dir = new File(TestUtil.REPORTS_FOLDER);
			for (File file : dir.listFiles()) {
				if (!file.isDirectory())
					file.delete();
			}
	    
}
		
}


