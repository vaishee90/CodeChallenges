import org.junit.Test;

import junit.framework.Assert;

public class MaximumAreaInLineGraphTest {
	@Test
	public void maxAreaTest() {
		int[] input = new int[] {2,3,4,5,18,17,6};
		int res = 17;
		Assert.assertTrue(MaximumAreaInLineGraph.maxArea(input) == res);
	}
}
