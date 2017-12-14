import org.junit.Test;
import util.Md5Utils;

import static junit.framework.Assert.assertEquals;

public class MD5Test {
    @Test
    public void testGetHash() throws Exception {
        String pass = "password";
        String result = Md5Utils.getMd5(pass);
        String expected = "5f4dcc3b5aa765d61d8327deb882cf99";
        assertEquals(result, expected);
    }
}