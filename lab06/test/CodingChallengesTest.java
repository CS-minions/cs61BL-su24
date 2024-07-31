import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertEquals;

public class CodingChallengesTest {

    @Test
    public void testMissingNumber() {
	int[] values = {1,2,3,4};
    assertEquals(CodingChallenges.missingNumber(values) , 0);
    int[] value = {0,2,3,4 , 5};
    assertEquals(CodingChallenges.missingNumber(value) , 1);
    int[] valu = {0,1,2,3,4,5,6};
    assertEquals(CodingChallenges.missingNumber(valu), 7);
    }

    @Test
    public void testIsPermutation() {
        String s1 = "sdldsj";
        String s2 = "sfddlsj";
        assertEquals(CodingChallenges.isPermutation(s1 , s2) , false);

    }
}
