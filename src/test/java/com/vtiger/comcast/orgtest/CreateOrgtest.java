package com.vtiger.comcast.orgtest;

import org.testng.annotations.Test;

import com.vtiger.comcast.genericutility.BaseClass;

public class CreateOrgtest extends BaseClass{
	
	@Test
	public void createOrganizationTest() {
		
	System.out.println("create organisation name");
	}
	
	@Test
	public void createOrganisationWithIndustry() {
		System.out.println("create organisation with industry type");
	}
	
	@Test
	public void createOrganisationeWithRating() {
		System.out.println("create organisation with rating");
	}

}