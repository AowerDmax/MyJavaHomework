import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 * 这个类实现了高等教育教学改革研究申报系统
 * 
 * @author
 * @see Catalog
 * @see ReviewerDatabase
 * @see ReviewingList
 * @see Project
 * @see GeneralProject
 * @see KeyProject
 * @see YouthProject
 * @see Reviewer
 * @see ReviewingItem
 */

public class HETRRSystem {
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private ReviewingList reviewingList;// 正在审查的项目列表
	private ReviewerDatabase reviewerDB;// 审查人数据库
	private Catalog catalog;// 项目列表
	private Catalog approvedList;// 已批准的项目列表

	public HETRRSystem(ReviewingList reviewingList, ReviewerDatabase reviewerDB, Catalog catalog,
			Catalog approvedList) {
		super();
		this.reviewingList = reviewingList;
		this.reviewerDB = reviewerDB;
		this.catalog = catalog;
		this.approvedList = approvedList;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ReviewingList reviewingList = loadReviewing();// 加载正在审查的项目列表
		ReviewerDatabase reviewerDB = loadReviewer();// 加载审查人数据库
		Catalog catalog = loadProject();// 加载项目列表
		Catalog approvedList = loadApprovedList();// 加载已批准的项目列表
		HETRRSystem app = new HETRRSystem(reviewingList, reviewerDB, catalog, approvedList);// 构造系统
		app.run();// 运行系统
	}

	/**
	 * 加载项目目录对象信息
	 * 
	 * @return
	 */
	private static Catalog loadProject() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Catalog catalog = new Catalog();

		catalog.addProject(new GeneralProject("G001", "Gneral Project001", "General Project No. 1", "Campus fund",
				sdf.parse("2019-1-1"), "NWPU", "1 years"));
		catalog.addProject(new GeneralProject("G002", "Gneral Project002", "General Project No. 2", "National fund",
				sdf.parse("2019-5-6"), "NWPU", "2 years"));
		catalog.addProject(new GeneralProject("G003", "Gneral Project003", "General Project No. 3", "First fund",
				sdf.parse("2019-7-1"), "NWPU", "3 years"));
		catalog.addProject(new GeneralProject("G004", "Gneral Project004", "General Project No. 4", "Campus fund",
				sdf.parse("2019-8-15"), "NWPU", "4 years"));
		catalog.addProject(new GeneralProject("G005", "Gneral Project005", "General Project No. 5", "Campus fund",
				sdf.parse("2019-2-24"), "NWPU", "3 years"));
		catalog.addProject(new GeneralProject("G006", "Gneral Project006", "General Project No. 6", "Campus fund",
				sdf.parse("2019-3-4"), "NWPU", "2 years"));

		catalog.addProject(new YouthProject("Y001", "Youth Project001", "Youth Project No. 1", "National fund",
				sdf.parse("2019-9-7"), "NWPU", "Master", 24));
		catalog.addProject(new YouthProject("Y002", "Youth Project002", "Youth Project No. 2", "First fund",
				sdf.parse("2019-10-1"), "NWPU", "PhD", 25));
		catalog.addProject(new YouthProject("Y003", "Youth Project003", "Youth Project No. 3", "First fund",
				sdf.parse("2019-4-1"), "NWPU", "PhD", 33));
		catalog.addProject(new YouthProject("Y004", "Youth Project004", "Youth Project No. 4", "First fund",
				sdf.parse("2019-5-13"), "NWPU", "PhD", 32));
		catalog.addProject(new YouthProject("Y005", "Youth Project005", "Youth Project No. 5", "First fund",
				sdf.parse("2019-2-13"), "NWPU", "PhD", 23));
		catalog.addProject(new YouthProject("Y006", "Youth Project006", "Youth Project No. 6", "First fund",
				sdf.parse("2019-11-1"), "NWPU", "PhD", 26));

		catalog.addProject(new KeyProject("K001", "Key Project001", "Key Project No. 1", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "professor", "null"));
		catalog.addProject(new KeyProject("K002", "Key Project002", "Key Project No. 2", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "associate professor", "null"));
		catalog.addProject(new KeyProject("K003", "Key Project003", "Key Project No. 3", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "professor", "null"));
		catalog.addProject(new KeyProject("K004", "Key Project004", "Key Project No. 4", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "professor", "null"));
		catalog.addProject(new KeyProject("K005", "Key Project005", "Key Project No. 5", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "associate professor", "null"));
		catalog.addProject(new KeyProject("K006", "Key Project006", "Key Project No. 6", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "professor", "null"));

