package com.hiddenleaf.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.core.io.FileSystemResource;

import com.hiddenleaf.domain.AccountsMaster;
//import com.hiddenleaf.domain.ETLDataTransfer;
import com.hiddenleaf.domain.ETLRunInfo;
import com.hiddenleaf.domain.Privilege;
import com.hiddenleaf.domain.RolesMaster;
import com.hiddenleaf.domain.RouteContact;
import com.hiddenleaf.domain.SiteMaster;
import com.hiddenleaf.domain.UserMaster;
import com.hiddenleaf.service.dto.RestEmailDTO;
import com.hiddenleaf.service.dto.UserMasterDTO;

public class MasterUtil {

	public UserMasterDTO converUsagerMasterToDTO(UserMaster userMaster, Map<String, String> rolesMap) {

		// Get all the roles
		String roleString = userMaster.getRoles();
		String[] roleArray = roleString.split(",");

		Set<String> permList = new TreeSet<String>();

		for (String name : roleArray) {

			if (rolesMap.containsKey(name)) {
				String permString = rolesMap.get(name);
				String[] permArray = permString.split(",");

				for (String pname : permArray) {
					permList.add(pname);
				}
			}
		}

		UserMasterDTO userdto = new UserMasterDTO();
		userdto.setUserMasterId(userMaster.getUserMasterId());
		userdto.setUserId(userMaster.getUserId());
		userdto.setUserName(userMaster.getUserName());
		userdto.setRoles(userMaster.getRoles());
		userdto.setStatus(userMaster.getStatus());
		userdto.setAssignedPermissions(permList);
		userdto.setDesignation(userMaster.getDesignation());
		userdto.setContactNumber(userMaster.getContactNumber());
		userdto.setContactPerson(userMaster.getContactPerson());
		userdto.setEmailID(userMaster.getEmailID());
		userdto.setCountry(userMaster.getCountry());
		userdto.setBranch(userMaster.getBranch());
		userdto.setLaneMapping(userMaster.getLaneMapping());
		userdto.setCompanyName(userMaster.getCompanyName());

		return userdto;
	}

	public Map<String, String> convertUserListToMap(List<UserMaster> roles) {

		Map<String, String> userMap = new HashMap<String, String>();

		for (UserMaster sim : roles) {
			userMap.put(sim.getUserId(), sim.getRoles());
		}

		return userMap;
	}

	public Map<String, String> convertRolesListToMap(List<RolesMaster> roles) {

		Map<String, String> permissions = new HashMap<String, String>();

		for (RolesMaster sim : roles) {
			permissions.put(sim.getRoleName(), sim.getAssignedPermissions());
		}

		return permissions;
	}

	public Map<String, String> convertPrivilegeListToMap(List<Privilege> plist) {

		Map<String, String> privilege = new HashMap<String, String>();

		for (Privilege sim : plist) {
			privilege.put(sim.getPrivilegeName(), sim.getPrivilegeId());
		}
		return privilege;
	}

	public Map<String, AccountsMaster> convertAccountsListToMap(List<AccountsMaster> accountList) {

		Map<String, AccountsMaster> accountMap = new HashMap<String, AccountsMaster>();

		for (AccountsMaster am : accountList) {
			accountMap.put(am.getAccountId(), am);
		}
		return accountMap;
	}

	public Map<String, SiteMaster> convertSitesListToMap(List<SiteMaster> sitesList) {

		Map<String, SiteMaster> sitesMap = new HashMap<String, SiteMaster>();

		for (SiteMaster am : sitesList) {
			sitesMap.put(am.getId(), am);
		}
		return sitesMap;
	}

	public Map<String, AccountsMaster> convertAccountListToMap(List<AccountsMaster> accountsList) {

		Map<String, AccountsMaster> accountMap = new HashMap<String, AccountsMaster>();

		for (AccountsMaster am : accountsList) {
			accountMap.put(am.getAccountId(), am);
		}
		return accountMap;
	}

	public Map<String, String> convertAccountListToMapName(List<AccountsMaster> accounts) {

		Map<String, String> accountMap = new HashMap<String, String>();

		for (AccountsMaster am : accounts) {
			accountMap.put(am.getAccountId(), am.getAccountName());
		}
		return accountMap;
	}

