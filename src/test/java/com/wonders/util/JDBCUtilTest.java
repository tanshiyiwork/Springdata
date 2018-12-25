package com.wonders.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection connection=JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}