		return catalog;
	}

	/**
	 * 加载已批准项目列表对象信息
	 * 
	 * @return
	 */
	private static Catalog loadApprovedList() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Catalog approvedlist = new Catalog();

		approvedlist.addProject(new GeneralProject("G001", "Gneral Project001", "General Project No. 1", "Campus fund",
				sdf.parse("2019-1-1"), "NWPU", "1 years"));
		approvedlist.addProject(new GeneralProject("G002", "Gneral Project002", "General Project No. 2",
				"National fund", sdf.parse("2019-5-6"), "NWPU", "2 years"));
		approvedlist.addProject(new GeneralProject("G003", "Gneral Project003", "General Project No. 3", "First fund",
				sdf.parse("2019-7-1"), "NWPU", "3 years"));

		approvedlist.addProject(new YouthProject("Y001", "Youth Project001", "Youth Project No. 1", "National fund",
				sdf.parse("2019-9-7"), "NWPU", "Master", 24));
		approvedlist.addProject(new YouthProject("Y002", "Youth Project002", "Youth Project No. 2", "First fund",
				sdf.parse("2019-10-1"), "NWPU", "PhD", 25));
		approvedlist.addProject(new YouthProject("Y003", "Youth Project003", "Youth Project No. 3", "First fund",
				sdf.parse("2019-4-1"), "NWPU", "PhD", 33));

		approvedlist.addProject(new KeyProject("K001", "Key Project001", "Key Project No. 1", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "professor", "null"));
		approvedlist.addProject(new KeyProject("K002", "Key Project002", "Key Project No. 2", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "associate professor", "null"));
		approvedlist.addProject(new KeyProject("K003", "Key Project003", "Key Project No. 3", "National fund",
				sdf.parse("2014-11-1"), "NWPU", "professor", "null"));

		return approvedlist;
	}

	/**
	 * 加载审查者数据库对象信息
	 * 
	 * @return
	 */
	private static ReviewerDatabase loadReviewer() {

		ReviewerDatabase reviewerDB = new ReviewerDatabase();

		reviewerDB.addReviewer(new Reviewer("123456", "Zhang San"));
		reviewerDB.addReviewer(new Reviewer("234561", "Li Si"));
		reviewerDB.addReviewer(new Reviewer("345612", "Wang Wu"));
		reviewerDB.addReviewer(new Reviewer("456123", "Zhao Liu"));
		reviewerDB.addReviewer(new Reviewer("561234", "Liang Qi"));
		reviewerDB.addReviewer(new Reviewer("612345", "Liu Ba"));
		reviewerDB.addReviewer(new Reviewer("111222", "Qian Jiu"));
		reviewerDB.addReviewer(new Reviewer("333444", "Chen Shi"));

		return reviewerDB;
	}

	/**
	 * 加载正在审查的项目列表对象信息
	 * 
	 * @return
	 */
	private static ReviewingList loadReviewing() {

		ReviewingList reviewingList = new ReviewingList();

		reviewingList.addItem(new ReviewingItem("123456", "G004", "General Project No. 4"));
		reviewingList.addItem(new ReviewingItem("123456", "Y004", "Youth Project No. 4"));
		reviewingList.addItem(new ReviewingItem("234561", "K004", "Key Project No. 4"));

		return reviewingList;
	}

	/**
	 * 获取用户输入的项目并给予反馈
	 * 
	 * @throws IOException
	 */
	private void run() throws IOException {

		while (true) {
			int choice = getChoice();
			if (choice == 0) {
				return;
			}
			if (choice == 1) {
				addProjectToCatalog();
				continue;
			} else if (choice == 2) {
				displayCatalog();
				continue;
			} else if (choice == 3) {
				while (true) {
					stdOut.println("Please input the code: ");
					String code = stdIn.readLine();
					Project project = this.catalog.getProject(code);
					if (project != null) {
						displayProject(code);
						break;
					} else {
						stdErr.println("There is no project with that code，Please enter again.");
					}
				}
			} else if (choice == 4) {
				while (true) {
					stdOut.println("Please input the code: ");
					String code = stdIn.readLine();
					Project project = this.catalog.getProject(code);
					stdOut.println("Please input the id: ");
					String id = stdIn.readLine();
					Reviewer reviewer = this.reviewerDB.getReviewer(id);
					if (project == null) {
						stdErr.println("There is no project with that code，Please enter again.");
					} else if (reviewer == null) {
						stdErr.println("There is no reviewer with that id，Please enter again.");
					} else {
						addReviewItem(code, id);
						break;
					}
				}
			} else if (choice == 5) {
				while (true) {
					stdOut.println("Please input the id: ");
					String id = stdIn.readLine();
					Reviewer reviewer = this.reviewerDB.getReviewer(id);
					if (reviewer != null) {
						displayReviewingProjects(id);
						break;
					} else {
						stdErr.println("There is no reviewer with that id，Please enter again.");
					}
				}
			} else if (choice == 6) {
				displayReviewingList();
				continue;
			} else if (choice == 7) {
				while (true) {
					stdOut.println("Please input the code: ");
					String code = stdIn.readLine();
					Project project = this.catalog.getProject(code);
					if (project != null) {
						addApprovedProject(code);
						break;
					} else {
						stdErr.println("There is no project with that code，Please enter again.");
					}
				}
			} else if (choice == 8) {
				while (true) {
					stdOut.println("Please input the code: ");
					String code = stdIn.readLine();
					Project project = this.approvedList.getProject(code);
					if (project != null) {
						displayApprovedProject(code);
						break;
					} else {
						stdErr.println("There is no approvedItem with that code，Please enter again.");
					}
				}
			}
		}
	}

	/**
	 * 提供选项内容并获取用户输入的选项
	 * 
	 * @return
	 * @throws IOException
	 */
	private int getChoice() throws IOException {
		int input;// 用户输入的选项
		while (true) {
			try {
				stdOut.print("[0]  Quit\n" + "[1]  Add a project to the project catalog applied\n"
						+ "[2]  Display the project catalog applied\n"
						+ "[3]  Display the information of a project by its code\n"
						+ "[4]  Add a project to the projects reviewed for each reviewer\n"
						+ "[5]  Display the projects reviewed for each review by the reviewer’s code\n"
						+ "[6]  Display the current system’s project list under reviewing: lists code, project and the corresponding reviewer\n"
						+ "[7]  Add a project to a list of approved projects and remove it from the current project list under reviewing\n"
						+ "[8]  Display the system’s project list under approved by listing its code\n"
						+ "choice>> \n");
				stdOut.flush();
				input = Integer.parseInt(stdIn.readLine());
				if (0 <= input && 8 >= input) {
					return input;// 输入0-8选项后跳出循环，返回输入值
				} else {
					stdErr.println("Invalid choice:  " + input);// 输入范围外的数字后，提示出错
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);// 输入非数字选项后，抛出异常
			}
		}
	}

	// 下面的函数体需要手动补充

	/**
	 * 选项1： 选择需要添加到目录中的项目类型并根据提示完成项目添加
	 * 
	 * @throws IOException
	 */
	private void addProjectToCatalog() throws IOException {

		// hand written code goes here...

	}

	/**
	 * 选项2： 显示目录，包括项目代码、项目说明和申请日期
	 */
	private void displayCatalog() {

		// hand written code goes here...

	}

	/**
	 * 选项3 ：根据用户输入的项目代码显示项目信息
	 * 
	 * @param code
	 *            项目代码
	 * @throws IOException
	 */
	private void displayProject(String code) {

		// hand written code goes here...

	}

	/**
	 * 选项4 ：根据用户输入的项目代码和审查者ID，将项目添加到正在审查的项目列表中
	 * 
	 * @param code
	 *            项目代码
	 * @param id
	 *            审查者id
	 */
	private void addReviewItem(String code, String id) {

		// hand written code goes here...

	}

	/**
	 * 选项5 ：根据审查者ID显示其正在审查的项目
	 * 
	 * @param id
	 *            审查者ID
	 */
	private void displayReviewingProjects(String id) {

		// hand written code goes here...

	}

	/**
	 * 选项6 ：显示当前系统正在审查的项目列表
	 */
	private void displayReviewingList() {

		// hand written code goes here...

	}

	/**
	 * 选项7 ：根据用户输入的项目代码，将一个项目从正在审查的项目中删除并添加到已批准的项目中
	 * 
	 * @param code
	 *            项目代码
	 */
	private void addApprovedProject(String code) {

		// hand written code goes here...

	}

	/**
	 * 选项8： 根据用户输入的已批准项目代码，显示已批准的项目信息
	 * 
	 * @param code
	 *            已批准项目代码
	 */
	private void displayApprovedProject(String code) {

		// hand written code goes here...

	}

}
