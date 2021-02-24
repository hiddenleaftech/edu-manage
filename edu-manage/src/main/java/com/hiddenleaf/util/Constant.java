package com.hiddenleaf.util;

/**
 * 
 * @author Raghunathan
 *
 */
public final class Constant {

	public static final String STRING_EMPTY = "";

	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
	public static final String SIGNING_KEY = "wdsi@123";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

	public static final String TEMPLATES_SOURCE_PATH = "templates/";
	public static final String TEMPLATES_MODE = "HTML5";
	public static final String UTF_8 = "UTF-8";
	public static final String XHTML = "XHTML";
	public static final String TEMPLATES_SUFFIX = ".html";

	// Regex for acceptable logins
	public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

	public static final String SYSTEM_ACCOUNT = "system";
	public static final String ANONYMOUS_USER = "anonymoususer";

	public static final String DOC_MASTER_STN = "DOCM-4";
	public static final String DOC_TYPE_MASTER_INBOUND = "DTYM-1";
	public static final String DOC_TYPE_MASTER_OUTBOUND = "DTYM-2";

	public static final String PART_TYPE_V_PART = "V";
	public static final String PART_TYPE_NV_PART = "NV";

	public static final String MATERIAL_INBOUND_TYPES_ID = "MSTM1";
	public static final String MATERIAL_OUTBOUND_TYPES_ID = "MSTM2";

	public static final String ORDER_STATUS_INBOUND_EXPECTED = "STCM-24";
	public static final String ORDER_STATUS_DECLIEND = "STCM12";
	public static final String POD_STATUS_DECLIEND = "STCM13";
	public static final String ORDER_STATUS_PICK_REQUESTED = "STCM-12";
	public static final String ORDER_STATUS_ORDER_CONSOLIDATED = "STCM-20";
	public static final String ORDER_STATUS_CONSOLIDATION_COMPLETED = "STCM9";
	public static final String ORDER_STATUS_PACKING_STARTED = "STCM-21";

	public static final String DOCKED_IN = "STCM-2";
	public static final String GATED_IN = "STCM-1";
	public static final String POD_GENERATED = "STCM-3";
	public static final String ORDER_PICK_ASSIGNED = "STCM-14";
	public static final String ORDER_PICK_COMPLETED = "STCM-16";
	public static final String ORDER_TYPE_INBOUND = "OTYM-1";
	public static final String BINNIND_COMPLETE_STATUS = "STCM-8";
	public static final String PART_PICKING = "STCM-19";

	public static final String PART_LOCKED_STATUS = "STCM-28";
	public static final String PART_RELEASED_STATUS = "STCM-29";
	public static final String BINNIND_INPROGRESS_STATUS = "STCM-5";
	public static final String BINNING_INPROGRESS_STATUS = "STCM-5";
	public static final String BAD_BIN = "STCM-7";
	public static final String SHORT_RECEIVED = "STCM-9";

	public static final Integer PART_PICKED = 1;
	public static final Integer PART_MISMATCH_INBOUND = 2;
	public static final Integer PART_ALREADY_PICKED = 3;
	public static final Integer PART_QUANTITY_MISSING = 4;
	public static final Integer PART_MISMATCH = 5;
	public static final Integer PART_PICKING_COMPLETED = 6;
	public static final Integer PART_SCAN_OUTBOUND = 7;
	public static final Integer PART_SCAN_INBOUND = 8;
	public static final Integer PART_MISMATCH_OUTBOUND = 9;
	public static final Integer PART_QUANTITY_EXCEEDS = 10;
	public static final Integer PART_NO_OF_LABELS = 11;
	public static final Integer PART_MISMATCH_BIN = 12;
	public static final Integer PART_BIN_SWITCHED = 13;
	public static final Integer PART_TRY_RANDOM_PICK = 14;
	public static final Integer PART_SHORT_QUANTITY = 15;
	public static final Integer PART_RANDOM_PICK_WAITING = 16;
	public static final Integer PART_ALTERNATE_REQUESTED = 17;
	public static final Integer PART_QUANTITY_INSUFFICIENT = 18;
	public static final Integer PART_NOT_MAPPED_WITH_USER = 19;
	
	public static final Integer SUCCESSFULLY_PICKED = 20;
	public static final Integer QUANTITY_NOT_AVAILABLE = 21;
	public static final Integer PART_PICKED_ID = 22;
	public static final Integer CHECK = 23;
	public static final Integer PICK_AGAIN = 24;
	public static final Integer QTY_GREATER_THEN_ZERO = 25;
	public static final Integer CORRECT_BIN = 26;
	public static final Integer INCORRECT_BIN = 27;
	public static final Integer ALL_PART_PICKED = 28;
	public static final Integer SCAN_CORRECT_PART_WITH_CORRECT_BIN = 29;
	public static final Integer QUANTITY_DOES_NOT_MATCH = 30;



