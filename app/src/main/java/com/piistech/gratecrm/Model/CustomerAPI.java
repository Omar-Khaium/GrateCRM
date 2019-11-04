package com.piistech.gratecrm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerAPI {


    @SerializedName("Id")
    @Expose
    public int id;
    @SerializedName("CustomerId")
    @Expose
    public String customerId;
    @SerializedName("CustomerNo")
    @Expose
    public String customerNo;
    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("FirstName")
    @Expose
    public String firstName;
    @SerializedName("LastName")
    @Expose
    public String lastName;
    @SerializedName("SSN")
    @Expose
    public String sSN;
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("BusinessName")
    @Expose
    public String businessName;
    @SerializedName("DateofBirth")
    @Expose
    public String dateofBirth;
    @SerializedName("PrimaryPhone")
    @Expose
    public String primaryPhone;
    @SerializedName("SecondaryPhone")
    @Expose
    public String secondaryPhone;
    @SerializedName("CellNo")
    @Expose
    public String cellNo;
    @SerializedName("Fax")
    @Expose
    public String fax;
    @SerializedName("EmailAddress")
    @Expose
    public String emailAddress;
    @SerializedName("CallingTime")
    @Expose
    public String callingTime;
    @SerializedName("Address")
    @Expose
    public String address;
    @SerializedName("Address2")
    @Expose
    public String address2;
    @SerializedName("Street")
    @Expose
    public String street;
    @SerializedName("City")
    @Expose
    public String city;
    @SerializedName("State")
    @Expose
    public String state;
    @SerializedName("ZipCode")
    @Expose
    public String zipCode;
    @SerializedName("Country")
    @Expose
    public String country;
    @SerializedName("StreetPrevious")
    @Expose
    public String streetPrevious;
    @SerializedName("CityPrevious")
    @Expose
    public String cityPrevious;
    @SerializedName("StatePrevious")
    @Expose
    public String statePrevious;
    @SerializedName("ZipCodePrevious")
    @Expose
    public String zipCodePrevious;
    @SerializedName("CountryPrevious")
    @Expose
    public String countryPrevious;
    @SerializedName("AccountNo")
    @Expose
    public String accountNo;
    @SerializedName("IsAlarmCom")
    @Expose
    public boolean isAlarmCom;
    @SerializedName("CreditScore")
    @Expose
    public String creditScore;
    @SerializedName("CreditScoreValue")
    @Expose
    public int creditScoreValue;
    @SerializedName("ContractTeam")
    @Expose
    public String contractTeam;
    @SerializedName("FundingCompany")
    @Expose
    public String fundingCompany;
    @SerializedName("MonthlyMonitoringFee")
    @Expose
    public String monthlyMonitoringFee;
    @SerializedName("CellularBackup")
    @Expose
    public boolean cellularBackup;
    @SerializedName("LeadSource")
    @Expose
    public String leadSource;
    @SerializedName("CustomerFunded")
    @Expose
    public boolean customerFunded;
    @SerializedName("Maintenance")
    @Expose
    public boolean maintenance;
    @SerializedName("Note")
    @Expose
    public String note;
    @SerializedName("SalesDate")
    @Expose
    public String salesDate;
    @SerializedName("InstallDate")
    @Expose
    public String installDate;
    @SerializedName("CutInDate")
    @Expose
    public String cutInDate;
    @SerializedName("Installer")
    @Expose
    public String installer;
    @SerializedName("Soldby")
    @Expose
    public String soldby;
    @SerializedName("FundingDate")
    @Expose
    public String fundingDate;
    @SerializedName("MiddleName")
    @Expose
    public String middleName;
    @SerializedName("JoinDate")
    @Expose
    public String joinDate;
    @SerializedName("ReminderDate")
    @Expose
    public String reminderDate;
    @SerializedName("QA1")
    @Expose
    public String qA1;
    @SerializedName("QA1Date")
    @Expose
    public String qA1Date;
    @SerializedName("QA2")
    @Expose
    public String qA2;
    @SerializedName("QA2Date")
    @Expose
    public String qA2Date;
    @SerializedName("Status")
    @Expose
    public String status;
    @SerializedName("BillAmount")
    @Expose
    public double billAmount;
    @SerializedName("PaymentMethod")
    @Expose
    public String paymentMethod;
    @SerializedName("BillCycle")
    @Expose
    public String billCycle;
    @SerializedName("BillDay")
    @Expose
    public int billDay;
    @SerializedName("BillNotes")
    @Expose
    public String billNotes;
    @SerializedName("BillTax")
    @Expose
    public boolean billTax;
    @SerializedName("BillOutStanding")
    @Expose
    public double billOutStanding;
    @SerializedName("ServiceDate")
    @Expose
    public String serviceDate;
    @SerializedName("Area")
    @Expose
    public String area;
    @SerializedName("StreetType")
    @Expose
    public String streetType;
    @SerializedName("Appartment")
    @Expose
    public String appartment;
    @SerializedName("Latlng")
    @Expose
    public String latlng;
    @SerializedName("SecondCustomerNo")
    @Expose
    public String secondCustomerNo;
    @SerializedName("AdditionalCustomerNo")
    @Expose
    public String additionalCustomerNo;
    @SerializedName("IsTechCallPassed")
    @Expose
    public boolean isTechCallPassed;
    @SerializedName("IsDirect")
    @Expose
    public boolean isDirect;
    @SerializedName("AuthorizeRefId")
    @Expose
    public String authorizeRefId;
    @SerializedName("AuthorizeCusProfileId")
    @Expose
    public String authorizeCusProfileId;
    @SerializedName("AuthorizeCusPaymentProfileId")
    @Expose
    public String authorizeCusPaymentProfileId;
    @SerializedName("AuthorizeDescription")
    @Expose
    public String authorizeDescription;
    @SerializedName("IsRequiredCsvSync")
    @Expose
    public boolean isRequiredCsvSync;
    @SerializedName("Passcode")
    @Expose
    public String passcode;
    @SerializedName("ActivationFee")
    @Expose
    public double activationFee;
    @SerializedName("FirstBilling")
    @Expose
    public String firstBilling;
    @SerializedName("ActivationFeePaymentMethod")
    @Expose
    public String activationFeePaymentMethod;
    @SerializedName("IsActive")
    @Expose
    public boolean isActive;
    @SerializedName("LastGeneratedInvoice")
    @Expose
    public String lastGeneratedInvoice;
    @SerializedName("Singature")
    @Expose
    public String singature;
    @SerializedName("CrossStreet")
    @Expose
    public String crossStreet;
    @SerializedName("DBA")
    @Expose
    public String dBA;
    @SerializedName("AlarmRefId")
    @Expose
    public String alarmRefId;
    @SerializedName("TransunionRefId")
    @Expose
    public String transunionRefId;
    @SerializedName("MonitronicsRefId")
    @Expose
    public String monitronicsRefId;
    @SerializedName("CentralStationRefId")
    @Expose
    public String centralStationRefId;
    @SerializedName("CmsRefId")
    @Expose
    public String cmsRefId;
    @SerializedName("PreferedEmail")
    @Expose
    public boolean preferedEmail;
    @SerializedName("PreferedSms")
    @Expose
    public boolean preferedSms;
    @SerializedName("IsAgreement")
    @Expose
    public boolean isAgreement;
    @SerializedName("IsFireAccount")
    @Expose
    public boolean isFireAccount;
    @SerializedName("CreatedByUid")
    @Expose
    public String createdByUid;
    @SerializedName("CreatedDate")
    @Expose
    public String createdDate;
    @SerializedName("LastUpdatedBy")
    @Expose
    public String lastUpdatedBy;
    @SerializedName("LastUpdatedByUid")
    @Expose
    public String lastUpdatedByUid;
    @SerializedName("LastUpdatedDate")
    @Expose
    public String lastUpdatedDate;
    @SerializedName("BusinessAccountType")
    @Expose
    public String businessAccountType;
    @SerializedName("PhoneType")
    @Expose
    public String phoneType;
    @SerializedName("Carrier")
    @Expose
    public String carrier;
    @SerializedName("ReferringCustomer")
    @Expose
    public String referringCustomer;
    @SerializedName("EsistingPanel")
    @Expose
    public String esistingPanel;
    @SerializedName("Ownership")
    @Expose
    public String ownership;
    @SerializedName("PurchasePrice")
    @Expose
    public double purchasePrice;
    @SerializedName("ContractValue")
    @Expose
    public String contractValue;
    @SerializedName("ChildOf")
    @Expose
    public String childOf;
    @SerializedName("EmailVerified")
    @Expose
    public boolean emailVerified;
    @SerializedName("HomeVerified")
    @Expose
    public boolean homeVerified;
    @SerializedName("County")
    @Expose
    public String county;
    @SerializedName("CustomerToken")
    @Expose
    public String customerToken;
    @SerializedName("PaymentToken")
    @Expose
    public String paymentToken;
    @SerializedName("ScheduleToken")
    @Expose
    public String scheduleToken;
    @SerializedName("EstCloseDate")
    @Expose
    public String estCloseDate;
    @SerializedName("ProjectWalkDate")
    @Expose
    public String projectWalkDate;
    @SerializedName("BranchId")
    @Expose
    public int branchId;
    @SerializedName("SubscriptionStatus")
    @Expose
    public String subscriptionStatus;
    @SerializedName("AnnualRevenue")
    @Expose
    public double annualRevenue;
    @SerializedName("Website")
    @Expose
    public String website;
    @SerializedName("Market")
    @Expose
    public String market;
    @SerializedName("Passengers")
    @Expose
    public int passengers;
    @SerializedName("Budget")
    @Expose
    public double budget;
    @SerializedName("SmartSetUpStep")
    @Expose
    public int smartSetUpStep;
    @SerializedName("CustomerAccountType")
    @Expose
    public String customerAccountType;
    @SerializedName("IsPrimaryPhoneVerified")
    @Expose
    public boolean isPrimaryPhoneVerified;
    @SerializedName("IsSecondaryPhoneVerified")
    @Expose
    public boolean isSecondaryPhoneVerified;
    @SerializedName("IsCellNoVerified")
    @Expose
    public boolean isCellNoVerified;
    @SerializedName("HomeOwner")
    @Expose
    public Object homeOwner;
    @SerializedName("AccessGivenTo")
    @Expose
    public String accessGivenTo;
    @SerializedName("DoNotCall")
    @Expose
    public String doNotCall;
    @SerializedName("PreferredContactMethod")
    @Expose
    public String preferredContactMethod;
    @SerializedName("SalesLocation")
    @Expose
    public Object salesLocation;
    @SerializedName("IsReceivePaymentMail")
    @Expose
    public Object isReceivePaymentMail;
    @SerializedName("BestTimeToCall")
    @Expose
    public Object bestTimeToCall;
    @SerializedName("CSProvider")
    @Expose
    public Object cSProvider;
    @SerializedName("RenewalTerm")
    @Expose
    public Object renewalTerm;
    @SerializedName("PreferedCall")
    @Expose
    public Object preferedCall;
    @SerializedName("IsAgreementSend")
    @Expose
    public Object isAgreementSend;
    @SerializedName("IsACHDiscount")
    @Expose
    public Object isACHDiscount;
    @SerializedName("CustomerStatus")
    @Expose
    public Object customerStatus;
    @SerializedName("TransferCustomerId")
    @Expose
    public Object transferCustomerId;
    @SerializedName("CancellationSignature")
    @Expose
    public Object cancellationSignature;
    @SerializedName("OriginalContactDate")
    @Expose
    public Object originalContactDate;
    @SerializedName("DuplicateCustomer")
    @Expose
    public String duplicateCustomer;
    @SerializedName("InspectionCompany")
    @Expose
    public Object inspectionCompany;
    @SerializedName("SoldBy2")
    @Expose
    public String soldBy2;
    @SerializedName("SoldBy3")
    @Expose
    public String soldBy3;
    @SerializedName("ContactedPerviously")
    @Expose
    public String contactedPerviously;
    @SerializedName("MovingDate")
    @Expose
    public String movingDate;
    @SerializedName("InstalledStatus")
    @Expose
    public Object installedStatus;
    @SerializedName("AcquiredFrom")
    @Expose
    public Object acquiredFrom;
    @SerializedName("FollowUpDate")
    @Expose
    public String followUpDate;
    @SerializedName("BuyoutAmountByADS")
    @Expose
    public Object buyoutAmountByADS;
    @SerializedName("BuyoutAmountBySalesRep")
    @Expose
    public Object buyoutAmountBySalesRep;
    @SerializedName("FinancedTerm")
    @Expose
    public Object financedTerm;
    @SerializedName("FinancedAmount")
    @Expose
    public Object financedAmount;
    @SerializedName("Levels")
    @Expose
    public Object levels;
    @SerializedName("SoldAmount")
    @Expose
    public Object soldAmount;
    @SerializedName("AgreementEmail")
    @Expose
    public Object agreementEmail;
    @SerializedName("AgreementPhoneNo")
    @Expose
    public Object agreementPhoneNo;
    @SerializedName("TaxExemption")
    @Expose
    public Object taxExemption;
    @SerializedName("AppoinmentSet")
    @Expose
    public Object appoinmentSet;
    @SerializedName("RowState")
    @Expose
    public int rowState;

    public CustomerAPI() {
    }

    public CustomerAPI(int id, String customerId, String customerNo, String title, String firstName, String lastName, String sSN, String type, String businessName, String dateofBirth, String primaryPhone, String secondaryPhone, String cellNo, String fax, String emailAddress, String callingTime, String address, String address2, String street, String city, String state, String zipCode, String country, String streetPrevious, String cityPrevious, String statePrevious, String zipCodePrevious, String countryPrevious, String accountNo, boolean isAlarmCom, String creditScore, int creditScoreValue, String contractTeam, String fundingCompany, String monthlyMonitoringFee, boolean cellularBackup, String leadSource, boolean customerFunded, boolean maintenance, String note, String salesDate, String installDate, String cutInDate, String installer, String soldby, String fundingDate, String middleName, String joinDate, String reminderDate, String qA1, String qA1Date, String qA2, String qA2Date, String status, double billAmount, String paymentMethod, String billCycle, int billDay, String billNotes, boolean billTax, double billOutStanding, String serviceDate, String area, String streetType, String appartment, String latlng, String secondCustomerNo, String additionalCustomerNo, boolean isTechCallPassed, boolean isDirect, String authorizeRefId, String authorizeCusProfileId, String authorizeCusPaymentProfileId, String authorizeDescription, boolean isRequiredCsvSync, String passcode, double activationFee, String firstBilling, String activationFeePaymentMethod, boolean isActive, String lastGeneratedInvoice, String singature, String crossStreet, String dBA, String alarmRefId, String transunionRefId, String monitronicsRefId, String centralStationRefId, String cmsRefId, boolean preferedEmail, boolean preferedSms, boolean isAgreement, boolean isFireAccount, String createdByUid, String createdDate, String lastUpdatedBy, String lastUpdatedByUid, String lastUpdatedDate, String businessAccountType, String phoneType, String carrier, String referringCustomer, String esistingPanel, String ownership, double purchasePrice, String contractValue, String childOf, boolean emailVerified, boolean homeVerified, String county, String customerToken, String paymentToken, String scheduleToken, String estCloseDate, String projectWalkDate, int branchId, String subscriptionStatus, double annualRevenue, String website, String market, int passengers, double budget, int smartSetUpStep, String customerAccountType, boolean isPrimaryPhoneVerified, boolean isSecondaryPhoneVerified, boolean isCellNoVerified, Object homeOwner, String accessGivenTo, String doNotCall, String preferredContactMethod, Object salesLocation, Object isReceivePaymentMail, Object bestTimeToCall, Object cSProvider, Object renewalTerm, Object preferedCall, Object isAgreementSend, Object isACHDiscount, Object customerStatus, Object transferCustomerId, Object cancellationSignature, Object originalContactDate, String duplicateCustomer, Object inspectionCompany, String soldBy2, String soldBy3, String contactedPerviously, String movingDate, Object installedStatus, Object acquiredFrom, String followUpDate, Object buyoutAmountByADS, Object buyoutAmountBySalesRep, Object financedTerm, Object financedAmount, Object levels, Object soldAmount, Object agreementEmail, Object agreementPhoneNo, Object taxExemption, Object appoinmentSet, int rowState) {
        this.id = id;
        this.customerId = customerId;
        this.customerNo = customerNo;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sSN = sSN;
        this.type = type;
        this.businessName = businessName;
        this.dateofBirth = dateofBirth;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.cellNo = cellNo;
        this.fax = fax;
        this.emailAddress = emailAddress;
        this.callingTime = callingTime;
        this.address = address;
        this.address2 = address2;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.streetPrevious = streetPrevious;
        this.cityPrevious = cityPrevious;
        this.statePrevious = statePrevious;
        this.zipCodePrevious = zipCodePrevious;
        this.countryPrevious = countryPrevious;
        this.accountNo = accountNo;
        this.isAlarmCom = isAlarmCom;
        this.creditScore = creditScore;
        this.creditScoreValue = creditScoreValue;
        this.contractTeam = contractTeam;
        this.fundingCompany = fundingCompany;
        this.monthlyMonitoringFee = monthlyMonitoringFee;
        this.cellularBackup = cellularBackup;
        this.leadSource = leadSource;
        this.customerFunded = customerFunded;
        this.maintenance = maintenance;
        this.note = note;
        this.salesDate = salesDate;
        this.installDate = installDate;
        this.cutInDate = cutInDate;
        this.installer = installer;
        this.soldby = soldby;
        this.fundingDate = fundingDate;
        this.middleName = middleName;
        this.joinDate = joinDate;
        this.reminderDate = reminderDate;
        this.qA1 = qA1;
        this.qA1Date = qA1Date;
        this.qA2 = qA2;
        this.qA2Date = qA2Date;
        this.status = status;
        this.billAmount = billAmount;
        this.paymentMethod = paymentMethod;
        this.billCycle = billCycle;
        this.billDay = billDay;
        this.billNotes = billNotes;
        this.billTax = billTax;
        this.billOutStanding = billOutStanding;
        this.serviceDate = serviceDate;
        this.area = area;
        this.streetType = streetType;
        this.appartment = appartment;
        this.latlng = latlng;
        this.secondCustomerNo = secondCustomerNo;
        this.additionalCustomerNo = additionalCustomerNo;
        this.isTechCallPassed = isTechCallPassed;
        this.isDirect = isDirect;
        this.authorizeRefId = authorizeRefId;
        this.authorizeCusProfileId = authorizeCusProfileId;
        this.authorizeCusPaymentProfileId = authorizeCusPaymentProfileId;
        this.authorizeDescription = authorizeDescription;
        this.isRequiredCsvSync = isRequiredCsvSync;
        this.passcode = passcode;
        this.activationFee = activationFee;
        this.firstBilling = firstBilling;
        this.activationFeePaymentMethod = activationFeePaymentMethod;
        this.isActive = isActive;
        this.lastGeneratedInvoice = lastGeneratedInvoice;
        this.singature = singature;
        this.crossStreet = crossStreet;
        this.dBA = dBA;
        this.alarmRefId = alarmRefId;
        this.transunionRefId = transunionRefId;
        this.monitronicsRefId = monitronicsRefId;
        this.centralStationRefId = centralStationRefId;
        this.cmsRefId = cmsRefId;
        this.preferedEmail = preferedEmail;
        this.preferedSms = preferedSms;
        this.isAgreement = isAgreement;
        this.isFireAccount = isFireAccount;
        this.createdByUid = createdByUid;
        this.createdDate = createdDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedByUid = lastUpdatedByUid;
        this.lastUpdatedDate = lastUpdatedDate;
        this.businessAccountType = businessAccountType;
        this.phoneType = phoneType;
        this.carrier = carrier;
        this.referringCustomer = referringCustomer;
        this.esistingPanel = esistingPanel;
        this.ownership = ownership;
        this.purchasePrice = purchasePrice;
        this.contractValue = contractValue;
        this.childOf = childOf;
        this.emailVerified = emailVerified;
        this.homeVerified = homeVerified;
        this.county = county;
        this.customerToken = customerToken;
        this.paymentToken = paymentToken;
        this.scheduleToken = scheduleToken;
        this.estCloseDate = estCloseDate;
        this.projectWalkDate = projectWalkDate;
        this.branchId = branchId;
        this.subscriptionStatus = subscriptionStatus;
        this.annualRevenue = annualRevenue;
        this.website = website;
        this.market = market;
        this.passengers = passengers;
        this.budget = budget;
        this.smartSetUpStep = smartSetUpStep;
        this.customerAccountType = customerAccountType;
        this.isPrimaryPhoneVerified = isPrimaryPhoneVerified;
        this.isSecondaryPhoneVerified = isSecondaryPhoneVerified;
        this.isCellNoVerified = isCellNoVerified;
        this.homeOwner = homeOwner;
        this.accessGivenTo = accessGivenTo;
        this.doNotCall = doNotCall;
        this.preferredContactMethod = preferredContactMethod;
        this.salesLocation = salesLocation;
        this.isReceivePaymentMail = isReceivePaymentMail;
        this.bestTimeToCall = bestTimeToCall;
        this.cSProvider = cSProvider;
        this.renewalTerm = renewalTerm;
        this.preferedCall = preferedCall;
        this.isAgreementSend = isAgreementSend;
        this.isACHDiscount = isACHDiscount;
        this.customerStatus = customerStatus;
        this.transferCustomerId = transferCustomerId;
        this.cancellationSignature = cancellationSignature;
        this.originalContactDate = originalContactDate;
        this.duplicateCustomer = duplicateCustomer;
        this.inspectionCompany = inspectionCompany;
        this.soldBy2 = soldBy2;
        this.soldBy3 = soldBy3;
        this.contactedPerviously = contactedPerviously;
        this.movingDate = movingDate;
        this.installedStatus = installedStatus;
        this.acquiredFrom = acquiredFrom;
        this.followUpDate = followUpDate;
        this.buyoutAmountByADS = buyoutAmountByADS;
        this.buyoutAmountBySalesRep = buyoutAmountBySalesRep;
        this.financedTerm = financedTerm;
        this.financedAmount = financedAmount;
        this.levels = levels;
        this.soldAmount = soldAmount;
        this.agreementEmail = agreementEmail;
        this.agreementPhoneNo = agreementPhoneNo;
        this.taxExemption = taxExemption;
        this.appoinmentSet = appoinmentSet;
        this.rowState = rowState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(String callingTime) {
        this.callingTime = callingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetPrevious() {
        return streetPrevious;
    }

    public void setStreetPrevious(String streetPrevious) {
        this.streetPrevious = streetPrevious;
    }

    public String getCityPrevious() {
        return cityPrevious;
    }

    public void setCityPrevious(String cityPrevious) {
        this.cityPrevious = cityPrevious;
    }

    public String getStatePrevious() {
        return statePrevious;
    }

    public void setStatePrevious(String statePrevious) {
        this.statePrevious = statePrevious;
    }

    public String getZipCodePrevious() {
        return zipCodePrevious;
    }

    public void setZipCodePrevious(String zipCodePrevious) {
        this.zipCodePrevious = zipCodePrevious;
    }

    public String getCountryPrevious() {
        return countryPrevious;
    }

    public void setCountryPrevious(String countryPrevious) {
        this.countryPrevious = countryPrevious;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public boolean isAlarmCom() {
        return isAlarmCom;
    }

    public void setAlarmCom(boolean alarmCom) {
        isAlarmCom = alarmCom;
    }

    public String getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public int getCreditScoreValue() {
        return creditScoreValue;
    }

    public void setCreditScoreValue(int creditScoreValue) {
        this.creditScoreValue = creditScoreValue;
    }

    public String getContractTeam() {
        return contractTeam;
    }

    public void setContractTeam(String contractTeam) {
        this.contractTeam = contractTeam;
    }

    public String getFundingCompany() {
        return fundingCompany;
    }

    public void setFundingCompany(String fundingCompany) {
        this.fundingCompany = fundingCompany;
    }

    public String getMonthlyMonitoringFee() {
        return monthlyMonitoringFee;
    }

    public void setMonthlyMonitoringFee(String monthlyMonitoringFee) {
        this.monthlyMonitoringFee = monthlyMonitoringFee;
    }

    public boolean isCellularBackup() {
        return cellularBackup;
    }

    public void setCellularBackup(boolean cellularBackup) {
        this.cellularBackup = cellularBackup;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public boolean isCustomerFunded() {
        return customerFunded;
    }

    public void setCustomerFunded(boolean customerFunded) {
        this.customerFunded = customerFunded;
    }

    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getCutInDate() {
        return cutInDate;
    }

    public void setCutInDate(String cutInDate) {
        this.cutInDate = cutInDate;
    }

    public String getInstaller() {
        return installer;
    }

    public void setInstaller(String installer) {
        this.installer = installer;
    }

    public String getSoldby() {
        return soldby;
    }

    public void setSoldby(String soldby) {
        this.soldby = soldby;
    }

    public String getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(String fundingDate) {
        this.fundingDate = fundingDate;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getqA1() {
        return qA1;
    }

    public void setqA1(String qA1) {
        this.qA1 = qA1;
    }

    public String getqA1Date() {
        return qA1Date;
    }

    public void setqA1Date(String qA1Date) {
        this.qA1Date = qA1Date;
    }

    public String getqA2() {
        return qA2;
    }

    public void setqA2(String qA2) {
        this.qA2 = qA2;
    }

    public String getqA2Date() {
        return qA2Date;
    }

    public void setqA2Date(String qA2Date) {
        this.qA2Date = qA2Date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBillCycle() {
        return billCycle;
    }

    public void setBillCycle(String billCycle) {
        this.billCycle = billCycle;
    }

    public int getBillDay() {
        return billDay;
    }

    public void setBillDay(int billDay) {
        this.billDay = billDay;
    }

    public String getBillNotes() {
        return billNotes;
    }

    public void setBillNotes(String billNotes) {
        this.billNotes = billNotes;
    }

    public boolean isBillTax() {
        return billTax;
    }

    public void setBillTax(boolean billTax) {
        this.billTax = billTax;
    }

    public double getBillOutStanding() {
        return billOutStanding;
    }

    public void setBillOutStanding(double billOutStanding) {
        this.billOutStanding = billOutStanding;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getAppartment() {
        return appartment;
    }

    public void setAppartment(String appartment) {
        this.appartment = appartment;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getSecondCustomerNo() {
        return secondCustomerNo;
    }

    public void setSecondCustomerNo(String secondCustomerNo) {
        this.secondCustomerNo = secondCustomerNo;
    }

    public String getAdditionalCustomerNo() {
        return additionalCustomerNo;
    }

    public void setAdditionalCustomerNo(String additionalCustomerNo) {
        this.additionalCustomerNo = additionalCustomerNo;
    }

    public boolean isTechCallPassed() {
        return isTechCallPassed;
    }

    public void setTechCallPassed(boolean techCallPassed) {
        isTechCallPassed = techCallPassed;
    }

    public boolean isDirect() {
        return isDirect;
    }

    public void setDirect(boolean direct) {
        isDirect = direct;
    }

    public String getAuthorizeRefId() {
        return authorizeRefId;
    }

    public void setAuthorizeRefId(String authorizeRefId) {
        this.authorizeRefId = authorizeRefId;
    }

    public String getAuthorizeCusProfileId() {
        return authorizeCusProfileId;
    }

    public void setAuthorizeCusProfileId(String authorizeCusProfileId) {
        this.authorizeCusProfileId = authorizeCusProfileId;
    }

    public String getAuthorizeCusPaymentProfileId() {
        return authorizeCusPaymentProfileId;
    }

    public void setAuthorizeCusPaymentProfileId(String authorizeCusPaymentProfileId) {
        this.authorizeCusPaymentProfileId = authorizeCusPaymentProfileId;
    }

    public String getAuthorizeDescription() {
        return authorizeDescription;
    }

    public void setAuthorizeDescription(String authorizeDescription) {
        this.authorizeDescription = authorizeDescription;
    }

    public boolean isRequiredCsvSync() {
        return isRequiredCsvSync;
    }

    public void setRequiredCsvSync(boolean requiredCsvSync) {
        isRequiredCsvSync = requiredCsvSync;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public double getActivationFee() {
        return activationFee;
    }

    public void setActivationFee(double activationFee) {
        this.activationFee = activationFee;
    }

    public String getFirstBilling() {
        return firstBilling;
    }

    public void setFirstBilling(String firstBilling) {
        this.firstBilling = firstBilling;
    }

    public String getActivationFeePaymentMethod() {
        return activationFeePaymentMethod;
    }

    public void setActivationFeePaymentMethod(String activationFeePaymentMethod) {
        this.activationFeePaymentMethod = activationFeePaymentMethod;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastGeneratedInvoice() {
        return lastGeneratedInvoice;
    }

    public void setLastGeneratedInvoice(String lastGeneratedInvoice) {
        this.lastGeneratedInvoice = lastGeneratedInvoice;
    }

    public String getSingature() {
        return singature;
    }

    public void setSingature(String singature) {
        this.singature = singature;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public String getdBA() {
        return dBA;
    }

    public void setdBA(String dBA) {
        this.dBA = dBA;
    }

    public String getAlarmRefId() {
        return alarmRefId;
    }

    public void setAlarmRefId(String alarmRefId) {
        this.alarmRefId = alarmRefId;
    }

    public String getTransunionRefId() {
        return transunionRefId;
    }

    public void setTransunionRefId(String transunionRefId) {
        this.transunionRefId = transunionRefId;
    }

    public String getMonitronicsRefId() {
        return monitronicsRefId;
    }

    public void setMonitronicsRefId(String monitronicsRefId) {
        this.monitronicsRefId = monitronicsRefId;
    }

    public String getCentralStationRefId() {
        return centralStationRefId;
    }

    public void setCentralStationRefId(String centralStationRefId) {
        this.centralStationRefId = centralStationRefId;
    }

    public String getCmsRefId() {
        return cmsRefId;
    }

    public void setCmsRefId(String cmsRefId) {
        this.cmsRefId = cmsRefId;
    }

    public boolean isPreferedEmail() {
        return preferedEmail;
    }

    public void setPreferedEmail(boolean preferedEmail) {
        this.preferedEmail = preferedEmail;
    }

    public boolean isPreferedSms() {
        return preferedSms;
    }

    public void setPreferedSms(boolean preferedSms) {
        this.preferedSms = preferedSms;
    }

    public boolean isAgreement() {
        return isAgreement;
    }

    public void setAgreement(boolean agreement) {
        isAgreement = agreement;
    }

    public boolean isFireAccount() {
        return isFireAccount;
    }

    public void setFireAccount(boolean fireAccount) {
        isFireAccount = fireAccount;
    }

    public String getCreatedByUid() {
        return createdByUid;
    }

    public void setCreatedByUid(String createdByUid) {
        this.createdByUid = createdByUid;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedByUid() {
        return lastUpdatedByUid;
    }

    public void setLastUpdatedByUid(String lastUpdatedByUid) {
        this.lastUpdatedByUid = lastUpdatedByUid;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getBusinessAccountType() {
        return businessAccountType;
    }

    public void setBusinessAccountType(String businessAccountType) {
        this.businessAccountType = businessAccountType;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getReferringCustomer() {
        return referringCustomer;
    }

    public void setReferringCustomer(String referringCustomer) {
        this.referringCustomer = referringCustomer;
    }

    public String getEsistingPanel() {
        return esistingPanel;
    }

    public void setEsistingPanel(String esistingPanel) {
        this.esistingPanel = esistingPanel;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getContractValue() {
        return contractValue;
    }

    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }

    public String getChildOf() {
        return childOf;
    }

    public void setChildOf(String childOf) {
        this.childOf = childOf;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isHomeVerified() {
        return homeVerified;
    }

    public void setHomeVerified(boolean homeVerified) {
        this.homeVerified = homeVerified;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCustomerToken() {
        return customerToken;
    }

    public void setCustomerToken(String customerToken) {
        this.customerToken = customerToken;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    public String getScheduleToken() {
        return scheduleToken;
    }

    public void setScheduleToken(String scheduleToken) {
        this.scheduleToken = scheduleToken;
    }

    public String getEstCloseDate() {
        return estCloseDate;
    }

    public void setEstCloseDate(String estCloseDate) {
        this.estCloseDate = estCloseDate;
    }

    public String getProjectWalkDate() {
        return projectWalkDate;
    }

    public void setProjectWalkDate(String projectWalkDate) {
        this.projectWalkDate = projectWalkDate;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getSmartSetUpStep() {
        return smartSetUpStep;
    }

    public void setSmartSetUpStep(int smartSetUpStep) {
        this.smartSetUpStep = smartSetUpStep;
    }

    public String getCustomerAccountType() {
        return customerAccountType;
    }

    public void setCustomerAccountType(String customerAccountType) {
        this.customerAccountType = customerAccountType;
    }

    public boolean isPrimaryPhoneVerified() {
        return isPrimaryPhoneVerified;
    }

    public void setPrimaryPhoneVerified(boolean primaryPhoneVerified) {
        isPrimaryPhoneVerified = primaryPhoneVerified;
    }

    public boolean isSecondaryPhoneVerified() {
        return isSecondaryPhoneVerified;
    }

    public void setSecondaryPhoneVerified(boolean secondaryPhoneVerified) {
        isSecondaryPhoneVerified = secondaryPhoneVerified;
    }

    public boolean isCellNoVerified() {
        return isCellNoVerified;
    }

    public void setCellNoVerified(boolean cellNoVerified) {
        isCellNoVerified = cellNoVerified;
    }

    public Object getHomeOwner() {
        return homeOwner;
    }

    public void setHomeOwner(Object homeOwner) {
        this.homeOwner = homeOwner;
    }

    public String getAccessGivenTo() {
        return accessGivenTo;
    }

    public void setAccessGivenTo(String accessGivenTo) {
        this.accessGivenTo = accessGivenTo;
    }

    public String getDoNotCall() {
        return doNotCall;
    }

    public void setDoNotCall(String doNotCall) {
        this.doNotCall = doNotCall;
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }

    public Object getSalesLocation() {
        return salesLocation;
    }

    public void setSalesLocation(Object salesLocation) {
        this.salesLocation = salesLocation;
    }

    public Object getIsReceivePaymentMail() {
        return isReceivePaymentMail;
    }

    public void setIsReceivePaymentMail(Object isReceivePaymentMail) {
        this.isReceivePaymentMail = isReceivePaymentMail;
    }

    public Object getBestTimeToCall() {
        return bestTimeToCall;
    }

    public void setBestTimeToCall(Object bestTimeToCall) {
        this.bestTimeToCall = bestTimeToCall;
    }

    public Object getcSProvider() {
        return cSProvider;
    }

    public void setcSProvider(Object cSProvider) {
        this.cSProvider = cSProvider;
    }

    public Object getRenewalTerm() {
        return renewalTerm;
    }

    public void setRenewalTerm(Object renewalTerm) {
        this.renewalTerm = renewalTerm;
    }

    public Object getPreferedCall() {
        return preferedCall;
    }

    public void setPreferedCall(Object preferedCall) {
        this.preferedCall = preferedCall;
    }

    public Object getIsAgreementSend() {
        return isAgreementSend;
    }

    public void setIsAgreementSend(Object isAgreementSend) {
        this.isAgreementSend = isAgreementSend;
    }

    public Object getIsACHDiscount() {
        return isACHDiscount;
    }

    public void setIsACHDiscount(Object isACHDiscount) {
        this.isACHDiscount = isACHDiscount;
    }

    public Object getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Object customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Object getTransferCustomerId() {
        return transferCustomerId;
    }

    public void setTransferCustomerId(Object transferCustomerId) {
        this.transferCustomerId = transferCustomerId;
    }

    public Object getCancellationSignature() {
        return cancellationSignature;
    }

    public void setCancellationSignature(Object cancellationSignature) {
        this.cancellationSignature = cancellationSignature;
    }

    public Object getOriginalContactDate() {
        return originalContactDate;
    }

    public void setOriginalContactDate(Object originalContactDate) {
        this.originalContactDate = originalContactDate;
    }

    public String getDuplicateCustomer() {
        return duplicateCustomer;
    }

    public void setDuplicateCustomer(String duplicateCustomer) {
        this.duplicateCustomer = duplicateCustomer;
    }

    public Object getInspectionCompany() {
        return inspectionCompany;
    }

    public void setInspectionCompany(Object inspectionCompany) {
        this.inspectionCompany = inspectionCompany;
    }

    public String getSoldBy2() {
        return soldBy2;
    }

    public void setSoldBy2(String soldBy2) {
        this.soldBy2 = soldBy2;
    }

    public String getSoldBy3() {
        return soldBy3;
    }

    public void setSoldBy3(String soldBy3) {
        this.soldBy3 = soldBy3;
    }

    public String getContactedPerviously() {
        return contactedPerviously;
    }

    public void setContactedPerviously(String contactedPerviously) {
        this.contactedPerviously = contactedPerviously;
    }

    public String getMovingDate() {
        return movingDate;
    }

    public void setMovingDate(String movingDate) {
        this.movingDate = movingDate;
    }

    public Object getInstalledStatus() {
        return installedStatus;
    }

    public void setInstalledStatus(Object installedStatus) {
        this.installedStatus = installedStatus;
    }

    public Object getAcquiredFrom() {
        return acquiredFrom;
    }

    public void setAcquiredFrom(Object acquiredFrom) {
        this.acquiredFrom = acquiredFrom;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public Object getBuyoutAmountByADS() {
        return buyoutAmountByADS;
    }

    public void setBuyoutAmountByADS(Object buyoutAmountByADS) {
        this.buyoutAmountByADS = buyoutAmountByADS;
    }

    public Object getBuyoutAmountBySalesRep() {
        return buyoutAmountBySalesRep;
    }

    public void setBuyoutAmountBySalesRep(Object buyoutAmountBySalesRep) {
        this.buyoutAmountBySalesRep = buyoutAmountBySalesRep;
    }

    public Object getFinancedTerm() {
        return financedTerm;
    }

    public void setFinancedTerm(Object financedTerm) {
        this.financedTerm = financedTerm;
    }

    public Object getFinancedAmount() {
        return financedAmount;
    }

    public void setFinancedAmount(Object financedAmount) {
        this.financedAmount = financedAmount;
    }

    public Object getLevels() {
        return levels;
    }

    public void setLevels(Object levels) {
        this.levels = levels;
    }

    public Object getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(Object soldAmount) {
        this.soldAmount = soldAmount;
    }

    public Object getAgreementEmail() {
        return agreementEmail;
    }

    public void setAgreementEmail(Object agreementEmail) {
        this.agreementEmail = agreementEmail;
    }

    public Object getAgreementPhoneNo() {
        return agreementPhoneNo;
    }

    public void setAgreementPhoneNo(Object agreementPhoneNo) {
        this.agreementPhoneNo = agreementPhoneNo;
    }

    public Object getTaxExemption() {
        return taxExemption;
    }

    public void setTaxExemption(Object taxExemption) {
        this.taxExemption = taxExemption;
    }

    public Object getAppoinmentSet() {
        return appoinmentSet;
    }

    public void setAppoinmentSet(Object appoinmentSet) {
        this.appoinmentSet = appoinmentSet;
    }

    public int getRowState() {
        return rowState;
    }

    public void setRowState(int rowState) {
        this.rowState = rowState;
    }
}