	/*
	 * public Map<String, String> convertMoblieListToMap(List<RouteContact> mobile)
	 * {
	 * 
	 * Map<String, String> mobileMap = new HashMap<String, String>();
	 * 
	 * for (RouteContact sim : mobile) { mobileMap.put(sim.getId(),
	 * sim.getMobileList()); }
	 * 
	 * return mobileMap; }
	 */

	public Map<String, String> convertEmailListToMap(List<RouteContact> email) {

		Map<String, String> emailMap = new HashMap<String, String>();

		for (RouteContact sim : email) {
			emailMap.put(sim.getId(), sim.getEmailList());
		}

		return emailMap;
	}

	public String dateToString(LocalDate dt) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String strDate = dateFormat.format(dt);
		return strDate;
	}

	public String accountValidation(AccountsMaster am, int rowCount) {

		StringBuilder errorBuilder = new StringBuilder("Row " + rowCount + ": Fail due to");

		if (am.getAccountId() == null) {
			errorBuilder.append(",AccountId Known");

		}
		if (am.getAccountName() == null) {
			errorBuilder.append(",AccountName Known");

		}

		if (!(am.isCityGroup() == true || am.isCityGroup() == false)) {
			errorBuilder.append(", CityGroup not known");
		}

		if (!(am.isClusterGroup() == true || am.isClusterGroup() == false)) {
			errorBuilder.append(", ClusterGroup not known");
		}

		if (!(am.isKitruleSavail() == true || am.isKitruleSavail() == false)) {
			errorBuilder.append(", KitruleSavail not known");
		}

		if (!(am.isPucavail() == true || am.isPucavail() == false)) {
			errorBuilder.append(", Pucavail not known");
		}

		if (!(am.isTruckAvail() == true || am.isTruckAvail() == false)) {
			errorBuilder.append(", TruckAvail not known");
		}

		errorBuilder.append(".\n");
		return errorBuilder.toString();
	}

	public void containerReportSendEmail(String subject, String text, EmailWorkFlow emailwflow, String toemailids,
			String ccemailids, String bccemailids, FileSystemResource fileSystemResource) {
		try {
			System.out.println("Container Report Email flow started");
			if (toemailids.isEmpty())
				return;

			if (text.length() <= 10)
				return;

			if (!toemailids.isEmpty()) {
				RestEmailDTO restEmailDto = new RestEmailDTO();

				List<String> toemailadd = new ArrayList<>();
				if (toemailids != null) {

					String s[] = toemailids.split(",");
					toemailadd.addAll(Arrays.asList(s));
				}
				List<String> ccemailadd = new ArrayList<>();
				if (ccemailids != null) {
					String s[] = ccemailids.split(",");
					ccemailadd.addAll(Arrays.asList(s));
				}

				List<String> bccemailadd = new ArrayList<>();
				if (bccemailids != null) {
					String s[] = bccemailids.split(",");
					bccemailadd.addAll(Arrays.asList(s));
				}

				System.out.println("Email Text-->" + text);
				System.out.println("toemailadd-->" + toemailadd);
				if (fileSystemResource != null) {
					restEmailDto.setIsFileAttached(true);
				} else {
					System.out.println("NNOOOOOOOOOOOO");
					restEmailDto.setIsFileAttached(false);
				}
				restEmailDto.setIsHtml(true);
				restEmailDto.setSubject(subject);
				restEmailDto.setToList(toemailadd);
				restEmailDto.setCcList(ccemailadd);
				restEmailDto.setBccList(bccemailadd);

				restEmailDto.setText(text);
				Boolean result;
				if (fileSystemResource != null) {
					result = emailwflow.emailProcess(restEmailDto, fileSystemResource);
				} else {
					result = emailwflow.emailProcess(restEmailDto);
				}
				System.out.println("Container Report Email sent " + result);
			} else
				return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String runETL(String stringDate, String etlpath, String dates, String host, String userName, String port,

			String ftpuserName, String ftpPath, String password, String database, String localpath, String ftphost,

			int ftpport, String ftpPassword, String ftpKey, String mileStoneFtpPath) {

		try {
			// ETL script
			String Command = etlpath;

			// Dates for which we want to load the data 1
			String date = " --context_param date=" + dates;

			System.out.println("date is " + dates);

			// DB Connection to the target DB 1+5
			String dbConnection = " --context_param host=" + host + " --context_param userName=" + userName
					+ " --context_param password=" + password + " --context_param port=" + port
					+ " --context_param database=" + database;

			// FTP local and remote path 1+5+3
			String dir = " --context_param localDirectory=" + localpath + " --context_param FTPDirectory=" + ftpPath+" --context_param FTPDirectoryUpdate="+ mileStoneFtpPath;

			// FTP Connection details 1+5+3+5= 14 context
			String ftpConnection = " --context_param ftphost=" + ftphost + " --context_param ftpuserName=" + ftpuserName
					+ " --context_param ftppassword=" + ftpPassword + " --context_param ftpport=" + ftpport
					+ " --context_param privateKeyDirectory=" + ftpKey;

			System.out.println("ETL Job Process Started....");

			String CommandLine = Command + date + dbConnection + dir + ftpConnection;

			System.out.println("Starting command line " + CommandLine + " ETL path " + etlpath);

			Process process = Runtime.getRuntime().exec(CommandLine);
			System.out.println("CMD Opened");

			process.waitFor();

			InputStream is = process.getInputStream();

			StringBuffer procesLog = new StringBuffer();
			String line = "";

			InputStreamReader response = new InputStreamReader(is);
			BufferedReader bufferedReader = new BufferedReader(response);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				procesLog.append(line);
			}

			InputStream os = process.getErrorStream();

			response = new InputStreamReader(is);
			bufferedReader = new BufferedReader(response);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				procesLog.append(line);
				procesLog.append("<br/>");
			}

			return procesLog.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	// ETL-Send Status MAIL
	public String sendMailETL(String subject, List<ETLRunInfo> etlRuns, EmailWorkFlow emailwflow, String toemailids,
			String ccemailids, String bccemailids, String jobOutput) {

		System.out.println("Etl Runs SIZE " + etlRuns.size());

		if (etlRuns == null)
			return "No records to report";

		if (etlRuns.size() <= 0)
			return "No records to report";

		String text = "";

		text = text + "ID = " + etlRuns.get(0).getId() + "  ,  " + text + "DATE = " + etlRuns.get(0).getDate() + "  ,  "
				+ text + "FILE_DATE =" + etlRuns.get(0).getFiledate() + "  ,  " + text + "STATUS ="
				+ etlRuns.get(0).getStatus() + "  ,  " + text + "ROW_COUNT = " + etlRuns.get(0).getRowcount() + "  ,  "
				+ text + "START_TIME = " + etlRuns.get(0).getStarttime() + "  ,  " + text + "END_TIME = "
				+ etlRuns.get(0).getEndtime() + "  ,  " + text + "ERROR_MESSAGE =  " + etlRuns.get(0).getErrormsg()
				+ "  ,  " + text + "  ,  " + text + "REPORT_PROCESS =  " + etlRuns.get(0).getReportProcess() + "  ,  ";

		subject = subject + text;

		System.out.println(" text " + text);

		// Allways send mail
//					if (text.length() <= 10)
//						return "null";
		//
		text = text + "<br/><br/><br/>\n" + jobOutput;

		if (!toemailids.isEmpty()) {
			RestEmailDTO restEmailDto = new RestEmailDTO();

			List<String> toemailadd = new ArrayList<>();
			if (toemailids != null) {

				String s[] = toemailids.split(",");
				toemailadd.addAll(Arrays.asList(s));
			}
			List<String> ccemailadd = new ArrayList<>();
			if (ccemailids != null) {
				String s[] = ccemailids.split(",");
				ccemailadd.addAll(Arrays.asList(s));
			}

			List<String> bccemailadd = new ArrayList<>();
			if (bccemailids != null) {
				String s[] = bccemailids.split(",");
				bccemailadd.addAll(Arrays.asList(s));
			}
			restEmailDto.setIsFileAttached(false);
			restEmailDto.setIsHtml(true);
			restEmailDto.setSubject(subject);
			restEmailDto.setToList(toemailadd);
			restEmailDto.setCcList(ccemailadd);
			restEmailDto.setBccList(bccemailadd);
			restEmailDto.setText(text);

			Boolean result = emailwflow.emailProcess(restEmailDto);
			System.out.println("Email sent " + result);

			return text;
		} else {
			return text;
		}

	}

	// ETL DATA TRANSFER DB TO DB
//	public String runETLDT(String stringDate, String etlpath, String dates, String host, String userName, String port,
//
//			String password, String databaseFrom, String databaseTo) {
//
//		try {
//			// ETL script
//			String Command = etlpath;
//
//			// Dates for which we want to load the data
//			String date = " --context_param date=" + dates;
//
//			System.out.println("date is " + dates);
//
//			// DB Connection to the target DB
//			String dbConnection = " --context_param host=" + host + " --context_param userName=" + userName
//					+ " --context_param password=" + password + " --context_param port=" + port
//					+ " --context_param databaseFROM=" + databaseFrom + " --context_param databaseTO=" + databaseTo;
//
//			System.out.println("ETL Job Process Started....");
//
//			String CommandLine = Command + date + dbConnection;
//
//			System.out.println("Starting command line " + CommandLine + "ETL path " + etlpath);
//
//			Process process = Runtime.getRuntime().exec(CommandLine);
//			System.out.println("CMD Opened");
//
//			process.waitFor();
//
//			InputStream is = process.getInputStream();
//
//			StringBuffer procesLog = new StringBuffer();
//			String line = "";
//
//			InputStreamReader response = new InputStreamReader(is);
//			BufferedReader bufferedReader = new BufferedReader(response);
//
//			while ((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
//				procesLog.append(line);
//			}
//
//			InputStream os = process.getErrorStream();
//
//			response = new InputStreamReader(is);
//			bufferedReader = new BufferedReader(response);
//
//			while ((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
//				procesLog.append(line);
//				procesLog.append("<br/>");
//			}
//
//			return procesLog.toString();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return e.getMessage();
//		}
//
//	}
//
//	// ETL-Send Status MAIL
//	public String sendMailETLDT(String subject, List<ETLDataTransfer> etlRuns, EmailWorkFlow emailwflow,
//			String toemailids, String ccemailids, String bccemailids, String jobOutput) {
//
//		System.out.println("Etl Runs SIZE " + etlRuns.size());
//
//		if (etlRuns == null)
//			return "No records to report";
//
//		if (etlRuns.size() <= 0)
//			return "No records to report";
//
//		String text = "";
//
//		text = text + "ID = " + etlRuns.get(0).getId() + "  ,  " + text + "DATE = " + etlRuns.get(0).getDate() + "  ,  "
//				+ text + "FILE_DATE =" + "  ,  " + text + "STATUS =" + etlRuns.get(0).getStatus() + "  ,  " + text
//				+ "ROW_COUNT = " + etlRuns.get(0).getRowcount() + "  ,  " + text + "START_TIME = "
//				+ etlRuns.get(0).getStarttime() + "  ,  " + text + "END_TIME = " + etlRuns.get(0).getEndtime() + "  ,  "
//				+ text + "ERROR_MESSAGE =  " + etlRuns.get(0).getErrormsg() + "  ,  " + text + "  ,  ";
//
//		subject = subject + text;
//
//		System.out.println(" text " + text);
//
//		// Allways send mail
////						if (text.length() <= 10)
////							return "null";
//		//
//		text = text + "<br/><br/><br/>\n" + jobOutput;
//
//		if (!toemailids.isEmpty()) {
//			RestEmailDTO restEmailDto = new RestEmailDTO();
//
//			List<String> toemailadd = new ArrayList<>();
//			if (toemailids != null) {
//
//				String s[] = toemailids.split(",");
//				toemailadd.addAll(Arrays.asList(s));
//			}
//			List<String> ccemailadd = new ArrayList<>();
//			if (ccemailids != null) {
//				String s[] = ccemailids.split(",");
//				ccemailadd.addAll(Arrays.asList(s));
//			}
//
//			List<String> bccemailadd = new ArrayList<>();
//			if (bccemailids != null) {
//				String s[] = bccemailids.split(",");
//				bccemailadd.addAll(Arrays.asList(s));
//			}
//			restEmailDto.setIsFileAttached(false);
//			restEmailDto.setIsHtml(true);
//			restEmailDto.setSubject(subject);
//			restEmailDto.setToList(toemailadd);
//			restEmailDto.setCcList(ccemailadd);
//			restEmailDto.setBccList(bccemailadd);
//			restEmailDto.setText(text);
//
//			Boolean result = emailwflow.emailProcess(restEmailDto);
//			System.out.println("Email sent " + result);
//
//			return text;
//		} else {
//			return text;
//		}
//
//	}

}
