package reportConfig;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			String workingDir = System.getProperty("user.dir");
			extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResultsV2.html", true);
		}
		return extent;
	}

	// @BeforeSuite
	// public void deleteAllFilesInReportNGScreenshot() {
	// deleteAllFileInFolder();
	// }
	//
	// public void deleteAllFileInFolder() {
	// try {
	// String workingDir = System.getProperty("user.dir");
	// String pathFolderDownload = workingDir + "/ExtentReports";
	// File file = new File(pathFolderDownload);
	// File[] listOfFiles = file.listFiles();
	// for (int i = 0; i < listOfFiles.length; i++) {
	// if (listOfFiles[i].isFile()) {
	// System.out.println(listOfFiles[i].getName());
	// new File(listOfFiles[i].toString()).delete();
	// }
	// }
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	//
	// }
}