	public static final Integer PICKER_SCAN_INBOUND = 1;
	public static final Integer PICKER_GET_LABELS = 2;
	public static final Integer PICKER_SCAN_OUTBOUND = 3;

	public static final Integer CONSOLIDATION_SUCCESS = 1;
	public static final Integer CONSOLIDATION_LEVEL_ALREADY_EXISTS = 2;
	public static final Integer CONSOLIDATION_SCAN_INCOMPLETE = 3;

	public static final String V_PART_ID = "PATM-1";
	public static final String NV_PART_ID = "PATM-2";
	public static final String PART_PICKED_STATUS_ID = "STCM-18";
	public static final String PART_PACKED_STATUS_ID = "STCM-25";

	public static final String ORDER_TYPE_OUTBOUND = "OTYM-2";
	public static final String INBOUND_PROCESS_DEF_ID = "WDSI_Inbound_Process";

	public static final String ASSIGNBINNERPROCESSKEY = "WDSI_Inbound_assignPurchaseOrder";
	public static final String BINNER_PROCESS_KEY = "WDSI_Inbound_BinningCallActivity";
	public static final String CONSOLIDATION_PROCESS_KEY = "WDSI_Outbound_Consolidation";

	public static final String PICK_TYPE_FMFO = "FMFO";
	public static final String PICK_TYPE_LMFO = "LMFO";
	public static final String PICK_TYPE_FEFO = "FEFO";
	public static final String PICK_TYPE_LEFO = "LEFO";

	public static final String DELIVERY_ENGINEER = "DITM1";
	public static final String DELIVERY_CUSTOMER_SITE = "DITM2";
	public static final String DELIVERY_END_CUSTOMER = "DITM3";
	public static final String DELIVERY_COURIER = "DITM4";
	public static final String DELIVERY_VEHICLE = "DITM5";

	public static final String DELIVERY_CODE_ENGINEER = "ENGINEER";
	public static final String DELIVERY_CODE_CUSTOMER_SITE = "CUSTSITE";
	public static final String DELIVERY_CODE_END_CUSTOMER = "ENDCUSTOMER";

	public static final int WIDTH = 30;
	public static final int HEIGHT = 20;
	public static final String PICKING_LABEL_TYPE = "OutBound";
	public static final String DESCREPENCY_PROCESS_KEY = "WDSI_inbound_listdiscrepanyparts";
	public static final String WAREHOUSE_MANAGER_APPROVAL_PROCESS_KEY = "WDSI_WarehouseManager_ApproveRequest";
	public static final String ALERT_TYPE = "ALTM-1";
	public static final String POD_NOT_PROCESS_ID = "NPM1";
	public static final String EXCESS_NOT_PROCESS_ID = "NPM2";
	public static final String DAMAGED_NOT_PROCESS_ID = "NPM3";
	public static final String SHORT_RCD_NOT_PROCESS_ID = "NPM4";
	public static final String TMP_ORDER_NOT_PROCESS_ID = "NPM5";
	public static final String SHORT_PICK_NOT_PROCESS_ID = "NPM6";
	public static final String EXCESS_POD_PROCESS_ID = "NPM9";
	public static final String RANDOM_PICK_PROCESS_ID = "NPM8";
	public static final String GOOD_BIN_TYPE = "BITY-8";
	public static final String BAD_BIN_TYPE = "BITY-9";
	public static final String SCRAP_BIN_TYPE = "BITY-10";
	public static final String DAMAGED_BIN_TYPE = "BITY-11";

	public static final Integer IS_EXCESS_FLAG = 1;
	public static final String OUTBOUND_TYPE = "STAT-2";
	public static final String INBOUND_TYPE = "STAT-1";
	public static final String OUTBOUND_PROCESSDEFINATIONID = "WDSI_Outbound_Process";
	public static final String CONSLOIDATION_PROCESSDEFINATIONID = "WDSI_Outbound_Consolidation";
	public static final String CONSLOIDATION_TASKID = "WDSI_Outbound_AddLevelOrBox";
	public static final String NOT_PROCESS_KEY_TEMP_SALES_ORDER = "TMPS";
	public static final String TEMP_ORDER_TYPE = "STCM8";

