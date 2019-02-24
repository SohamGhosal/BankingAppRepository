package com.BankingApp.util;
public final class QueryMapper {
public static final String getUser="FROM User where userId=:uid and Password=:password and lockStatus=:lock"; 
public static final String validateUser="FROM User where userId=:uid  and lockStatus=:lock";
public static final String checkAnswer="FROM User where secretQues=:secretquest and Ans=:answer";
public static final String getCustomer="FROM Customer where accountid=:accountId";
public static final String checkUser="FROM User where Password=:pwd and userId=:uid";
public static final String getMultipleServcie="FROM ServiceTracker where accId=:accountid";
public static final String getAdmin="From BankAdmin where adminid=:adminId and adminpassword=:adminPassword";
public static final String getRequests="FROM CustomerRequests where status=:status";
public static final String getOpenService="FROM ServiceTracker where serviceStatus=:status";
public static final String findRequest="From ServiceTracker where accId=:accountid and serviceDesc=:servdesc and serviceStatus=:status";
public static final String getTransactions="FROM Transactions where accountNo=:accid";
}
