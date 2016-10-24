package abtlibrary.keywords.frameworklibrary;

import java.util.Hashtable;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

import com.rmn.testrail.entity.TestInstance;
import com.rmn.testrail.entity.TestResult;
import com.rmn.testrail.entity.TestRun;
import com.rmn.testrail.entity.TestRunGroup;
import com.rmn.testrail.service.TestRailService;

import abtlibrary.ABTLibraryNonFatalException;
import abtlibrary.RunOnFailureKeywordsAdapter;
import abtlibrary.keywords.operatinglibrary.OperatingSystem;
import abtlibrary.keywords.selenium2library.Logging;

@RobotKeywords
public class TestRail extends RunOnFailureKeywordsAdapter {
	private TestRailService trs;
	private String client = "";
	private String username = "";

	/**
	 * Instantiated Logging keyword bean
	 */
	@Autowired
	protected Logging logging;

	/**
	 * Instantiated OperationSystem keyword bean
	 */
	@Autowired
	protected OperatingSystem os = new OperatingSystem();

	public static void main(String[] ar) {
		TestRail tr = new TestRail();
		tr.addResult("Verify functionality of Login with valid values", "Test", "Pass");
		// System.out.println(tr.getPlanId());
		// System.out.println(tr.getProjectId());
	}

	/**
	 * Returns required info to connect to TestRail. <br>
	 * All properties are stored in configuration.properties file. <br>
	 * * (On Mac)
	 * <b>/Users/username/Desktop/TestData/configuration.properties</b><br>
	 * * (On Window) <b>C:\TestData\configuration.properties</b>
	 * 
	 * @return all TestRail properties set in .properties file
	 */
	public Hashtable<String, String> getDefaultProperty() {
		String client = os.getConfiguration("testrail_client");
		String username = os.getConfiguration("testrail_username");
		String password = os.getConfiguration("testrail_password");
		String project = os.getConfiguration("testrail_project");
		String testPlan = os.getConfiguration("testrail_testplan");
		String configuration = os.getConfiguration("testrail_configuration");
		Hashtable<String, String> defaultProperties = new Hashtable<String, String>();
		defaultProperties.put("client", client);
		defaultProperties.put("username", username);
		defaultProperties.put("password", password);
		defaultProperties.put("projectName", project);
		defaultProperties.put("planName", testPlan);
		defaultProperties.put("configuration", configuration);

		return defaultProperties;
	}

	public void connectTestRail() {
		Hashtable<String, String> defaultProperties = getDefaultProperty();
		connectTestRail(defaultProperties.get("client"), defaultProperties.get("username"),
				defaultProperties.get("password"));
	}

	public void connectTestRail(String client, String username, String password) {
		if (trs == null || !this.client.equals(client) || !this.username.equals(username)) {
			this.client = client;
			this.username = username;
			trs = new TestRailService(client, username, password);
		}
	}

	@RobotKeywordOverload
	public int getProjectId() {
		Hashtable<String, String> defaultProperties = getDefaultProperty();
		return getProjectId(defaultProperties.get("client"), defaultProperties.get("username"),
				defaultProperties.get("password"), defaultProperties.get("projectName"));
	}

