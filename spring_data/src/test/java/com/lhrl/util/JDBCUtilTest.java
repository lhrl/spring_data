package com.lhrl.util;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

public class JDBCUtilTest {

	@Test
	public void getConnection() throws Exception{
		Connection connection=JDBCUtil.getConnection();
		Assert.assertNotNull(connection);
	}
	
	
}
