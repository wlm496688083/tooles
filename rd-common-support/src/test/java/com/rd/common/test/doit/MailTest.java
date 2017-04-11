package com.rd.common.test.doit;

import com.rd.common.test.TestBase;
import com.rd.common.util.MailUtil;
import org.junit.Test;

/**
 * Created by admin on 2017/4/11.
 */
public class MailTest extends TestBase {

    @Test
    public void test() {
        MailUtil.sendMail("errr");
    }
}