	public static final String MATERIAL_INBOUND_REQUESTED = "STCM6";
	public static final String MATERIAL_OUTBOUND_REQUESTED = "STCM7";

	public static final int ORDER_DELIVERY_CATEGORY = 1;
	public static final int DISPATCH_DELIVERY_CATEGORY = 2;

	public static final String GOOD_PART_STOCKTYPE = "STYM-1";
	public static final String BAD_PART_STOCKTYPE = "STYM-2";
	public static final String SCRAP_PART_STOCKTYPE = "STYM-3";
	public static final String DAMAGED_PART_STOCKTYPE = "STYM-4";
	public static final String SHORT_RCD_PART_STOCKTYPE = "STYM-6";
	public static final String ORDER_NOTIFY_TYPE = "ORDER";
	public static final String OTHER_NOTIFY_TYPE = "VEHICLE";

	public static final int QTY_LESS = 1;
	public static final int BINNING_INPROGRESS = 2;
	public static final int COMPLETED = 3;

	public static final int DISCREPENCY_ADDED = 1;
	public static final int DISCREPENCY_ALREADY_ADDED = 2;
	public static final int DISCREPENCY_ADDING_EXCESS_QUANTITY = 3;
	public static final int DISCREPENCY_SCAN_CORRECT_PART = 4;
	public static final int DISCREPENCY_ENTER_V_PART_QUANTITY = 5;
	public static final int DISCREPENCY_SCAN_COMPLETED = 6;
	public static final int SHORT_PICK_NOTIFIED = 0;
	public static final int DISCREPENCY_PART_ALREADY_SCANNED = 7;

	public static final int PART_OR_BOX_SCANNED = 1;
	public static final int PARTS_ALREADY_EXIST = 2;
	public static final int SERIAL_NO_NOT_AVAILABLE = 3;
	public static final int BOX_ALREADY_EXIST = 4;
	public static final int BOX_SCANNED = 5;
	public static final int SCAN_COMPLETED = 6;
	public static final int INVALIDSCAN = 7;
	public static final int INVALIDWEIGHT = 8;

	public static final String PHONENUMBER = "phonenumber";
	public static final String VEHNUMBER = "vehNumber";
	public static final String DRIVERNAME = "driverName";
	public static final String INVOICENUMBER = "InvoiceNumber";
	public static final String CUSTOMERREFERANCE = "customerReference";
	public static final String GATEINNO = "GateInnumber";
	public static final String PARTNUMBER = "partnumber";
	public static final String TYPE_INBOUND = "inbound";
	public static final String TYPE_OUTBOUND = "outbound";

	public static final String PACKING_COMPLETED = "STCM9";

	public static final int BIN_LABEL = 1;
	public static final int BIN_PARTS_ALREAY_EXIST = 2;
	public static final int IS_V_PART = 3;
	public static final int PART_SUCESSFULLY_SAVED = 4;
	public static final int PART_SCAN_COMPLETED = 5;
	public static final int BINNING_SCAN_CORRECT_PART = 6;
	public static final int INVALID_SERIAL_NUMBER = 7;
	public static final int WRONG_ACCOUNT_MAPPING = 8;
	public static final int SCAN_DISCREPENCY_PART = 9;
	public static final int VPARTS_QTY_LESS = 10;
	public static final int BARCODE_WIDTH = 60;
	public static final int BARCODE_HEIGHT = 50;
	public static final int BARCODE_HEIGHT_PDF = 30;
	public static final int PACKINGSLIP_BARCODE_HEIGHT = 80;
	public static final int PACKINGSLIP_BARCODE_WIDTH = 300;

	public static final int LABEL_SIZE_TWOBYTWO = 2;
	public static final int LABEL_SIZE_FOURBYFOUR = 4;
	public static final String HOLD__TEMP_ORDER = "R19";
	public static final String REJECT_TEMP_ORDER = "R16";
	public static final String HOLD_TEMP_SHORT_QTY = "R20";
	public static final String CONTINUE_TEMP_SHORT_QTY = "R15";
	public static final String REJECT_SHORT_QTY = "R16";
	public static final String HOLD_TEMP_ORDER_STATUSID = "STCM12001";
	public static final String HOLD_TEMP_SHORT_QTY_ORDER_STATUSID = "STCM12002";
	public static final String ALTER_TEMP_SHORT_QTY_ORDER_STATUSID = "STCM12005";
	public static final String REJECT_SHORT_STATUSID = "STCM12009";
	public static final String RANDOM_PICK_STATUS_APPROVED_ID = "STCM12003";