	/**
	 * Search and retrieve project id from specified client and project name.
	 * <br>
	 * 
	 * @param client
	 *            client id (ex: "scout24").
	 * @param username
	 *            account to login TestRail.
	 * @param password
	 *            password.
	 * @param projectName
	 *            working project.
	 * @return working project id.
	 */
	@RobotKeyword
	@ArgumentNames({ "client", "username", "password", "projectName" })
	public int getProjectId(String client, String username, String password, String projectName) {
		connectTestRail(client, username, password);
		int i = 0;
		int projectId = -1;
		while (i < 5) {
			try {
				if (trs.getProjectByName(projectName) != null) {
					projectId = trs.getProjectByName(projectName).getId();
					break;
				} else
					i++;
			} catch (Exception e) {
				i++;
				if (i == 5) {
					logging.warn(String.format("Could not find project '%s'", projectName));
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
		return projectId;
	}

	@RobotKeywordOverload
	public int getPlanId() {
		Hashtable<String, String> defaultProperties = getDefaultProperty();
		return getPlanId(defaultProperties.get("client"), defaultProperties.get("username"),
				defaultProperties.get("password"), defaultProperties.get("projectName"),
				defaultProperties.get("planName"));
	}

	/**
	 * Search and retrieve plan id from specified client, project and plan name
	 * 
	 * @param client
	 *            client id (ex: "scout24").
	 * @param username
	 *            account to login TestRail.
	 * @param password
	 *            password.
	 * @param projectName
	 *            working project.
	 * @param planName
	 *            working test plan.
	 * @return working test plan id.
	 */
	@RobotKeyword
	@ArgumentNames({ "client", "username", "password", "projectName", "planName" })
	public int getPlanId(String client, String username, String password, String projectName, String planName) {
		int projectId = getProjectId(client, username, password, projectName);
		int i = 0;
		int planId = -1;
		while (i < 5) {
			try {
				if (trs.getProject(projectId).getTestPlanByName(planName) != null) {
					planId = trs.getProject(projectId).getTestPlanByName(planName).getId();
					break;
				} else
					i++;
			} catch (Exception e) {
				i++;
				if (i == 5) {
					logging.warn(String.format("Test plan '%s' is closed or not exist in project '%s'", planName,
							projectName));
				}
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return planId;
	}

	@RobotKeywordOverload
	@ArgumentNames({ "testcase", "comment", "status" })
	public void addResult(String testcase, String comment, String status) {
		Hashtable<String, String> defaultProperties = getDefaultProperty();
		addResult(testcase, comment, status, defaultProperties.get("client"), defaultProperties.get("username"),
				defaultProperties.get("password"), defaultProperties.get("projectName"),
				defaultProperties.get("planName"), defaultProperties.get("configuration"));
	}

	/**
	 * Add result status and comment to executed testcase.
	 * 
	 * @param client
	 *            client id (ex: "scout24").
	 * @param username
	 *            account to login TestRail.
	 * @param password
	 *            password.
	 * @param projectName
	 *            working project.
	 * @param planName
	 *            working test plan.
	 * @param configuration
	 *            configuraton in test plan (ex: android - 6.x.x)
	 * @param testcase
	 *            testcase name
	 * @param comment
	 *            comment in test result
	 * @param status
	 *            result status (ex: Pass, Fail).
	 */
	@RobotKeyword
	@ArgumentNames({ "testcase", "comment", "status", "client=NONE", "username=NONE", "password=NONE",
			"projectName=NONE", "planName=NONE", "configuration=NONE" })
	public void addResult(String testcase, String comment, String status, String client, String username,
			String password, String projectName, String planName, String configuration) {
		int stop = 0;
		int i = 0;
		int planId = getPlanId(client, username, password, projectName, planName);
		if (planId > -1) {
			while (i < 5) {
				try {
					for (TestRunGroup trg : trs.getTestPlan(planId).getEntries()) {
						for (TestRun testrun : trg.getRuns()) {
							if (testrun.getConfig() != null) {
								System.out.println("Test Run: " + testrun.getConfig().toLowerCase());
								System.out.println("Test Config: " + configuration.toLowerCase());
								if (testrun.getConfig().toLowerCase().contains(configuration.toLowerCase())) {
									for (TestInstance test : trs.getTests(testrun.getId())) {
										if (test.getTitle().equalsIgnoreCase(testcase)) {
											TestResult result = new TestResult();

											if (status.toLowerCase().contains("pass")) {
												result.setStatusId(1);
											} else
												result.setStatusId(5);
											result.setComment(comment);

											trs.addTestResult(test.getId(), result);
											stop = 1;
											throw new ABTLibraryNonFatalException(
													String.format("Test Status '%s'", status));
										}
										if (stop == 1)
											break;
									}
								}
							}
							if (stop == 1)
								break;
						}
						if (stop == 1)
							break;
					}
					i = 5;
				} catch (RuntimeException e) {
					i = i + 1;
					if (i == 5) {
						logging.warn(String.format(
								"Unable to add result to test case '%s' with configuration '%s'. Please check if test name in test script matched with test case on TestRail.",
								testcase, configuration));
					} else
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		}
	}

}