	public static final String SHORT_PICK_TASK_KEY = "WDSI_Outbound_Picking";

	public static final String WORKFLOW_INBOUND_PROCESSKEY = "WDSI_Inbound_Process";
	public static final String WORKFLOW_OUTBOUND_PROCESSKEY = "WDSI_Outbound_Process";
	public static final String WORKFLOW_PURCHASEORDER_PROCESSKEY = "WDSI_Inbound_assignPurchaseOrder";
	public static final String WORKFLOW_CONSOLIDATION_PROCESSKEY = "WDSI_Outbound_Consolidation";
	public static final String WORKFLOW_BINNING_TASKKEY = "WDSI_Inbound_AwaitingBinning";
	public static final String WORKFLOW_LIST_POD_RECORDS_TASKKEY = "WDSI_InboundProcess_ListPodrecords";
	public static final String WORKFLOW_AWAITING_BINNING_TASKKEY = "WDSI_Inbound_AwaitingBinning";
	public static final String WORKFLOW_PICKER_DASHBOARD_TASKKEY = "WDSI_Outbound_PickingUser";
	public static final String WORKFLOW_WHMANAGER_tASKKEY = "WDSI_WarehouseManager_ApproveRequest";
	public static final String WORKFLOW_CONSOLIDATION_TASKKEY = "WDSI_Outbound_Consolidation";
	public static final String WORKFLOW_EXCESSUPLOAD_TASKKEY = "WDSI_inbound_uploadExcessPurchaseOrder";
	public static final String WORKFLOW_EXCESSEDIT_TASKKEY = "WDSI_inbound_edipPurchaseOrder";

	public static final int NOTIFICATION_TYPE_GATEIN = 1;
	public static final int NOTIFICATION_TYPE_POD_ASSIGNMENT = 2;
	public static final int NOTIFICATION_TYPE_BINNER_ASSIGNMENT = 3;
	public static final int NOTIFICATION_TYPE_PICKER_ASSIGNMENT = 4;
	public static final int NOTIFICATION_TYPE_WAREHOUSEMANAGER_APPROVAL = 5;
	public static final int NOTIFICATION_TYPE_CONSOLIDATION = 6;
	public static final String EXCESS_POD_ALLOW = "STCM17003";
	public static final String EXCESS_POD_DENY = "STCM17004";
	public static final String EXCESS_POD_APPROVAL = "STCM17017";

	public static final int BINNING_MODE = 1;
	public static final int PICKING_MODE = 2;

	public static final int STOCK_MINUS = 1;
	public static final int STOCK_PLUS = 2;

	public static final String VEHICLE_NUM = "DITM5";
	public static final String COURIER_NUM = "DITM4";
	public static final String ENGINNEER_NUM = "DITM1";

	public static String JWT_TOKEN = null;

//	public static final String CONDITIONAL_POD_APPORVAL = "PPODAL";
//	public static final String CONDITIONAL_POD_APPORVED = "PPODED";
//	public static final String EXCESS_POD_APPORVAL = "EPODAL";
//	public static final String EXCESS_POD_APPORVED = "EPODED";
//	public static final String ORDER_EXCESS_APPORVED = "OEED";
//	public static final String ORDER_EXCESS_APPORVAL = "OEAL";
//	public static final String ORDER_SHORT_APPORVAL = "OSAL";
//	public static final String ORDER_SHORT_APPORVED = "OSED";
//	public static final String ORDER_DAMAGE_APPORVAL = "ODAL";
//	public static final String ORDER_DAMAGE_APPORVED = "ODED";
//	public static final String SHOR_TPICK_APPORVAL = "SPAL";
//	public static final String SHORT_PICK_APPORVED = "SPED";
//	public static final String RANDOM_PICK_APPORVAL = "RPAL";
//	public static final String RANDOM_PICK_APPORVED = "RPED";
//	public static final String TMP_SALES_ORDER_APPORVAL = "TSOAL";
//	public static final String TMP_SALES_ORDER_APPORVED = "TSOED";
//	public static final String TMP_SALES_ORDER_REJECT = "TSOR";
//	public static final String EXCESS_POD_REJECT = "EPR";

	public static final String CONDITIONAL_POD_APPORVAL = "STCM17014";
	public static final String CONDITIONAL_POD_APPORVED = "STCM17015";
	public static final String EXCESS_POD_APPORVAL = "STCM17016";
	public static final String EXCESS_POD_APPORVED = "STCM17017";
	public static final String ORDER_EXCESS_APPORVED = "STCM17018";
	public static final String ORDER_EXCESS_APPORVAL = "STCM17019";
	public static final String ORDER_SHORT_APPORVAL = "STCM17020";
	public static final String ORDER_SHORT_APPORVED = "STCM17021";
	public static final String ORDER_DAMAGE_APPORVAL = "STCM17023";
	public static final String ORDER_DAMAGE_APPORVED = "STCM17022";
	public static final String SHOR_TPICK_APPORVAL = "STCM17024";
	public static final String SHORT_PICK_APPORVED = "STCM17025";
	public static final String RANDOM_PICK_APPORVAL = "STCM17027";
	public static final String RANDOM_PICK_APPORVED = "STCM17026";
	public static final String TMP_SALES_ORDER_APPORVAL = "STCM17028";
	public static final String TMP_SALES_ORDER_APPORVED = "STCM17029";
	public static final String TMP_SALES_ORDER_REJECT = "STCM17030";
	public static final String EXCESS_POD_REJECT = "STCM17031";

	public static final String ES_KEYWORD = "keyword";
	public static final String ES_STANDARD_ANALYZER = "standard";
	public static final String ES_AUTOCOMPLETE_ANALYZER = "autocomplete";

	public static final Long DEFAULT_LABEL_VALUE = 1l;
	public static final Integer HUS_ORDER = 2;
	public static final String DELIVERY_WORKSHOP = "DITM6";
	public static final String DELIVERY_DESPATCH = "DITM7";
	public static final String SERVICETYPEMASTER_ID = "SVYM7";

	public static final long labelSizeFourInch = 288;
	public static final long labelSizeTwoInch = 144;

	public static final String DESPATCH_COMPLETED = "STCM2002";
	public static final String EXCESS_RECEIVED = "STCM-30";
	public static final String BINNER_ASSIGNMENT = "STCM-31";
	public static final String BIN_TO_BIN_TRANSFER = "STCM-32";
	public static final String DAMAGED_PART = "STCM-33";

	public static final Integer EMAIL_CC = 1;
	public static final Integer EMAIL_TO = 2;
	public static final Integer EMAIL_BCC = 3;

	public static final String LABEL_TYPE_INBOUND = "Inbound";
	public static final String LABEL_TYPE_OUTBOUND = "Outbound";
	public static final String LABEL_TYPE_HUSQUVARNA = "Replen";
	public static final String LABEL_TYPE_BADBIN = "BAD BIN";
	public static final String STOCK_TYPE_EXCESS = "Excess";
	public static final String GATE_OUT = "STCM10";

	public static final String ACTOR_TYPE_WAREHOUSE = "AM1";
	public static final String ACTOR_TYPE_DEALER = "AM2";

	public static final String ACTOR_WAREHOUSE = "AM001";
	public static final String ACTOR_DEALER = "AM002";

	public static final String PART_PIKING = "STCM9002";
	public static final String PART_Short = "STCM16001";

	public static final String MODE_OF_VEHICLE = "ABCM16001";
	public static final String MODE_OF_COURIER = "ABCM16002";

	public static final String OUTBOUND_ORDER_DECLINED = "STCM-13";
	public static final String PICK_COMPLETED = "STCM-90";

	public static final String NO_PARTS_AVAIALABLE = "STCM21065";
	public static final String HUS_INWARD = "STCM9015";
	public static final String HUS_ACTORID = "AM002";
	
	public static final String MODE_OF_TRANSPORT_VEHICLE = "ABCM16001"; 
	public static final String MODE_OF_TRANSPORT_COURIER = "ABCM16002";

	public static final String PART_TYPE_FG= "HUSQUVARNA FG";
	public static final String PART_TYPE_HS= "HUSQUVARNA SPARE";
	public static final String PART_TYPE_CONSUMABLE= "HUSQUVARNA CONSUMABLES";
	public static final String PART_TYPE_ACCESSORIES= "HUSQUVARNA ACCESSORIES";
	
	public static final String ORDER_DELIVERED = "STCM9016";
	public static final String REQUEST_NUMBER = "msysRequestNumber";
	public static final String ORDERID = "id";
	
	public static final int ORDER_UPLOADED_AS_NORMAL = 0;
	public static final int ORDER_UPLOADED_AS_ERROR = 1;
	public static final int ORDER_UPLOADED_AS_EXCESS = 2;
	public static final int ORDER_UPLOADED_AS_NORMAL_EXCESS = 3;
	public static final int ORDER_UPLOADED_AS_ERROR_EXCESS = 4;
	public static final int ORDER_UPLOADED_AS_EXCESS_EXCESS = 5;
	
}
